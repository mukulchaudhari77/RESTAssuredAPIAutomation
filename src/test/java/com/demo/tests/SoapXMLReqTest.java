package com.demo.tests;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class SoapXMLReqTest {

	@Test
	public void validateSoapXML() throws IOException {
		File file = new File("./SoapReq/Add.xml");

		if (file.exists())
			System.out.println("   >> FILE Exists");
		FileInputStream fileinputstream =new FileInputStream(file);
		String requestBody = IOUtils.toString(fileinputstream, "UTF-8");
		baseURI="http://www.dneonline.com";
		given().contentType("text/xml").accept(ContentType.XML).
		body(requestBody).
		when().post("calculator.asmx").
		then().statusCode(200).and().log().all();
	}
}
