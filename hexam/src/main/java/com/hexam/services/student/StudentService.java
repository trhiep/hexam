package com.hexam.services.student;

import com.hexam.dtos.student.ClassStudentDTO;

import java.util.List;

/**
 * @author trhiep
 */
public interface StudentService {
    List<ClassStudentDTO> findClassesForStudentByPersonId(Long personId);
}
