package com.hieptv.hexam.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author trhiep
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Answer {

    @ManyToOne
    @JoinColumn(name = "question_id", referencedColumnName = "question_id")
    private ExamQuestion examQuestion;

    @Id
    @Column(name = "answer_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer answerId;

    @NotEmpty
    @Column(name = "title")
    private String title;

    @NotEmpty
    @Column(name = "correct_ans")
    private Boolean correctAns;

    @NotEmpty
    @Column(name = "last_modified_date")
    private LocalDateTime lastModifiedDate;

    @PreUpdate
    public void preUpdate() {
        lastModifiedDate = LocalDateTime.now();
    }
}