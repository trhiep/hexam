package com.hexam.controllers.teacher;

import com.hexam.config.CustomUserDetails;
import com.hexam.repositories.person.PersonRepository;
import com.hexam.services.teacher.TeacherService;
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
