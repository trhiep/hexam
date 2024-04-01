package com.hexam.controllers.teacher;

import com.hexam.config.CustomUserDetails;
import com.hexam.constants.EntityConstants;
import com.hexam.constants.WebErrorMessage;
import com.hexam.constants.WebSuccessMessage;
import com.hexam.models.Exam;
import com.hexam.models.ExamSettings;
import com.hexam.models.Person;
import com.hexam.repositories.exam.ExamRepository;
import com.hexam.repositories.person.PersonRepository;
import com.hexam.services.exam.ExamSettingsServiceImpl;
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
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

/**
 * @author trhiep
 */
@Controller
@RequestMapping("/giao-vien/bai-thi")
public class TeacherExamController {
    @Autowired
    ExamRepository examRepository;
    @Autowired
    ExamSettingsServiceImpl examSettingsService;
    @Autowired
    PersonRepository personRepository;

    private void getUserDetailsInf(Model model) {
        CustomUserDetails customUserDetails = SecurityInformationLoader.getCustomUserDetails();
        if (customUserDetails != null) {
            model.addAttribute("person", personRepository.findByUserName(customUserDetails.getUsername()));
        }
    }

    @GetMapping
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
        model.addAttribute("toastMessage", model.getAttribute("toastMessage"));
        return "pages/teacher/my-exam";
    }

    @GetMapping(value = "/tao-bai-thi")
    public String createExamGet(Model model) {
        getUserDetailsInf(model);
        return "pages/teacher/create-exam";
    }

    @PostMapping(value = "/tao-bai-thi")
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
