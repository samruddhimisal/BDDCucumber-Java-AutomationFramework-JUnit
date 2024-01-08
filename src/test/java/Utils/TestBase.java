package Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase 
{
	public WebDriver driver;
	
	public WebDriver webDriverManager() throws IOException
	{
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//src//test//resources//global.properties");
		Properties prop = new Properties();
		prop.load(fis);
		String url = prop.getProperty("QAurl");
		String browser_prop = prop.getProperty("browser");
		
		/*
		 * run this command from command line (if maven is installed on remote/local system)
		 * 1. mvn test -Dcucumber.features="<feature_file_path>" _Dbrowser=firefox
		 * 2. mvn test -Dcucumber.filter.tags=@SmokeTest _Dbrowser=firefox
		 * The above command overrides the options given in TestBase.java file
		 * 
		 * //to get the property passed through CLI: 
		 * String browser_maven = System.getProperty("browser"); 
		 * 
		 * String browser result = browser_maven!=null ? browser_maven : browser_prop
		 */
		
		if(driver == null)
		{
			if(browser_prop.equalsIgnoreCase("firefox"))
			{
				System.setProperty("webdriver.firefox.driver",System.getProperty("user.dir")+"//src//test//resources//geckodriver");
				driver = new FirefoxDriver();
			}		
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
			driver.get(url);
			driver.manage().window().maximize();
		}
		return driver;
	}
}
