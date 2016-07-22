package main.java.com.homeaway.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import test.java.com.homeaway.locators.HomePageLocators;

public class CommonUtils {
	String homepageUrl = "http://store.demoqa.com/";
	DriverUtils dUtils = new DriverUtils();
	HomePageLocators hLocators = new HomePageLocators();
	
	public void goToHomePage(WebDriver driver) {
		driver.get(homepageUrl);
		dUtils.waitForPageToLoad(driver);
		driver.manage().window().maximize();
	}
	
	public Select selectValueFromDropDown(WebDriver driver, String selectId) {
		Select dropdown = new Select(driver.findElement(By.cssSelector(selectId)));
		return dropdown;
		
	}
	
	public void moveToElementAndSelectProduct(WebDriver driver) {
		Actions builder = new Actions(driver);
		WebElement hoverElement = driver.findElement(By.cssSelector(hLocators.productCategory));
		builder.moveToElement(hoverElement).perform();
		dUtils.waitForPageElement(driver, hLocators.iphoneProduct, "css");
		driver.findElement(By.cssSelector(hLocators.iphoneProduct)).click();
	}
}
