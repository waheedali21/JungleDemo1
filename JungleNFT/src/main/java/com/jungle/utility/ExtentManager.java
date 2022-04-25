package com.jungle.utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.jungle.actiondriver.Action;

public class ExtentManager {

	// Step#1 - Extent 4.0.9v classes
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest test;

	public static void setUpExtentReport() {

		Action action  = new Action();
		// file path for generating the extent report in HTML format
		//htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "\\test-output\\ExtentReport\\MyReport"+ action.getCurrentTime() + ".html");
		
		htmlReporter = new ExtentHtmlReporter(
				System.getProperty("user.dir") + "\\test-output\\ExtentReport\\MyReport.html");

		//in *xml* file we have define the Extent-Report theme
		htmlReporter.loadXMLConfig(System.getProperty("user.dir") + "\\extent-config.xml");
		extent = new ExtentReports();

		extent.attachReporter(htmlReporter);

		// ** Set some more parameter for Environment
		extent.setSystemInfo("HostName", "Ali Waheed");
		extent.setSystemInfo("ProjectName", "Jungle NFT");
		extent.setSystemInfo("QA Engineer", "Waheed");
		extent.setSystemInfo("OS", "Windows 10");
		extent.setSystemInfo("Browser", "Chrome");
	}

	public static void endReport() {
		extent.flush();
	}

}
