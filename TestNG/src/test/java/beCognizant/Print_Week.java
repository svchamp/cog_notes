package beCognizant;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Print_Week {
//	Declaring the global variables
	WebDriver driver;
	WebDriverWait myWait;
	
//	Constructor
	public Print_Week(WebDriver driver) {
		this.driver = driver;
		myWait=new WebDriverWait(this.driver,Duration.ofSeconds(10));
	}

//	Printing all week details
	void printAllWeeks() throws InterruptedException {
//		Getting the dates in proper format
		LocalDate ld;
//		Defining the proper format
		DateTimeFormatter dtf=DateTimeFormatter.ofPattern("MM/dd/YYYY");
		
//		Storing the current date as string
		ld=LocalDate.now();
		String now=dtf.format(ld);
		
//		Storing the 1 week before date as string
		ld=LocalDate.now().minusWeeks(1);
		String one=dtf.format(ld);
		
//		Storing the 2 week before date as string
		ld=LocalDate.now().minusWeeks(2);
		String two=dtf.format(ld);
		
//		Validate the results
		printWeek(now);
		printWeek(one);
		printWeek(two);
	}
	
//	Validating the required week details
	void printWeek(String week) throws InterruptedException {
		WebElement e;
//		Selecting 'Date' option from 'SearchBy' dropdown
		e=myWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//select[@id='CTS_TS_LAND_WRK_CTS_TS_SEARCH']")));
		Select select=new Select(e);
		select.selectByIndex(1);
		
		
//		Selecting the respective date
		Thread.sleep(4000);
		driver.findElement(By.xpath("//input[@id='CTS_TS_LAND_WRK_DATE']")).sendKeys(week);
		
//		Clicking on the search button
		driver.findElement(By.xpath("//a[@id='CTS_TS_LAND_WRK_SEARCH']")).click();
		
//		Storing the result in a List
		Thread.sleep(4000);
		List<WebElement> lis=driver.findElements(By.xpath("//div[@id='win0divCTS_TS_LAND_PER_$55$$0']/div"));
		
//		Validating the dates
		System.out.print(lis.get(0).getText());
		
//		Printing the status
		System.out.print(" - "+lis.get(1).getText()+"\n");

//		Clicking on the 'clear' button
		driver.findElement(By.xpath("//a[@id='CTS_TS_LAND_WRK_PB_CLEAR']")).click();
		Thread.sleep(4000);
	}
}
