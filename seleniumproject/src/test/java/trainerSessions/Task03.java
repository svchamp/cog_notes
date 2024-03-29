package trainerSessions;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task03 {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		WebElement e;
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		
		Thread.sleep(4000);
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
		
		TakesScreenshot ts=(TakesScreenshot) driver;
		File src,dest;
		//--------------- take screenshot ------------------------
		src=ts.getScreenshotAs(OutputType.FILE);
		dest=new File("C:\\Users\\2318403\\eclipse-workspace\\seleniumproject\\src\\test\\java\\trainerSessions\\one.png");
		FileUtils.copyFile(src, dest);
		System.out.println("Screenshot Taken");
		
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		Thread.sleep(5000);
		
		//-------------- take screenshot ---------------------
		src=ts.getScreenshotAs(OutputType.FILE);
		dest=new File("C:\\Users\\2318403\\eclipse-workspace\\seleniumproject\\src\\test\\java\\trainerSessions\\two.png");
		FileUtils.copyFile(src, dest);
		System.out.println("Screenshot Taken");
		
		//span[text()='Admin']
		driver.findElement(By.xpath("//span[text()='Admin']")).click();
		Thread.sleep(4000);
		
		//--------------- take screenshot --------------------------
		src=ts.getScreenshotAs(OutputType.FILE);
		dest=new File("C:\\Users\\2318403\\eclipse-workspace\\seleniumproject\\src\\test\\java\\trainerSessions\\3.png");
		FileUtils.copyFile(src, dest);
		System.out.println("Screenshot Taken");
		
		e=driver.findElement(By.xpath("//div[@class='oxd-table-filter-area']//input[@class='oxd-input oxd-input--active']"));
		e.sendKeys("nalim");
		
		driver.findElement(By.xpath("//div[@class='oxd-select-text-input'][1]")).click();
		driver.findElement(By.xpath("//div[@role='option'][3]")).click();
		
		driver.findElement(By.xpath("//input[contains(@placeholder,'Type for hints')]")).sendKeys("Nalim R P");
		Thread.sleep(5000);
//		driver.findElement(By.xpath("//div[@class='oxd-autocomplete-dropdown --position-bottom']")).click();
		
		driver.findElement(By.xpath("//div[contains(text(),'-- Select --')]")).click();
		Thread.sleep(5000);
		
//      ------------ take screenshot -----------------------------------
		src=ts.getScreenshotAs(OutputType.FILE);
		dest=new File("C:\\Users\\2318403\\eclipse-workspace\\seleniumproject\\src\\test\\java\\trainerSessions\\4.png");
		FileUtils.copyFile(src, dest);
		System.out.println("Screenshot Taken");
		
		driver.findElement(By.xpath("//button[normalize-space()='Search']")).click();
		Thread.sleep(5000);
		
		//      ------------ take screenshot -----------------------------------
		src=ts.getScreenshotAs(OutputType.FILE);
		dest=new File("C:\\Users\\2318403\\eclipse-workspace\\seleniumproject\\src\\test\\java\\trainerSessions\\5.png");
		FileUtils.copyFile(src, dest);
		System.out.println("Screenshot Taken");
		
	}

}
