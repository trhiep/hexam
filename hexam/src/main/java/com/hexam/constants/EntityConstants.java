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

    interface Exam {
        Integer EXAM_CODE_GENERATED_LENGTH = 8;
        Integer EXAM_NAME_MIN_LENGTH = 5;
        Integer EXAM_NAME_MAX_LENGTH = 100;
        Integer EXAM_DESCRIPTION_MAX_LENGTH = 255;
        Integer EXAM_MIN_DURATION = 5;
        Integer EXAM_MAX_DURATION = 180;
        Integer EXAM_MIN_ATTEMPTS = 1;
        Double EXAM_MIN_PASS_SCORE = 0.0;
        Double EXAM_MAX_PASS_SCORE = 10.0;
        Integer EXAM_PUBLICATION_MIN_VALUE = 1;
        Integer EXAM_PUBLICATION_MAX_VALUE = 3;
        String DEFAULT_EXAM_IMAGE = "http://res.cloudinary.com/duzrv35z5/image/upload/v1710772929/17960224-2ec7-4ec6-be87-09135f82ba3a.jpg";
    }
}
