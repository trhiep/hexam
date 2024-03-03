package com.hieptv.hexam.models;

import com.hieptv.hexam.constants.ErrorMessage;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author trhiep
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = "user_name"), @UniqueConstraint(columnNames = "email_address")})
public class Person {

    @Id
    @Column(name = "person_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer personId;

    @Column(name = "user_type")
    private String userType;

    @NotEmpty(message = ErrorMessage.Person.NOT_EMPTY_USERNAME)
    @Column(name = "user_name")
    private String userName;

    @Column(name = "full_name")
    private String fullName;

    @NotEmpty(message = ErrorMessage.Person.NOT_EMPTY_EMAIL)
    @Column(name = "email_address")
    private String emailAddress;

}
