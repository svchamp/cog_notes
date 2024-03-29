package trainerSessions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
//		WebDriverWait myWait=new WebDriverWait(driver, Duration.ofSeconds(10));
		Task01 obj=new Task01();
		
		obj.Module1(driver);
		obj.Module2(driver);
		
		
	}
	void Module2(WebDriver driver) {
		
		driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']")).click();
		driver.findElement(By.xpath("//button[contains(@id,'bike-light')]")).click();
	}
	void Module1(WebDriver driver) {
		
		String url="https://www.saucedemo.com/";
		String username="standard_user",pass="secret_sauce";
		
		driver.get(url);
		
		
		driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(pass);
		driver.findElement(By.xpath("//input[@id='login-button']")).click();
		//user logged in
		
		driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']")).click();
		driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
		
		//cart page remove product
		driver.findElement(By.xpath("//button[@id='remove-sauce-labs-backpack']")).click();
		//back to home page
		driver.findElement(By.xpath("//button[@id='continue-shopping']")).click();
		
		//select another product
		driver.findElement(By.xpath("//button[contains(@id,'bike-light')]")).click();
		driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
		
		//checkout button
		driver.findElement(By.xpath("//button[@id='checkout']")).click();
		
		//input the values
		driver.findElement(By.xpath("//input[@id='first-name']")).sendKeys("Shrinivas");
		driver.findElement(By.xpath("//input[@id='last-name']")).sendKeys("Verma");
		driver.findElement(By.xpath("//input[@id='postal-code']")).sendKeys("411057");
		//continue
		driver.findElement(By.xpath("//input[@id='continue']")).click();
		
		//finish
		driver.findElement(By.xpath("//button[@id='finish']")).click();
		
		String text=driver.findElement(By.xpath("//h2[contains(text(),'order')]")).getText();
		System.out.println(text);
		
		//back to home page
		driver.findElement(By.xpath("//button[@id='back-to-products']")).click();
	}

}
