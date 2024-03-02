package com.hieptv.heducation.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
public class Enrollment {

    @Id
    private Integer personId;

    @Id
    private Integer classId;

    @NotEmpty
    private LocalDateTime enrolledDate;

    @NotEmpty
    private Boolean cancelled;

    private String cancelReason;

    @NotEmpty
    private Boolean leftClass;

    private LocalDateTime leftDate;
}
