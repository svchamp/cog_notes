package testCases;

import java.util.Set;

import org.testng.annotations.Test;

import pageObjects.GoogleLogin;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_004_LoginTest extends BaseClass {

	@Test
	public void verifyLogin() throws InterruptedException {
		logger.info("** Starting TC_004_LoginTest **");
		System.out.println("** Starting TC_004_LoginTest **");
		
		HomePage hp=new HomePage(driver);
		String parent=driver.getWindowHandle();
		
		System.out.println("Clicking on login button");
		logger.info("Clicking on login button");
		hp.clickButtonLogin();
		
		logger.info("Clicking on Google-login button ");
		System.out.println("Clicking on Google-login button ");
		hp.clickGoogleLoginButton();
		
		logger.info("Switching the tab");
		System.out.println("Switching the tab");
		Set<String> handles=driver.getWindowHandles();
		for(String s:handles) {
			if(!s.equals(parent)){
				driver.switchTo().window(s);
				break;
			}
		}
		Thread.sleep(4000);
		
		GoogleLogin gl=new GoogleLogin(driver,myWait);
		
		System.out.println("Entering blank email");
		logger.info("Entering blank email");
		gl.enterEmail("");
		
		logger.info("Clicking on next button");
		System.out.println("Clicking on next button");
		gl.buttonNext();
		try {
			String invalidLoginMessage=gl.getInvalidLoginMessage();
			logger.info("Invalid login message found");
			//Printing invalid login message
			System.out.println("Login message: "+invalidLoginMessage);
		}catch(Exception e) {
			System.out.println("Invalid login message not found");
		}
		
		
		System.out.println("** Finished TC_004_LoginTest **");
		logger.info("** Finished TC_004_LoginTest **");
	}
}

