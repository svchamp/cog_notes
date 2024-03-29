package test01;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlertWithInputBox {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url="https://the-internet.herokuapp.com/javascript_alerts";
		WebDriver driver=new ChromeDriver();
		
		WebDriverWait myWait=new WebDriverWait(driver, Duration.ofSeconds(10));
		
		driver.get(url);
//		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
		
		Alert alertWindow=myWait.until(ExpectedConditions.alertIsPresent());
		
		alertWindow.sendKeys("Shrinivas");
		alertWindow.accept();
	}

}
