package test.java.com.homeaway.testcases;

import org.junit.Assert;
//import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import main.java.com.homeaway.pageactions.HomePageActions;
import main.java.com.homeaway.pageactions.ProductCategoryPageActions;
import main.java.com.homeaway.pageactions.ProductPageActions;
import main.java.com.homeaway.pageactions.CheckOutPageActions;
import main.java.com.homeaway.utils.CommonUtils;
import main.java.com.homeaway.utils.DriverUtils;

public class TestEmptyCartMessage {
	DriverUtils driver = new DriverUtils();
	HomePageActions homeActions = new HomePageActions();
	ProductCategoryPageActions pcActions = new ProductCategoryPageActions();
	ProductPageActions ppActions = new ProductPageActions();
	CheckOutPageActions chActions = new CheckOutPageActions();
	CommonUtils cUtils = new CommonUtils();
	
	/**
	 * Verifies empty cart.
	 * Test steps:
	 * 1. Select iPhone4s and add to cart from product category
	 * 2. Checkout the purchase
	 * 3. Update quantity in the cart
	 * 4. Empty cart
	 * 5. Verify empty cart message.
	 */
	@Test
	public void testEmptyCartMessage() {
		String expectedErrormsg = "Oops, there is nothing in your cart.";
		String actualErrormsg = "";
		WebDriver wd = driver.getFirefoxDriver();
		cUtils.goToHomePage(wd);
		cUtils.moveToElementAndSelectProduct(wd);
		pcActions.selectIphoneProductFromProductList(wd);
		ppActions.addItemToCart(wd);
		ppActions.goToCheckOut(wd);
		chActions.updateQuantity(wd);
		chActions.removeItems(wd);
		actualErrormsg = chActions.getEmptyCartMessage(wd);
		System.out.println("Screen::" + actualErrormsg);
		Assert.assertEquals(expectedErrormsg, actualErrormsg);
			
	}
}
