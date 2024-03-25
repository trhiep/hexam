package com.hexam.controllers.student;

import com.hexam.config.CustomUserDetails;
import com.hexam.dtos.student.ClassStudentDTO;
import com.hexam.models.ClassEnrollment;
import com.hexam.models.Classes;
import com.hexam.models.Person;
import com.hexam.repositories.person.PersonRepository;
import com.hexam.repositories.student.ClassStudentRepository;
import com.hexam.services.classes.ClassServiceImpl;
import com.hexam.services.classes.ClassStudentServiceImpl;
import com.hexam.services.student.StudentServiceImpl;
import com.hexam.utils.loader.SecurityInformationLoader;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author trhiep
 */
@Controller
@RequestMapping("/hoc-sinh")
public class StudentClassController {

    @Autowired
    PersonRepository personRepository;
    @Autowired
    ClassStudentRepository classStudentRepository;
    @Autowired
    StudentServiceImpl studentService;
    @Autowired
    ClassServiceImpl classService;
    @Autowired
    ClassStudentServiceImpl classStudentService;


    private void getUserDetailsInf(Model model) {
        CustomUserDetails customUserDetails = SecurityInformationLoader.getCustomUserDetails();
        if (customUserDetails != null) {
            model.addAttribute("person", personRepository.findByUserName(customUserDetails.getUsername()));
        }
    }

    @RequestMapping("/")
    public String myClass(Model model) {
        getUserDetailsInf(model);
        model.addAttribute("pageTitle", "Lớp học của tôi");
        Person person = (Person) model.getAttribute("person");
        if (person != null) {
            List<ClassStudentDTO> classesOfStudent = studentService.findClassesForStudentByPersonId(person.getPersonId());
            model.addAttribute("classList", classesOfStudent);
        }
        model.addAttribute("toastMessage", (String) model.getAttribute("toastMessage"));
        return "pages/student/my-class";
    }

    @RequestMapping("/tham-gia-lop-hoc")
    public String joinClass(HttpServletRequest request, Model model, RedirectAttributes redirectAttributes) {
        getUserDetailsInf(model);
        String joinCode = request.getParameter("joinCode");
        Classes foundClass = classService.getClassesByJoinCode(joinCode);
        if (foundClass == null) {
            redirectAttributes.addFlashAttribute("toastMessage", "Mã tham gia không tồn tại!");
        } else {
            Person person = (Person) model.getAttribute("person");
            ClassEnrollment foundClassStudent = classStudentService.findClassEnrollmentByPersonPersonIdAndClassesClassId(person.getPersonId(), foundClass.getClassId());
            if (foundClassStudent != null) {
                redirectAttributes.addFlashAttribute("toastMessage", "Bạn đang tham gia lớp học này!");
            } else {
                ClassEnrollment classEnrollment = ClassEnrollment.builder()
                        .person(person)
                        .classes(foundClass)
                        .enrolledDate(LocalDateTime.now())
                        .leftClass(false)
                        .build();
                classStudentRepository.save(classEnrollment);
                redirectAttributes.addFlashAttribute("toastMessage", "Tham gia lớp học thành công!");
            }
        }
        return "redirect:/hoc-sinh/";
    }
}
