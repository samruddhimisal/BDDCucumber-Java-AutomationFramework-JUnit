package StepDefinitions;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import Utils.TestSetup;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;

public class Hooks 
{
	TestSetup testSetup;
	public Hooks(TestSetup testSetup)
	{
		this.testSetup=testSetup;
	}
	
	@After
	public void afterScenario() throws IOException
	{
		testSetup.testBase.webDriverManager().quit();
	}
	
	@AfterStep
	public void addScreenshot(Scenario scenario) throws IOException
	{
		WebDriver driver = testSetup.testBase.webDriverManager();
		if(scenario.isFailed())
		{
			//take screenshot if the scenario step fails
			File sourcePath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			byte[] fileContent = FileUtils.readFileToByteArray(sourcePath);
			scenario.attach(fileContent, "image/png", "image");
		}
	}
		
}
