/**
 * 
 */
package com.jungle.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.jungle.base.BaseClass;
import com.jungle.pageobjects.MarketPage;
import com.jungle.utility.Log;

/**
 * @author Waheed
 *
 */
public class MarketPageTest extends BaseClass{
	
	MarketPage marketPageObj;
	
	
	
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
	public void validateMarketPageUrlTest() {
		marketPageObj = new MarketPage();
		
		Log.startTestCase("validateMarketPageUrlTest");
		String urlMarketPage = marketPageObj.validateMarketPageUrl();
		System.out.println("Market page url: " + urlMarketPage);
		Assert.assertEquals(urlMarketPage, "https://jungle.co/#market");
		
		Log.endTestCase("validateMarketPageUrlTest");
	}

	
	@Test
	public void validateExplorePageTextTest() {
		marketPageObj = new MarketPage();
		
		Log.startTestCase("validateExplorePageTextTest");
		String txtMarketBrowseByCategory = marketPageObj.validateExplorePageText();
		System.out.println("Landing page text: " + txtMarketBrowseByCategory);
		Assert.assertEquals(txtMarketBrowseByCategory, "Browse by category");
		
		Log.endTestCase("validateExplorePageTextTest");
	}
	
	
	@Test
	public void validateMarketSubCategoryTest() {
		marketPageObj = new MarketPage();
		
		Log.startTestCase("validateMarketSubCategoryTest");
		Boolean txtSubCategory = marketPageObj.validateMarketSubCategory();
		Assert.assertTrue(txtSubCategory);
		
		Log.endTestCase("validateMarketSubCategoryTest");
	}
	
	
}
