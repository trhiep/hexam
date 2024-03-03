package com.hieptv.hexam.models;

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

    @NotEmpty
    @Column(name = "class_name")
    private String className;

    @NotEmpty
    @UniqueElements
    @Column(name = "join_code")
    private String joinCode;

    @NotEmpty
    @Column(name = "active")
    private Boolean active;

    @NotEmpty
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
