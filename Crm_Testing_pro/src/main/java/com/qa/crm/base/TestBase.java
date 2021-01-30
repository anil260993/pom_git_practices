package com.qa.crm.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.qa.crm.util.Utility;



public class TestBase {
	public static Properties prop;
	public static WebDriver driver;
	private static  Logger log;
	
	public TestBase() throws IOException{
		FileInputStream fis=new FileInputStream("D:\\eclipse_automation_workspace\\Crm_Testing_pro\\src\\main\\java\\com\\qa\\crm\\util\\config.properties");
		prop=new Properties();
		prop.load(fis);
		log=LogManager.getLogger(TestBase.class.getName());
		
		
	}
	public static void intialize(){
		String browser_name=prop.getProperty("browser");
		if(browser_name.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", "D:\\Testing\\software\\chromedriver.exe");
			driver=new ChromeDriver();
			log.info("chrome bowser is launched");
			
		}
		else if(browser_name.equals("ff")){
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\Dyagala Anil Kumar\\Desktop\\ios\\geckodriver.exe");
			driver=new FirefoxDriver();
			log.info("firefox bowser is launched");
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Utility.page_load_timeout, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Utility.page_implicity_wait, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		log.info(prop.getProperty("url")+" ::url is opened");
		
		
	}


}
