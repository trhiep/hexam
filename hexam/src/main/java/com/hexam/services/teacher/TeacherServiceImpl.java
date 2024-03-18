package com.hexam.services.teacher;

import com.hexam.dtos.ClassTeacherDTO;
import com.hexam.dtos.TeacherDTO;
import com.hexam.repositories.ClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author trhiep
 */
@Service
public class TeacherServiceImpl implements TeacherService{

    @Autowired
    ClassRepository classRepository;

    @Override
    public List<ClassTeacherDTO> findClassesForTeacherByPersonId(Long personId) {
        return classRepository.findClassesForTeacherByPersonId(personId);
    }
}
