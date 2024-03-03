package com.hieptv.hexam.models;

import com.hieptv.hexam.constants.ErrorMessage;
import com.hieptv.hexam.utils.generator.CodeGenerator;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.UniqueElements;

import java.time.LocalDateTime;

/**
 * @author trhiep
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = "join_code")})
public class Classes {

    @Id
    @Column(name = "class_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer classId;

    @NotEmpty(message = ErrorMessage.Classes.NOT_EMPTY_CLASS_NAME)
    @Column(name = "class_name")
    private String className;

    @Column(name = "join_code")
    private String joinCode;

    @Column(name = "active")
    private Boolean active;

    @Column(name = "last_modified_date")
    private LocalDateTime lastModifiedDate;

    @PrePersist
    public void prePersist() {
        joinCode = CodeGenerator.generateRandomString(6);
        active = true;
        lastModifiedDate = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        lastModifiedDate = LocalDateTime.now();
    }
}
