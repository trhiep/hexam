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
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "exam_settings")
public class ExamSettings {

    @Id
    @OneToOne
    @JoinColumn(name = "exam_id", referencedColumnName = "exam_id")
    private Exam exam;

    @NotEmpty(message = ErrorMessage.ExamSettings.NOT_EMPTY_EXAM_NAME)
    @Column(name = "exam_name")
    private String examName;

    @Column(name = "exam_description")
    private String examDescription;

    @Column(name = "image_link")
    private String imageLink;

    @NotEmpty(message = ErrorMessage.ExamSettings.NOT_EMPTY_PUBLICATION)
    @Column(name = "publication")
    private Integer publication;

    @Column(name = "start_date")
    private LocalDateTime startDate;

    @Column(name = "end_date")
    private LocalDateTime endDate;

    @NotEmpty(message = ErrorMessage.ExamSettings.NOT_EMPTY_DURATION)
    @Column(name = "duration")
    private Integer duration;

    @Column(name = "attempts")
    private Integer attempts;

    @NotEmpty(message = ErrorMessage.ExamSettings.NOT_EMPTY_PASS_SCORE)
    @Column(name = "pass_score")
    private Double passScore;

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
