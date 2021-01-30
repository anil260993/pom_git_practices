package com.qa.crm.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.crm.base.TestBase;
import com.qa.crm.util.Utility;



public class Loginpage extends TestBase {

	public Loginpage() throws IOException {
		PageFactory.initElements(driver,this);
		
	}
	//OR
	/*@FindBy(name="/html/body/div[2]/div/div[1]/a/img")
	WebElement logo;*/
	@FindBy(xpath="//a[contains(text(),'Sign')]")
	WebElement Signup_button;
	@FindBy(xpath="//a[contains(text(),'Pricing')]")
	WebElement Pricing_button;

	@FindBy(xpath="//a[contains(text(),'Features')]")
	WebElement Features_button;
	@FindBy(xpath="//a[contains(text(),'Customers')]")
	WebElement Customers_button;
	@FindBy(xpath="//a[contains(text(),'Contact')]")
	WebElement Contact_button;
	
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement Login_btn;
	
	@FindBy(xpath="//a[contains(text(),'Sign Up')]")
	WebElement signUp_btn;
	
	
	
	//Methods
	
	
	

public String loginPageUrlValidation(){
	return driver.getCurrentUrl();
}
	
	public String loginPageTitleValidation(){
		return driver.getTitle();
	}
	
	public Homepage validatingLoginPage(String un,String pwd) throws IOException{
		username.sendKeys(un);
		password.sendKeys(pwd);
		Login_btn.click();
	return	new Homepage();
		
	}
	
	public SignupPage signupPage(){
		WebDriverWait wait=new WebDriverWait(driver,5);
		wait.until(ExpectedConditions.visibilityOf(signUp_btn));
		System.out.println("clicked on signin button");
		signUp_btn.click();
	System.out.println("title of tab::"+driver.getTitle());
	return new SignupPage();
		
	}
}
