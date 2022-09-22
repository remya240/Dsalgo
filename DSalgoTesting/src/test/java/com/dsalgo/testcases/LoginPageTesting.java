package com.dsalgo.testcases;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;

import com.dsalgo.pageobjects.GetstartedPageobject;
import com.dsalgo.pageobjects.HomePageobject;
import com.dsalgo.pageobjects.RegisterPageobject;

public class LoginPageTesting extends Baseclass {
	
	public GetstartedPageobject getstartedpage;
	public RegisterPageobject registerpageobject;
	public HomePageobject homepageobject;
	public ReadConfig loginobj= new ReadConfig();


	@Test(priority=2)
	public void LoginTestingsetup() throws InterruptedException, IOException {
		driver.findElement (By.xpath("//input[@value='Login']")).click();
		driver.findElement (By.xpath("//input[@name='username']")).sendKeys(ReadConfig.prop.getProperty("username"));
		driver.findElement (By.xpath("//input[@name='password']")).sendKeys(ReadConfig.prop.getProperty("password"));
		driver.findElement (By.xpath("//input[@value='Login']")).click();
		logger.info("Loginpage Tesing completed");
	}
	@Test(priority=1)
	public void negativeTest1Login() throws IOException, InterruptedException {
		getstartedpage=new GetstartedPageobject(driver);
		homepageobject=new HomePageobject(driver);
		driver.get(url);
		getstartedpage.Getstartedclick();
		homepageobject.signinvalidation();
		Thread.sleep(2000);
		homepageobject.signinvalidation();	

	}
	
	@Test(priority=3)
	public void drowndown() {
		
	}

	
	
  }


