package extentReport;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(extentReport.ExtentReportManager.class)
public class ListenerWithoutXML {
	@Test(priority = 1)
	void test1() {
		Assert.assertEquals(1, 1);
	}
	
	@Test(priority = 2)
	void test2() {
		Assert.assertEquals(1, 2);
	}
	
	@Test(priority=3, dependsOnMethods = {"test2"})
	void test3() {
		//it is skipped
	}
}
