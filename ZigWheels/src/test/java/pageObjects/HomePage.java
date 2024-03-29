package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
//	WebDriver driver;

	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//a[text()='New Bikes']") 
	WebElement dropdownNewBikes;
	
	@FindBy(xpath="//span[text()='Upcoming Bikes']")
	WebElement upComingBikes;
	
	@FindBy(xpath="//a[text()='Used Cars']")
	WebElement dropdownUsedCars;
	
	@FindBy(xpath="//span[text()='Chennai']")
	WebElement usedCars_Chennai;
	
	@FindBy(xpath="//div[@id='forum_login_wrap_lg']")
	WebElement buttonLogin;
	
	@FindBy(xpath="//span[text()='Google']/parent::*")
	WebElement googleLoginButton;
	
	
	public void clickUpcomingBikes() {
		Actions act=new Actions(driver);
		act.moveToElement(dropdownNewBikes).perform();
		upComingBikes.click();
	}
	
	public void clickUsedCars_Chennai() {
		
		Actions act=new Actions(driver);
		act.moveToElement(dropdownUsedCars).perform();
		usedCars_Chennai.click();
	}
	
	public void clickButtonLogin() {
		buttonLogin.click();
	}
	
	public void clickGoogleLoginButton() {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()",googleLoginButton);
	}
}






