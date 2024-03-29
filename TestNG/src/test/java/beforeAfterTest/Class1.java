package beforeAfterTest;

import org.testng.annotations.*;

public class Class1 {

	@Test
	void abc() {
		System.out.println("abc from class1");
	}
	
	@AfterTest
	void after() {
		System.out.println("AfterTest in class1");
	}
	
	@BeforeSuite
	void bs() {
		System.out.println("BefreSuite in class 1");
	}
}
