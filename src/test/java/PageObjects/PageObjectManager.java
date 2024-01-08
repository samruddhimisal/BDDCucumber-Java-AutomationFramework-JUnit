package PageObjects;

import org.openqa.selenium.WebDriver;

//This file contains object for all PO files
public class PageObjectManager 
{	
	public WebDriver driver;
	public HomePagePO homePage;
	public OffersPagePO offersPage;
	public CheckoutPagePO checkoutPage;
	
	public PageObjectManager(WebDriver driver)
	{
		this.driver=driver;
	}
	public HomePagePO getHomePage()
	{
		homePage = new HomePagePO(driver);
		return homePage;
	}
	public OffersPagePO getOffersPage()
	{
		offersPage = new OffersPagePO(driver);
		return offersPage;
	}
	public CheckoutPagePO getCheckoutPage()
	{
		checkoutPage = new CheckoutPagePO(driver);
		return checkoutPage;
	}
}
