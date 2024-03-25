package com.hexam.services.classes;

import com.hexam.models.ClassEnrollment;

/**
 * @author trhiep
 */
public interface ClassStudentService {
    ClassEnrollment findClassEnrollmentByPersonPersonIdAndClassesClassId(Long personId, Long classId);
}
