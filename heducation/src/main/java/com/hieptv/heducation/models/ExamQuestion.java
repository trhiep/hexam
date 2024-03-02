package com.hieptv.heducation.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
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
    @GeneratedValue
    private Integer questionId;

    @NotEmpty
    private Integer examId;

    @NotEmpty
    private String content;

    private String imageLink;

    private LocalDateTime modifiedDate;
}
