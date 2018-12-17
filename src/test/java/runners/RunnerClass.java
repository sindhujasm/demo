package runners;

import java.io.File;
import java.io.FileReader;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;




@RunWith(Cucumber.class)
@CucumberOptions(

	   plugin = {"com.cucumber.listener.ExtentCucumberFormatter:target/Results/report.html"},
		features={"src/test/resources/features/"}, 
		glue={"stepdefinition"},
		tags={"@tag2,@tag7"}

)
public class RunnerClass extends AbstractTestNGCucumberTests {
	
	@AfterClass
	 public static void writeExtentReport() {
	Reporter.loadXMLConfig("C:/Users/s.magarajothiprasad/workspace/demo/extent-config.xml");
	
	 }
}

