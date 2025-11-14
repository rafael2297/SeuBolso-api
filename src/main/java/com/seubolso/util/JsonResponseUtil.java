package com.seubolso.util;

import java.util.HashMap;
import java.util.Map;

public class JsonResponseUtil {

    public static Map<String, Object> success(Object data) {
        Map<String, Object> map = new HashMap<>();
        map.put("success", true);
        map.put("data", data);
        return map;
    }

    public static Map<String, Object> error(String message) {
        Map<String, Object> map = new HashMap<>();
        map.put("success", false);
        map.put("error", message);
        return map;
    }
}
