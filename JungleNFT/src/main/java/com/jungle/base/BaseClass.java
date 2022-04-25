
package com.jungle.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.jungle.utility.ExtentManager;


/*
 * @author Waheed
 * 
 * 
 * In BaseClass we will 
 * - Load the configuration file
 * - Initialize the browser
 * - Launch the URL
 * - Initiate the Logs
 * - Snapshot utility for failed test cases 
 *
 */
public class BaseClass {

	public static WebDriver driver;

	public static Properties prop;
	public static FileInputStream fis;

	
	
	
	@BeforeSuite
	// Load the configuration file elements
	public static void loadConfig() {

		//Extent reports
		ExtentManager.setUpExtentReport();

		// initialize the log4j environment using DOM tree
		DOMConfigurator.configure("log4j.xml");

		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					System.getProperty("user.dir") + "\\Configuration\\config.properties");
			prop.load(ip);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	
	@AfterSuite
	public void afterSuite() {
		ExtentManager.endReport();
	}

	//launch the url in respective browser
	public static void launchApps() {
		String browserName = prop.getProperty("browser");

		if (browserName.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\executable\\chromedriver.exe");
			driver = new ChromeDriver();

		} else if (browserName.equalsIgnoreCase("FireFox")) {

			System.setProperty("webdriver.gecko.driver",
					System.getProperty("user.dir") + "\\executable\\geckodriver.exe");
			driver = new FirefoxDriver();

		} else if (browserName.equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver",
					System.getProperty("user.dir") + "\\executable\\ie.exe");
			driver = new InternetExplorerDriver();

		}

		else {
			System.out.println("Invalid browser..");
		}

		// Maximize the screen
		driver.manage().window().maximize();
		// Delete all the cookies
		driver.manage().deleteAllCookies();
		// PageLoad TimeOuts
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

		// Launching the URL
		driver.get(prop.getProperty("url"));
	}

}
