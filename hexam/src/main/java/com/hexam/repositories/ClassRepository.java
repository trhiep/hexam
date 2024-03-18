package com.hexam.repositories;

import com.hexam.dtos.ClassTeacherDTO;
import com.hexam.dtos.TeacherDTO;
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
            SELECT new com.hexam.dtos.ClassTeacherDTO
            (
                p.personId,
                cl.classId,
                cl.className,
                cl.joinCode,
                cl.active,
                cl.lastModifiedDate
            )
            FROM Classes cl JOIN ClassTeacher ct ON cl.classId = ct.classes.classId JOIN Person p ON ct.person.personId = p.personId
            WHERE p.userRole.roleCode = 'TEACH' AND p.personId = :personId
            """
    )
    List<ClassTeacherDTO> findClassesForTeacherByPersonId(@Param("personId") Long personId);

    Classes getClassesByJoinCode(String joinCode);
}
