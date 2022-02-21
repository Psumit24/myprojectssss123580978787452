package configanddataprovider;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
//import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataProvideExcel {
	public Object[][] readExcelAndLoadIntoArray(String fileName) {
		Object[][] obj = null;
		try {
			// FileInputStream fis = new FileInputStream("D:\\Jsumit\\MyProject12\\Excel
			// Sheet\\NumberData1.xlsx");//hard coded
			FileInputStream fis = new FileInputStream(fileName);
			XSSFWorkbook book = new XSSFWorkbook(fis);
			//XSSFSheet sheet = book.getSheet("NumberData");
			 XSSFSheet sheet = book.getSheet("StringData");
			int lastRow = sheet.getLastRowNum();

			obj = new Object[lastRow][sheet.getRow(0).getLastCellNum() - 1];

			for (int i = 1; i <= lastRow; i++) {
				Row row = sheet.getRow(i);
				for (int j = 1; j < row.getLastCellNum(); j++) {
					Cell cell = row.getCell(j);
					switch (cell.getCellType()) {
					case Cell.CELL_TYPE_NUMERIC:
						obj[i - 1][j - 1] = cell.getNumericCellValue();
						break;
					case Cell.CELL_TYPE_STRING:
						obj[i - 1][j - 1] = cell.getStringCellValue();
						break;
					case Cell.CELL_TYPE_BOOLEAN:
						obj[i - 1][j - 1] = cell.getBooleanCellValue();
						break;
					case Cell.CELL_TYPE_BLANK:
						obj[i - 1][j - 1] = cell.getErrorCellValue();
						break;
					}

					// System.out.print(cell.getNumericCellValue()+"\t");
				}
				// System.out.println();
			}
			// Row row = sheet.getRow(1);
			// Cell cell = row.getCell(1);00
			// cell.getNumericCellValue();
			// System.out.println(cell.getNumericCellValue());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return obj;
	}

	public static void main(String[] args) {
		new DataProvideExcel().readExcelAndLoadIntoArray("D:\\Jsumit\\MyProject12\\Excel Sheet\\NumberData1.xlsx");
	}
}
