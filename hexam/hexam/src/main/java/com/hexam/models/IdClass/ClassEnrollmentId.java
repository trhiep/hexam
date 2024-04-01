package com.hexam.models.IdClass;

import com.hexam.models.Classes;
import com.hexam.models.Person;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author trhiep
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClassEnrollmentId implements Serializable {
    private Person person;
    private Classes classes;
}
