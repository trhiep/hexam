package com.hexam.controllers;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.hexam.config.CustomUserDetails;
import com.hexam.models.ExamSettings;
import com.hexam.models.Person;
import com.hexam.repositories.PersonRepository;
import com.hexam.services.exam.ExamSettingsServiceImpl;
import com.hexam.utils.loader.SecurityInformationLoader;
import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * @author trhiep
 */
@Controller
public class HomeController {

    @Autowired
    PersonRepository personRepository;

    @Autowired
    ExamSettingsServiceImpl examSettingsService;

    @RequestMapping("/")
    public String home(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            for (GrantedAuthority authority : auth.getAuthorities()) {
                if (authority.getAuthority().equals("ROLE_ADMIN")) {
                    return "redirect:/admin/";
                }
                if (authority.getAuthority().equals("ROLE_TEACH")) {
                    return "redirect:/giao-vien/";
                }
            }
        }

        List<ExamSettings> publicExamsNow = examSettingsService.getExamSettingsByPublicationAndEndDateAfter(1, LocalDateTime.now());
        model.addAttribute("publicExamsNow", publicExamsNow);

        CustomUserDetails customUserDetails = SecurityInformationLoader.getCustomUserDetails();
        if (customUserDetails != null) {
            model.addAttribute("person", personRepository.findByUserName(customUserDetails.getUsername()));
        }
        model.addAttribute("pageTitle", "HExam");
        return "pages/guest/index";
    }
}
