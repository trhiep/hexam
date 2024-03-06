package com.hexam.services.user;

import com.hexam.models.Person;

/**
 * @author trhiep
 */
public interface UserService {
    Person findByUserName(String userName);

    boolean isExistedUserName(String userName);
    Person findByEmailAddress(String emailAddress);
    boolean isExistedEmail(String email);

}
