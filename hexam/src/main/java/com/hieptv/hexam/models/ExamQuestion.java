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
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ExamQuestion {

    @Id
    @Column(name = "question_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer questionId;

    @ManyToOne
    @JoinColumn (name = "exam_id", referencedColumnName = "exam_id")
    private Exam exam;

    @NotEmpty
    @Column(name = "content")
    private String content;

    @Column(name = "image_link")
    private String imageLink;

    @Column(name = "modified_date")
    private LocalDateTime modifiedDate;
}
