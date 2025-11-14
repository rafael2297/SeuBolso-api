package com.seubolso.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateUtil {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public static String toString(LocalDate date) {
        return date != null ? date.format(formatter) : null;
    }

    public static LocalDate toDate(String text) {
        return text != null ? LocalDate.parse(text, formatter) : null;
    }
}
