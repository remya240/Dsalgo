package com.dsalgo.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class RegisterPageobject {
	WebDriver ldriver; 
	@FindBy (name="username")
	WebElement username;
	@FindBy (name="password1")
	WebElement password1;
	@FindBy (name="password2")
	WebElement password2;
	@FindBy (xpath="//input[@value='Register']")
	WebElement registerbutton;
	@FindBy (xpath="//a[text()='Login ']")
	WebElement loginlink;
	
	public  RegisterPageobject(WebDriver rdriver) {
		 PageFactory.initElements(rdriver,this);
	}
		

	public String validateRegisterpageTitle() {
		return ldriver.getTitle();
	}
	
	public void validateLoginlink() {
		loginlink.click();
	}
	
	public void validateregisterbutton() {
		registerbutton.click();
	}

	public void registerpagedata(String un, String pwd1,String pwd2) {
		// TODO Auto-generated method stub
		username.sendKeys(un);
		password1.sendKeys(pwd1);
		password2.sendKeys(pwd2);
	}
			
}




		
	
	


