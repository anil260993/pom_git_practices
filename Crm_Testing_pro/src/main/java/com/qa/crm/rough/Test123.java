package com.qa.crm.rough;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.qa.crm.util.Utility;

public class Test123 {

	public static void main(String[] args) throws IOException {
	System.setProperty("webdriver.chrome.driver", "D:\\Testing\\software\\chromedriver.exe");
	WebDriver		driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Utility.page_load_timeout, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Utility.page_implicity_wait, TimeUnit.SECONDS);
		driver.get("https://in-gres.vassarlabs.com/dev/gecdataonline/misview;locname=INDIA;loctype=COUNTRY;locuuid=ffce954d-24e1-494b-ba7e-0931d8ad6085;component=recharge;period=annual;stateuuid=94360caf-ebf0-4303-8c9e-3509bb0cded2;category=all;year=2016-2017;view=admin;computationType=normal");
	  FileOutputStream fos =new FileOutputStream("C:\\Users\\Dyagala Anil Kumar\\Desktop\\ios\\efg.xlsx");
	 XSSFWorkbook workbook = new XSSFWorkbook();
     XSSFSheet sheet = workbook.createSheet("data");
List<WebElement> rowcount=driver.findElements(By.xpath("html/body/app-root/main/app-misview/div/div[2]/div[2]/div/table/tbody/tr"));
XSSFRow row1=sheet.createRow(0);
row1.createCell(1).setCellValue("Hilly Area");
row1.createCell(0).setCellValue("State name");
for(int i=1;i<=rowcount.size();i++){
	String state=driver.findElement(By.xpath("/html/body/app-root/main/app-misview/div/div[2]/div[2]/div/table/tbody/tr["+i+"]/td[2]")).getText();
	String hillytext=driver.findElement(By.xpath("/html/body/app-root/main/app-misview/div/div[2]/div[2]/div/table/tbody/tr["+i+"]/td[8]")).getText();
XSSFRow row=	sheet.createRow(i);
row.createCell(0).setCellValue(state);
//row.createCell(1).setCellValue(hillytext);

}


workbook.write(fos);
	
	driver.quit();
	
	}

}
