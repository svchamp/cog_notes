package dataProvidersAndGrouping;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class daaataProvider {
	WebDriver driver;
	String url;
	
	@BeforeMethod
	void setup() {
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		url="https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
		
	}
	
	@Test(dataProvider="dp")
	void testLogin(String email,String pass) throws InterruptedException {
		driver.get(url);
//		Thread.sleep(5000);
		WebElement e=driver.findElement(By.xpath("//input[@name='username']"));
		e.sendKeys(email);
		e=driver.findElement(By.xpath("//input[@name='password']"));
		e.sendKeys(pass);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
//		Thread.sleep(4000);
		String exp="https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
		Assert.assertEquals(exp,driver.getCurrentUrl());
	}
	
	@AfterMethod
	void tearDown() {
		driver.quit();
	}
	
	@DataProvider(name="dp")
	String[][] loginData() {
		//take data from excel
		String data[][]=new String[3][2];
		data[0][0]="Admin";
		data[0][1]="admin123";
//		data[0][3]="third";
		
		data[1][0]="wrong";
		data[1][1]="wrongPass";
//		data[0][3]="third";
		
		data[2][0]="Admin";
		data[2][1]="admin123";
//		data[0][3]="third";
		
		return data;
	}
	
	
	
	
	
	
	
}
