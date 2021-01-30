package com.qa.crm.rough;

import java.util.Iterator;
import java.util.Set;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import com.qa.crm.util.Utility;

import jdk.nashorn.internal.runtime.regexp.joni.constants.Arguments;

public class Sample {
	
	@DataProvider
	public Object[][] getCRMTestData() throws InvalidFormatException{
		Object data[][] = Utility.getTestData("Login");
		return data;
	}
	@Test(dataProvider="getCRMTestData")
	public static void m1(String username,String pwd) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\Testing\\software\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://classic.crmpro.com");
		driver.findElement(By.name("username")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(pwd);
		Thread.sleep(5000);
		driver.quit();
		System.out.println("login page username::"+username+"  password::"+pwd);

	}
	
	
	
	@DataProvider
	public Object[][] getlogin() throws InvalidFormatException{
		Object data[][] = Utility.getTestData("Signup");
		return data;
	}
	@Test(dataProvider="getlogin")
	public static void m2(String username,String pwd) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\Testing\\software\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://classic.crmpro.com");
		driver.findElement(By.name("username")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(pwd);
		Thread.sleep(5000);
		driver.quit();
		System.out.println("signup page username::"+username+"  password::"+pwd);

	}
}