package main.java.com.homeaway.pageactions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import main.java.com.homeaway.utils.DriverUtils;
import test.java.com.homeaway.locators.ProductPageLocators;

public class ProductPageActions {
	DriverUtils dUtils = new DriverUtils();
	ProductPageLocators ppLocators = new ProductPageLocators();
	public void addItemToCart(WebDriver driver) {
		dUtils.waitForPageElement(driver, ppLocators.addToCart, "css");
		driver.findElement(By.cssSelector(ppLocators.addToCart)).click();
	}
	
	public void goToCheckOut(WebDriver driver) {
		dUtils.waitForPageElement(driver, ppLocators.confirmCheckout, "css");
		driver.findElement(By.cssSelector(ppLocators.confirmCheckout)).click();
	}
	
  
}