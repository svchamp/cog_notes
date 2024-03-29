package beCognizant;
 
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
public class Timesheet {
	WebDriverWait myWait;
	JavascriptExecutor js;
	String url="https://cognizantonline.sharepoint.com/sites/Be.Cognizant/SitePages/Home.aspx";
	WebDriver driver;
	@BeforeClass
	void setup() throws InterruptedException {
		driver=new ChromeDriver();
		myWait=new WebDriverWait(driver,Duration.ofSeconds(15));
		driver.manage().window().maximize();
		js=(JavascriptExecutor) driver;
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		Thread.sleep(3000);
		driver.get(url);
		Thread.sleep(30000);
//	    Thread.sleep(5000);
	}
	@Test(priority=1)
	void beCognizant() throws InterruptedException {
		Thread.sleep(5000);
		WebElement e=myWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='_8ZYZKvxC8bvw1xgQGSkvvA==']")));
		Thread.sleep(3000);
		e.click();
		e=myWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='mectrl_currentAccount_secondary']")));
		String email=e.getText();
		String name=driver.findElement(By.xpath("//div[@id='mectrl_currentAccount_primary']")).getText();
		System.out.println(email+":"+name);
 
		driver.findElement(By.xpath("//div[@title='OneCognizant']")).click();
//		Thread.sleep(4000);
//		e.click();
	}
	@Test(priority=2)
	void oneCognizant() throws InterruptedException {
		WebElement e;
		Set<String> set=driver.getWindowHandles();
		for(String s:set) {
			driver.switchTo().window(s);
			Thread.sleep(3000);

//			Assert.assertEquals(driver.getTitle(),"OneCognizant");
//			System.out.println(s);
			if(driver.getTitle().equalsIgnoreCase("OneCognizant")) {
				//System.out.println(s);
				break;
			}
		}
		e=myWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='oneC_searchAutoComplete']")));
		e.sendKeys("timesheet");
		e=myWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[ contains(text(),'Timesheet') ]")));
		js.executeScript("arguments[0].click()",e);
		//driver.findElement(By.xpath("//input[@id='oneC_searchAutoComplete']")).sendKeys("timesheet");
	}
	@Test(priority=3)
	void timesheet() throws InterruptedException {
		WebElement e;
//		e=myWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[ contains(text(),'Timesheet') ]")));
//		js.executeScript("arguments[0].click()",e);
		Thread.sleep(3000);
		Set<String> set=driver.getWindowHandles();
		//System.out.println("size"+set.size()); 
		for(String s:set) {
			driver.switchTo().window(s);
			Thread.sleep(3000);

//			Assert.assertEquals(driver.getTitle(), "Timesheet Landing Component");
//			System.out.println(driver.getTitle());
//			
			if(driver.getTitle().equalsIgnoreCase("Timesheet Landing Component")) {
//				WebElement dropdown=;
//				Select dp=new Select(driver.findElement(By.tagName("select")));
//				dp.selectByValue("1");

				break;
			}

		}
		System.out.println("Last 3 week details........");
		String stt=driver.findElement(By.xpath("//*[@id=\"win0divCTS_TS_LAND_WRK_GROUP_BOX_1$1\"]")).getText();
		System.out.println(stt);
		System.out.println("............................");
		String stt2=driver.findElement(By.xpath("//*[@id=\"win0divCTS_TS_LAND_WRK_GROUP_BOX_1$2\"]")).getText();
		System.out.println(stt2);
		System.out.println("............................");
 
		String stt3=driver.findElement(By.xpath("//*[@id=\"win0divCTS_TS_LAND_WRK_GROUP_BOX_1$3\"]")).getText();
		System.out.println(stt3);
		System.out.println("............................");
 
		Select dp=new Select(driver.findElement(By.tagName("select")));
		dp.selectByValue("1");
		LocalDate currentDate=LocalDate.now();
		DateTimeFormatter formatter=DateTimeFormatter.ofPattern("MM/dd/yyyy"); 
		String date=currentDate.format(formatter);
		System.out.println(date);
		Thread.sleep(3000);
		driver.findElement(By.id("CTS_TS_LAND_WRK_DATE")).sendKeys(date);
		driver.findElement(By.xpath("//div[contains(@class,'search_button')]//span/a")).click();
	//	WebElement refresh=driver.findElement(By.xpath("//a[@id='CTS_TS_LAND_WRK_PB_CLEAR']"));  
		//wait.until(ExpectedConditions.visibilityOf(refresh));
		Thread.sleep(3000);
		String s=driver.findElement(By.xpath("//div[@class='ps_box-group psc_layout timesheet_period_group_box']//a")).getText();
		System.out.println(s);
		DateTimeFormatter formatter2=DateTimeFormatter.ofPattern("MM/dd/yyyy"); 
		LocalDate d=LocalDate.parse(date,formatter2);
		DateTimeFormatter formatter3=DateTimeFormatter.ofPattern("dd/MMM/yyyy"); 
		String fd=d.format(formatter3);
		System.out.println(fd);
		String [] arr=fd.split("/");
		int a=Integer.parseInt(arr[0]);
		if(s.contains(arr[1].toUpperCase()) && s.contains(arr[2])) {
			if(Integer.parseInt(s.substring(0, 2)) <=a && Integer.parseInt(s.substring(15,17))>=a){
				System.out.println("current week is validated");
			}
		}


}
	@Test(priority=4)
	void status() {
		Select dp=new Select(driver.findElement(By.tagName("select")));
		dp.selectByValue("2");
	}

}