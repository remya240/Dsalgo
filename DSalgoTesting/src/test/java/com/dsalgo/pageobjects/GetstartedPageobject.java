package com.dsalgo.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GetstartedPageobject {
	WebDriver ldriver; 
	
	public  GetstartedPageobject(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver,this);
	}
	
	@FindBy(xpath="//button[text()='Get Started']")WebElement getStarted;
	public void Getstartedclick() {
		getStarted.click();
	}

}
