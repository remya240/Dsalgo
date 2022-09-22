package com.dsalgo.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePageobject {
	WebDriver ldriver;
	@FindBy (className="dropdown-toggle")
	WebElement dsDropdown;
	@FindBy(xpath="//a[text()=' Register ']")
	WebElement register;
	@FindBy (xpath="//a[text()='Sign in']")
	WebElement Login;
	
	
    public HomePageobject(WebDriver rdriver) {
		 ldriver=rdriver;
			
			PageFactory.initElements(rdriver,this);
		
	}
	public  String verifyhomepageTitle() {
		 String title=ldriver.getTitle();
		 return title;
	}
	public void DropdownlistValidation() {
		dsDropdown.click();
	}
	
	public void Registervalidation() {
		register.click();
	}
	public void signinvalidation() {
		Login.click();
	}
}




