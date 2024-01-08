package CucumberOptions;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/java/Features", 
glue="StepDefinitions", 
monochrome=true, 
tags="@PlaceOrder or @OffersPage",
plugin= {"html:target/cucumberHTMLReport.html","json:target/cucumberJSONReport.json",
"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
"rerun:target/failed_Scenarios.txt"})

public class JunitTestRunnerTest
{
	
}

/*
 * In Junit only feature files can run parallel but not scenarios in feature files
 * e.g.
 * if featureFile1 = 1 scenario
 * if featureFile2 = 2 scenarios
 * then 1 scenario each will run from the feature files
 * once 1st scenario run is done in file2 then only 2nd will start
 *  
 */
