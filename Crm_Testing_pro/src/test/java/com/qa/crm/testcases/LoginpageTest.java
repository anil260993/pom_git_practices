package com.qa.crm.testcases;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.crm.base.TestBase;
import com.qa.crm.pages.Homepage;
import com.qa.crm.pages.Loginpage;
import com.qa.crm.pages.SignupPage;

public class LoginpageTest extends TestBase {
	Loginpage loginpage;
	Homepage homepage;
	SignupPage signuppage;
	SoftAssert softassert;
	private static  Logger log;
	
	
	public LoginpageTest() throws IOException{
		super();
		log=LogManager.getLogger(Loginpage.class.getClass());
	}
	@BeforeTest
public void setUp() throws IOException{
	intialize();
	loginpage=new Loginpage();
	 softassert=new SoftAssert();
	
	
}

//@Test(priority=1)
public void loginPageUrlTest(){
	String url=loginpage.loginPageUrlValidation();
	softassert.assertEquals(url, "https://classic.crmpro.com/","login page url is not matching ");
	log.info(url+"loginpage url is matching ");

}

//@Test(priority=2)
public void loginPageTitleTest(){
	String LoginpageTitle=loginpage.loginPageTitleValidation();
	softassert.assertEquals(LoginpageTitle, "CRMPRO - CRM software for customer relationship management, sales, and support.","login page title is not matching ");
	log.info(LoginpageTitle+"::loginpage title is matching ");
}

//@Test(priority=3)
public void loginFunctionalityTest() throws IOException{
	homepage=loginpage.validatingLoginPage(prop.getProperty("username"),prop.getProperty("password"));
	log.info("login functionality completed");
	
}
	@Test(priority=4)
	public void signuppageTest(){
	signuppage=	loginpage.signupPage();
	log.info("signup functionality completed");
		
	}
	
	
	

 


@AfterTest
public void tearDown() throws InterruptedException{
	softassert.assertAll();
	if(driver!=null){
		driver.quit();
	}
}
}
