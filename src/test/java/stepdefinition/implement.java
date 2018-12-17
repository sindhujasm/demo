package stepdefinition;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.testng.annotations.Test;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.relevantcodes.extentreports.ExtentReports;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import wrappers.GenericWrappers;

public class implement extends GenericWrappers   {
	

	GenericWrappers wrap =new GenericWrappers();
//	static WebDriver driver;
	Properties obj = new Properties(); 
	FileInputStream objfile=null;
	public implement() throws IOException  {
	 objfile = new FileInputStream(System.getProperty("user.dir")+"\\object.properties");
	obj.load(objfile);
	
	}
	
	@Before
	public void beforeSuite(Scenario scenario1){
		reports = new ExtentReports("C:/Users/s.magarajothiprasad/workspace/demo/result.html", false);
		reports.loadConfig(new File("C:/Users/s.magarajothiprasad/workspace/demo/extent-config.xml"));
		scenario=scenario1;
		test=reports.startTest(this.getClass().getSimpleName()+"..."+scenario.getName());
		
		test.assignAuthor("Sindhu");
		test.assignCategory("smoke");
		System.setProperty("webdriver.chrome.driver", "C:/Users/s.magarajothiprasad/workspace/projectdemo/drivers/chromedriver.exe");
		driver =new ChromeDriver();
	}
	
	public String getReportConfigPath(){
		 String reportConfigPath = obj.getProperty("reportConfigPath");
		 if(reportConfigPath!= null) return reportConfigPath;
		 else throw new RuntimeException("Report Config Path not specified in the Configuration.properties file for the Key:reportConfigPath"); 
		}
	
	
@Given("^Open browser and launch url$")
public void open_browser_and_launch_url() throws Throwable {
	wrap.urlLaunch("https://www.google.com", "chrome");
	
    }

@Given("^Open \"([^\"]*)\" browser and launch \"([^\"]*)\"$")
public void open_browser_and_launch_url(String arg1, String arg2) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
   wrap.urlLaunch(obj.getProperty(arg2),arg1);
}



@Given("^enter the word to search$")
public void enter_the_word_to_search() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	wrap.sendText("//input[@title='Search']", "Weather");

}

@Given("^enter the \"([^\"]*)\" as \"([^\"]*)\"to search$")
public void enter_the_as_to_search(String arg1, String arg2) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    wrap.sendText(obj.getProperty(arg1), arg2);
}

@When("^click on \"([^\"]*)\"$")
public void click_on(String arg1) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    wrap.enter();
}

//orange application

@Given("^enter \"([^\"]*)\" username as \"([^\"]*)\"$")
public void enter_username_as(String arg1, String arg2) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    wrap.sendText(arg1, arg2);
}

@Given("^enter \"([^\"]*)\" password as \"([^\"]*)\"$")
public void enter_password_as(String arg1, String arg2) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	 wrap.sendText(arg1, arg2);
}

@Given("^click on \"([^\"]*)\" submit button$")
public void click_on_submit_button(String arg1) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
   wrap.click(arg1);
}

@When("^click on \"([^\"]*)\" button$" )
public void click_on_button(String arg1) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    wrap.click(obj.getProperty(arg1));
}

@When("^verify \"([^\"]*)\" is readonly$" )
public void verify_is_readonly(String arg1) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    wrap.readOnly(arg1);
}

@Then("^enter \"([^\"]*)\" as \"([^\"]*)\"$")
public void enter_as(String arg1, String arg2) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    wrap.sendText(arg1, arg2);
}

@When("^display all \"([^\"]*)\" datas$" )
public void display_all_datas(String arg1) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    wrap.dataRetrieve(obj.getProperty(arg1));
}

@Then("^select \"([^\"]*)\" and \"([^\"]*)\" dates$")
public void select_and_dates(String arg1, String arg2) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
   wrap.datePicker(arg1, arg2);
}

@When("^uncheck \"([^\"]*)\" check box$" )
public void uncheck_check_box(String arg1) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    wrap.checkBox(obj.getProperty(arg1));
}
@Given("^close browser$")
public void close_browser() throws Throwable {
	wrap.closeBrowser();
	
    }

@When("^verify \"([^\"]*)\" in \"([^\"]*)\" candidate name$" )
public void verify_in_candidate_name(String text,String arg1) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    wrap.containsVerification(text,obj.getProperty(arg1));
}

@When("^verify \"([^\"]*)\" error message$" )
public void verify_error_message(String arg1) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    wrap.verifyError(arg1);
    }

@Given("^click on ok$")
public void click_on_ok() throws Throwable {
	wrap.handleAlert();
	
    }



}
