package com.hexam.repositories.teacher;

import com.hexam.models.ClassTeacher;
import com.hexam.models.IdClass.ClassTeacherId;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author trhiep
 */
public interface ClassTeacherRepository extends JpaRepository<ClassTeacher, ClassTeacherId> {
    ClassTeacher findClassTeacherByPersonPersonIdAndClassesClassId(Long personId, Long classId);
    ClassTeacher findClassTeacherByPersonPersonIdAndClassesClassUrl(Long personId, String classUrl);
}
