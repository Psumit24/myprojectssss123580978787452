package parameterations;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SuccessPer1 {
int count=0;
@Test(successPercentage = 50,invocationCount = 5)
public void m11() {
count++;
System.out.println("Verifying count:"+count);
Assert.assertTrue(count%2==0);
}

}
