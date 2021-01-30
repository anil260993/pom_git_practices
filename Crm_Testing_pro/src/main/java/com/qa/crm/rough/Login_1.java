package com.qa.crm.rough;

import org.openqa.selenium.WebDriver;

public class Login_1 {
public static WebDriver driver;
	public static void main(String[] args) {
		Login l=new Login();
	WebDriver a=	l.init_driver("chrome");
	//driver=	Login.getDriver();
a.get("https://www.toolsqa.com/selenium-webdriver/webdrivermanager/");
	}

}
