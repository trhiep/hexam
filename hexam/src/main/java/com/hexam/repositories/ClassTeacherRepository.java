package com.hexam.repositories;

import com.hexam.models.ClassTeacher;
import com.hexam.models.ClassTeacherId;
import com.hexam.models.Classes;
import com.hexam.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author trhiep
 */
public interface ClassTeacherRepository extends JpaRepository<ClassTeacher, ClassTeacherId> {
    ClassTeacher findClassTeacherByPersonPersonIdAndClassesClassId(Integer personId, Integer classId);
}
