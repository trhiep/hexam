package com.hieptv.heducation.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.criteria.CriteriaBuilder;
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
    private Integer examId;

    @NotEmpty
    private String examName;

    private String examDescription;

    private String imageLink;

    @NotEmpty
    private Integer publication;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    @NotEmpty
    private Integer duration;

    private Integer attempts;

    @NotEmpty
    private Double passScore;

    private LocalDateTime modifiedDate;
}
