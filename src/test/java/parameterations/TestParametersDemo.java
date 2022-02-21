package parameterations;

import org.testng.Assert;
import org.testng.annotations.Test;

@Test(singleThreaded = true)
public class TestParametersDemo {
	int count = 1;

	@Test(enabled = false)//test case ignore
	public void m1() {
		System.out.println("I am Disabled>>>");
	}

	@Test
	public void m2() {
		System.out.println("I am Enabled>>>>");
	}

	@Test(priority = -1)
	public void m3() {
		System.out.println("I am Enabled33>>>>");
	}

	@Test(invocationCount = 2)//invocation count=0 test case ignore
	public void m4() {
		System.out.println("<<<<<<<<<m4>>>>>>>>");
	}

	@Test(invocationTimeOut = 10000, invocationCount = 3)
	public void m5() throws InterruptedException {
		System.out.println("<<<m5>>>>");
		Thread.sleep(1000);
	}

	@Test(timeOut = 3000, invocationCount = 3)
	public void m6() throws InterruptedException {
		System.out.println("<<<m6>>>>");
		Thread.sleep(1000);
	}

	@Test(successPercentage = 30, invocationCount = 5)
	public void m7() {
		if (count % 2 == 0) {
			System.out.println("SuccessPercentage" + count);
		} else {
			count++;
			System.out.println("<<<SuccessPercentage m7>>>>" + count);
			Assert.assertTrue(false);
		}

	}
}
