package assertdemo;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftlyAssert {
	@Test
public void m1() {
SoftAssert softly = new SoftAssert();
softly.assertEquals(10, 12);
//softly.assertTrue(10%2==0);
softly.assertEquals("Hi", "Hi");
softly.assertEquals("Hi", "Hello");
softly.assertAll();
}
}
