package util;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import com.dsalgo.pageobjects.GetstartedPageobject;
import com.dsalgo.pageobjects.HomePageobject;
import com.dsalgo.pageobjects.LoginPageobject;
import com.dsalgo.testcases.Baseclass;

import util.XLUtils;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;


 public class LogintestReadExcelTest extends Baseclass{
		@BeforeClass
		public void registerpageopen() throws InterruptedException {

			GetstartedPageobject	getstartedpage=new GetstartedPageobject(driver);
			driver.get(url);
			getstartedpage.Getstartedclick();
			logger.info("Checking signinpage");
			HomePageobject LOginobj=new HomePageobject(driver);
			LOginobj. signinvalidation();
			Thread.sleep(2000);
		
		}
		

	@Test(priority=2,dataProvider="test2data")
	 public void test2(String username, String pwd) throws InterruptedException{
		try {
		LoginPageobject rp=new LoginPageobject(driver);
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(username);
	    driver.findElement(By.xpath("//input[@name='password']")).sendKeys(pwd);
		
		 rp.validatelogin();
		}catch (Exception e)
		{
		}
	}
    
 @DataProvider(name="test2data")
	public  Object[][] getData() throws IOException {
		String excelPath1="/home/ajithcp/eclipse-workspace-java/DSalgoTesting/Excel/DSALGOTEST SHEET.xlsx";
		 Object data[][]=test2Data(excelPath1,"sheet2");
		 return data;
		
	}

	@Test(priority=1)
	public  Object[][] test2Data(String excelPath1, String sheetName) throws IOException {
		XLUtils excel=new XLUtils(excelPath1, sheetName);;
		int rowCount=excel.getRowCount(excelPath1, "sheet2");
		int colcount=excel.getCellCount(excelPath1, "sheet2",1);
		System.out.println(rowCount);
		System.out.println(colcount);
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
