package com.hexam.utils.formatter;

/**
 * @author trhiep
 */
public class IntegerFormatter {
    public static Integer getIntegerFromString(String inputtedValue) {
        try {
            return Integer.parseInt(inputtedValue);
        } catch (NumberFormatException exception) {
            System.out.println("Invalid number!");
        }
        return null;
    }
}
