package com.hexam.dtos.teacher;

import lombok.Builder;
import lombok.Data;

/**
 * @author trhiep
 */

@Data
@Builder
public class TeacherDTO {
    private Long personId;
    private String profileImage;
    private String fullName;
    private String userName;
    private String emailAddress;
    private Boolean enable;

    public TeacherDTO(Long personId, String profileImage, String fullName, String userName, String emailAddress, Boolean enable) {
        this.personId = personId;
        this.profileImage = profileImage;
        this.fullName = fullName;
        this.userName = userName;
        this.emailAddress = emailAddress;
        this.enable = enable;
    }

    public TeacherDTO() {
    }
}
