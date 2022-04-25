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
public class HowItWorksPage extends BaseClass{

	// In order to access re-usable methods
	Action action = new Action();
	
	
	
	
	//Page Objects
	@FindBy(xpath = "//a[@class='nav__link'][normalize-space()='How It Works']")
	WebElement linkHowItWorks;
	
	
	@FindBy(xpath = "//h2[normalize-space()='How it works']")
	WebElement txtHowItWorksHeadingText;
	
	
	@FindBy(xpath = "//h3[normalize-space()='Build your collection']")
	public WebElement txtHowItWorksSubHeadingText;
	
	
	
	// Initializing the web element
		public HowItWorksPage() {
			PageFactory.initElements(driver, this);
		}
		
		

		
		// Page Actions
		public String validateHowItWorkPageUrl() {
			action.click(driver, linkHowItWorks);
			return action.getCurrentURL(driver);
		}
		
		
		
		public String validateHowItWorkeadingText() {
			action.isDisplayed(driver, txtHowItWorksHeadingText);
			String txtHeadingText = txtHowItWorksHeadingText.getText();
			return txtHeadingText;
		}
		
		
		public String validateSubHeadingText() {
			action.isDisplayed(driver, txtHowItWorksSubHeadingText);
			return txtHowItWorksSubHeadingText.getText();
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

}
