package parameterations;

import org.testng.annotations.Test;


public class Groupss1 {
	@Test(groups = "Regression")
public void m1() {
System.out.println("<<M1>>");
throw new ArithmeticException();
}
	@Test(alwaysRun = false,dependsOnMethods = {"m1","m3"})
	//alwaysRun=true is soft dependency
	public void m2() {
	System.out.println("<<M2>>");
	}
	@Test(groups = "Regression")
	public void m3() {
	System.out.println("<<M3>>");
	}
	@Test(groups = "Smoke")
	public void m4() {
	System.out.println("<<M4>>");
	}
	@Test(groups = "Regression")
	public void m5() {
	System.out.println("<<M5>>");
	}
	@Test(groups = "Smoke")
	public void m6() {
	System.out.println("<<M6>>");
	}
}
