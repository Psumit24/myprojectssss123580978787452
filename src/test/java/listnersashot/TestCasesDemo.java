package listnersashot;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(ITestListenerInterface.class)
public class TestCasesDemo extends BaseClass {
	@Test
public void m1() {
System.out.println("<<M1>>");
}
	@Test
	public void m2() {
	System.out.println("<<M2>>");
	throw new AssertionError();
	}
	@Test
	public void m3() {
	System.out.println("<<M3>>");
	}
	@Test
	public void m4() {
	System.out.println("<<M4>>");
	}
}
