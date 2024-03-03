package com.hieptv.hexam.models;

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
public class ClassExam {

    @Id
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "class_id", referencedColumnName = "class_id")
    private Classes classes;

    @Id
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "exam_id", referencedColumnName = "exam_id")
    private Exam exam;
}
