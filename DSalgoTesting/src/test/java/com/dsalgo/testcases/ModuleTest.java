package com.dsalgo.testcases;

import org.testng.annotations.Test;
import com.dsalgo.pageobjects.GraphPageobject;
import com.dsalgo.pageobjects.LoginPageobject;
import com.dsalgo.pageobjects.QueuePageobject;



public class ModuleTest  extends Baseclass{

	//LogintestReadExcelTest loiginobj =new LogintestReadExcelTest();
	@Test(priority=0)
	public void GraphTest() throws InterruptedException {
		GraphPageobject grphpageobj = new GraphPageobject(driver);
		grphpageobj.clickGraph();	
		driver.navigate().back();
		grphpageobj.clickGraphRepresentations();
		driver.navigate().back();
		Thread.sleep(2000);
		grphpageobj.clickPractiseQuestions();
		driver.navigate().back();
		driver.navigate().back();
		Thread.sleep(2000);
		driver.navigate().back();
		driver.navigate().back();

	}
	@Test(priority=1)
	public void QueueTest() throws InterruptedException {
		LoginPageobject loginobj = new LoginPageobject(driver);
		QueuePageobject Queueobj = new QueuePageobject(driver);
		Queueobj.clickQueue();	
		driver.navigate().back();
		Queueobj.clickImplementationusingcollection();
		driver.navigate().back();
		Thread.sleep(2000);
		Queueobj.clickImplementationusingarray();
		driver.navigate().back();
		Queueobj.clickQueueoperations();
		driver.navigate().back();
		Queueobj.clickPractiseQuestions();
		loginobj.validatelogout();
		driver.navigate().back();
		driver.navigate().back();
		Thread.sleep(2000);
		driver.navigate().back();
		driver.navigate().back();
		driver.navigate().back();
		driver.navigate().back();

	}
}
