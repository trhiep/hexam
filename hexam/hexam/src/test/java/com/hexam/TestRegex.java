package com.hexam;

import com.hexam.utils.validator.RegexValidator;

/**
 * @author trhiep
 */
public class TestRegex {
    public static void main(String[] args) {
        System.out.println(RegexValidator.isMatches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", "hieptran.pa@gmail.com"));
        System.out.println(true && false && false && true && false && true && false && false && false && true && false);
    }
}
