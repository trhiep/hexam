package com.hexam.dtos.student;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author trhiep
 */
@Data
@Builder
public class StudentDTO {
    private Long personId;
    private String profileImage;
    private String fullName;
    private String userName;
    private String emailAddress;
    private Boolean enable;

    public StudentDTO() {
    }

    public StudentDTO(Long personId, String profileImage, String fullName, String userName, String emailAddress, Boolean enable) {
        this.personId = personId;
        this.profileImage = profileImage;
        this.fullName = fullName;
        this.userName = userName;
        this.emailAddress = emailAddress;
        this.enable = enable;
    }
}
