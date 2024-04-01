package com.hexam.services.student;

import com.hexam.dtos.student.ClassStudentDTO;
import com.hexam.models.ClassEnrollment;
import com.hexam.repositories.classes.ClassRepository;
import com.hexam.repositories.student.ClassStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author trhiep
 */
@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    ClassRepository classRepository;
    @Autowired
    ClassStudentRepository classStudentRepository;

    @Override
    public List<ClassStudentDTO> findClassesForStudentByPersonId(Long personId) {
        return classRepository.findClassesForStudentByPersonId(personId);
    }
}
