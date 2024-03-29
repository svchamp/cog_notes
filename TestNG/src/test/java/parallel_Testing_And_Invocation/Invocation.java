package parallel_Testing_And_Invocation;

import org.testng.annotations.Test;

public class Invocation {
	@Test(invocationCount=10)
	void fun() {
		System.out.println("invo");
	}
}
