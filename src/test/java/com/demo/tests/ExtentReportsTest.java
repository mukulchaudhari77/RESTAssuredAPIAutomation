package com.demo.tests;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportsTest {
	@Test
	public void extentTest() {
		ExtentReports extent = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter("report/index.html");
		extent.attachReporter(spark);

		spark.config().setTheme(Theme.DARK);
		spark.config().setDocumentTitle("Automation Report");
		spark.config().setReportName("Extent Report");
		extent.attachReporter(spark);
		
		ExtentTest test= extent.createTest("Login Test");
		test.pass("Login Test started successfully");
		test.pass("url is loaded");
		test.pass("value entered");
		test.pass("Login test completed successfully");
		
		ExtentTest test1= extent.createTest("Homepage Test");
		test1.pass("Homepage is started successfully");
		test1.pass("url is loaded");
		test1.pass("value entered");
		test1.fail("homepage Test Failed");
		
		extent.flush();
		
	}
}
