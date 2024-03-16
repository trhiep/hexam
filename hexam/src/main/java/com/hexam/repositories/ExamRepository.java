package com.hexam.repositories;

import com.hexam.models.Exam;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author trhiep
 */
public interface ExamRepository extends JpaRepository<Exam, Integer> {
    List<Exam> findExamsByPersonPersonId(Integer personId);
}
