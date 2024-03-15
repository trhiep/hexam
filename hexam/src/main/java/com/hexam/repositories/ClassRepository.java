package com.hexam.repositories;

import com.hexam.dtos.TeacherDTO;
import com.hexam.models.Classes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author trhiep
 */
public interface ClassRepository extends JpaRepository<Classes, Integer> {

    @Query(value = """
            SELECT new com.hexam.dtos.TeacherDTO
            (
                p.personId,
                p.profileImage,
                p.fullName,
                p.userName,
                p.emailAddress,
                p.enable
            )
            FROM Person p
            WHERE p.userRole.roleCode = 'TEACH'
            """
    )
    List<TeacherDTO> findAllTeacher();
}
