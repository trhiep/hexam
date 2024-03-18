package com.hexam.models;

import com.hexam.models.IdClass.ClassTeacherId;
import jakarta.persistence.*;
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
@Table(name = "class_teacher")
@IdClass(ClassTeacherId.class)
public class ClassTeacher {

    @Id
    @ManyToOne
    @JoinColumn(name = "class_id", referencedColumnName = "class_id")
    private Classes classes;

    @Id
    @ManyToOne
    @JoinColumn(name = "person_id", referencedColumnName = "person_id")
    private Person person;

}
