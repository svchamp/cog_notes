package trainerSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.testng.annotations.Test; 

public class JavaScriptExecutor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Login();
		System.out.println("not working");
	}
  public static void Login()
  {
	  	WebDriver driver= new ChromeDriver();
 
	    //Creating the JavascriptExecutor interface object by Type casting
	    JavascriptExecutor js = (JavascriptExecutor)driver;
	    
	    //Launching the Site.    
	    driver.get("https://demo.guru99.com/V4/");
	    
	    WebElement button =driver.findElement(By.name("btnLogin"));
	    
	    //Login to Guru99     
	    driver.findElement(By.name("uid")).sendKeys("mngr34926");
	    driver.findElement(By.name("password")).sendKeys("amUpenu");
	    
	    //Perform Click on LOGIN button using JavascriptExecutor    
	    js.executeScript("arguments[0].click();", button);
	                            
	    //To generate Alert window using JavascriptExecutor. Display the alert message       
	    js.executeScript("alert('Welcome to Guru99');");
  

  }
}


  
  
  
  
  
  
  