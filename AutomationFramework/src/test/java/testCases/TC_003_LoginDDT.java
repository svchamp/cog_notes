package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_003_LoginDDT extends BaseClass {
	
	@Test(dataProvider= "LoginData",dataProviderClass=DataProviders.class)
	public void verify_loginDDT(String email,String pass,String exp) {
		logger.info("** Starting TC_003_LoginDDT **");
		try {
			HomePage hp=new HomePage(driver);
			hp.clickMyAccount();
			hp.clickLogin();
			
			LoginPage lp=new LoginPage(driver);
			logger.info("Entering valid email and password..");
			lp.setEmail(email);
			lp.setPassword(pass);
			lp.clickLogin();
			logger.info("Clicked on login button");
			
			MyAccountPage macc=new MyAccountPage(driver);
			boolean targetPage=macc.isMyAccountPageExists();
			if(exp.equals("Valid")) {
				if(targetPage=true) {
					macc.clickLogout();
					Assert.assertTrue(targetPage);
				}
				else {
					Assert.fail();
				}
			}
			else {
				if(targetPage==true) {
					Assert.fail();
				}
				else {
					Assert.assertTrue(true);
				}
			}
		}catch(Exception e) {
			Assert.fail();
		}
		
		logger.info("** Finished TC_003_LoginDDT **");
	}
}
















