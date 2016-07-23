package main.java.com.homeaway.pageactions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import main.java.com.homeaway.utils.DriverUtils;
import test.java.com.homeaway.locators.MyAccountPageLocators;

public class MyAccountPageActions {
	MyAccountPageLocators mpLoc = new MyAccountPageLocators();
	DriverUtils dUtils = new DriverUtils();
	
	/**
	 * a) Enter username : geetha.k, pwd: energy123 on the Account login page.
	 * b) Click on Login button
	 * c) Once Login, then click on 'Your Details' link
	 * d) Modify with zip code to 78654 in the myaccount details and Save Profile. 
     * e) Logout
     * f) Login back and verify that the zipcode is equal to 78654
	 */
	
	public void logintoAccount(WebDriver driver) {
		driver.findElement(By.cssSelector(mpLoc.login)).sendKeys("geetha.k");
		driver.findElement(By.cssSelector(mpLoc.password)).sendKeys("energy123");
		driver.findElement(By.cssSelector(mpLoc.loginButton)).click();
	
	}
	public void clickOnDetailsLink(WebDriver driver) {
		dUtils.waitForPageElement(driver, mpLoc.accountDetailsLink, "css");
		driver.findElement(By.cssSelector(mpLoc.accountDetailsLink)).click();
		dUtils.waitForPageToLoad(driver);
	}
	
	public void updateYourAccountDetails(WebDriver driver) {
		driver.findElement(By.cssSelector(mpLoc.phone)).clear();
		driver.findElement(By.cssSelector(mpLoc.phone)).sendKeys("1234567890");
		driver.findElement(By.cssSelector(mpLoc.saveProfile)).click();
		dUtils.waitForPageToLoad(driver);
		driver.findElement(By.cssSelector(mpLoc.logoutLink)).click();	
		dUtils.waitForPageToLoad(driver);
	}
	
	public String getUpdatedPhoneNumber(WebDriver driver) {
		return driver.findElement(By.cssSelector(mpLoc.phone)).getAttribute("value");
	}
}
