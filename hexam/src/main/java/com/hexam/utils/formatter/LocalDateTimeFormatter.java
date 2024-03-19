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

    public static void main(String[] args) {
        String date = "32-02-2024 12:00";
        LocalDateTime result = getValidLocalDateTime(date);
        System.out.println(result);
    }
}
