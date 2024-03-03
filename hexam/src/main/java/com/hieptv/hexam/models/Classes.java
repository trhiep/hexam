package com.hieptv.hexam.models;

import jakarta.persistence.*;
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
public class Classes {

    @Id
    @Column(name = "class_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer classId;

    @NotEmpty
    @Column(name = "class_name")
    private String className;

    @NotEmpty
    @Column(name = "join_code")
    private String joinCode;

    @NotEmpty
    @Column(name = "active")
    private Boolean active;

    @NotEmpty
    @Column(name = "modified_date")
    private LocalDateTime modifiedDate;
}
