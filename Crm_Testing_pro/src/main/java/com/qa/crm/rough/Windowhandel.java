package com.qa.crm.rough;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Windowhandel {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\Testing\\software\\chromedriver.exe");
	WebDriver	driver=new ChromeDriver();
	 driver.manage().window().maximize();
	driver.get("https://demoqa.com/browser-windows");
	driver.findElement(By.id("tabButton")).click();
	driver.findElement(By.id("windowButton")).click();
	driver.findElement(By.id("messageWindowButton")).click();
	
	String Mainwindow=driver.getWindowHandle();
	Set<String> childwindow=driver.getWindowHandles();
	Iterator<String> itr=childwindow.iterator();
	while(itr.hasNext()){
		String chi=itr.next();
		if(!Mainwindow.equalsIgnoreCase(chi)){
			Thread.sleep(5000);
			WebElement text=   driver.findElement(By.cssSelector("#sampleHeading"));
			System.out.println(text.getText());
		}
		System.out.println(driver.switchTo().window(Mainwindow).getTitle());
	}
	
	 // Opening all the child window
	//Thread.sleep(5000);
   
    }
    
    
	}


