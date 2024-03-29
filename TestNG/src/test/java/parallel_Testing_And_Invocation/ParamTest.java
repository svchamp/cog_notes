package parallel_Testing_And_Invocation;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class ParamTest {
	WebDriver driver;
	
	@BeforeClass
	@Parameters({"browser"})
	void setup(String br) {
		if(br.equals("chrome"))
			driver=new ChromeDriver();
		else
			driver=new EdgeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		System.out.println("setup");
	}
	
	@Test(priority=1)
	void testTitle() throws InterruptedException {
//		Thread.sleep(4000);
		System.out.println(driver.getTitle());
		Assert.assertEquals(driver.getTitle(),"OrangeHRM");
		
	}
	
	@Test(priority=2)
	void testUrl() {
		System.out.println(driver.getCurrentUrl());
		Assert.assertEquals(driver.getCurrentUrl(),"OrangeHRM");
		
	}
	
	@AfterClass
	void close() {
		driver.quit();
	}
	
}
