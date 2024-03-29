package dataProvidersAndGrouping;

import org.testng.annotations.*;

public class Grouping {

	@Test(priority=1,groups= {"sanity","regression"})
	void loginbyemail(){
		
	}
	@Test(priority=2,groups= {"sanity"})
	void loginbyfacebook(){
		
	}
	@Test(priority=3,groups= {"sanity"})
	void loginbytwitter() {
		
	}
	
	@Test(priority=4,groups= {"sanity","regression"})
	void signupbyemail() {
		
	}
	
	@Test(priority=5,groups= {"regression"})
	void signupbyfacebook() {
		
	}
	@Test(priority=6,groups= {"regression"})
	void signupbytwitter() {
		
	}
	
	@Test(priority=7,groups= {"sanity"})
	void payinrupees() {
		
	}
	@Test(priority=8,groups= {"sanity","regression"})
	void payindollar() {
		
	}
	@Test(priority=9,groups= {"sanity","regression"})
	void payineuro() {
		
	}
	
}
