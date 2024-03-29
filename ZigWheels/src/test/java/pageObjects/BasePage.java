package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	WebDriver driver;
	WebDriverWait myWait;
	
	public BasePage(WebDriver driver,WebDriverWait myWait) {
		this.driver=driver;
		this.myWait=myWait;
		PageFactory.initElements(driver,this);
	}
	
	public BasePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
}
