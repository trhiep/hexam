package com.hexam.models;

import com.hexam.constants.EntityConstants;
import com.hexam.constants.EntityErrorMessage;
import com.hexam.utils.formatter.LocalDateTimeFormatter;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
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
    @Column(name = "exam_settings_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long examSettingsId;

    @OneToOne
    @JoinColumn(name = "exam_code", referencedColumnName = "exam_code")
    private Exam exam;

    @NotEmpty(message = EntityErrorMessage.ExamSettings.NOT_EMPTY_EXAM_NAME)
    @Column(name = "exam_name")
    private String examName;

    @Column(name = "exam_description")
    private String examDescription;

    @Column(name = "image_link")
    private String imageLink;

    @NotNull(message = EntityErrorMessage.ExamSettings.NOT_EMPTY_PUBLICATION)
    @Column(name = "publication")
    private Integer publication;

    @Column(name = "start_date")
    private LocalDateTime startDate;

    @Column(name = "end_date")
    private LocalDateTime endDate;

    @NotNull(message = EntityErrorMessage.ExamSettings.NOT_EMPTY_DURATION)
    @Column(name = "duration")
    private Integer duration;

    @Column(name = "attempts")
    private Integer attempts;

    @NotNull(message = EntityErrorMessage.ExamSettings.NOT_EMPTY_PASS_SCORE)
    @Column(name = "pass_score")
    private Double passScore;

    @Column(name = "last_modified_date")
    private LocalDateTime lastModifiedDate;

    @PrePersist
    public void prePersist() {
        imageLink = EntityConstants.Exam.DEFAULT_EXAM_IMAGE;
        lastModifiedDate = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        lastModifiedDate = LocalDateTime.now();
    }

    // Custom Getter
    public String getFormattedStartDate() {
        return LocalDateTimeFormatter.getFormattedLocalDateTimeString(this.startDate);
    }

    public String getFormattedEndDate() {
        return LocalDateTimeFormatter.getFormattedLocalDateTimeString(this.endDate);
    }
}
