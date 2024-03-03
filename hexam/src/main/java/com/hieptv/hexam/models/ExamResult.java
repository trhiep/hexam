package com.hieptv.hexam.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author trhiep
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ExamResult {

    @Id
    @OneToOne
    @JoinColumn(name = "exam_enrollment_id", referencedColumnName = "enrollment_id")
    private ExamEnrollment examEnrollment;

    @NotEmpty
    @Column(name = "score")
    private Double score;

}
