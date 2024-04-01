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
    public ClassTeacher findClassTeacherByPersonIdAndClassId(Long personId, Long classId) {
        return classTeacherRepository.findClassTeacherByPersonPersonIdAndClassesClassId(personId, classId);
    }

    @Override
    public ClassTeacher findClassTeacherByPersonIdAndClassUrl(Long personId, String classUrl) {
        return classTeacherRepository.findClassTeacherByPersonPersonIdAndClassesClassUrl(personId, classUrl);
    }

}
