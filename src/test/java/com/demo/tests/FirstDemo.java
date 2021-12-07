package com.demo.tests;

import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.*;
import static io.restassured.RestAssured.*;
import io.restassured.response.Response;

public class FirstDemo extends BaseTest{

	@Test
	public static void getlistOfUserByPageNo() {
		int pageNumber = 1;
		Response response = given().queryParam("page", pageNumber)
				.when().
				get("users")
				.then().
				extract().response();
		Assert.assertEquals(response.statusCode(), 200);
		JsonPath jsonPath = new JsonPath(response.asString());
		Assert.assertEquals(jsonPath.getInt("page"), pageNumber);
		Assert.assertEquals(jsonPath.getInt("per_page"), 6);
		Assert.assertEquals(jsonPath.getInt("total"), 12);
		Assert.assertEquals(jsonPath.getList("data").size(), 6);
		Assert.assertTrue(jsonPath.getString("data[3].email").contains("@reqres.in"));
		Assert.assertEquals(jsonPath.getString("data[0].email"), "george.bluth@reqres.in");
	}
}
