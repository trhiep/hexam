package com.hexam.services.classes;

import com.hexam.models.ClassTeacher;
import com.hexam.models.Classes;
import com.hexam.models.Person;
import com.hexam.repositories.ClassTeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author trhiep
 */
@Service
public class ClassTeacherServiceImpl implements ClassTeacherService{

    @Autowired
    ClassTeacherRepository classTeacherRepository;

    @Override
    public ClassTeacher findClassTeacherByPersonPersonIdAndClassesClassId(Long personId, Long classId) {
        return classTeacherRepository.findClassTeacherByPersonPersonIdAndClassesClassId(personId, classId);
    }
}
