package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleLogin extends BasePage {
	
	public GoogleLogin(WebDriver driver,WebDriverWait myWait) {
		super(driver,myWait);
	}
	
	@FindBy(xpath="//input[@type='email']")
	WebElement inputEmail;
	
	@FindBy(xpath="//span[text()='Next']")
	WebElement buttonNext;
	
	@FindBy(xpath="//div[contains(text(),'find your Google') or contains(text(),'Enter an email')]")
	WebElement invalidLogin;
	
	public void enterEmail(String email) {
		myWait.until(ExpectedConditions.visibilityOf(inputEmail));
		inputEmail.sendKeys(email);
	}
	
	public void buttonNext() {
		buttonNext.click();
	}
	
	public String getInvalidLoginMessage() {
		return invalidLogin.getText();
	}
}
