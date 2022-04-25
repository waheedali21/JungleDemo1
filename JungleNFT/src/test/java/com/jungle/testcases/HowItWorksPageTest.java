/**
 * 
 */
package com.jungle.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.jungle.base.BaseClass;
import com.jungle.pageobjects.HowItWorksPage;
import com.jungle.utility.Log;

/**
 * @author Waheed
 *
 */
public class HowItWorksPageTest extends BaseClass{
	
	HowItWorksPage howItWorksPageObj;
	
	
	@BeforeMethod
	public void setUp() {
		BaseClass.launchApps();
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
	// Test Cases
	
	@Test
	public void validateHowItWorkPageUrlTest() {
		howItWorksPageObj = new HowItWorksPage();
		
		Log.startTestCase("validateHowItWorkPageUrlTest");
		String actualUrl = howItWorksPageObj.validateHowItWorkPageUrl();
		System.out.println("How It Works Page Url: " + actualUrl);
		Assert.assertEquals(actualUrl, "https://jungle.co/#steps");
		
		Log.endTestCase("validateHowItWorkPageUrlTest");
	}
	
	
	@Test
	public void validateHowItWorkeadingTextTest() {
		howItWorksPageObj = new HowItWorksPage();
		
		Log.startTestCase("validateHowItWorkeadingTextTest");
		String headingText = howItWorksPageObj.validateHowItWorkeadingText();
		System.out.println("Heading text for How It Works Page: " + headingText);
		Assert.assertEquals(headingText, "How it works");
		
		Log.endTestCase("validateHowItWorkeadingTextTest");
	}
	
	
	@Test
	public void validateSubHeadingTextTest() {
		howItWorksPageObj = new HowItWorksPage();
		
		Log.startTestCase("validateSubHeadingTextTest");
		String subHeadingCategoryText = howItWorksPageObj.validateSubHeadingText();
		System.out.println("Sub Heading text for How It Works Page: " + subHeadingCategoryText);
		Assert.assertEquals(subHeadingCategoryText, "Build your collection");
		Log.endTestCase("validateSubHeadingTextTest");
	}
	
	
}
