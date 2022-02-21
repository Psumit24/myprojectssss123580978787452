package parameterations;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import configanddataprovider.BaseClass;

public class CrossBrowsingTest extends BaseClass {
	@Test
	public void verifyTestingShastrapage() {
		String value = System.getProperty("x");
		System.out.println("Value is>>" + value);
		System.out.println(driver.getTitle());
		
		assertEquals(driver.getTitle(), "Testing Shastra | Training | Placement");
	}
}
