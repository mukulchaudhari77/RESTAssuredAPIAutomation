package com.demo.tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.annotations.*;
import java.util.HashMap;
import java.util.Map;
import static io.restassured.RestAssured.*;
import org.testng.Assert;

public class HttpLocalRestAPI {

	@Test(priority = 0)
	public void getListOfMovies() {
		Response response = given().get("http://localhost:3000/Movies").then().extract().response();
		System.out.println(response.asPrettyString());
		Assert.assertEquals(response.statusCode(), 200);
	}
	@Test(priority = 1)
	public void getListOfCricketers() {
		given().
		get("http://localhost:3000/Cricketers").
		then().
		statusCode(200).log().all();
	}
	@Test(priority = 2)
	public void getListOfCars() {
		Response response = get("http://localhost:3000/Cars");
		System.out.println(response.asPrettyString());
		System.out.println(response.getStatusCode());
	}
	@Test(priority = 3)
	public void getSingleMovieById() {
		Response response = get("http://localhost:3000/Movies/2");
		System.out.println(response.asPrettyString());
		System.out.println(response.getStatusCode());
	}
	@Test(priority = 4)
	public void getSingleCricketerById() {
		Response response = get("http://localhost:3000/Cricketers/4");
		System.out.println(response.asPrettyString());
		System.out.println(response.getStatusCode());
	}
	@Test(priority = 5)
	public void getSingleCarById() {
		Response response = get("http://localhost:3000/Cars/3");
		System.out.println(response.asPrettyString());
		System.out.println(response.getStatusCode());
	}
	@Test(priority = 6)
	public void postdataToMovies() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", 4);
		map.put("title", "Red Notice");
		map.put("series", "Dwyane Johnson");
		JSONObject request = new JSONObject(map);
		baseURI = "http://localhost:3000";
		given().
		contentType(ContentType.JSON).accept(ContentType.JSON).body(request.toJSONString()).
		when().post("/Movies").
		then().statusCode(500).log().all();
	}
	@Test(priority = 7)
	public void putdataToMovies() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", 3);
		map.put("title", "Harry Potter");
		map.put("parts", 8);
		JSONObject request = new JSONObject(map);
		baseURI = "http://localhost:3000";
		given().
		contentType(ContentType.JSON).accept(ContentType.JSON).body(request.toJSONString()).
		when().post("/Movies").
		then().statusCode(500).log().all();
	}
}
