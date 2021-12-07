package com.demo.tests;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import java.util.HashMap;
import java.util.Map;

public class HttpMethods extends BaseTest {

	@Test(priority = 0)
	public void httpGetUserMethod() {
		int pageNumber = 1;
		Response response = given().queryParam("page", pageNumber)
				.when().get("users")
				.then().extract().response();
		Assert.assertEquals(response.statusCode(), 200);

		JsonPath jsonPath = new JsonPath(response.asString());
		Assert.assertEquals(jsonPath.getInt("data[2].id"), 3);
		Assert.assertEquals(jsonPath.getString("data[2].email"), "emma.wong@reqres.in");
		Assert.assertEquals(jsonPath.getString("data[2].first_name"), "Emma");
		Assert.assertEquals(jsonPath.getString("data[2].last_name"), "Wong");
		Assert.assertEquals(jsonPath.getString("data[2].avatar"), "https://reqres.in/img/faces/3-image.jpg");
	}
	@Test(priority = 1)
	public void httpPostUserMethod() {	
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("name", "Raghav");
		map.put("job", "Teacher");
		int pageNumber=1;
		Response response = given().queryParam("page", pageNumber).
				when().post("users").
				then().extract().response();
		Assert.assertEquals(response.statusCode(), 415);
	}
	@Test(priority = 2)
	public void httpUpdateUserMethod() {
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
	@Test(priority = 3)
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
	@Test(priority = 4)
	public void httpDeleteMethodbyId() {
		when().
		delete("api/users/2").
		then().
		statusCode(204).log().all();
	}
}
