package casProject;


import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Print_Status {
	//Declaring the global variables
	WebDriver driver;
	JavascriptExecutor js;
	
	//constructor
	public Print_Status(WebDriver driver) {
		this.driver=driver;
		js=(JavascriptExecutor)driver;
	}

//	Method for printing all the status details
	void print() throws InterruptedException {
//		selecting status from SearchBy dropdown
		WebElement inp1=driver.findElement(By.xpath("//select[@id='CTS_TS_LAND_WRK_CTS_TS_SEARCH']"));
		Select select1=new Select(inp1);
		select1.selectByIndex(2);
		
//		Selecting status dropdown
		Thread.sleep(3000);
		WebElement inp2=driver.findElement(By.xpath("//select[@id='CTS_TS_LAND_WRK_CTS_TS_LAND_STATUS']"));
		Select select2=new Select(inp2);
	
//		Storing all options from the dropdown in a List of WebElement
		List<WebElement> options2=select2.getOptions();
		
//		Storing the Text from each of the option in a List of String
//		This prevents stale element reference exception
		List<String> str=new ArrayList<>();
		for(WebElement e:options2) {
			str.add(e.getText());
		}
		
//		Traversing the different 'status' dropdown options and validating the result
		for(int i=1;i<options2.size();i++) {
//			Printing the Text() from the option
			System.out.println(str.get(i)+" :-");
			
//			Selecting 'status' from SearchBy dropdown
			inp1=driver.findElement(By.xpath("//select[@id='CTS_TS_LAND_WRK_CTS_TS_SEARCH']"));
			select1=new Select(inp1);
			select1.selectByIndex(2);
			Thread.sleep(3000);
			
//			Selecting the respective option from 'status' dropdown
			inp2=driver.findElement(By.xpath("//select[@id='CTS_TS_LAND_WRK_CTS_TS_LAND_STATUS']"));
			select2=new Select(inp2);
			select2.selectByIndex(i);
			Thread.sleep(3000);
			
//			Clicking on the search button
			js.executeScript("arguments[0].click()", driver.findElement(By.xpath("//a[@id='CTS_TS_LAND_WRK_SEARCH']")));
			Thread.sleep(3000);
			
//			Validating the results
			printStatus(driver);
			
//			Clicking on the 'clear' button 
			js.executeScript("arguments[0].click()", driver.findElement(By.xpath("//a[@id='CTS_TS_LAND_WRK_PB_CLEAR']")));
			Thread.sleep(3000);
			
//			Handling the popup in case of 'No Search result found'
			try {
				driver.findElement(By.xpath("//*[@id='#ICOK']")).click();
			}catch(Exception err) {
			}
			finally {
				Thread.sleep(3000);
			}
		}
		
	}
//	Method for printing the search results
	void printStatus(WebDriver driver) {
		List<WebElement> lis=driver.findElements(By.xpath("//a[contains(@id,'CTS_TS_LAND_PER_DESCR30')]"));
		for(WebElement x:lis) {
			System.out.println(x.getText());
		}
	}
}
