package com.hexam.repositories.person;

import com.hexam.dtos.teacher.TeacherDTO;
import com.hexam.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author trhiep
 */
public interface PersonRepository extends JpaRepository<Person, Long> {
    Person findByUserName(String username);

    Person findByEmailAddress(String email);

    @Query(value = """
            SELECT new com.hexam.dtos.teacher.TeacherDTO
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
