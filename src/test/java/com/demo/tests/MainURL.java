package com.demo.tests;

import static io.restassured.RestAssured.baseURI;

import org.testng.annotations.BeforeTest;

public class MainURL {
	
	@BeforeTest
	public void setUpbaseURL() {
		baseURI = "http://reqres.in/api";
	}
	
}
