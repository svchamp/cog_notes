package pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage_WithPageFactory {
	WebDriver driver;
	//constructor
	LoginPage_WithPageFactory(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	//WebElemenmts-> locators + identification
	//2 ways to do this:-
	@FindBy(xpath="//img[@alt='company-branding']") WebElement img_logo;
	
	@FindBy(name="username") 
	WebElement txt_username;
	
	@FindBy(css="input[placeholder='Password']") WebElement txt_password;
	@FindBy(xpath="//button[normalize-space()='Login']") WebElement btn_submit;
	
	
	//action methods
	public void setUsername(String username) throws InterruptedException {
		txt_username.sendKeys(username);
		Thread.sleep(2000);
	}
	public void setPassword(String password) throws InterruptedException {
		txt_password.sendKeys(password);
		Thread.sleep(2000);
	}
	public void submit() {
		btn_submit.click();
	}
}
