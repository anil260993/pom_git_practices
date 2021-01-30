package com.qa.crm.rough;

import java.util.Iterator;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Logger_test {

	public static void main(String[] args) throws InterruptedException {
		//Logger log=LogManager.getLogger(Logger_test.class.getName());
		System.setProperty("webdriver.chrome.driver", "D:\\Testing\\software\\chromedriver.exe");
		WebDriver	driver=new ChromeDriver();
		//log.debug("lauching browser");
		//log.info("text");
		 driver.manage().window().maximize();
		driver.get("https://demoqa.com/browser-windows");
		//log.debug("opening url	");
		driver.findElement(By.id("tabButton")).click();
		driver.findElement(By.id("windowButton")).click();
		driver.findElement(By.id("messageWindowButton")).click();
		//log.error("test is faling");
		driver.quit();
		
		/*String Mainwindow=driver.getWindowHandle();
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
		}*/

	}

}
