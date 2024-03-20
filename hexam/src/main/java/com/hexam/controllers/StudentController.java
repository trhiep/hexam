package com.hexam.controllers;

import com.hexam.config.CustomUserDetails;
import com.hexam.models.Person;
import com.hexam.repositories.PersonRepository;
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
@RequestMapping("/hoc-sinh/")
public class StudentController {

    @Autowired
    PersonRepository personRepository;

    private void getUserDetailsInf(Model model) {
        CustomUserDetails customUserDetails = SecurityInformationLoader.getCustomUserDetails();
        if (customUserDetails != null) {
            model.addAttribute("person", personRepository.findByUserName(customUserDetails.getUsername()));
        }
    }

    @GetMapping
    public String index(Model model) {
        getUserDetailsInf(model);
        Person person = (Person) model.getAttribute("person");
        if (person != null) {
            model.addAttribute("person", person);
        }
        return "pages/student/index";
    }
}
