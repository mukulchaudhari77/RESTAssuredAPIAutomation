package com.demo.tests;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class DeleteUserTest extends MainURL {

	@Test
	public void deleteUserByIdTest() {
		MainURL.createtest("delete user test", "Regression");
		Response response = given().contentType(ContentType.JSON)
				.when().delete("api/users/2")
				.then()
				.extract().response();
		Assert.assertEquals(response.statusCode(),301);
	}
}


