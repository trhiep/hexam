package com.hexam.repositories.classes;

import com.hexam.dtos.teacher.ClassTeacherDTO;
import com.hexam.dtos.student.ClassStudentDTO;
import com.hexam.models.Classes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author trhiep
 */
public interface ClassRepository extends JpaRepository<Classes, Long> {

    @Query(value = """
            SELECT new com.hexam.dtos.teacher.ClassTeacherDTO
            (
                p.personId,
                cl.classId,
                cl.className,
                cl.classUrl,
                cl.joinCode,
                cl.active,
                cl.lastModifiedDate
            )
            FROM Classes cl JOIN ClassTeacher ct ON cl.classId = ct.classes.classId JOIN Person p ON ct.person.personId = p.personId
            WHERE p.userRole.roleCode = 'TEACH' AND p.personId = :personId
            """
    )
    List<ClassTeacherDTO> findClassesForTeacherByPersonId(@Param("personId") Long personId);

    @Query(value = """
            SELECT new com.hexam.dtos.student.ClassStudentDTO
            (
                p.personId,
                cl.classId,
                cl.className,
                cl.classUrl,
                cl.joinCode,
                cl.active,
                cl.lastModifiedDate
            )
            FROM Classes cl JOIN ClassEnrollment ce ON cl.classId = ce.classes.classId JOIN Person p ON ce.person.personId = p.personId
            WHERE p.userRole.roleCode = 'STUDN' AND p.personId = :personId
            """
    )
    List<ClassStudentDTO> findClassesForStudentByPersonId(@Param("personId") Long personId);

    Classes getClassByJoinCode(String joinCode);

    Classes getClassByClassUrl(String classUrl);
}
