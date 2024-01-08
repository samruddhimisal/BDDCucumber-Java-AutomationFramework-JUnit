package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Utils.TestSetup;

public class HomePagePO 
{
	WebDriver driver;
	private By searchProduct = By.xpath("//input[contains(@class, 'search-keyword')]");
	private By productName = By.xpath("//*[contains(@class, 'product-name')]");
	private By incrementItemCount = By.xpath("//*[contains(@class, 'increment')]"); 
	private By addToCartBtn = By.cssSelector(".product-action button");
	private By itemQtyBox = By.xpath("//input[contains(@class, 'quantity')]");
	
	public HomePagePO(WebDriver driver)
	{
		this.driver=driver;
	}
	public void searchProdInHomePage(String inputCharacters)
	{		
		driver.findElement(searchProduct).sendKeys(inputCharacters);
	}
	
	public String getProdName() throws InterruptedException
	{		
	    String prodName = driver.findElement(productName).getText(); 
	    return prodName;
	}
	public String getTitleOfHomePage()
	{
		return driver.getTitle();
	}
	public void addProductItems(int quantity) throws InterruptedException
	{	
		while(quantity != Integer.valueOf(driver.findElement(itemQtyBox).getAttribute("value"))) 
		{
			driver.findElement(incrementItemCount).click();
		}
	}
	public void addToCart()
	{
		driver.findElement(addToCartBtn).click();
	}
}
