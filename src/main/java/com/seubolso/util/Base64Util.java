package com.seubolso.util;

import java.util.Base64;

public class Base64Util {

    public static boolean isBase64(String value) {
        try {
            Base64.getDecoder().decode(value);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    public static byte[] decode(String base64) {
        return Base64.getDecoder().decode(base64);
    }

    public static String encode(byte[] data) {
        return Base64.getEncoder().encodeToString(data);
    }
}
