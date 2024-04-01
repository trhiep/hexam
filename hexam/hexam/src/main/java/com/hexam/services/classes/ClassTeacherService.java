package com.hexam.services.classes;

import com.hexam.models.ClassTeacher;

/**
 * @author trhiep
 */
public interface ClassTeacherService {
    ClassTeacher findClassTeacherByPersonIdAndClassId(Long personId, Long classId);

    ClassTeacher findClassTeacherByPersonIdAndClassUrl(Long personId, String classUrl);
}
