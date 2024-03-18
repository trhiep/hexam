package com.hexam.services.exam;

import com.hexam.models.ExamSettings;

import java.util.List;

/**
 * @author trhiep
 */
public interface ExamSettingsService {
    ExamSettings getExamSettingsByExamExamCode(String examCode);
}
