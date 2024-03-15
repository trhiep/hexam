package com.hexam.services.teacher;

import com.hexam.dtos.ClassTeacherDTO;
import com.hexam.dtos.TeacherDTO;

import java.util.List;

/**
 * @author trhiep
 */
public interface TeacherService {

    List<ClassTeacherDTO> findClassesForTeacherByPersonId(Integer personId);
}
