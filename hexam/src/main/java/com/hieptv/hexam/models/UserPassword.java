package com.hieptv.hexam.models;

import com.hieptv.hexam.utils.generator.SaltPasswordGenerator;
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
@Table(name = "user_password")
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

    @Column(name = "last_modified_date")
    private LocalDateTime lastModifiedDate;

    @PrePersist
    public void prePersist() {
        pwdSalt = SaltPasswordGenerator.getSalt();
        lastModifiedDate = LocalDateTime.now();
    }
    @PreUpdate
    public void preUpdate() {
        pwdSalt = SaltPasswordGenerator.getSalt();
        lastModifiedDate = LocalDateTime.now();
    }

}
