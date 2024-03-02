package com.hieptv.heducation.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
public class Answer {

    @Id
    private Integer questionId;

    @Id
    @GeneratedValue
    private Integer answerId;

    @NotEmpty
    private String title;

    @NotEmpty
    private Boolean correctAns;

    @NotEmpty
    private LocalDateTime modifiedDate = LocalDateTime.now();
}
