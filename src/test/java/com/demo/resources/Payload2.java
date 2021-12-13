package com.demo.resources;

import java.util.HashMap;
import java.util.Map;

public class Payload2 {
	public static Map<String, Object> createUserData2(int id, String title, String series) {
		Map<String, Object> map1 = new HashMap<>();
		map1.put("id", id);
		map1.put("title", title);
		map1.put("series", series);
		return map1;
	}
	public static Map<String, Object> updateUserData3(int id, String title, String series) {
		Map<String, Object> map2 = new HashMap<>();
		map2.put("id", id);
		map2.put("title", title);
		map2.put("series", series);
		return map2;
	}
}