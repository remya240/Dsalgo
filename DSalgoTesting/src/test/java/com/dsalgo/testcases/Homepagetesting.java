package com.dsalgo.testcases;
import java.io.IOException;
import org.testng.AssertJUnit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.dsalgo.pageobjects.GetstartedPageobject;
import com.dsalgo.pageobjects.HomePageobject;

public class Homepagetesting extends Baseclass{
	@BeforeClass
	public void Getstartedpagesetup() throws InterruptedException {
		GetstartedPageobject getstartedpage = new GetstartedPageobject(driver);
		driver.get(url);
		logger.info("Url is opened");
	    driver.manage().window().maximize();
		getstartedpage.Getstartedclick();
		Thread.sleep(2000);
		logger.info("getstartedpage Tesing completed");
		
	}
	
	@Test(priority=1)
	public void Homepagetest() throws InterruptedException {
		
		HomePageobject homepageobject=new HomePageobject(driver);
		homepageobject.DropdownlistValidation();
		Thread.sleep(2000);
		homepageobject.Registervalidation();
		homepageobject.signinvalidation();
		logger.info("Homepage Tesing completed");
	
	}
	
	@Test(priority=0)
	public void negativeTest() throws IOException {
		HomePageobject homepageobject=new HomePageobject(driver);
		String title= homepageobject.verifyhomepageTitle();
		CaptureScreen(driver,"Screenshot");
		AssertJUnit.assertEquals(title, "NumpyNinga1");
	}
	
}