package wrappers;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.Scenario;
import cucumber.api.java.Before;

public class GenericWrappers  {
	//static WebDriver driver;
	ArrayList <Object> output=null;
	//Robot robot = new Robot(); 
	public static WebDriver driver;
	public static ExtentReports reports;
	public static ExtentTest test;
	public static Scenario scenario;
	

	
	public static String capture(WebDriver webdriver) throws IOException{
		TakesScreenshot ts = (TakesScreenshot)webdriver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String dest = System.getProperty("user.dir") +"\\Screenshots\\"+"ExecutionResults-"+timestamp1()+"\\"+scenario.getName()+"\\"+timestamp()+".png";
		File destination = new File(dest);
		FileUtils.copyFile(source, destination);       

		return dest;
	}
	
	public static String timestamp() {
        return new SimpleDateFormat("HH-mm-ss").format(new Date());
}
	
	public static String timestamp1() {
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
}
	



	
	
public void urlLaunch(String element,String browserName) throws IOException{
	/*if(browserName.equalsIgnoreCase("chrome")){
		System.setProperty("webdriver.chrome.driver", "C:/Users/s.magarajothiprasad/workspace/projectdemo/drivers/chromedriver.exe");
		driver = new ChromeDriver();
	}
	if(browserName.equalsIgnoreCase("firefox")){
		
	}*/
	
	driver.get(element);
	test.log(LogStatus.PASS,"url launched"+test.addScreenCapture(capture(driver)));
	driver.manage().window().maximize();
}

public void sendText(String element,String text) throws IOException{
	if(element.startsWith("//")){
	driver.findElement(By.xpath(element)).sendKeys(text);
	test.log(LogStatus.PASS,"username and pwd entered"+test.addScreenCapture(capture(driver)));
	}else
	{
		driver.findElement(By.id(element)).sendKeys(text);
		test.log(LogStatus.PASS,"url launched"+test.addScreenCapture(capture(driver)));
	}
}

public void enter() throws AWTException{
	Robot robot = new Robot(); 
	 robot.keyPress(java.awt.event.KeyEvent.VK_ENTER);
	 robot.keyRelease(java.awt.event.KeyEvent.VK_ENTER);
}

public void click(String element) throws IOException{
	if(element.startsWith("//")){
		driver.findElement(By.xpath(element)).click();
		test.log(LogStatus.PASS,"url launched"+test.addScreenCapture(capture(driver)));
		}else
		{
	driver.findElement(By.id(element)).click();
		}
}

public void readOnly(String element){
	String value=driver.findElement(By.id(element)).getAttribute("disabled");
	String value1=driver.findElement(By.id(element)).getAttribute("");
	//System.out.println(value);
	if(value.equals("true")){
		System.out.println("Employee id field is disabled");
	} else
	{
		System.out.println("EMployee id field is enabled");
}
}

public void dataRetrieve(String arg1){
	WebElement myTable = driver.findElement(By.xpath(arg1));
	List<WebElement> row= myTable.findElements(By.tagName("tr"));
	
	int rowSize=row.size();
	
	for(int i=0;i<rowSize;i++){
		List<WebElement> col= row.get(i).findElements(By.tagName("td"));
		int colSize=col.size();
		
		for(int j=0;j<colSize;j++){
			Object cellText=col.get(j).getText();
			System.out.println(cellText);
			
		}
		System.out.println("-----------------------");
	}
}


public void containsVerification(String text,String arg1){
	WebElement myTable = driver.findElement(By.xpath(arg1));
	List<WebElement> row= myTable.findElements(By.tagName("tr"));
	
	int rowSize=row.size();
	
	for(int i=0;i<rowSize;i++){
		List<WebElement> col= row.get(i).findElements(By.tagName("td"));
		int colSize=col.size();
		
		for(int j=0;j<colSize;j++){
			Object cellText=col.get(j).getText();
			System.out.println(cellText);
			
			if(cellText==null){
				System.out.println("ignore");
			}
			if(cellText.toString().equalsIgnoreCase(text)){
				output.add(cellText);
			}
			
		}
		System.out.println("-----------------------");
	}
	
}


public void datePicker(String arg1,String arg2){
	WebElement fromDate = driver.findElement(By.id(arg1));
	fromDate.clear();
	fromDate.sendKeys("2018-11-29");
	WebElement toDate = driver.findElement(By.id(arg2));
	toDate.clear();
	toDate.sendKeys("2018-12-03");
}

public void checkBox(String element){
	driver.findElement(By.xpath(element)).click();
}


public void closeBrowser(){
	driver.close();
}

public void verifyError(String id){
	String errorMessage=driver.findElement(By.id(id)).getText();
	if(errorMessage.equalsIgnoreCase("Invalid credentials")){
		System.out.println("validated");
			}
}

public void handleAlert(){
	driver.switchTo().alert().accept();
}


}

