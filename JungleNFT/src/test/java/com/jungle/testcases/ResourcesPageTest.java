/**
 * 
 */
package com.jungle.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.jungle.base.BaseClass;
import com.jungle.pageobjects.ResourcesPage;
import com.jungle.utility.Log;

/**
 * @author Waheed
 *
 */
public class ResourcesPageTest extends BaseClass{
	
	ResourcesPage resourcesPageObj;
	
	
	@BeforeMethod
	public void setUp() {
		BaseClass.launchApps();
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
	
	//Test Cases
	
	
	@Test
	public void validateResoucePageUrlTest() {
		resourcesPageObj = new ResourcesPage();
		
		Log.startTestCase("validateResoucePageUrlTest");
		String urlResourcesPage = resourcesPageObj.validateResoucePageUrl();
		System.out.println("Resource page Url: " + urlResourcesPage);	
		Assert.assertEquals(urlResourcesPage, "https://jungle.co/faq/");
		
		Log.endTestCase("validateResoucePageUrlTest");
	}
	
	
	
	@Test
	public void validateResourceHeadingTextFAQsTest() {
		resourcesPageObj = new ResourcesPage();
		
		Log.startTestCase("validateResourceHeadingTextFAQsTest");
		resourcesPageObj.validateResoucePageUrl();//click Resource option from top menu
		
		String FAQsHeading = resourcesPageObj.validateResourceHeadingTextFAQs();
		System.out.println("FAQs Heading text: " + FAQsHeading);
		Assert.assertEquals(FAQsHeading, "Frequently Asked Questions");
		
		Log.endTestCase("validateResourceHeadingTextFAQsTest");
	}
	
	
	
	@Test
	public void validateResourceSubHeadingTextFAQsTest() {
		resourcesPageObj = new ResourcesPage();

		Log.startTestCase("validateResourceSubHeadingTextFAQsTest");
		resourcesPageObj.validateResoucePageUrl();// click Resource option from top menu
		String FAQsSubHeadingText = resourcesPageObj.validateResourceSubHeadingTextFAQs();
		System.out.println("FAQs sub heading text: " + FAQsSubHeadingText);
		Assert.assertEquals(FAQsSubHeadingText, "How do I report an NFT, user, or collection?");
		
		Log.endTestCase("validateResourceSubHeadingTextFAQsTest");
	}
	
	
	@Test
	public void FAQsContentVerificationTest() {
		resourcesPageObj = new ResourcesPage();
		
		Log.startTestCase("FAQsContentVerificationTest");
		resourcesPageObj.validateResoucePageUrl();// click Resource option from top menu
		String  FAQsSubContent= resourcesPageObj.FAQsContentVerification();
		System.out.println("FAQs content when it clicked: " + FAQsSubContent);
		Assert.assertEquals(FAQsSubContent, "User safety is a priority at Jungle, especially when it comes to possible scams or malicious content. Please review the following information if you would like to ensure Jungle reviews a specific token, user, or collection.");
		
		Log.endTestCase("FAQsContentVerificationTest");
	}
	
	
	
	
	
	
	
	
	

}
