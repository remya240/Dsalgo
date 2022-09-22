package com.dsalgo.testcases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import com.dsalgo.pageobjects.GetstartedPageobject;
import com.dsalgo.pageobjects.HomePageobject;
import com.dsalgo.pageobjects.RegisterPageobject;
import util.XLUtils;


public class RegisterTestExcelDataProvider extends Baseclass {

	@BeforeClass
	public void registerpagenotsedingvalue() throws InterruptedException {
		
		GetstartedPageobject getstartedpage = new GetstartedPageobject(driver);
		HomePageobject homepageobject = new HomePageobject(driver);
		RegisterPageobject registerpageobject = new RegisterPageobject(driver);
		driver.get(url);
		getstartedpage.Getstartedclick();
		logger.info("Checking registerfield");
		homepageobject.Registervalidation();
		Thread.sleep(2000);
		registerpageobject.validateregisterbutton();
	}
	

    @Test(priority=2,dataProvider="test1data")
    public void test1(String username, String password1,String password2) throws InterruptedException {
		
    	try {
			RegisterPageobject rp = new RegisterPageobject(driver);
			driver.findElement(By.name("username")).sendKeys(username);
			driver.findElement(By.name("password1")).sendKeys(password1);
			driver.findElement(By.name("password2")).sendKeys(password2);
			rp.validateregisterbutton();
	   
    	}
    	catch (Exception e)
    	{
    		
    	}
	}
	
	
	
	@DataProvider(name="test1data")
	public  Object[][] getData() throws IOException {
		String excelPath="/home/ajithcp/eclipse-workspace-java/DSalgoTesting/Excel/DSALGOTEST SHEET.xlsx";
		 Object data[][]=test1Data(excelPath,"sheet1");
		 return data;
		
	}
	
	
	@Test(priority=1)
	public  Object[][] test1Data(String excelpath, String sheetName) throws IOException {
		
		XLUtils excel=new XLUtils(excelpath, sheetName);
		int rowCount=4;//excel.getRowCount(excelpath, "sheet1");
		int colcount=3;//excel.getCellCount(excelpath, "sheet1",1);
		Object data[][]=new  Object[rowCount][colcount];
		
		for(int i=1;i<rowCount;i++)
		{
			for(int j=0;j<colcount;j++)
			{
			String cellData=XLUtils.GetCellDataString(i, j);
			data[i-1][j]=cellData;
			}
		}
		return data;
	}

}
