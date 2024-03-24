package com.hexam.services.teacher;

import com.hexam.dtos.teacher.ClassTeacherDTO;

import java.util.List;

/**
 * @author trhiep
 */

public interface TeacherService {

    List<ClassTeacherDTO> findClassesForTeacherByPersonId(Long personId);

}
