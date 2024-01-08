package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OffersPagePO 
{
	WebDriver driver;
	private By offersPageLink = By.xpath("//a[text()='Top Deals']");
	private By searchProduct = By.xpath("//*[@id='search-field']");
	private By productName = By.xpath("//table[contains(@class, 'table table-bordered')]/tbody/tr/td[1]");
	
	public OffersPagePO(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void navigateToOffersPage()
	{
		driver.findElement(offersPageLink).click();
	}
	public void searchProdInOffersPage(String inputCharacters)
	{		
		driver.findElement(searchProduct).sendKeys(inputCharacters);
	}
	public String getProdName() throws InterruptedException
	{		
		Thread.sleep(2000);	    
	    String prodName = driver.findElement(productName).getText(); 
	    return prodName;
	}
}
