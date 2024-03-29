package test01;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Wait {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		
		//implicit wait
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//declaration of explicit wait
		WebDriverWait myWait=new WebDriverWait(driver,Duration.ofSeconds(10));
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
//		String xp="//input[@placeholder='Username']";
//		driver.findElement(By.xpath(xp)).sendKeys("Admin");
		
		//use of explicit wait
		WebElement username=myWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Username']")));
		username.sendKeys("Admin");
		System.out.println("Done");
		
		driver.navigate().to("https://www.amazon.in/");
		driver.navigate().refresh();
		
		driver.navigate().back();
		driver.navigate().forward();
		
		driver.navigate().refresh();
		
	}

}
 