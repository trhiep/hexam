package com.hexam.models;

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
public class ClassTeacherId implements Serializable {
    private Classes classes;
    private Person person;
}
