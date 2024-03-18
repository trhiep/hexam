package com.hexam.repositories;

import com.hexam.models.ExamSettings;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author trhiep
 */
public interface ExamSettingsRepository extends JpaRepository<ExamSettings, Long> {
    ExamSettings getExamSettingsByExamExamCode(String examCode);

    List<ExamSettings> getExamSettingsByPublicationAndEndDateAfter(Integer publication, LocalDateTime endDate);
}
