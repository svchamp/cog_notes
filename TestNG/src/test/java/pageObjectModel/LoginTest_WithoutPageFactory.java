package pageObjectModel;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class LoginTest_WithoutPageFactory {
	WebDriver driver;
	LoginPage_WithoutPageFactory lp;
	
	String url="https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
	
	@BeforeClass
	void setup() {
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(url);
	}
	
	@Test
	void testLogin() throws InterruptedException {
		lp=new LoginPage_WithoutPageFactory(driver);
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
