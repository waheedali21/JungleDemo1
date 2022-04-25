
package com.jungle.roughwork;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

/**
 * @author Waheed
 *
 */
public class End2End {

	public static void main(String[] args) throws Exception {
	
		WebDriver driver;
		
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\executable\\chromedriver.exe");
		driver = new ChromeDriver();
		
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
		
		
		driver.get("https://jungle.co/");
		
		
		
		
		
		//Case#1 validate site Logo
		System.out.println(driver.findElement(By.xpath("//img[@class='img- logo__imagee']")).isDisplayed());
		
		//Case#2 validate site title
		String actualTitle = driver.getTitle();
		System.out.println("Title: " +  actualTitle);
		Assert.assertEquals(actualTitle, driver.getTitle());
		
		//Case#3 validate site Url
		String actualUrl = driver.getCurrentUrl();
		System.out.println("Url:" +  actualUrl);
		Assert.assertEquals(actualUrl, driver.getCurrentUrl());
		
		
		//Case#4 - Navigate to Explore option from top menu
		driver.findElement(By.xpath("(//a[text()='Explore'])[1]")).click();
		String exploreUrl = driver.getCurrentUrl();
		System.out.println("Expore page Url: " + exploreUrl);
		Assert.assertEquals(exploreUrl, driver.getCurrentUrl());
		
		Thread.sleep(2000);
		
		
	     driver.findElement(By.xpath("//img[@class='img- logo__imagee']")).click();
	     
		//Case#5 - Navigate to Market option from top menu
		driver.findElement(By.xpath("//a[@class='nav__link'][normalize-space()='Market']")).click();
		String marketUrl = driver.getCurrentUrl();
		System.out.println("Market page url:" + marketUrl);
		Assert.assertEquals(marketUrl, "https://jungle.co/#market");
		
		//Case#6 - Navigate to How it Works option from top menu
		Thread.sleep(2000);	
	     driver.findElement(By.xpath("//img[@class='img- logo__imagee']")).click();
	     
	     
	     driver.findElement(By.xpath("//a[@class='nav__link'][normalize-space()='How It Works']")).click();
	     String How_it_Work_Ulr = driver.getCurrentUrl();
	     System.out.println("How it work page url: " + How_it_Work_Ulr);
	     Assert.assertEquals(How_it_Work_Ulr, "https://jungle.co/#steps");
	
	 	Thread.sleep(2000);	
	     driver.findElement(By.xpath("//img[@class='img- logo__imagee']")).click();
	
	     
		//Case#7 - Navigate to Resources option from top menu
		driver.findElement(By.xpath("//a[@class='nav__link'][normalize-space()='Resources']")).click();
		String resourcePageUrl = driver.getCurrentUrl();
		System.out.println("Resouce page url" + resourcePageUrl);
		Assert.assertEquals(resourcePageUrl , "https://jungle.co/faq/");
		
		Thread.sleep(2000);	
	     driver.findElement(By.xpath("//img[@class='img- logo__imagee']")).click();
	
	     
		//Case#8 - Sign up with valid email and validate the success/thank you message
		Thread.sleep(2000);
		
		WebElement btnSignUp = driver.findElement(By.xpath("//button[@class='subscribe-box__submit btn btn--outline']"));
		//Actions action = new Actions(driver);
		//action.moveToElement(btnSignUp).build().perform();
				
		//driver.findElement(By.xpath("//button[@class='subscribe-box__submit btn btn--outline']")).click();
		
		scrollByVisibilityOfElement(driver, btnSignUp);
		
		
		//JSClick(driver, btnSignUp);
		
		Thread.sleep(2000);
		
		btnSignUp.click();
		
		
	}
	
	
	public static void scrollByVisibilityOfElement(WebDriver driver, WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", ele);

	}
	
	public static  boolean JSClick(WebDriver driver, WebElement ele) {
		boolean flag = false;
		try {
			// WebElement element = driver.findElement(locator);
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", ele);
			// driver.executeAsyncScript("arguments[0].click();", element);
			flag = true;
		}

		catch (Exception e) {
			throw e;

		} finally {
			if (flag) {
				System.out.println("Click Action is performed");
			} else if (!flag) {
				System.out.println("Click Action is not performed");
			}
		}
		return flag;
	}

	
	

}

