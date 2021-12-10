package com.demo.resources;

import java.util.HashMap;
import java.util.Map;

public class Payload2 {
	public static Map<String, Object> createUserData2(String title, String series) {
		Map<String, Object> map1 = new HashMap<String, Object>();
		map1.put("id", 6);
		map1.put("title", title);
		map1.put("series", series);
		return map1;
	}
	public static Map<String, Object> updateUserData3(String title) {
		Map<String, Object> map2 = new HashMap<String, Object>();
		map2.put("id", 7);
		map2.put("title", title);
		return map2;
	}
}