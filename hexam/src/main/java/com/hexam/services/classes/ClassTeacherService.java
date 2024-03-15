package com.hexam.services.classes;

import com.hexam.models.ClassTeacher;
import com.hexam.models.Classes;
import com.hexam.models.Person;

/**
 * @author trhiep
 */
public interface ClassTeacherService {
    ClassTeacher findClassTeacherByPersonPersonIdAndClassesClassId(Integer personId, Integer classId);
}
