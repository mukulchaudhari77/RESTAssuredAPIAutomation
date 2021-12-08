package com.demo.tests;

import static com.demo.utils.Formatter.*;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.*;

import static io.restassured.RestAssured.*;

import io.restassured.response.Response;

public class GetDemoTest extends BaseTest {

    @Test
    public static void getListOfUserByPageNo() {
        int pageNumber = 1;
        Response response = given().queryParam("page", pageNumber)
                .when().get("users").then().extract().response();

        Assert.assertEquals(response.statusCode(), 200);
        JsonPath jsonPath = convertResponseToJsonPath(response);
        Assert.assertEquals(jsonPath.getInt("page"), pageNumber);
        Assert.assertEquals(jsonPath.getInt("per_page"), 6);
        Assert.assertEquals(jsonPath.getInt("total"), 12);
        Assert.assertEquals(jsonPath.getList("data").size(), 6);
        Assert.assertTrue(jsonPath.getString("data[3].email").contains("@reqres.in"));
        Assert.assertEquals(jsonPath.getString("data[0].email"), "george.bluth@reqres.in");

        Assert.assertEquals(jsonPath.getInt("data[2].id"), 3);
        Assert.assertEquals(jsonPath.getString("data[2].email"), "emma.wong@reqres.in");
        Assert.assertEquals(jsonPath.getString("data[2].first_name"), "Emma");
        Assert.assertEquals(jsonPath.getString("data[2].last_name"), "Wong");
        Assert.assertEquals(jsonPath.getString("data[2].avatar"), "https://reqres.in/img/faces/3-image.jpg");
    }
}
