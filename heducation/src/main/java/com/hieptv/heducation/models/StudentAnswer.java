package com.hieptv.heducation.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.validation.constraints.NotEmpty;

/**
 * @author trhiep
 */
@Entity
public class StudentAnswer {

    @Id
    @GeneratedValue
    private Integer studentAnswerId;

    @NotEmpty
    private Integer personId;

    @NotEmpty
    private Integer examId;

    @NotEmpty
    private Integer questionId;

    @NotEmpty
    private Integer answerId;
}
