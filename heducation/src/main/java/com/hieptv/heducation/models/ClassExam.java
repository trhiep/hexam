package com.hieptv.heducation.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
    private Integer classId;

    @Id
    private Integer examId;
}
