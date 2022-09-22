package com.dsalgo.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.dsalgo.testcases.Baseclass;
import com.dsalgo.testcases.ReadConfig;

//import com.dsalgo.config.Baseclass;
//import com.dsalgo.config.ReadConfig;

public class LoginPageobject extends Baseclass {
	WebDriver ldriver;
	public ReadConfig loginobj= new ReadConfig();

	public LoginPageobject(WebDriver rdriver) {
		 ldriver=rdriver;
		 PageFactory.initElements(rdriver,this);
	}
	@FindBy(xpath="//a[text()=' Register ']")
	WebElement register;
	@FindBy (xpath="//a[text()='Sign in']")WebElement signIn;
	@FindBy (xpath="//input[@name='username']")WebElement usern;
	@FindBy (xpath="//input[@name='password']")WebElement pasword;
	@FindBy (xpath="//input[@value='Login']")WebElement login;
	@FindBy (xpath="//a[text()='Sign out']")WebElement logout;

	public void SignIn() {
		signIn.click();
	}
	
    public void loginpagedata(String un, String pwd) {
			// TODO Auto-generated method stub
    	usern.sendKeys(un);
    	usern.sendKeys(pwd);
    }
    
	public void validatelogin() {
		login.click();
	}
	
	public void validatelogout() {
		logout.click();
	}
	
	public  String verifyLoginpageTitle() {
		String title=ldriver.getTitle();
		return title;
	}
}



