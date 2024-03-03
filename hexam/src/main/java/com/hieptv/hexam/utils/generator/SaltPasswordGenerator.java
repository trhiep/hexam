package com.hieptv.hexam.utils.generator;

import java.security.SecureRandom;
import java.util.Base64;

/**
 * @author trhiep
 */
public class SaltPasswordGenerator {

    private static final int BYTE_LENGTH_OF_SALT = 8;

    public static String getSalt() {
        SecureRandom secureRandom = new SecureRandom();
        byte[] salt = new byte[BYTE_LENGTH_OF_SALT];
        secureRandom.nextBytes(salt);
        return Base64.getEncoder().encodeToString(salt);
    }

}
