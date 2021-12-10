package com.demo.report;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ReportManager {
	public static ExtentTest test;
	static ExtentReports extent;
	
	public static void configReport() {
		extent = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter("report/index.html");
		spark.config().setTheme(Theme.DARK);
		spark.config().setDocumentTitle("API Automation Report");
		spark.config().setReportName("ExtentReports");
		extent.attachReporter(spark);	
	}
	
	public static void flushReport() {
		extent.flush();
	}
	public static void createtest(String testName,String testType) {
		test = extent.createTest(testName)
				.assignCategory(testType)
				.assignAuthor("Otis")
				.assignDevice("Firefox 61");
	}
}
