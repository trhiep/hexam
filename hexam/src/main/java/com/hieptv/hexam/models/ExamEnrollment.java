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
public class ExamEnrollment {

    @Id
    @Column(name = "enrollment_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer enrollmentId;

    @ManyToOne
    @JoinColumn(name = "person_id", referencedColumnName = "person_id")
    private Person person;

    @ManyToOne
    @JoinColumn(name = "exam_id", referencedColumnName = "exam_id")
    private Exam exam;

    @NotEmpty
    @Column(name = "enroll_time")
    private LocalDateTime enrollTime;

    @PrePersist
    public void prePersist() {
        enrollTime = LocalDateTime.now();
    }
}
