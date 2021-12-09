package com.demo.tests;

import static com.demo.resources.Payload.updateUserData;
import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UpdateUserTest extends MainURL{

	@Test
	public void updateUserTest() {
		MainURL.createtest("update user test", "Smoke");
		Response response = given().contentType(ContentType.JSON)
				.body(updateUserData("Mukul", "Software Engineer", "TestingAutomation"))
				.when().put("/users/2")
				.then().extract().response();
		Assert.assertEquals(response.statusCode(), 301);
	}

	@Test
	public void updateUserPatchTest() {
		MainURL.createtest("update the user test", "Smoke");
		Response response = given().contentType(ContentType.JSON)
				.body(updateUserData("Mukul", "Software Engineer", "TestingAutomation"))
				.when().patch("api/users/2")
				.then().extract().response();
		Assert.assertEquals(response.statusCode(), 301);
	}
}
