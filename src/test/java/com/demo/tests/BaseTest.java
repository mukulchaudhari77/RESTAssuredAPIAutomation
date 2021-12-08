package com.demo.tests;

import static io.restassured.RestAssured.baseURI;

import org.testng.annotations.BeforeTest;

public class BaseTest {

	@BeforeTest
	public void setUpBaseURI() {
		baseURI = "https://reqres.in/api";
	}
}
