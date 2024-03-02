package com.hieptv.heducation.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
    private Integer personId;

    private String pwdHash;

    private String pwdSalt;

    private LocalDateTime modifiedDate;

}
