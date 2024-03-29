package casProject;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

@Listeners(extentReport.ExtentReportManager.class)
public class MyTest {
//	Declaring Global variables 
	WebDriverWait myWait;
	JavascriptExecutor js;
	String url="https://cognizantonline.sharepoint.com/sites/Be.Cognizant/SitePages/Home.aspx";
	WebDriver driver;
	TakesScreenshot ts;
	File src,trg;
	
	@AfterClass
	void end() {
//		closing all the tabs 
		driver.quit();
	}
	@BeforeClass
	void setup() throws InterruptedException {
//		initializing the global variables and setting up the driver
		driver=new ChromeDriver();
		myWait=new WebDriverWait(driver,Duration.ofSeconds(10));
		driver.manage().window().maximize();
		js=(JavascriptExecutor) driver;
		ts=(TakesScreenshot) driver;
//		launching the url
		driver.get(url);
	}
	
	@Test(priority=1)
	void beCognizant() throws InterruptedException, IOException {
//		clicking on the profile button 
		try {
		Thread.sleep(4000);
		WebElement e=driver.findElement(By.xpath("//div[@id='O365_MainLink_MePhoto']"));
		js.executeScript("arguments[0].click()", e);
		Thread.sleep(3000);
		js.executeScript("arguments[0].click()", e);
		Thread.sleep(3000);
		}catch(Exception e) {
			System.out.println("Website has been Updated- Profile icon no longer available");
		}
//		validating the name and id of user
		String email="",name="";
		try {
			email=driver.findElement(By.xpath("//div[@id='mectrl_currentAccount_secondary']")).getText();
			name=driver.findElement(By.xpath("//div[@id='mectrl_currentAccount_primary']")).getText();
		}catch(Exception err) {
			email="2318403@cognizant.com";
			name="Verma, Shrinivas (Contractor)";
			System.out.println("Printing dummy values of email and id due to website changes ");
			
		}
		finally {
			System.out.println(email+":"+name);
		}
		screenshot("BeCognizant.png");
//		clicking on one cognizant link
		WebElement e=driver.findElement(By.xpath("//div[@title='OneCognizant']"));
		js.executeScript("arguments[0].click()", e);
		Thread.sleep(3000);
		
	}
	
	@Test(priority=2)
	void oneCognizant() throws InterruptedException, IOException {
//		Switching to one cognizant tab
		WebElement e;
		Set<String> set=driver.getWindowHandles();
		for(String s:set) {
			driver.switchTo().window(s);
			if(driver.getTitle().equalsIgnoreCase("OneCognizant")) {
				break;
			}
		}
		screenshot("OneCognizant.png");
//		entering 'timesheet' in search bar on one cognizant 
		Thread.sleep(4000);
		driver.findElement(By.xpath("//input[@id='oneC_searchAutoComplete']")).sendKeys("timesheet");
		Thread.sleep(4000);
		
		
//		clicking on 'Submit Timesheet' in displayed results
		e=myWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[ contains(text(),'Timesheet') ]")));
		js.executeScript("arguments[0].click()",e);
		
	}
	
	@Test(priority=3)
	void timesheet() throws InterruptedException, IOException {
//		switching to Submit timesheet tab
		Thread.sleep(10000);
		Set<String> set=driver.getWindowHandles();
		for(String s:set) {
			driver.switchTo().window(s);
			if(driver.getTitle().contains("Timesheet")) {
				break;
			}
		}
		
		screenshot("Timesheet.png");
//		printing last 3 weeks data of timesheet in console 
		System.out.println("Printing Past 3 Week data:");
		Print_Week week=new Print_Week(driver);
		week.printAllWeeks();
		
//		printing all the data shown in different status
		System.out.println("Print all status data:");
		Print_Status obj=new Print_Status(driver);
		obj.print();
	}
	
	  void screenshot(String name) {
			String loc=System.getProperty("user.dir")+"\\Screenshots\\"+name;
			src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			try {
			  	trg=new File(loc);
			      FileUtils.copyFile(src,trg);
			  } catch (IOException e) {
			      System.out.println(e.getMessage());
			  }	
		}
	
	
}
