package com.hexam.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author trhiep
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "class_exam")
public class ClassExam {

    @Id
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "class_id", referencedColumnName = "class_id")
    private Classes classes;

    @Id
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "exam_code", referencedColumnName = "exam_code")
    private Exam exam;
}
