package test01;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day02 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(5000);
		driver.manage().window().maximize();
		
		System.out.println("title-> "+driver.getTitle());
		
//		String pageSource=driver.getPageSource();
//		System.out.println(pageSource);
		String handle=driver.getWindowHandle();
		System.out.println(handle);
		
		driver.findElement(By.xpath("//a[normalize-space()='OrangeHRM, Inc']")).click();
		Thread.sleep(5000);
		
		Set<String> setHandles=driver.getWindowHandles();
		System.out.println(setHandles);
		
		
//		closes first tab and not new one
		driver.close();
		
		//closes all tabs
		//driver.quit();
		
		
		
	}

}
