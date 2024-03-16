package com.hexam.services.exam;

import com.hexam.models.Exam;

import java.util.List;

/**
 * @author trhiep
 */
public interface ExamService {
    List<Exam> findExamsByPersonPersonId(Integer personId);
}
