package pageObjectModel;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTest_WithPageFactory {
	WebDriver driver;
	LoginPage_WithPageFactory lp;
	
	String url="https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
	
	@BeforeClass
	void setup() {
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(url);
	}
	
	@Test
	void testLogin() throws InterruptedException {
		lp=new LoginPage_WithPageFactory(driver);
		lp.setUsername("Admin");
		lp.setPassword("admin123");
		lp.submit();
		
		Assert.assertEquals(driver.getTitle(), "OrangeHRM");
	}
	
	@AfterClass
	void tearDown() {
		driver.quit();
	}
}
