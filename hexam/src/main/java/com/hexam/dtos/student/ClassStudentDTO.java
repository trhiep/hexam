package com.hexam.dtos.student;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author trhiep
 */
@Data
@Builder
public class ClassStudentDTO {
    private Long teacherId;
    private Long classId;
    private String className;
    private String joinCode;
    private Boolean active;
    private LocalDateTime lastModifiedDate;

    public ClassStudentDTO() {
    }

    public ClassStudentDTO(Long teacherId, Long classId, String className, String joinCode, Boolean active, LocalDateTime lastModifiedDate) {
        this.teacherId = teacherId;
        this.classId = classId;
        this.className = className;
        this.joinCode = joinCode;
        this.active = active;
        this.lastModifiedDate = lastModifiedDate;
    }
}
