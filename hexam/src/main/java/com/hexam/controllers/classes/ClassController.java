package com.hexam.controllers.classes;

import com.hexam.config.CustomUserDetails;
import com.hexam.dtos.student.ClassStudentDTO;
import com.hexam.models.ClassEnrollment;
import com.hexam.models.ClassTeacher;
import com.hexam.models.Classes;
import com.hexam.models.Person;
import com.hexam.repositories.person.PersonRepository;
import com.hexam.services.classes.ClassServiceImpl;
import com.hexam.services.classes.ClassStudentServiceImpl;
import com.hexam.services.classes.ClassTeacherServiceImpl;
import com.hexam.services.student.StudentServiceImpl;
import com.hexam.utils.loader.SecurityInformationLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

/**
 * @author trhiep
 */
@Controller
@RequestMapping("/lop-hoc")
public class ClassController {

    @Autowired
    ClassServiceImpl classService;
    @Autowired
    PersonRepository personRepository;
    @Autowired
    ClassStudentServiceImpl classStudentService;
    @Autowired
    ClassTeacherServiceImpl classTeacherService;

    private void getUserDetailsInf(Model model) {
        CustomUserDetails customUserDetails = SecurityInformationLoader.getCustomUserDetails();
        if (customUserDetails != null) {
            model.addAttribute("person", personRepository.findByUserName(customUserDetails.getUsername()));
        }
    }

    @GetMapping("/{joinCode}")
    public String getClassDetails(@PathVariable String joinCode, Model model, RedirectAttributes redirectAttributes) {
        getUserDetailsInf(model);
        Person person = (Person) model.getAttribute("person");
        if (person != null) {
            ClassEnrollment classOfStudent = null;
            ClassTeacher classOfTeacher = null;
            if (person.getUserRole().getRoleCode().equals("STUDN")) {
                classOfStudent = classStudentService.findClassEnrollmentByPersonPersonIdAndClassesJoinCode(person.getPersonId(), joinCode);
            } else if(person.getUserRole().getRoleCode().equals("TEACH")) {
                classOfTeacher = classTeacherService.findClassTeacherByPersonPersonIdAndClasses_JoinCode(person.getPersonId(), joinCode);
            }
            if (classOfStudent == null && classOfTeacher == null) {
                redirectAttributes.addFlashAttribute("toastMessage", "Bạn chưa tham gia lớp học này!");
                return "redirect:/hoc-sinh/";
            } else {
                Classes classInf = classService.getClassesByJoinCode(joinCode);
                model.addAttribute("pageTitle", "Lớp học " + classInf.getClassName());
                model.addAttribute("classInf", classInf);
                return "pages/classes/index";
            }
        } else {
            return "redirect:/";
        }
    }
}
