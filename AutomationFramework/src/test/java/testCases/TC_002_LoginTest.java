package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass {
	
	@Test(groups= {"sanity","master"})
	public void verify_login() {
		try {
		logger.info("** Starting TC_002_LoginTest **");
		logger.debug("capturing debug logs....");
		
		//Home page
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		logger.info("Clicked on MyAccount link");
		hp.clickLogin();
		logger.info("Clicked Login link");
		
		//login page
		LoginPage lp=new LoginPage(driver);
		logger.info("Entering valid email and password");
		lp.setEmail(p.getProperty("email"));
		lp.setPassword(p.getProperty("password"));
		lp.clickLogin();
		logger.info("Clicked on Login Button");
		
		//MyAccount page
		MyAccountPage macc=new MyAccountPage(driver);
		
		boolean targetPage=macc.isMyAccountPageExists();
		if(targetPage==true) {
			logger.info("Login test passed...");
			Assert.assertTrue(targetPage);
		}
		else {
			logger.error("Login test failed...");
			Assert.fail();
		}
		}catch(Exception e) {
			Assert.fail();
		}
		logger.info("** Finished TC_002_LoginTest **");
		
		
		
		
		
		
		
		
		
		
		
	}
}
