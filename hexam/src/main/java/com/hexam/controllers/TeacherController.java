package com.hexam.controllers;

import com.hexam.config.CustomUserDetails;
import com.hexam.repositories.PersonRepository;
import com.hexam.services.user.UserServiceImpl;
import com.hexam.utils.loader.SecurityInformationLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author trhiep
 */
@Controller
@RequestMapping("/giao-vien")
public class TeacherController {

    @Autowired
    PersonRepository personRepository;

    private void getUserDetailsInf(Model model) {
        CustomUserDetails customUserDetails = SecurityInformationLoader.getCustomUserDetails();
        if (customUserDetails != null) {
            model.addAttribute("person", personRepository.findByUserName(customUserDetails.getUsername()));
        }
    }

    @GetMapping
    public String index() {
        return "redirect:/giao-vien/";
    }

    @RequestMapping("/")
    public String admin(Model model) {
        getUserDetailsInf(model);
        return "pages/teacher/index";
    }
}
