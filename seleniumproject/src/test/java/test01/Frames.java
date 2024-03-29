package test01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Frames {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		String url="https://ui.vision/demo/webtest/frames/";
		WebDriver driver=new ChromeDriver();
		
		driver.get(url);
		
		//take screenshot
		
		//click on nested frames
		driver.findElement(By.xpath("//a[text()='iFrame']")).click();

		//switch to iframe
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//body[@id='tinymce']")).sendKeys("This is the sample data");
		//take screenshot
		
		driver.navigate().back();
		//take screenshot
		
		driver.findElement(By.xpath("//a[text()='Nested Frames']")).click();
	}

}
