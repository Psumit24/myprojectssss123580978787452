package com.dataproviderdemo;

import org.testng.annotations.DataProvider;

import configanddataprovider.DataProvideExcel;

public class DataProviders {
	@DataProvider(name = "String Data")
	public Object[][] dataaProvider1() {
		DataProvideExcel excel = new DataProvideExcel();
		Object obj[][] = excel.readExcelAndLoadIntoArray("D:\\Jsumit\\MyProject12\\Excel Sheet\\NumberData1.xlsx");
		return obj;
	}

	@DataProvider(name = "Number Data")
	public Object[][] dataProvider() {
		Object obj[][] = { { 12, 14 }, { 10, 20 }, { 30, 40 }, { 50, 60 } };
		return obj;
	}

	@DataProvider(name = "Login Data")
	public void loginData() {
		

	}

	@DataProvider(name = "Register Data")
	public Object[][] registerData() {
		DataProvideExcel excel = new DataProvideExcel();
		Object obj[][] = excel.readExcelAndLoadIntoArray("D:\\Jsumit\\MyProject12\\Excel Sheet\\NumberData1.xlsx");
		return obj;

	}
}
