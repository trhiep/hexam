package com.hexam.models;

import com.hexam.constants.ErrorMessage;
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
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "exam_question")
public class ExamQuestion {

    @Id
    @Column(name = "question_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer questionId;

    @ManyToOne
    @JoinColumn (name = "exam_id", referencedColumnName = "exam_id")
    private Exam exam;

    @NotEmpty(message = ErrorMessage.ExamQuestion.NOT_EMPTY_CONTENT)
    @Column(name = "content")
    private String content;

    @Column(name = "image_link")
    @Lob
    private String imageLink;

    @Column(name = "last_modified_date")
    private LocalDateTime lastModifiedDate;

    @PrePersist
    public void prePersist() {
        lastModifiedDate = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        lastModifiedDate = LocalDateTime.now();
    }
}
