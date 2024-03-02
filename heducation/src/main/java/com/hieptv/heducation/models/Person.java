package com.hieptv.heducation.models;

import com.hieptv.heducation.constants.ErrorMessage;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author trhiep
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Person {

    @Id
    @GeneratedValue
    private Integer personId;

    @NotEmpty
    private String userType;

    @NotEmpty(message = ErrorMessage.Person.NOT_EMPTY_USERNAME)
    private String userName;

    private String fullName;

    @NotEmpty
    private String emailAddress;

}
