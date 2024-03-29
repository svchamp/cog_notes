package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class MyListener implements ITestListener {
	
	public void onStart(ITestContext context){
		System.out.println("onStart");
	}
	public void onFinish(ITestContext context) {
		System.out.println("onFinish");
	}
	
	public void onTestFailure(ITestResult result) {
		System.out.println("onTestFailure");
	}
	public void onTestStart(ITestResult result) {
		System.out.println("onTestStart");
	}
	public void onTestSkipped(ITestResult result) {
		System.out.println("onTestSkipped");
	}
	public void onTestSuccess(ITestResult result) {
		System.out.println("onTestSuccess");
	}
	
	
}

//public class MyListener extends TestListenerAdapter {
//	
//	
//}
