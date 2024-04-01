package com.hexam;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author trhiep
 */
public class GetPass {
    public static void main(String[] args) {
        System.out.println(new BCryptPasswordEncoder().encode("123"));
    }
}
