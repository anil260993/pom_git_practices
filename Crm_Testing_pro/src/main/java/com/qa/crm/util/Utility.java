package com.qa.crm.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;

import com.qa.crm.base.TestBase;

public class Utility extends TestBase {
	public Utility() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	public static long page_load_timeout=50;
	public static long page_implicity_wait=15;
	
	
	public static void moveInToFrame(){
		driver.switchTo().frame("mainpanel");
		
	}
	
	public static void moveOutOfFrame(){
		driver.switchTo().defaultContent();
		
	}
	
	public static String TESTDATA_SHEET_PATH = "C:\\Users\\Dyagala Anil Kumar\\Desktop\\ios\\TestData.xlsx";

	static Workbook book;
	static Sheet sheet;
	static JavascriptExecutor js;



	public static Object[][] getTestData(String sheetName) throws InvalidFormatException {
		FileInputStream file = null;
		try {
			file = new FileInputStream(TESTDATA_SHEET_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		// System.out.println(sheet.getLastRowNum() + "--------" +
		// sheet.getRow(0).getLastCellNum());
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
				// System.out.println(data[i][k]);
			}
		}
		return data;
	}
	
	

}
