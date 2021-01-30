package com.qa.crm.rough;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excels {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		String file="C:\\Users\\Dyagala Anil Kumar\\Desktop\\ios\\efg.xlsx";
		XSSFWorkbook myExcelBook = new XSSFWorkbook(new FileInputStream(file));
		FileOutputStream fos=new FileOutputStream(file);
	Sheet	sheet=myExcelBook.getSheetAt(0);
	int  row=sheet.getLastRowNum();
	for(int i=1;i<=row;i++){
		String text=sheet.getRow(i).getCell(0).getStringCellValue();
		 sheet.getRow(i).createCell(1).setCellValue(i);
		
		System.out.println(text);
		
	}
	myExcelBook.write(fos);
		

	}

}
