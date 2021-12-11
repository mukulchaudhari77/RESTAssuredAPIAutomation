package com.demo.resources;

import java.util.HashMap;
import java.util.Map;

public class Payload {
    public static Map<String, String> createUserData(String name, String job) {
        Map<String, String> map = new HashMap<>();
        map.put("name", name);
        map.put("job", job);
        return map;
    }

    public static Map<String, String> updateUserData(String name, String job) {
        Map<String, String> map = new HashMap<>();
        map.put("name", name);
        map.put("job", job);
        return map;
    }

}



