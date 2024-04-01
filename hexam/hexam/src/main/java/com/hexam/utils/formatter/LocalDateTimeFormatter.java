package com.hexam.utils.formatter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author trhiep
 */
public class LocalDateTimeFormatter {

    public static LocalDateTime getValidLocalDateTime(String inputtedValue) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        try {
            return LocalDateTime.parse(inputtedValue, formatter);
        } catch (Exception e) {
            System.out.println(inputtedValue);
        }
        return null;
    }

    public static String getFormattedLocalDateTimeString(LocalDateTime inputtedValue) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        try {
            return inputtedValue.format(formatter);
        } catch (Exception e) {
            System.out.println(inputtedValue);
        }
        return null;
    }

    public static void main(String[] args) {
        LocalDateTime test = LocalDateTime.now();
        String result = getFormattedLocalDateTimeString(test);
        System.out.println(result);
    }
}
