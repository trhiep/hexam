package com.hieptv.hexam.services.user;

import com.hieptv.hexam.models.Person;
import com.hieptv.hexam.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author trhiep
 */
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private PersonRepository personRepository;

    @Override
    public Person findByUserName(String userName) {
        return personRepository.findByUserName(userName);
    }
}
