package com.hexam.services.classes;

import com.hexam.models.Classes;
import com.hexam.repositories.classes.ClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author trhiep
 */

@Service
public class ClassServiceImpl implements ClassService{

    @Autowired
    ClassRepository classRepository;

    @Override
    public void saveClass(Classes classes) {
        classRepository.save(classes);
    }

    @Override
    public Classes getClassByJoinCode(String joinCode) {
        return classRepository.getClassByJoinCode(joinCode);
    }

    @Override
    public Classes getClassByClassUrl(String classUrl) {
        return classRepository.getClassByClassUrl(classUrl);
    }
}
