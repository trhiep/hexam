package com.hexam.controllers.admin;

import com.hexam.config.CustomUserDetails;
import com.hexam.dtos.teacher.TeacherDTO;
import com.hexam.repositories.person.PersonRepository;
import com.hexam.services.user.UserServiceImpl;
import com.hexam.utils.loader.SecurityInformationLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author trhiep
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    PersonRepository personRepository;

    @Autowired
    UserServiceImpl userService;

    private void getUserDetailsInf(Model model) {
        CustomUserDetails customUserDetails = SecurityInformationLoader.getCustomUserDetails();
        if (customUserDetails != null) {
            model.addAttribute("person", personRepository.findByUserName(customUserDetails.getUsername()));
        }
    }

    @GetMapping
    public String index() {
        return "redirect:/admin/";
    }

    @RequestMapping("/")
    public String admin(Model model) {
        getUserDetailsInf(model);
        return "pages/admin/index";
    }

    @RequestMapping("/quan-ly-giao-vien")
    public String getTeacherList(Model model) {
        List<TeacherDTO> teachers = userService.findAllTeacher();
        model.addAttribute("teachers", teachers);
        getUserDetailsInf(model);
        return "pages/admin/person-mng/teacher/teacher-list";
    }

}
