package annotations;

import org.testng.Assert;
import org.testng.annotations.*;

public class Dependency {
	
	@Test
	void openApp() {
		System.out.println("openApp");
	}
	
	@Test(priority=1,dependsOnMethods = {"openApp"})
	void login() {
		System.out.println("logout");
		
	}
	
	@Test(priority=2,dependsOnMethods = {"login"})
	void search() {
		System.out.println("search");
		Assert.assertTrue(false);
	}
	
	@Test(priority=3,dependsOnMethods = {"search"})
	void advancedSearch() {
		System.out.println("advancedSearch");
		Assert.assertTrue(true);
	}
	
	@Test(priority=4,dependsOnMethods = {"login"})
	void logout() {
		System.out.println("logout");
	}
	
	
	
	
}
