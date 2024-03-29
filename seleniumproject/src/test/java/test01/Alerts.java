package test01;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Alerts {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		String url="https://the-internet.herokuapp.com/javascript_alerts";
		WebDriver driver=new ChromeDriver();
		
		WebDriverWait myWait=new WebDriverWait(driver, Duration.ofSeconds(10));
		
		driver.get(url);
//		Thread.sleep(5000);
		//button[@onclick='jsConfirm()']
		driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();
		
		
//		We have to use explicit wait for this to work
//		Alert alertWindow=driver.switchTo().alert();
		
		Alert alertWindow=myWait.until(ExpectedConditions.alertIsPresent());
		
		System.out.println(alertWindow.getText());
		
//		alertWindow.accept();
		alertWindow.dismiss();
	}

}
