/**
 * Verifies update account details.
 * Test Steps:
 * a) skip account creation process
 * b) Create user manually with zip code 78681 and login with the user
 * c) Update zip code to 78654 in the myaccount details.
 * d) Logout
 * e) Login back and verify that the zipcode is equal to 78654
 */

package test.java.com.homeaway.testcases;

import org.junit.Test;
import org.openqa.selenium.WebDriver;

import org.junit.Assert;
import main.java.com.homeaway.pageactions.HomePageActions;
import main.java.com.homeaway.pageactions.MyAccountPageActions;
import main.java.com.homeaway.utils.CommonUtils;
import main.java.com.homeaway.utils.DriverUtils;

public class TestAccountDetails 

{

DriverUtils driver = new DriverUtils();
HomePageActions homeActions = new HomePageActions();
MyAccountPageActions mpActions = new MyAccountPageActions();
CommonUtils cUtils = new CommonUtils();


@Test
public void testAccountDetails() {
	String expectedPhNumber="1234567890";
	WebDriver wd = driver.getFirefoxDriver();
	cUtils.goToHomePage(wd);
	homeActions.clickMyaccount(wd);
	mpActions.logintoAccount(wd);
	mpActions.clickOnDetailsLink(wd);
	mpActions.updateYourAccountDetails(wd);
	mpActions.logintoAccount(wd);
	mpActions.clickOnDetailsLink(wd);
	String actualPhoneNumber = mpActions.getUpdatedPhoneNumber(wd);
	Assert.assertEquals(expectedPhNumber, actualPhoneNumber);
}
}
