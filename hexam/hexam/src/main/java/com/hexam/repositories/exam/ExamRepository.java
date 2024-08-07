package com.hexam.repositories.exam;

import com.hexam.models.Exam;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * @author trhiep
 */
public interface ExamRepository extends JpaRepository<Exam, Long> {
    List<Exam> findExamsByPersonPersonId(Long personId);

    Optional<Exam> findExamsByExamCode(String examCode);

}
