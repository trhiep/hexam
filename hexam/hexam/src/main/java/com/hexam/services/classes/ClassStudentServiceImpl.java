package com.hexam.services.classes;

import com.hexam.models.ClassEnrollment;
import com.hexam.repositories.classes.ClassRepository;
import com.hexam.repositories.student.ClassStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author trhiep
 */
@Service
public class ClassStudentServiceImpl implements ClassStudentService{
    @Autowired
    ClassStudentRepository classStudentRepository;

    @Override
    public ClassEnrollment findClassEnrollmentByPersonPersonIdAndClassesClassId(Long personId, Long classId) {
        return classStudentRepository.findClassEnrollmentByPersonPersonIdAndClassesClassId(personId, classId);
    }

    @Override
    public ClassEnrollment findClassEnrollmentByPersonIdAndClassUrl(Long personId, String classUrl) {
        return classStudentRepository.findClassEnrollmentByPersonPersonIdAndClassesClassUrl(personId, classUrl);
    }

}
