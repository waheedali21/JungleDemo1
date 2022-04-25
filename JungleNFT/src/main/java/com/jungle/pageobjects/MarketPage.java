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
public class MarketPage extends BaseClass {

	// In order to access re-usable methods
	Action action = new Action();

	
	
	// Page Elements
	@FindBy(xpath = "//a[@class='nav__link'][normalize-space()='Market']")
	WebElement linkMarkets;
	
	
	@FindBy(xpath = "//h2[normalize-space()='Browse by category']")
	WebElement txtBrowseByCategory;
	
	
	@FindBy(xpath = "//h3[normalize-space()='Music']")
	WebElement categoryMusic;
	
	
	@FindBy(xpath = "//div[contains(text(),'Whether you’re starting from scratch or want to ad')]")
	WebElement txtBuildYourCollection;
	
	
	// Initializing the web element
	public MarketPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	
	
	
	//Page Actions
	public String validateMarketPageUrl() {
		action.click(driver, linkMarkets);
		return action.getCurrentURL(driver);
	}
	
	
	public String validateExplorePageText() {
		action.isDisplayed(driver, txtBrowseByCategory);
		String txtBrowserCategoty = txtBrowseByCategory.getText();
		return txtBrowserCategoty;				
	}
	
	
	public boolean validateMarketSubCategory() {
		return action.isDisplayed(driver, categoryMusic);
	}
	
	
	
	
	

}
