/**
 * Re usable methods.
 */

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
	
	/**
	 * Opens the home page and maximize the window.
	 * @param driver
	 */
	public void goToHomePage(WebDriver driver) {
		driver.get(homepageUrl);
		dUtils.waitForPageToLoad(driver);
		driver.manage().window().maximize();
	}
	
	/**
	 * Select a value from dropdowns.
	 * @param driver
	 * @param selectId
	 * @return
	 */
	public Select selectValueFromDropDown(WebDriver driver, String selectId) {
		Select dropdown = new Select(driver.findElement(By.cssSelector(selectId)));
		return dropdown;
		
	}
	
	/**
	 * Mouse over on any element and select a value from the list.
	 * @param driver
	 */
	public void moveToElementAndSelectProduct(WebDriver driver) {
		Actions builder = new Actions(driver);
		WebElement hoverElement = driver.findElement(By.cssSelector(hLocators.productCategory));
		builder.moveToElement(hoverElement).perform();
		dUtils.waitForPageElement(driver, hLocators.iphoneProduct, "css");
		driver.findElement(By.cssSelector(hLocators.iphoneProduct)).click();
	}
}
