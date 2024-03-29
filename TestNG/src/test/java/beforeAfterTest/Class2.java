package beforeAfterTest;

import org.testng.annotations.*;

public class Class2 {
	@Test
	void xyz() {
		System.out.println("xyz from class2");
	}
	
	@BeforeTest
	void before() {
		System.out.println("BeforeTest in class2");
	}
	
	@AfterSuite
	void as() {
		System.out.println("AfterSuite in class2");
	}
}
