package com.hexam.validator;

import com.hexam.constants.EntityConstants;
import com.hexam.constants.WebErrorMessage;
import com.hexam.utils.formatter.DoubleFormatter;
import com.hexam.utils.formatter.IntegerFormatter;
import com.hexam.utils.formatter.LocalDateTimeFormatter;
import org.springframework.ui.Model;

import java.time.LocalDateTime;

/**
 * @author trhiep
 */
public class ExamValidator {

    public static boolean isValidExamName(String examName, Model model) {
        if (examName.isEmpty()
                || examName.length() < EntityConstants.Exam.EXAM_NAME_MIN_LENGTH
                || examName.length() > EntityConstants.Exam.EXAM_NAME_MAX_LENGTH) {
            model.addAttribute("INVALID_EXAM_NAME",
                    WebErrorMessage.ExamError.INVALID_EXAM_NAME);
            return false;
        }
        return true;
    }

    public static boolean isValidExamStartDate(String examDate, Model model) {
        System.out.println(LocalDateTimeFormatter.getValidLocalDateTime(examDate));
        if (examDate.isEmpty() || LocalDateTimeFormatter.getValidLocalDateTime(examDate) == null) {
            model.addAttribute("INVALID_EXAM_DATE", WebErrorMessage.ExamError.INVALID_EXAM_DATE);
            return false;
        }
        return true;
    }

    public static boolean isValidExamEndDate(String examEndDate, LocalDateTime examStartDate, Model model) {
        LocalDateTime examEndDateFormatted = LocalDateTimeFormatter.getValidLocalDateTime(examEndDate);
        if (examEndDateFormatted == null || examEndDateFormatted.isBefore(examStartDate)) {
            model.addAttribute("INVALID_EXAM_END_DATE", WebErrorMessage.ExamError.INVALID_EXAM_END_DATE);
            return false;
        }
        return true;
    }

    public static boolean isValidExamDuration(String examDuration, Model model) {
        Integer examDurationInt = IntegerFormatter.getIntegerFromString(examDuration);
        if (examDuration.isEmpty() || examDurationInt == null
                || examDurationInt < EntityConstants.Exam.EXAM_MIN_DURATION
                || examDurationInt > EntityConstants.Exam.EXAM_MAX_DURATION) {
            model.addAttribute("INVALID_EXAM_DURATION",
                    WebErrorMessage.ExamError.INVALID_EXAM_DURATION);
            return false;
        }
        return true;
    }

    public static boolean isValidExamAttempts(String examAttempts, Model model) {
        Integer examAttemptsInt = IntegerFormatter.getIntegerFromString(examAttempts);
        if (examAttempts.isEmpty() || examAttemptsInt == null
                || examAttemptsInt < EntityConstants.Exam.EXAM_MIN_ATTEMPTS) {
            model.addAttribute("INVALID_EXAM_ATTEMPTS",
                    WebErrorMessage.ExamError.INVALID_EXAM_ATTEMPTS);
            return false;
        }
        return true;
    }

    public static boolean isValidExamPassScore(String examPassScore, Model model) {
        Double examPassScoreDouble = DoubleFormatter.getDoubleFromString(examPassScore);
        if (examPassScore.isEmpty() || examPassScoreDouble == null
                || examPassScoreDouble < EntityConstants.Exam.EXAM_MIN_PASS_SCORE
                || examPassScoreDouble > EntityConstants.Exam.EXAM_MAX_PASS_SCORE) {
            model.addAttribute("INVALID_EXAM_PASS_SCORE",
                    WebErrorMessage.ExamError.INVALID_EXAM_PASS_SCORE);
            return false;
        }
        return true;
    }

    public static boolean isValidExamPublication(String examPublication, Model model) {
        Integer examPublicationInt = IntegerFormatter.getIntegerFromString(examPublication);
        if (examPublication.isEmpty() || examPublicationInt == null
                || examPublicationInt < EntityConstants.Exam.EXAM_PUBLICATION_MIN_VALUE
                || examPublicationInt > EntityConstants.Exam.EXAM_PUBLICATION_MAX_VALUE) {
            model.addAttribute("INVALID_EXAM_PUBLICATION",
                    WebErrorMessage.ExamError.INVALID_EXAM_PUBLICATION);
            return false;
        }
        return true;
    }

}
