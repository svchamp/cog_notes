package annotations;

import org.testng.annotations.*;

public class BeforeAfterClass {
	@BeforeClass
	void login() {
		System.out.println("login");
	}
	
	@AfterClass
	void logout() {
		System.out.println("logout");
	}
	
	@Test(priority=1)
	void search() {
		System.out.println("search");
	}
	
	@Test(priority=2)
	void advancedSearch() {
		System.out.println("advanced search");
	}
}
