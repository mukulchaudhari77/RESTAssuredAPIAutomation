package com.demo.tests;

import static io.restassured.RestAssured.*;
import org.testng.annotations.*;
import io.restassured.http.ContentType;
import java.util.HashMap;
import java.util.Map;
import org.json.simple.JSONObject;

public class PutPatchDelete {
	@BeforeTest
	public void setUpBaseURI() {
		baseURI = "https://reqres.in/api";
	}
	
	@Test
	public void httpPutMethod() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", "Mukul");
		map.put("job", "Software Engineer");
		map.put("role", "TestingAutomation");
		JSONObject req = new JSONObject(map);
		System.out.println(req.toJSONString());
		given().
		contentType(ContentType.JSON).
		accept(ContentType.JSON).
		body(req.toJSONString()).
		when().
		put("/users/2").
		then().
		statusCode(200).log().all();
	}
	@Test
	public void httpPatchMethod() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", "Mukul");
		map.put("job", "Software Engineer");
		map.put("role", "TestingAutomation");
		JSONObject req = new JSONObject(map);
		System.out.println(req.toJSONString());
		given().
		contentType(ContentType.JSON).
		accept(ContentType.JSON).
		body(req.toJSONString()).
		when().
		patch("api/users/2").
		then().
		statusCode(200).log().all();
	}
	@Test
	public void httpDeleteMethod() {
		when().
		delete("api/users/2").
		then().
		statusCode(204).log().all();
	}
}
