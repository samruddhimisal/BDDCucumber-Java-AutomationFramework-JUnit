package Utils;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;

public class GenericUtils 
{
	public WebDriver driver;
	
	public GenericUtils(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void switchControlToChildWindow()
	{
		//Get and store all the open window (browser tabs) handles
				Set<String> set = driver.getWindowHandles();
				//Iterate through the windows to get parent(main) window and child(offers page) window
				Iterator<String> it = set.iterator();
				String parentWindow = it.next(); //parent at index 0
				String childWindow = it.next(); //child at index 1
				//Switch to child window
				driver.switchTo().window(childWindow);	
	}
}
