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
public class ExamSettings {


    @Id
    @OneToOne
    @JoinColumn(name = "exam_id", referencedColumnName = "exam_id")
    private Exam exam;

    @NotEmpty
    @Column(name = "exam_name")
    private String examName;

    @Column(name = "exam_description")
    private String examDescription;

    @Column(name = "image_link")
    private String imageLink;

    @NotEmpty
    @Column(name = "publication")
    private Integer publication;

    @Column(name = "start_date")
    private LocalDateTime startDate;

    @Column(name = "end_date")
    private LocalDateTime endDate;

    @NotEmpty
    @Column(name = "duration")
    private Integer duration;

    @Column(name = "attempts")
    private Integer attempts;

    @NotEmpty
    @Column(name = "pass_score")
    private Double passScore;

    @Column(name = "modified_date")
    private LocalDateTime modifiedDate;
}
