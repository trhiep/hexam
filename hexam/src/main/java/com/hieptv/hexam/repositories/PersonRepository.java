package com.hieptv.hexam.repositories;

import com.hieptv.hexam.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author trhiep
 */
public interface PersonRepository extends JpaRepository<Person, Integer> {
    Person findByUserName(String username);
}
