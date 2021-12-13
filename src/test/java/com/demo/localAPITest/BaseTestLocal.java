package com.demo.localAPITest;

import static io.restassured.RestAssured.baseURI;

import org.testng.annotations.BeforeTest;

import com.demo.report.ReportManager;

public class BaseTestLocal {

	@BeforeTest
	protected void setUpbaseURLLocal() {
		baseURI = "http://localhost:3000/";
	}
	protected static void addResponseToReport(String response) {
		ReportManager.logResponse(response);
	}
}
