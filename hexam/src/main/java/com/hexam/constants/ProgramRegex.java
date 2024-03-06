package com.hexam.constants;

/**
 * @author trhiep
 */
public interface ProgramRegex {
    interface UserInformationRegex {
        String USERNAME_REGEX = "^[a-z0-9]{3,25}$";

        String EMAIL_REGEX = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";

        String PASSWORD_REGEX = "(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,}";
    }
}
