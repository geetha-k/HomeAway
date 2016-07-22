package main.java.com.homeaway.utils;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverUtils {
	WebDriver driver;
	
	/**
	 * Creates firefox driver object
	 * @return WebDriver instance
	 */
	public WebDriver getFirefoxDriver() {
		driver = new FirefoxDriver();
		return driver;
	}
	
	/**
	 * creates chrome driver instance
	 * @return WebDriver
	 */
	public WebDriver getChromeDriver() {
		driver = new ChromeDriver();
		return driver;
	}
	
	/**
	 * Wait for an element is visible up to 30 seconds
	 * @param driver1 webdriver instance
	 * @param locator xpath or css of the element.
	 */
	public void waitForPageElement(WebDriver driver1, String locator, String type) {
		if (type.equals("xpath")) {
			WebElement myDynamicElement = (new WebDriverWait(driver1, 30))
			.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
		} else if(type.equals("css")) {
			WebElement myDynamicElement = (new WebDriverWait(driver1, 10))
			.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(locator)));
		}
	}
	
	/**
	 * Waits for page to load. Its an implicit wait and will wait up to 30 seconds.
	 * @param driver2 webdriver instance
	 */
	public void waitForPageToLoad(WebDriver driver2) {
	        ExpectedCondition<Boolean> expectation = new
	                ExpectedCondition<Boolean>() {
	                    public Boolean apply(WebDriver driver2) {
	                        return ((JavascriptExecutor) driver2).executeScript("return document.readyState").toString().equals("complete");
	                    }
	                };
	        try {
	            Thread.sleep(1000);
	            WebDriverWait wait = new WebDriverWait(driver2, 30);
	            wait.until(expectation);
	        } catch (Throwable error) {
	            Assert.fail("Timeout waiting for Page Load Request to complete.");
	        }
	    }
	}
