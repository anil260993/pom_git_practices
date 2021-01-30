package com.qa.crm.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.crm.base.TestBase;



public class Homepage extends TestBase{
	
	
	
	public Homepage() throws IOException {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//td[contains(text(),'Demo')]")
	WebElement  usernamelabel;

	public boolean userLabelValidation(){
		System.out.println("merge issue in homepage class local_12435");
		return usernamelabel.isDisplayed();
		
		
	}
	public String homepageUrlValidation(){
		return driver.getCurrentUrl();
	}
	
}
