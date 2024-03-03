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
public class UserPassword {

    @Id
    @OneToOne()
    @JoinColumn (name = "person_id", referencedColumnName = "person_id")
    private Person person;

    @Column(name = "pwd_hash")
    @NotEmpty
    private String pwdHash;

    @Column(name = "pwd_salt")
    @NotEmpty
    private String pwdSalt;

    @Column(name = "modified_date")
    private LocalDateTime modifiedDate;

}
