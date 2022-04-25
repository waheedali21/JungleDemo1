/**
 * 
 */
package com.jungle.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.jungle.base.BaseClass;
import com.jungle.dataprovider.DataProviders;
import com.jungle.pageobjects.LandingPage;
import com.jungle.utility.Log;

/**
 * @author Waheed
 *
 */
public class LandingPageTest extends BaseClass{

	LandingPage landingPageObj;
	
	
	
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
	public void validateLogoTest() {
		landingPageObj = new LandingPage();
		
		Log.startTestCase("validateLogoTest");
		
		boolean resultLogo = landingPageObj.validateLogo();
		Log.info("Log is displayed and store in boolean value");
		Assert.assertTrue(resultLogo);
		Log.info("Log is displayed & verified");
		
		Log.endTestCase("validateLogoTest");
	}
	
	
	@Test
	public void validatePageTitleTest() {
		landingPageObj = new LandingPage();
		
		Log.startTestCase("validatePageTitleTest");		
		Log.info("Get the landingpage/current page title");
		String actualTitle = landingPageObj.validatePageTitle();
		Log.info("Page title stored in string value");
		Assert.assertEquals(actualTitle, driver.getTitle());
		Log.info("Page title is verifed");
		
		Log.endTestCase("validatePageTitleTest");
	}
	
	@Test
	public void validateLandingPageUrlTest() {
		landingPageObj = new LandingPage();
		
		Log.startTestCase("validatePageTitleTest");
		Log.info("Get the current page Url");
		String actualUrl = landingPageObj.validateLandingPageUrl();
		Log.info("Store the current page url in string value");
		Assert.assertEquals(actualUrl, driver.getCurrentUrl());
		Log.info("Current page url is validated");
		
		Log.endTestCase("validateLandingPageUrlTest");
	}
	
	
	@Test
	public void validateSignUpLinkIsPresentTest() {
		landingPageObj = new LandingPage();
		
		Log.startTestCase("validateSignUpLinkIsPresentTest");
		Log.info("In top menu SignUp link is showing/displaying");
		Boolean singUpLink = landingPageObj.validateSignUpLinkIsPresent();	
		Assert.assertTrue(singUpLink);
		Log.info("SignUp link validated successfully");
		
		Log.endTestCase("validateSignUpLinkIsPresentTest");
	}
	
	
	@Test
	public void validateConnectWalletButtonTest() {
		landingPageObj = new LandingPage();
		
		Log.startTestCase("validateConnectWalletButtonTest");
		Log.info("In top menu Connect Wallet button is showing/displaying");
		Boolean walletButton = landingPageObj.validateConnectWalletButton();
		Assert.assertTrue(walletButton);
		Log.info("Wallet Button is validated successfully");		
		Log.endTestCase("validateConnectWalletButtonTest");
	}
	
	@Test
	public void landingPageContentVerificationTest() {
		landingPageObj = new LandingPage();
		
		Log.startTestCase("landingPageContentVerificationTest");
		Log.info("Ladning page content is showing");
		Boolean text = landingPageObj.landingPageContentVerification();
		Assert.assertTrue(text);
		Log.info("Landing page content Buy, Sell & Create Digital Art is verified");
		
		Log.endTestCase("validateConnectWalletButtonTest");
		
	}
	
/*	
   //Email hardcode
	@Test
	public void doSunscribeTest() {
		landingPageObj = new LandingPage();
		
		
		String thankYouMessage = landingPageObj.doSubscribe("jungle@gmail.com");
		System.out.println("Thank You SignUp Message: " + thankYouMessage);
		Assert.assertEquals(thankYouMessage, "Thank you, You are in!");
		 
	}
	
 */
	
	@Test(dataProvider = "emailSignUp",  dataProviderClass = DataProviders.class)
	public void doSunscribeTest(String email) {
		landingPageObj = new LandingPage();
		
		
		Log.startTestCase("doSunscribeTest");
		Log.info("Passing email for SignUp");
		String thankYouMessage = landingPageObj.doSubscribe(email);
		Log.info("SignUp thank you message is showing");
		System.out.println("Thank You SignUp Message: " + thankYouMessage);
		Log.info("Getting than you message when email is entered as well as SignUp button is clicked");
		
		Assert.assertEquals(thankYouMessage, "Thank you, You are in!");
		Log.info("Signup thanks you message is validated successfully");
		
		Log.endTestCase("doSunscribeTest");
		
	}
	
}



















