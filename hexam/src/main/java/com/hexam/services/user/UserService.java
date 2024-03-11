package com.hexam.services.user;

import com.hexam.dtos.TeacherDTO;
import com.hexam.models.Person;

import java.util.List;

/**
 * @author trhiep
 */
public interface UserService {
    Person findByUserName(String userName);

    boolean isExistedUserName(String userName);
    Person findByEmailAddress(String emailAddress);
    boolean isExistedEmail(String email);

    List<TeacherDTO> findAllTeacher();

}
