package test.java.com.homeaway.locators;

/**
 * Css locators for Checkout page.
 * @author geetha
 *
 */
public class CheckOutLocators {
	public static final String totalPrice = "#checkout_total .pricedisplay";
	public static final String continueOnCheckout = ".step2"; //it will nice to have a class on <span> here.
	public static final String countrySelect = "#current_country";
	public static final String calculate = "input[name='wpsc_submit_zipcode']"; 
	public static final String updateQuantityNumber = "form input[name='quantity']";
	public static final String updateQuantity = "form input[value='Update']";
	public static final String removeCart = "form input[value='Remove']";
	public static final String emptyMessage = ".entry-content";
}
