package com.hexam.utils.formatter;

/**
 * @author trhiep
 */
public class DoubleFormatter {
    public static Double getDoubleFromString(String inputtedValue) {
        try {
            return Double.parseDouble(inputtedValue);
        } catch (NumberFormatException exception) {
            System.out.println("Invalid number!");
        }
        return null;
    }
}
