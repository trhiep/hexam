package com.hexam.repositories;

import com.hexam.models.ExamSettings;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author trhiep
 */
public interface ExamSettingsRepository extends JpaRepository<ExamSettings, Long> {
}
