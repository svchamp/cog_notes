package trainerSessions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.edge.EdgeDriver;


public class LoginForm {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		
		//multiple drivers can be launched from one script
//		WebDriver fire=new EdgeDriver();
//		fire.get("https://www.google.com/");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F");
		
		WebElement x=driver.findElement(By.xpath("//input[@id='Email']"));
		x.clear();
		Thread.sleep(1000);
		x.sendKeys("admin@yourstore.com");
		
		WebElement y=driver.findElement(By.xpath("//input[@id='Password']"));
		y.clear();
		Thread.sleep(1000);
		y.sendKeys("admin");
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}

}
