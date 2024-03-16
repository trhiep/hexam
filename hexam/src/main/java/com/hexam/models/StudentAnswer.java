package com.hexam.models;

import jakarta.persistence.*;

/**
 * @author trhiep
 */
@Entity
@Table(name = "student_answer")
public class StudentAnswer {

    @Id
    @Column(name = "student_answer_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer studentAnswerId;

    @ManyToOne
    @JoinColumn(name = "person_id", referencedColumnName = "person_id")
    private Person person;

    @ManyToOne
    @JoinColumn(name = "exam_code", referencedColumnName = "exam_code")
    private Exam exam;

    @ManyToOne
    @JoinColumn(name = "question_id", referencedColumnName = "question_id")
    private Answer answerQuestion;

    @ManyToOne
    @JoinColumn(name = "answer_id", referencedColumnName = "answer_id")
    private Answer answer;
}
