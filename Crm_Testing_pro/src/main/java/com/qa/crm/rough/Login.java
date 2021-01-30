package com.qa.crm.rough;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Login {

	
		
		
		// public static WebDriver driver;
		
		public static ThreadLocal<WebDriver> tldriver=new ThreadLocal();
		 public WebDriver init_driver(String browser){
			 System.out.println("browser ::"+browser);
			 if(browser.equals("chrome")){
				 WebDriverManager.chromedriver().setup();
				 tldriver.set(new ChromeDriver());
			 }
			 else if(browser.equals("ff")){
				 WebDriverManager.firefoxdriver().setup();
				 tldriver.set(new FirefoxDriver());
			 }
			 getDriver().manage().deleteAllCookies();
			 getDriver().manage().window().maximize();
			 return getDriver();
		 }
		
		public static synchronized WebDriver getDriver(){
			return tldriver.get();
		}

	}


