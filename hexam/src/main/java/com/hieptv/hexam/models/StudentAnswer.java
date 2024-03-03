package com.hieptv.hexam.models;

import jakarta.persistence.*;

/**
 * @author trhiep
 */
@Entity
public class StudentAnswer {

    @Id
    @Column(name = "student_answer_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer studentAnswerId;

    @ManyToOne
    @JoinColumn(name = "person_id", referencedColumnName = "person_id")
    private Person person;

    @ManyToOne
    @JoinColumn(name = "exam_id", referencedColumnName = "exam_id")
    private Exam exam;

    @ManyToOne
    @JoinColumn(name = "question_id", referencedColumnName = "question_id")
    private Answer answerQuestion;

    @ManyToOne
    @JoinColumn(name = "answer_id", referencedColumnName = "answer_id")
    private Answer answer;
}
