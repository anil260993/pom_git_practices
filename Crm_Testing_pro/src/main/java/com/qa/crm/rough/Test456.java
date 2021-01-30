package com.qa.crm.rough;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Test456 {

	public static void main(String[] args) throws IOException {
		try{
		String path="C:\\Users\\Dyagala Anil Kumar\\Desktop\\ios\\efg.xlsx";
		FileInputStream file = new FileInputStream(new File(path)); 
		  XSSFWorkbook workbook = new XSSFWorkbook(file);

		  XSSFSheet sheet = workbook.getSheetAt(0);
		  int rowcount=sheet.getLastRowNum();
		  for(int i=1;i<rowcount;i++){
		  Cell searchText3 = sheet.getRow(i).getCell(1);
		  searchText3.setCellValue("abc");
		  }

		  file.close();

		  FileOutputStream outFile =new FileOutputStream(new File(path));
		  workbook.write(outFile);
		  outFile.close();

		 } catch (FileNotFoundException fnfe) {
		  fnfe.printStackTrace();
		 } catch (IOException ioe) {
		  ioe.printStackTrace();
		 }
		 }
}