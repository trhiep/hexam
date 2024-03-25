package com.hexam.repositories.student;

import com.hexam.models.ClassEnrollment;
import com.hexam.models.ClassTeacher;
import com.hexam.models.IdClass.ClassEnrollmentId;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author trhiep
 */
public interface ClassStudentRepository extends JpaRepository<ClassEnrollment, ClassEnrollmentId> {
    ClassTeacher findClassEnrollmentByPersonPersonIdAndClassesClassId(Long personId, Long classId);
}
