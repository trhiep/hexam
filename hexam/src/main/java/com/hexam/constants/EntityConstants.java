package com.hexam.constants;

import jakarta.persistence.criteria.CriteriaBuilder;

/**
 * @author trhiep
 */
public interface EntityConstants {
    interface Person {
        Integer FULL_NAME_MIN_LENGTH = 1;
        Integer FULL_NAME_MAX_LENGTH = 125;
        Integer USER_NAME_MIN_LENGTH = 3;
        Integer USER_NAME_MAX_LENGTH = 35;
        Integer EMAIL_MAX_LENGTH = 125;
        Integer PASSWORD_MIN_LENGTH = 8;
        Integer PASSWORD_MAX_LENGTH = 125;
    }
}
