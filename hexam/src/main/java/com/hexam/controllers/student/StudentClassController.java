package com.hexam.controllers.student;

import com.hexam.config.CustomUserDetails;
import com.hexam.dtos.teacher.ClassTeacherDTO;
import com.hexam.models.Person;
import com.hexam.repositories.person.PersonRepository;
import com.hexam.services.teacher.TeacherService;
import com.hexam.utils.loader.SecurityInformationLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author trhiep
 */
@Controller
@RequestMapping("/hoc-sinh/lop-hoc")
public class StudentClassController {

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

    @RequestMapping("/lop-hoc-cua-toi")
    public String myClass(Model model) {
        getUserDetailsInf(model);
        model.addAttribute("pageTitle", "Lớp học của tôi");
        Person person = (Person) model.getAttribute("person");
        if (person != null) {
            List<ClassTeacherDTO> classesOfTeacher = teacherService.findClassesForTeacherByPersonId(person.getPersonId());
            model.addAttribute("classList", classesOfTeacher);
        }
        model.addAttribute("toastMessage", (String) model.getAttribute("toastMessage"));
        return "pages/teacher/my-class";
    }
}
