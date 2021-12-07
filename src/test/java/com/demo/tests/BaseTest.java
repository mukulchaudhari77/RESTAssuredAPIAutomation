package com.demo.tests;

import static io.restassured.RestAssured.*;
import org.testng.annotations.*;

public class BaseTest {

	@BeforeTest
	public void setUpBaseURI() {
		baseURI = "https://reqres.in/api";
	}
}
