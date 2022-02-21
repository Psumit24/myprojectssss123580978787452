package com.dataproviderdemo;

import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class FirstDataProvider {
	@Test( dataProvider = "Number Data", dataProviderClass = DataProviders.class)
	public void tc_1(int x, int y) {
		System.out.println(x + "\t" + y);
	}
	@Ignore
	@Test(dataProvider = "Number Data1", dataProviderClass = DataProviders.class)
	public void tc_2(double x, double y) {

		double result = (x + y);
		Assert.assertTrue(result % 2 == 0, "Result is not Even:>>" + result);
	}
	@Test(dataProvider = "String Data", dataProviderClass = DataProviders.class)
	public void tc_3(String s, String y) {
		
	String result=s.concat( y);
		System.out.println(result);
	}
}
