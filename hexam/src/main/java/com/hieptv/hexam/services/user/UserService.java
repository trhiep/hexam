package com.hieptv.hexam.services.user;

import com.hieptv.hexam.models.Person;

/**
 * @author trhiep
 */
public interface UserService {
    Person findByUserName(String userName);
}
