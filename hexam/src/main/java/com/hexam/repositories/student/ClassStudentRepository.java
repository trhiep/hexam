package com.hexam.repositories.student;

import com.hexam.models.ClassEnrollment;
import com.hexam.models.IdClass.ClassEnrollmentId;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author trhiep
 */
public interface ClassStudentRepository extends JpaRepository<ClassEnrollment, ClassEnrollmentId> {
    ClassEnrollment findClassEnrollmentByPersonPersonIdAndClassesClassId(Long personId, Long classId);
    ClassEnrollment findClassEnrollmentByPersonPersonIdAndClassesJoinCode(Long personId, String joinCode);
}
