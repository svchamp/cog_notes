package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass {

	//Start all function names with either verify or test
	@Test(groups= {"regression","master"})
	public void verify_account_registration() {
		
//		adding text to logs
		logger.info("*** starting TC_01_AccountRegistrationTest ***");
		
		try {
		HomePage home=new HomePage(driver);
		logger.info("Clicked on MyAccount link");
		home.clickMyAccount();
		logger.info("Clicked on registration link");
		home.clickRegister();
		
		logger.info("Entering customer details");
		AccountRegistrationPage regPage=new AccountRegistrationPage(driver);
		
		regPage.setFirstName(randomString().toUpperCase());
		regPage.setLastName(randomString().toUpperCase());
		regPage.setEmail(randomString()+"@gmail.com");
		regPage.setTelephone(randomNumber());
		
		String pass=randomAlphaNumeric();
		regPage.setPassword(pass);
		regPage.setConfirmPassword(pass);
		
		regPage.setPrivacyPolicy();
		regPage.clickContinue();
		logger.info("Clicked on continue..");
		
		String confMsg=regPage.getConfirmationMsg();
		logger.info("Validating expected message");
		Assert.assertEquals(confMsg,"Your Account Has Been Created!");
		}catch(Exception e) {
			logger.error("test failed");
			Assert.fail();
		}
		logger.info("*** Finished TC_01_AccountRegistrationTest ***");
		
	}
	
	
}


















