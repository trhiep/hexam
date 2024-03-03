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
public class ClassEnrollment {

    @Id
    @ManyToOne
    @JoinColumn(name = "person_id", referencedColumnName = "person_id")
    private Person person;

    @Id
    @ManyToOne
    @JoinColumn(name = "class_id", referencedColumnName = "class_id")
    private Classes classes;

    @NotEmpty
    @Column(name = "enrolled_date")
    private LocalDateTime enrolledDate;

    @NotEmpty
    @Column(name = "cancelled")
    private Boolean cancelled;

    @Column(name = "cancel_reason")
    private String cancelReason;

    @NotEmpty
    @Column(name = "left_class")
    private Boolean leftClass;

    @Column(name = "left_date")
    private LocalDateTime leftDate;
}
