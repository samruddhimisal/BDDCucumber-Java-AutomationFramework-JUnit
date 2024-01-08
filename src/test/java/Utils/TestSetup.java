package Utils;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import PageObjects.PageObjectManager;

public class TestSetup 
{
	public WebDriver driver;
	public String productNameMainPage;
	public String productNameOffersPage;
	public String productName;
	public int productQty;
	public PageObjectManager poManager;
	public TestBase testBase;
	public GenericUtils genericUtils;
	
	public TestSetup() throws IOException
	{
		testBase = new TestBase();
		poManager = new PageObjectManager(testBase.webDriverManager());
		genericUtils = new GenericUtils(testBase.webDriverManager());
	}

}
