package com.hexam.services.exam;

import com.hexam.models.Exam;
import com.hexam.models.ExamSettings;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author trhiep
 */
public interface ExamSettingsService {
    ExamSettings getExamSettingsByExamExamCode(String examCode);

    List<ExamSettings> getExamSettingsByPublicationAndEndDateAfter(Integer publication, LocalDateTime endDate);

    boolean saveExamAndExamSettings(Exam exam, ExamSettings examSettings);
}
