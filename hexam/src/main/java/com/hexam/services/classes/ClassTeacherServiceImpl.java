package com.hexam.services.classes;

import com.hexam.models.ClassTeacher;
import com.hexam.repositories.teacher.ClassTeacherRepository;
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

    @Override
    public ClassTeacher findClassTeacherByPersonPersonIdAndClasses_JoinCode(Long personId, String joinCode) {
        return classTeacherRepository.findClassTeacherByPersonPersonIdAndClasses_JoinCode(personId, joinCode);
    }
}
