package main.java.com.homeaway.pageactions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import main.java.com.homeaway.utils.DriverUtils;
import test.java.com.homeaway.locators.ProductCategoryLocators;

public class ProductCategoryPageActions {
	
	ProductCategoryLocators pcLocators = new ProductCategoryLocators();
	DriverUtils dUtils = new DriverUtils();
	
	public void selectIphoneProductFromProductList(WebDriver driver) {
		dUtils.waitForPageElement(driver, pcLocators.iphone4sSimFree, "css");
		driver.findElement(By.cssSelector(pcLocators.iphone4sSimFree)).click();
	}
}
