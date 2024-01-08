package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import PageObjects.CheckoutPagePO;
import PageObjects.HomePagePO;
import PageObjects.OffersPagePO;
import PageObjects.PageObjectManager;
import Utils.TestBase;
import Utils.TestSetup;

public class CheckoutStepDef 
{
	public WebDriver driver;
	public String productNameMainPage;
	public TestSetup testSetup;
	public PageObjectManager poManager;
	public TestBase testBase;
	public HomePagePO homePage;
	public CheckoutPagePO checkoutPage;
	
	public CheckoutStepDef(TestSetup testSetup)
	{
		this.testSetup = testSetup;
		this.checkoutPage = testSetup.poManager.getCheckoutPage();
		this.homePage =  testSetup.poManager.getHomePage();
	}
	
	@Then("^User proceeds to checkout and validates the (.+) items count is (.+) in checkout page$")
	public void proceedToCheckout(String vegName, int quantity) throws InterruptedException 
	{
	    checkoutPage.checkOutIems();
	    Thread.sleep(5000);
	    testSetup.productName = checkoutPage.validateProdName().split("-")[0].trim();
	    Assert.assertEquals(testSetup.productName, homePage.getProdName().split("-")[0].trim());
	   
	    testSetup.productQty = Integer.parseInt(checkoutPage.validateProdQuantity());
	    Assert.assertEquals(testSetup.productQty, quantity);
	}
	
	@Then("User has the ability to enter promo code and place the order")
	public void verifyPromoAndPlaceOrderBtns() 
	{		
		Assert.assertTrue(checkoutPage.verifyPromoButton());
		Assert.assertTrue(checkoutPage.verifyPlaceOrderButton());
	}
	
}
