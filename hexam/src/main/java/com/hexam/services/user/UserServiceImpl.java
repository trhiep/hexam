package com.hexam.services.user;

import com.hexam.models.Person;
import com.hexam.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
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

    @Override
    public boolean isExistedUserName(String userName) {
        return personRepository.findByUserName(userName) == null;
    }

    @Override
    public Person findByEmailAddress(String emailAddress) {
        return personRepository.findByEmailAddress(emailAddress);
    }

    @Override
    public boolean isExistedEmail(String email) {
        return personRepository.findByEmailAddress(email) == null;
    }
}
