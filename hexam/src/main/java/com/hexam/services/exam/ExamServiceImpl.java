package com.hexam.services.exam;

import com.hexam.models.Exam;
import com.hexam.repositories.ExamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author trhiep
 */
@Service
public class ExamServiceImpl implements ExamService {

    @Autowired
    ExamRepository examRepository;

    @Override
    public List<Exam> findExamsByPersonPersonId(Long personId) {
        return examRepository.findExamsByPersonPersonId(personId);
    }
}
