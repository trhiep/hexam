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


    @Autowired
    ExamService examService;
    @Autowired
    ExamRepository examRepository;
    @Autowired
    ExamSettingsServiceImpl examSettingsService;
    @RequestMapping("/bai-thi")
    public String myExam(Model model) {
        getUserDetailsInf(model);
        Person person = (Person) model.getAttribute("person");
        if (person != null) {
            List<Exam> examsOfPerson = examRepository.findExamsByPersonPersonId(person.getPersonId());
            List<ExamSettings> exams = new ArrayList<>();
            for (Exam examOfPerson : examsOfPerson) {
                exams.add(examSettingsService.getExamSettingsByExamExamCode(examOfPerson.getExamCode()));
            }
            model.addAttribute("exams", exams);
        }
        model.addAttribute("toastMessage", (String) model.getAttribute("toastMessage"));
        return "pages/teacher/my-exam";
    }

    @RequestMapping(value = "/bai-thi/tao-bai-thi", method = RequestMethod.GET)
    public String createExamGet(Model model) {
        getUserDetailsInf(model);
        return "pages/teacher/create-exam";
    }

    @RequestMapping(value = "/bai-thi/tao-bai-thi", method = RequestMethod.POST)
    public String createExamPost(HttpServletRequest request, Model model, RedirectAttributes redirectAttributes) {
        getUserDetailsInf(model);
        Person person = (Person) model.getAttribute("person");

        String examName = request.getParameter("examName");
        boolean isValidExamName = ExamValidator.isValidExamName(examName, model);

        String startDate = request.getParameter("examStartDate");
        boolean isValidExamStartDate = ExamValidator.isValidExamStartDate(startDate, model);

        String endDate = request.getParameter("examEndDate");
        boolean isValidExamEndDate = true;
        if (!endDate.isEmpty() && isValidExamStartDate) {
            isValidExamEndDate = ExamValidator.isValidExamEndDate(endDate, LocalDateTimeFormatter.getValidLocalDateTime(startDate), model);
        }

        String duration = request.getParameter("examDuration");
        boolean isValidExamDuration = ExamValidator.isValidExamDuration(duration, model);

        String publication = request.getParameter("examPublication");
        boolean isValidPublication = ExamValidator.isValidExamPublication(publication, model);

        String attempts = request.getParameter("examAttempts");
        boolean isValidExamAttempt = true;
        if(!attempts.isEmpty()) {
            isValidExamAttempt = ExamValidator.isValidExamAttempts(attempts, model);
        }

        String passScore = request.getParameter("examPassScore");
        boolean isValidExamPassScore = ExamValidator.isValidExamPassScore(passScore, model);

        if (isValidExamName
                && isValidExamStartDate
                && isValidExamEndDate
                && isValidExamDuration
                && isValidPublication
                && isValidExamAttempt
                && isValidExamPassScore) {
            String examCode = CodeGenerator.generateRandomString(EntityConstants.Exam.EXAM_CODE_GENERATED_LENGTH);
            Exam newExam = Exam.builder()
                    .examCode(examCode)
                    .person(person)
                    .build();
            ExamSettings newExamSettings = ExamSettings.builder()
                    .exam(newExam)
                    .examName(examName)
                    .publication(IntegerFormatter.getIntegerFromString(publication))
                    .duration(IntegerFormatter.getIntegerFromString(duration))
                    .passScore(DoubleFormatter.getDoubleFromString(passScore))
                    .startDate(LocalDateTimeFormatter.getValidLocalDateTime(startDate))
                    .endDate(LocalDateTimeFormatter.getValidLocalDateTime(endDate))
                    .attempts(IntegerFormatter.getIntegerFromString(attempts))
                    .build();

            boolean isSaveSuccessfully = examSettingsService.saveExamAndExamSettings(newExam, newExamSettings);

            if (isSaveSuccessfully) {
                redirectAttributes.addFlashAttribute("toastMessage", WebSuccessMessage.Exam.SAVE_EXAM_SUCCESSFULLY);
            } else {
                redirectAttributes.addFlashAttribute("toastMessage", WebErrorMessage.ExamError.SAVE_EXAM_FAILED);
            }
        } else {
            return "pages/teacher/create-exam";
        }
        return "redirect:/giao-vien/bai-thi";
    }
}
