package main.java.com.homeaway.pageactions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import main.java.com.homeaway.utils.CommonUtils;
import main.java.com.homeaway.utils.DriverUtils;
import test.java.com.homeaway.locators.CheckOutLocators;

public class CheckOutPageActions {
	DriverUtils dUtils = new DriverUtils();
	CheckOutLocators coLocators = new CheckOutLocators();
	CommonUtils cUtils = new CommonUtils();
	
	public void clickContinueOnCheckOutPage(WebDriver driver) {
		dUtils.waitForPageElement(driver, coLocators.continueOnCheckout, "css");
		driver.findElement(By.cssSelector(coLocators.continueOnCheckout)).click();
	}
	
	public void selectCountryAndCalculate(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		dUtils.waitForPageElement(driver, coLocators.countrySelect, "css");
		Select dropdown = cUtils.selectValueFromDropDown(driver, coLocators.countrySelect);
		dropdown.selectByValue("US");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.cssSelector(coLocators.calculate)).click();
	}
	
	public String getTotalPrice(WebDriver driver) {
		dUtils.waitForPageElement(driver, coLocators.totalPrice, "css");
		return driver.findElement(By.cssSelector(coLocators.totalPrice)).getText();
		
	}

}
