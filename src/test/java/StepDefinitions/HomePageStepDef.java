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

import PageObjects.HomePagePO;
import PageObjects.OffersPagePO;
import PageObjects.PageObjectManager;
import Utils.TestBase;
import Utils.TestSetup;

public class HomePageStepDef 
{
	public WebDriver driver;
	public String productNameMainPage;
	public TestSetup testSetup;
	public PageObjectManager poManager;
	public TestBase testBase;
	public HomePagePO homePage;
	
	public HomePageStepDef(TestSetup testSetup)
	{
		this.testSetup = testSetup;
		this.homePage =  testSetup.poManager.getHomePage();
	}
	
	
	@Given("User is on GreenCart Home page")
	public void launchGreenKartHomePage() 
	{
		 Assert.assertTrue(homePage.getTitleOfHomePage().contains("GreenKart"));
	}
	
	@When("^User searches with product shortname (.+) to display product card$")
	public void searchProductInMainPage(String inputCharacters) throws InterruptedException 
	{
		homePage.searchProdInHomePage(inputCharacters);
		//Get only the product name from entire string(Tomato - 1 kg)
		Thread.sleep(3000);
		testSetup.productNameMainPage = homePage.getProdName().split("-")[0].trim();
		//System.out.println("Extracted product name in Home Page is : "+testSetup.productNameMainPage); 
	    
	}	
	
	@When("^Adds (.+) items of selected product to cart$")
	public void addProductQuantity(String quantity) throws InterruptedException 
	{
		Thread.sleep(3000);
		homePage.addProductItems(Integer.parseInt(quantity));			
		homePage.addToCart();
	}
	
}
