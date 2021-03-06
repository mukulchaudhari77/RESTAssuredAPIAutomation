package com.demo.tests;

import static com.demo.resources.Payload.createUserData;
import static com.demo.utils.Formatter.convertResponseToJsonPath;
import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class PostDemoTest extends BaseTest {

	@Test(description = "Test create User in the List")
	public void testCreateUser() {
		String name = "morpheus";
		String job = "Professor";

		Response response = given()
				.when().contentType(ContentType.JSON).body(createUserData(name, job))
				.post("users")
				.then().extract().response();
		addResponseToReport(response.asPrettyString());
		Assert.assertEquals(response.statusCode(), 201);
		JsonPath jsonPath = convertResponseToJsonPath(response);
		Assert.assertEquals(jsonPath.getString("name"), name);
		Assert.assertEquals(jsonPath.getString("job"), job);
	}
}
