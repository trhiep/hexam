package com.hexam.repositories.exam;

import com.hexam.models.Exam;
import com.hexam.models.ExamSettings;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 * @author trhiep
 */
public interface ExamSettingsRepository extends JpaRepository<ExamSettings, Long> {
    ExamSettings getExamSettingsByExamExamCode(String examCode);

    List<ExamSettings> getExamSettingsByPublicationAndEndDateAfter(Integer publication, LocalDateTime endDate);

    Optional<ExamSettings> findExamSettingsByExam(Exam exam);

    ExamSettings findExamSettingsByExamExamCodeAndExamPersonPersonId(String examCode, Long personId);
    ExamSettings findExamSettingsByExamExamCode(String examCode);
}
