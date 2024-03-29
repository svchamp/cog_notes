package trainerSessions;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Task02 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver=new EdgeDriver();
		module1(driver);
		module2(driver);
	}
	public static void module2(WebDriver driver) throws InterruptedException {
		WebElement e=waitForElementPresent(driver, By.xpath("//button[contains(text(),'Withdrawl')]"), 10);
		e.click();
		
		WebDriverWait myWait=new WebDriverWait(driver, Duration.ofSeconds(10));
		
		e=driver.findElement(By.xpath("//input[@type='number']"));
		myWait.until(ExpectedConditions.refreshed(ExpectedConditions.stalenessOf(e)));
		e=driver.findElement(By.xpath("//input[@type='number']"));
		e.sendKeys("2000");	
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		e=waitForElementPresent(driver, By.xpath("//span[contains(text(),'successful')]"), 10);
		System.out.println("message:"+e.getText());
		printDetails(driver);
		
		//Reading table contents and printing
		e=waitForElementPresent(driver, By.xpath("//button[contains(text(),'Transactions')]"), 10);
		e.click();
		myWait.until( ExpectedConditions.visibilityOf( driver.findElement(By.xpath("//table")) ) );
//		waitForElementPresent(driver, By.xpath("//table"), 10);
		int col=driver.findElements(By.xpath("//table/thead/tr//td")).size();
		int row=driver.findElements(By.xpath("//table/tbody/tr")).size();
		
		//print table headers
		for(int i=1;i<=col;i++) {
			String loc="//table/thead/tr[1]/td["+i+"]";
			WebElement temp=driver.findElement(By.xpath(loc));
			System.out.print(temp.getText()+"\t\t");
		}
		System.out.println();
		
		//print table contents
		for(int i=1;i<=row;i++) {
			for(int j=1;j<=col;j++) {
				String loc="//table/tbody/tr["+i+"]/td["+j+"]";
				WebElement temp=driver.findElement(By.xpath(loc));
				System.out.print(temp.getText()+"\t\t");
			}
			System.out.println();
		}
		
		//logout
		driver.findElement(By.xpath("//button[@class='btn logout']")).click();
		
		//home
		e=waitForElementPresent(driver, By.xpath("//button[@class='btn home']"), 10);
		e.click();
		
		//bank manager
		e=waitForElementPresent(driver, By.xpath("//button[contains(text(),'Bank')]"), 10);
		e.click();
		
		e=waitForElementPresent(driver, By.xpath("//button[contains(text(),'Add')]"), 10);
		e.click();
		
		e=waitForElementPresent(driver, By.xpath("//input[@ng-model='fName']"), 10);
		e.sendKeys("Shrinivas");
		driver.findElement(By.xpath("//input[@ng-model='lName']")).sendKeys("Verma");
		driver.findElement(By.xpath("//input[@ng-model='postCd']")).sendKeys("411057");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		Alert alert=myWait.until(ExpectedConditions.alertIsPresent());
		alert.accept();
		
		//customers
		driver.findElement(By.xpath("//button[contains(text(),'Customers')]")).click();
		
		waitForElementPresent(driver, By.xpath("//table"), 10);
		
		col=driver.findElements(By.xpath("//table/thead/tr//td")).size();
		col--;
		row=driver.findElements(By.xpath("//table/tbody/tr")).size();
		
		//print table headers
		for(int i=1;i<=col;i++) {
			String loc="//table/thead/tr[1]/td["+i+"]";
			WebElement temp=driver.findElement(By.xpath(loc));
			System.out.print(temp.getText()+"\t");
		}
		System.out.println();
		
		//print table contents
		for(int i=1;i<=row;i++) {
			for(int j=1;j<=col;j++) {
				String loc="//table/tbody/tr["+i+"]/td["+j+"]";
				WebElement temp=driver.findElement(By.xpath(loc));
				System.out.print(temp.getText()+"\t");
			}
			System.out.println();
		}
		
		
	}
	
	public static void module1(WebDriver driver) throws InterruptedException {
		WebElement e;
		driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
		driver.manage().window().maximize();
		

		e=waitForElementPresent(driver, By.xpath("//button[text()='Customer Login']"), 10);
		e.click();
	
		e=waitForElementPresent(driver, By.cssSelector("select#userSelect"), 10);
		Select select=new Select(e);
		select.selectByVisibleText("Harry Potter");
		driver.findElement(By.cssSelector("button[type='submit']")).click();
		
		e=waitForElementPresent(driver, By.cssSelector("select#accountSelect"), 10);
		select=new Select(e);
		select.selectByVisibleText("1004");
		
		printDetails(driver);
		
		driver.findElement(By.xpath("//button[contains(text(),'Deposit')]")).click();
		e=waitForElementPresent(driver, By.xpath("//div/input"), 10);
		e.sendKeys("2000");
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		String success=driver.findElement(By.xpath("//span[contains(text(),'Successful')]")).getText();
		System.out.println("message displayed: "+success);
		
		printDetails(driver);
		
	}
	public static WebElement waitForElementPresent(WebDriver driver,By locator,int timeout) {
		WebDriverWait myWait=new WebDriverWait(driver,Duration.ofSeconds(timeout));
		WebElement element=myWait.until(ExpectedConditions.presenceOfElementLocated(locator));
		return element;
	}
	public static void printDetails(WebDriver driver) {
		System.out.println(driver.findElement(By.xpath("//div[@class='center'][1]")).getText()  );
	}
}
