package test.java.com.homeaway.testcases;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import main.java.com.homeaway.pageactions.CheckOutPageActions;
import main.java.com.homeaway.pageactions.HomePageActions;
import main.java.com.homeaway.pageactions.ProductCategoryPageActions;
import main.java.com.homeaway.pageactions.ProductPageActions;
import main.java.com.homeaway.utils.CommonUtils;
import main.java.com.homeaway.utils.DriverUtils;

public class TestAppleOrder {
	DriverUtils driver = new DriverUtils();
	HomePageActions homeActions = new HomePageActions();
	ProductCategoryPageActions pcActions = new ProductCategoryPageActions();
	ProductPageActions ppActions = new ProductPageActions();
	CheckOutPageActions chActions = new CheckOutPageActions();
	CommonUtils cUtils = new CommonUtils();
	
	
	@Test
	public void testAppleOrder() {
		String productPrice = "$282.00";
		String finalPrice = "";
		WebDriver wd = driver.getFirefoxDriver();
		cUtils.goToHomePage(wd);
		cUtils.moveToElementAndSelectProduct(wd);
		//homeActions.selectApple4SProduct(wd);
		pcActions.selectIphoneProductFromProductList(wd);
		ppActions.addItemToCart(wd);
		ppActions.goToCheckOut(wd);
		chActions.clickContinueOnCheckOutPage(wd);
		chActions.selectCountryAndCalculate(wd);
		finalPrice = chActions.getTotalPrice(wd);
		Assert.assertEquals(finalPrice, productPrice, "Total price is wrong. Test failed.");
	}
}