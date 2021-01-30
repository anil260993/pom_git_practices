package com.qa.crm.rough;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelTest {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		String path="C:\\Users\\Dyagala Anil Kumar\\Desktop\\ios\\efg.xlsx";
		
		XSSFWorkbook workbook=new XSSFWorkbook( new FileInputStream(path));
		XSSFSheet sheet=workbook.getSheetAt(0);
	int rowcount=sheet.getLastRowNum();
	//int coulmcount=sheet.getRow(1).getLastCellNum();
		for(int i=1;i<=rowcount;i++){
			if(i%2==0){
				sheet.getRow(i).createCell(1).setCellValue("Even");
			}
			else{
				sheet.getRow(i).createCell(1).setCellValue("odd");
			}
		}
		FileOutputStream fos=new FileOutputStream(path);
		workbook.write(fos);
		

	}

}
