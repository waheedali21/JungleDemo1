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
public class ExplorePage extends BaseClass{
	
	//In order to access re-usable methods
	Action action  = new Action();
	
	
	

	//Page Elements
	@FindBy(xpath = "//a[@class='nav__link'][normalize-space()='Explore']")
	WebElement linkExplore;
	
	
	@FindBy(xpath = "//h2[normalize-space()='Frequently asked questions']")
	WebElement txtFrquenltyAskedQuestions;
	
	
	
	
	
	
	
	
	//Initializing the web element
	public ExplorePage() {
		PageFactory.initElements(driver, this);
	}
	
	
	
	//Page Actions
	public String validateExplorePageUrl() {
		action.click(driver, linkExplore);
		return action.getCurrentURL(driver);
	}
	
	
	public String validateExplorePageText() {
		action.isDisplayed(driver, txtFrquenltyAskedQuestions);
		String txtFAQs = txtFrquenltyAskedQuestions.getText();
		return txtFAQs;
		
		
	}

}
