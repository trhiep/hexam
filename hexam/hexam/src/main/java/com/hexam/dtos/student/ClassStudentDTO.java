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
    private Long studentId;
    private Long classId;
    private String className;
    private String classUrl;
    private String joinCode;
    private Boolean active;
    private LocalDateTime lastModifiedDate;

    public ClassStudentDTO() {
    }

    public ClassStudentDTO(Long studentId, Long classId, String className, String classUrl, String joinCode, Boolean active, LocalDateTime lastModifiedDate) {
        this.studentId = studentId;
        this.classId = classId;
        this.className = className;
        this.classUrl = classUrl;
        this.joinCode = joinCode;
        this.active = active;
        this.lastModifiedDate = lastModifiedDate;
    }
}
