package com.badou.cloud.commons;

import java.util.HashMap;
import java.util.Map;

public class ResultUtil {

    public static final Map<String, Object> OK = new HashMap<>();
    public static final Map<String, Object> NOT_OK = new HashMap<>();

    static {
        OK.put("success", true);
        NOT_OK.put("success", false);
    }

}
