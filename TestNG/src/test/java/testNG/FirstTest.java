package testNG;

import org.testng.annotations.Test;

public class FirstTest {
  @Test
  public void test1() {
	  System.out.println("test1");
  }
  @Test
  public void test2() {
	  System.out.println("test2");
  }
  //Normal java method isnt executed as there is no main method
  public void test3() {
	  System.out.println("test3");
  }
}
