package com.hexam.utils.validator;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * @author trhiep
 */
public class RegexValidator {

    public static boolean isMatches(String regex, String value) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(value);
        return matcher.matches();
    }
}
