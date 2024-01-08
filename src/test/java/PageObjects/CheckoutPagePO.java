package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Utils.TestSetup;

public class CheckoutPagePO 
{
	WebDriver driver;
	private By cartBag = By.xpath("//a[contains(@class, 'cart-icon')]/img");
	private By checkOutButton = By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]");
	private By promoButton = By.cssSelector(".promoBtn");
	private By placeOrderbtn = By.xpath("//button[contains(text(),'Place Order')]");
	private By prodNameInCheckoutPage = By.xpath("//*[contains(@class, 'product-name')]");
	private By prodQuantity = By.xpath("//table[@id='productCartTables']/tbody/tr/td[3]/p[contains(@class, 'quantity')]");
	
	public CheckoutPagePO(WebDriver driver)
	{
		this.driver=driver;
	}
	public void checkOutIems()
	{		
		driver.findElement(cartBag).click();
		driver.findElement(checkOutButton).click();
	}
	public Boolean verifyPromoButton()
	{
		return driver.findElement(promoButton).isDisplayed();
	}
	public Boolean verifyPlaceOrderButton()
	{
		return driver.findElement(placeOrderbtn).isDisplayed();
	}
	public String validateProdName()
	{   
	    String prodName = driver.findElement(prodNameInCheckoutPage).getText(); 
	    return prodName;
	}
	public String validateProdQuantity()
	{   
	    String prodQty = driver.findElement(prodQuantity).getText(); 
	    return prodQty;
	}
	
	
}
