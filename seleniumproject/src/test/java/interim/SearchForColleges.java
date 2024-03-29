package interim;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SearchForColleges {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url="https://www.eduvidya.com/";
		
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.manage().window().maximize();
		driver.get(url);
		System.out.println("Opening the webpage: https://www.eduvidya.com/");
		
		//Your connection is not Secure
		try {
		System.out.println("Handling the security");
		driver.findElement(By.xpath("//button[@id='details-button']")).click();
		driver.findElement(By.xpath("//a[@id='proceed-link']")).click();
		}catch(Exception e) {
			System.out.println("Link security issue");
			driver.quit();
		}
		
		//Click on "Colleges" link in the Menu bar
		driver.findElement(By.linkText("Colleges")).click();
		
		//Click on "Course" dropdown and select a course (ex: Science)
		WebElement course=driver.findElement(By.xpath("//select[@id='ddl_Category']"));
		Select selectCourse=new Select(course);
		selectCourse.selectByVisibleText("Science");
		System.out.println("Choosing \"Science\" from course dropdown");
		
		//Click on "City" dropdown and select a city (ex: Chennai)
		WebElement city=driver.findElement(By.xpath("//select[@id='ddl_City']"));
		Select selectCity=new Select(city);
		selectCity.selectByVisibleText("Chennai");
		System.out.println("Choosing \"Chennai\" from city dropdown");
		
		//Click on search button
		System.out.println("Clicking on the search button");
		driver.findElement(By.xpath("//input[@id='btnSearch']")).click();
		
		//Verify the result is displayed or not
		List<WebElement> result=driver.findElements(By.xpath("//div[@class='detail-list']/ul/li/div/a"));
		if(result.size()==0) {
			System.out.println("No search results found");
		}
		else {
			System.out.println("Search result is displayed");
		}
		
		System.out.println("Closing the browser");
		driver.quit();
	}

}
