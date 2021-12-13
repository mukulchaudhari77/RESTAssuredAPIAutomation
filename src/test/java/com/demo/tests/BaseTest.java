package com.demo.tests;

import static io.restassured.RestAssured.baseURI;

import org.testng.annotations.BeforeTest;

import com.demo.report.ReportManager;

public class BaseTest {
	
	@BeforeTest
	protected void setUpbaseURL() {
		baseURI = "https://reqres.in/api";
	}
	protected static void addResponseToReport(String response) {
		ReportManager.logResponse(response);
	}
}
