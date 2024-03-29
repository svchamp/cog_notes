package test01;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SizeAndPositionOfBrowserWindow {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		String url="https://ui.vision/demo/webtest/frames/";
		WebDriver driver=new ChromeDriver();
		
		driver.get(url);
		
		Point p=new Point(100,100);
		Thread.sleep(5000);
		driver.manage().window().setPosition(p);
		
		p=new Point(0,0);
		driver.manage().window().setPosition(p);
		
		Dimension d=new Dimension(250,500);
		driver.manage().window().setSize(d);
	}

}
