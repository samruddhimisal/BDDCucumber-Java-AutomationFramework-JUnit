package StepDefinitions;

import java.util.Iterator;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import PageObjects.OffersPagePO;
import PageObjects.PageObjectManager;
import Utils.TestSetup;
import io.cucumber.java.en.Then;

public class OffersPageStepDef 
{
	public WebDriver driver;
	public String productNameMainPage;
	public String productNameOffersPage;
	TestSetup testSetup;
	PageObjectManager poManager;
	
	public OffersPageStepDef(TestSetup testSetup)
	{
		this.testSetup = testSetup;
	}
	
	public void switchToOffersPage()
	{
		//If not already switched to offers page then only perform the following actions
		//if(!testSetup.driver.getCurrentUrl().equalsIgnoreCase("https://rahulshettyacademy.com/seleniumPractise/#/offers"))
		
		OffersPagePO offersPage = testSetup.poManager.getOffersPage();
		//Open the offers page in new browser tab
		offersPage.navigateToOffersPage();
		//switch to offers page window
		testSetup.genericUtils.switchControlToChildWindow();
			
	}
	
	@Then("^User searches with same shortname (.+) in Offers page$")
	public void searchProductInOffersPage(String inputCharacters) throws InterruptedException 
	{
		OffersPagePO offersPage = testSetup.poManager.getOffersPage();
		
		switchToOffersPage();
		offersPage.searchProdInOffersPage(inputCharacters); 
		testSetup.productNameOffersPage = offersPage.getProdName();	
	    //System.out.println("Extracted product name in Offers Page is : "+testSetup.productNameOffersPage); 
	}
	
	@Then("Validate that the product name in Offers page matches with Home page")
	public void validateProductName() 
	{
		Assert.assertEquals(testSetup.productNameMainPage, testSetup.productNameOffersPage);
	}
}
