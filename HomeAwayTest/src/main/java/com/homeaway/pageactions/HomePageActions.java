package main.java.com.homeaway.pageactions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import main.java.com.homeaway.utils.DriverUtils;
import test.java.com.homeaway.locators.HomePageLocators;

public class HomePageActions {
	HomePageLocators homeLoc = new HomePageLocators();
	DriverUtils dUtils = new DriverUtils();
	
	/**
	 * Clicks Product category link and selects iPhone link on the home page.
	 * @param driver -- its a WebDriver instance.
	 */
	public void selectApple4SProduct(WebDriver driver) {
		driver.findElement(By.cssSelector(homeLoc.productCategory)).click();
		dUtils.waitForPageElement(driver, homeLoc.iphoneProduct, "css");
		driver.findElement(By.cssSelector(homeLoc.iphoneProduct)).click();
	}
	
	public void clickMyaccount(WebDriver driver) {
		driver.findElement(By.cssSelector(homeLoc.myaccountLink)).click();
	}
}
