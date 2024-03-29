package pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage_WithoutPageFactory {
	
	WebDriver driver;
	//constructor
	LoginPage_WithoutPageFactory(WebDriver driver){
		this.driver=driver;
	}
	//locators
	By logo_img_loc=By.xpath("//img[@alt='company-branding']");
	By txt_username_loc=By.name("username");
	By txt_password_loc=By.cssSelector("input[placeholder='Password']");
	By btn_submit_loc=By.xpath("//button[normalize-space()='Login']");
	
	//action methods
	public void setUsername(String username) throws InterruptedException {
		driver.findElement(txt_username_loc).sendKeys(username);
		Thread.sleep(2000);
	}
	public void setPassword(String password) throws InterruptedException {
		driver.findElement(txt_password_loc).sendKeys(password);
		Thread.sleep(2000);
	}
	public void submit() {
		driver.findElement(btn_submit_loc).click();
	}
}
