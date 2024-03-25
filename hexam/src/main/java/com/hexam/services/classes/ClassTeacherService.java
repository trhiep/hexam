package com.hexam.services.classes;

import com.hexam.models.ClassTeacher;
import com.hexam.models.Classes;
import com.hexam.models.Person;

/**
 * @author trhiep
 */
public interface ClassTeacherService {
    ClassTeacher findClassTeacherByPersonPersonIdAndClassesClassId(Long personId, Long classId);
    ClassTeacher findClassTeacherByPersonPersonIdAndClasses_JoinCode(Long personId, String joinCode);
}
