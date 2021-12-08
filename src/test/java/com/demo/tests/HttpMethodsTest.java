package com.demo.tests;

import static com.demo.resources.Payload.*;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static com.demo.utils.Formatter.convertResponseToJsonPath;
import static io.restassured.RestAssured.*;


public class HttpMethodsTest extends BaseTest {

    @Test(priority = 1)
    public void testCreateUser() {
        String name = "Raghav";
        String job = "Teacher";

        Response response = given().
                when().contentType(ContentType.JSON)
                .body(createUserData(name, job))
                .post("users")
                .then().extract().response();
        Assert.assertEquals(response.statusCode(), 201);
        JsonPath jsonPath = convertResponseToJsonPath(response);
        Assert.assertEquals(jsonPath.getString("name"), name);
        Assert.assertEquals(jsonPath.getString("job"), job);
    }

    @Test(priority = 2)
    public void updateUserTest() {
        Response response = given().contentType(ContentType.JSON)
                .body(updateUserData("Mukul", "Software Engineer", "TestingAutomation"))
                .when().put("/users/2")
                .then().extract().response();
        Assert.assertEquals(response.statusCode(), 200);
    }

    @Test(priority = 3)
    public void httpPatchMethod() {
        Response response = given().contentType(ContentType.JSON)
                .body(updateUserData("Mukul", "Software Engineer", "TestingAutomation"))
                .when().patch("api/users/2")
                .then().extract().response();
        Assert.assertEquals(response.statusCode(), 200);
    }

    @Test(priority = 4)
    public void httpDeleteMethodbyId() {
        when().
                delete("api/users/2").
                then().
                statusCode(204).log().all();
    }
}