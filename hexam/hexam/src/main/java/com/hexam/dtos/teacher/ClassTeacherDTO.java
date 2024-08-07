package com.hexam.dtos.teacher;

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
    private Long teacherId;
    private Long classId;
    private String className;
    private String classUrl;
    private String joinCode;
    private Boolean active;
    private LocalDateTime lastModifiedDate;

    public ClassTeacherDTO() {
    }

    public ClassTeacherDTO(Long teacherId, Long classId, String className, String classUrl, String joinCode, Boolean active, LocalDateTime lastModifiedDate) {
        this.teacherId = teacherId;
        this.classId = classId;
        this.className = className;
        this.classUrl = classUrl;
        this.joinCode = joinCode;
        this.active = active;
        this.lastModifiedDate = lastModifiedDate;
    }
}
