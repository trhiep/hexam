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
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ExamEnrollment {

    @Id
    @GeneratedValue
    private Integer enrollmentId;

    @NotEmpty
    private Integer personId;

    @NotEmpty
    private Integer examId;

    @NotEmpty
    private LocalDateTime enrollTime;
}
