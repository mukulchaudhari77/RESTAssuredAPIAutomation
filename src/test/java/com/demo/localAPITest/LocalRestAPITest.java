package com.demo.localAPITest;

import static com.demo.resources.Payload2.createUserData2;
import static com.demo.resources.Payload2.updateUserData3;
import static com.demo.utils.Formatter.convertResponseToJsonPath;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class LocalRestAPITest {

	@Test(priority = 0)
	public void getListOfMovies() {
		Response response = given().get("http://localhost:3000/Movies")
				.then().extract().response();
		Assert.assertEquals(response.statusCode(), 200);
		JsonPath jsonPath = convertResponseToJsonPath(response);
		Assert.assertEquals(jsonPath.getInt("id[1]"), 2);
		Assert.assertEquals(jsonPath.getString("title[2]"),"Harry Potter");
		Assert.assertEquals(jsonPath.getString("series[3]"),"Dwyane Johnson");
	}
	@Test(priority = 1)
	public void getListOfCricketers() {
		Response response = given().get("http://localhost:3000/Cricketers")
				.then().extract().response();
		Assert.assertEquals(response.statusCode(), 200);
		JsonPath jsonPath = convertResponseToJsonPath(response);
		Assert.assertEquals(jsonPath.getInt("id[0]"), 1);
		Assert.assertEquals(jsonPath.getString("name[2]"),"ABdevillers");
		Assert.assertEquals(jsonPath.getString("country[1]"),"India");
	}
	@Test(priority = 2)
	public void getListOfCars() {
		Response response = given().get("http://localhost:3000/Cars")
				.then().extract().response();
		Assert.assertEquals(response.statusCode(), 200);
		JsonPath jsonPath = convertResponseToJsonPath(response);
		Assert.assertEquals(jsonPath.getInt("id[0]"), 1);
		Assert.assertEquals(jsonPath.getString("name[2]"),"Swift");
		Assert.assertEquals(jsonPath.getString("brand[1]"),"BMW");
	}
	@Test(priority = 3)
	public void getSingleMovieById() {
		Response response = given().get("http://localhost:3000/Movies/2")
				.then().extract().response();
		JsonPath jsonPath = convertResponseToJsonPath(response);
		Assert.assertEquals(jsonPath.getInt("id"), 2);
		Assert.assertEquals(jsonPath.getString("title"),"Fast And Furious");
		Assert.assertEquals(jsonPath.getString("series"),"Universal Pictures");
	}
	@Test(priority = 4)
	public void getSingleCricketerById() {
		Response response = given().get("http://localhost:3000/Cricketers/4")
				.then().extract().response();
		Assert.assertEquals(response.statusCode(), 200);
		JsonPath jsonPath = convertResponseToJsonPath(response);
		Assert.assertEquals(jsonPath.getInt("id"), 4);
		Assert.assertEquals(jsonPath.getString("name"),"Glein Maxwell");
		Assert.assertEquals(jsonPath.getString("country"),"Australia");
	}
	@Test(priority = 5)
	public void getSingleCarById() {
		Response response = given().get("http://localhost:3000/Cars/3")
				.then().extract().response();
		Assert.assertEquals(response.statusCode(), 200);
		JsonPath jsonPath = convertResponseToJsonPath(response);
		Assert.assertEquals(jsonPath.getInt("id"), 3);
		Assert.assertEquals(jsonPath.getString("name"),"Swift");
		Assert.assertEquals(jsonPath.getString("brand"),"Suzuki");

	}
	@Test(priority = 6)
	public void postdataToMovies() {
		baseURI = "http://localhost:3000";
		String title = "Dabang";
		String series = "Bollywood";
		Response response = given().
				when().contentType(ContentType.JSON)
				.body(createUserData2(title , series))
				.post("/Movies")
				.then().extract().response();
		Assert.assertEquals(response.statusCode(),500);
	}
	@Test(priority = 7)
	public void putdataToMovies() {
		baseURI = "http://localhost:3000";
		String title = "Dabang 2";
		Response response = given().
				when().contentType(ContentType.JSON)
				.body(updateUserData3(title))
				.post("/Movies")
				.then().extract().response();
		Assert.assertEquals(response.statusCode(), 500);
	}
}
