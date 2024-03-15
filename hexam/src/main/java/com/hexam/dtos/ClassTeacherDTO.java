package com.hexam.dtos;

import com.hexam.constants.EntityErrorMessage;
import com.hexam.models.Classes;
import jakarta.persistence.Column;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author trhiep
 */
@Data
@Builder
public class ClassTeacherDTO {
    private Integer teacherId;
    private Integer classId;
    private String className;
    private String joinCode;
    private Boolean active;
    private LocalDateTime lastModifiedDate;

    public ClassTeacherDTO() {
    }

    public ClassTeacherDTO(Integer teacherId, Integer classId, String className, String joinCode, Boolean active, LocalDateTime lastModifiedDate) {
        this.teacherId = teacherId;
        this.classId = classId;
        this.className = className;
        this.joinCode = joinCode;
        this.active = active;
        this.lastModifiedDate = lastModifiedDate;
    }
}
