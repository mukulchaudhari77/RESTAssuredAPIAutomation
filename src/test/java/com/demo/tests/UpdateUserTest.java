package com.demo.tests;

import static com.demo.resources.Payload.updateUserData;
import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UpdateUserTest extends BaseTest {

	@Test(description = "Test Update the User in the List")
	public void updateUserTest() {
		Response response = given().contentType(ContentType.JSON)
				.body(updateUserData("Mukul", "Software Engineer"))
				.when().put("/users/2")
				.then().extract().response();
		addResponseToReport(response.asPrettyString());
		Assert.assertEquals(response.statusCode(), 200);
		Assert.assertNotNull(response.body());
	}

	@Test(description = "Test Update the User in the List by using Patch")
	public void updateUserPatchTest() {
		Response response = given().contentType(ContentType.JSON)
				.body(updateUserData("Mukul", "Software Engineer"))
				.when().patch("/users/2")
				.then().extract().response();
		addResponseToReport(response.asPrettyString());
		Assert.assertNotNull(response.body());
		Assert.assertEquals(response.statusCode(), 200);
	}
}
