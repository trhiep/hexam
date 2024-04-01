package com.hexam.models;

import com.hexam.models.IdClass.ClassEnrollmentId;
import jakarta.persistence.*;
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
@Table(name = "class_enrollment")
@IdClass(ClassEnrollmentId.class)
public class ClassEnrollment {

    @Id
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "person_id", referencedColumnName = "person_id")
    private Person person;

    @Id
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "class_id", referencedColumnName = "class_id")
    private Classes classes;

    @Column(name = "enrolled_date")
    private LocalDateTime enrolledDate;

    @Column(name = "left_class")
    private Boolean leftClass;

    @Column(name = "left_date")
    private LocalDateTime leftDate;

    @PrePersist
    public void prePersist() {
        leftClass = true;
        enrolledDate = LocalDateTime.now();
    }
}
