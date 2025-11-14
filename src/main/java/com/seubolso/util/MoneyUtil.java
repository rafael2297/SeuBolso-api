package com.seubolso.util;

import java.text.DecimalFormat;

public class MoneyUtil {

    private static final DecimalFormat formatter = new DecimalFormat("#,##0.00");

    public static String format(Double value) {
        if (value == null) return "0.00";
        return formatter.format(value);
    }
}
