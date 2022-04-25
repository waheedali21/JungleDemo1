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
 * @author waheed
 *
 */
public class ResourcesPage extends BaseClass{
	
	
	//In order to access re-usable methods
		Action action  = new Action();
		
		
		
		
		// Page Elements

		//@FindBy(xpath = "//a[normalize-space()='Resources']")
		@FindBy(xpath = "//a[@class='nav__link'][normalize-space()='Resources']")
		WebElement linkResouces;
		
		
		@FindBy(xpath = "//h1[@class='faq-content__title']")
		WebElement txtFAQsHeading;
		
		
		//@FindBy(xpath = "//a[normalize-space()='How do I report an NFT, user, or collection?']")
		@FindBy(xpath = "//a[contains(text(),'How do I report an NFT, user, or collection?')]")
		WebElement linkFAQsVerification;
		
		@FindBy(xpath = "//p[1]")
		WebElement linkFAQsContent;
		
		
		
		
		//Initializing the web element
		public ResourcesPage() {
			PageFactory.initElements(driver, this);
		}
		
		
		
		
		//Page Actions
		public String validateResoucePageUrl() {
			action.click(driver, linkResouces);
			return action.getCurrentURL(driver);
		}
		
		
		public String validateResourceHeadingTextFAQs() {
			
			action.scrollByVisibilityOfElement(driver, txtFAQsHeading);
			action.isDisplayed(driver, txtFAQsHeading);
			action.fluentWait(driver, txtFAQsHeading, 10);
			
			return txtFAQsHeading.getText();
		}
		
		
		public String validateResourceSubHeadingTextFAQs() {
			action.fluentWait(driver, linkFAQsVerification, 10);
			action.isDisplayed(driver, linkFAQsVerification);
			return linkFAQsVerification.getText();
			
			
		}
		
		
		
		public String FAQsContentVerification() {
			action.isDisplayed(driver, linkFAQsVerification);
			action.fluentWait(driver, linkFAQsVerification, 10);
			action.click(driver, linkFAQsVerification);
			
			action.fluentWait(driver, linkFAQsVerification, 10);
		   // action.getCurrentURL(driver);
			return linkFAQsContent.getText();
		}
		
		
		
		
		
		

}
