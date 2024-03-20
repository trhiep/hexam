package com.hexam.services.exam;

import com.hexam.models.Exam;
import com.hexam.models.ExamSettings;
import com.hexam.repositories.ExamRepository;
import com.hexam.repositories.ExamSettingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 * @author trhiep
 */
@Service
public class ExamSettingsServiceImpl implements ExamSettingsService{

    @Autowired
    ExamSettingsRepository examSettingsRepository;
    @Autowired
    ExamRepository examRepository;

    @Override
    public ExamSettings getExamSettingsByExamExamCode(String examCode) {
        return examSettingsRepository.getExamSettingsByExamExamCode(examCode);
    }

    @Override
    public List<ExamSettings> getExamSettingsByPublicationAndEndDateAfter(Integer publication, LocalDateTime endDate) {
        return examSettingsRepository.getExamSettingsByPublicationAndEndDateAfter(publication, endDate);
    }

    @Override
    public boolean saveExamAndExamSettings(Exam exam, ExamSettings examSettings) {
        examRepository.save(exam);
        Optional<Exam> savedExam = examRepository.findExamsByExamCode(exam.getExamCode());
        if (savedExam.isPresent()) {
            examSettingsRepository.save(examSettings);
            Optional<ExamSettings> savedExamSettings = examSettingsRepository.findExamSettingsByExam(exam);
            if (savedExamSettings.isPresent()) {
                return true;
            } else {
                examRepository.delete(exam);
            }
        }
        return false;
    }

    @Override
    public ExamSettings findExamSettingsByExamExamCodeAndExamPersonPersonId(String examCode, Long personId) {
        return examSettingsRepository.findExamSettingsByExamExamCodeAndExamPersonPersonId(examCode, personId);
    }

    @Override
    public ExamSettings findExamSettingsByExamExamCode(String examCode) {
        return examSettingsRepository.findExamSettingsByExamExamCode(examCode);
    }

}
