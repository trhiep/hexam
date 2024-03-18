package com.hexam.services.exam;

import com.hexam.models.ExamSettings;
import com.hexam.repositories.ExamSettingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author trhiep
 */
@Service
public class ExamSettingsServiceImpl implements ExamSettingsService{

    @Autowired
    ExamSettingsRepository examSettingsRepository;

    @Override
    public ExamSettings getExamSettingsByExamExamCode(String examCode) {
        return examSettingsRepository.getExamSettingsByExamExamCode(examCode);
    }
}
