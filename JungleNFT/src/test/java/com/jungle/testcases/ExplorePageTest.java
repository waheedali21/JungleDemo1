/**
 * 
 */
package com.jungle.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.jungle.base.BaseClass;
import com.jungle.pageobjects.ExplorePage;
import com.jungle.utility.Log;

/**
 * @author Waheed
 *
 */
public class ExplorePageTest extends BaseClass {
	
	
	ExplorePage explorePageObj;
	
	
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
	public void validateExplorePageUrlTest() {
		explorePageObj = new ExplorePage();		
		
		Log.startTestCase("validateExplorePageUrlTest");
		String urlExplorePage = explorePageObj.validateExplorePageUrl();
		System.out.println("Explore page url: " + urlExplorePage);
		Assert.assertEquals(urlExplorePage, "https://jungle.co/#faq");
		
		Log.endTestCase("validateExplorePageUrlTest");
		
	}
	
	
	@Test
	public void validateExplorePageTextTest() {
		explorePageObj = new ExplorePage();		
		
		Log.startTestCase("validateExplorePageTextTest");
		String FAQsHeadingText = explorePageObj.validateExplorePageText();
		System.out.println("FAQs Heading text is: " +FAQsHeadingText );
		Assert.assertEquals(FAQsHeadingText, "Frequently asked questions");
		
		Log.endTestCase("validateExplorePageTextTest");
	}

}
