package testDefinations;

import org.junit.runner.RunWith;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.cucumber.java.After;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.TestNGCucumberRunner;

@RunWith(Cucumber.class)
@CucumberOptions(features = "C:/Users/sarve/eclipse-workspace/Endureka/src/test/resources/Features/whatfix.feature", glue = {"testDefinations"}, 
 monochrome = true,
 
plugin = {"pretty","junit:target/JunitReports/report.xml",
				  "html:target/HTMLReports/report.html",
				  "json:target/JSONReports/report.json",
				  "json:target/cucumber-reports/CucumberTestReport.json"}
)


public class TestRunner_whatfix{

	
  
}
