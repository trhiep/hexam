package com.hexam.controllers;

import com.hexam.config.CustomUserDetails;
import com.hexam.constants.EntityConstants;
import com.hexam.constants.WebErrorMessage;
import com.hexam.constants.WebSuccessMessage;
import com.hexam.dtos.ClassTeacherDTO;
import com.hexam.models.*;
import com.hexam.repositories.ClassTeacherRepository;
import com.hexam.repositories.ExamRepository;
import com.hexam.repositories.ExamSettingsRepository;
import com.hexam.repositories.PersonRepository;
import com.hexam.services.classes.ClassServiceImpl;
import com.hexam.services.classes.ClassTeacherService;
import com.hexam.services.exam.ExamService;
import com.hexam.services.exam.ExamSettingsServiceImpl;
import com.hexam.services.teacher.TeacherService;
import com.hexam.utils.formatter.DoubleFormatter;
import com.hexam.utils.formatter.IntegerFormatter;
import com.hexam.utils.formatter.LocalDateTimeFormatter;
import com.hexam.utils.generator.CodeGenerator;
import com.hexam.utils.loader.SecurityInformationLoader;
import com.hexam.validator.ExamValidator;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

/**
 * @author trhiep
 */
@Controller
@RequestMapping("/giao-vien")
public class TeacherController {

    @Autowired
    PersonRepository personRepository;

    @Autowired
    TeacherService teacherService;

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
    public String homePage(Model model) {
        getUserDetailsInf(model);
        model.addAttribute("toastMessage", (String) model.getAttribute("toastMessage"));
        return "pages/teacher/index";
    }
}
