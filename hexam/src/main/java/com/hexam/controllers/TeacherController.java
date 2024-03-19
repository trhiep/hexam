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

    @Autowired
    ClassServiceImpl classService;

    @Autowired
    ClassTeacherRepository classTeacherRepository;

    @RequestMapping("/tao-lop-hoc")
    public String createClass(HttpServletRequest request, Model model, RedirectAttributes redirectAttributes) {
        getUserDetailsInf(model);
        String className = request.getParameter("className");
        String joinCode = CodeGenerator.generateRandomString(6);
        while (true) {
            Classes foundClass = classService.getClassesByJoinCode(joinCode);
            if (foundClass != null) {
                joinCode = CodeGenerator.generateRandomString(6);
            } else {
                break;
            }
        }
        Classes newClass = Classes.builder()
                .className(className)
                .joinCode(joinCode)
                .build();
        classService.saveClass(newClass);

        Person person = (Person) model.getAttribute("person");
        Classes insertedClass = classService.getClassesByJoinCode(joinCode);
        classTeacherRepository.save(new ClassTeacher(insertedClass, person));

        redirectAttributes.addFlashAttribute("toastMessage", "Tạo lớp học thành công!");
        return "redirect:/giao-vien/lop-hoc-cua-toi";
    }

    @Autowired
    ClassTeacherService classTeacherService;
    @RequestMapping("/tham-gia-lop-hoc")
    public String joinClass(HttpServletRequest request, Model model, RedirectAttributes redirectAttributes) {
        getUserDetailsInf(model);
        String joinCode = request.getParameter("joinCode");
        Classes foundClass = classService.getClassesByJoinCode(joinCode);
        if (foundClass == null) {
            redirectAttributes.addFlashAttribute("toastMessage", "Mã tham gia không tồn tại!");
        } else {
            Person person = (Person) model.getAttribute("person");
            ClassTeacher foundClassTeacher = classTeacherService.findClassTeacherByPersonPersonIdAndClassesClassId(person.getPersonId(), foundClass.getClassId());
            if (foundClassTeacher != null) {
                redirectAttributes.addFlashAttribute("toastMessage", "Bạn đang tham gia lớp học này!");
            } else {
                classTeacherRepository.save(new ClassTeacher(foundClass, person));
                redirectAttributes.addFlashAttribute("toastMessage", "Tham gia lớp học thành công!");
            }
        }
        return "redirect:/giao-vien/lop-hoc-cua-toi";
    }



}
