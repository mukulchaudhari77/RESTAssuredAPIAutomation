package com.demo.tests;

import static org.hamcrest.CoreMatchers.hasItems;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import java.util.HashMap;
import java.util.Map;

public class GetAndPostExm {

	@Test
	public void testGet() {
		baseURI = "https://reqres.in/api";
		given().
		get("/users?page=2").
		then().
		statusCode(200).
		body("data[4].first_name", equalTo("George")).
		body("data.first_name",hasItems("George","Rachel"));
	}
	
	@Test
	public void testPost() {	
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("name", "Raghav");
		map.put("job", "Teacher");
		JSONObject req= new JSONObject(map);
		System.out.println(req.toJSONString());
		given().
		post("/users").
		then().
		statusCode(415);
	}
}
