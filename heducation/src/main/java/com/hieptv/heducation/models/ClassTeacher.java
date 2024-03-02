package com.hieptv.heducation.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
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
public class ClassTeacher {

    @Id
    @GeneratedValue
    private Integer classTeacherId;

    @NotEmpty
    private Integer classId;

    @NotEmpty
    private Integer personId;

}
