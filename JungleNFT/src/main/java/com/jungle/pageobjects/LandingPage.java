/**
 * 
 */
package com.jungle.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.jungle.actiondriver.Action;
import com.jungle.base.BaseClass;

/**
 * @author Waheed
 *
 */
public class LandingPage extends BaseClass {
	
	//In order to access re-usable methods
	Action action  = new Action();
	
	
	
	
	//Page Elements
	@FindBy(xpath = "//img[@alt='Jungle logo']")
	WebElement imgLogo;
	
	@FindBy(xpath = "//span[@class='login__link__text']")
	WebElement linkSignUp;
	
	@FindBy(xpath = "//button[@class='btn btn--outline']")
	WebElement btnConnectWallet;
	
	@FindBy(xpath = "//h1[@class='banner-text__headline']")
	WebElement textLandingPageContent;
	
	//@FindBy(id = "placeholder")
	@FindBy(xpath = "//input[@placeholder='Enter your email']")
	WebElement txtEnterEmailForSignUp;
	
	@FindBy(xpath = "//button[@class='subscribe-box__submit btn btn--outline']")
	WebElement btnSingUpSubscribe;
	
	//@FindBy(xpath = "//div[@class='jsState subscribe-box__state is--visible']")
	@FindBy(xpath = "//div[text()='Thank you, You are in!']")
	WebElement txtThankYouSignUpMessage;
	
	
	
	
	//Initializing the web element
	public LandingPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	
	//Page Actions
	public boolean validateLogo() {
		return action.isDisplayed(driver, imgLogo);
	}
	
	public String validatePageTitle() {
		return action.getTitle(driver);
		
	}
	
	public String validateLandingPageUrl() {
		return action.getCurrentURL(driver);
	}
	
	
	public boolean validateSignUpLinkIsPresent() {
		return action.isDisplayed(driver, linkSignUp);
		
	}
	
	public boolean validateConnectWalletButton() {
		return action.isDisplayed(driver, btnConnectWallet);
	}
	
	
	public boolean landingPageContentVerification() {
		return action.isDisplayed(driver, textLandingPageContent);
	}
	
	
	public String doSubscribe(String email) {
		action.scrollByVisibilityOfElement(driver, txtEnterEmailForSignUp);
		action.type(txtEnterEmailForSignUp, email);
		action.fluentWait(driver, btnSingUpSubscribe, 15);
		action.JSClick(driver, btnSingUpSubscribe);

		action.fluentWait(driver, txtThankYouSignUpMessage, 10);
		// return driver.findElement(By.xpath("txtThankYouSignUpMessage")).getText();

		return txtThankYouSignUpMessage.getText();

	}


		
	}


