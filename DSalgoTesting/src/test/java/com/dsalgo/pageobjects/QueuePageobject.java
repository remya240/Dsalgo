package com.dsalgo.pageobjects;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.dsalgo.testcases.Baseclass;
import com.dsalgo.testcases.ReadConfig;

public class QueuePageobject extends Baseclass {
	WebDriver ldriver; 
	JavascriptExecutor js;
	public  QueuePageobject(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver,this);
		this.js=(JavascriptExecutor)this.ldriver;
	}
	@FindBy(xpath="//h5[text()='Queue']/../a")WebElement QueuegetStarted;	
	@FindBy(xpath="//ul/a[text()='Implementation of Queue in Python']")WebElement ImplementationofQueueinpython;	
	@FindBy(xpath="//a[text()='Implementation using collections.deque']")WebElement Implementationusingcollection;	
	@FindBy(xpath="//li/a[text()='Implementation using array']")WebElement Implementationusingarray;
	@FindBy(xpath="//li/a[text()='Queue Operations']")WebElement Queueoperations;	
	@FindBy(xpath="//button[text()='Run']")WebElement Run;	
	@FindBy(xpath="//a[text()='Try here>>>']")WebElement Tryhere;
	@FindBy(css="#answer_form > div > div > div.CodeMirror-scroll")WebElement code;
	@FindBy(xpath="//a[text()='Practice Questions']")WebElement PracticeQuestions;	

	public ReadConfig pythonobj= new ReadConfig();

	public  void clickQueue()
	{
		QueuegetStarted.click();
		js.executeScript("window.scrollBy(0,1000)");
		ImplementationofQueueinpython.click();
		Tryhere.click();
		ldriver.findElement (By.xpath("//textarea[@tabindex=0]")).sendKeys(ReadConfig.prop.getProperty("editorText"));

		//code.click();
		//pythonobj.getEditortext();
		Run.click();
	}
	public  void clickImplementationusingcollection() {
		Implementationusingcollection.click();
		//js.executeScript("window.scrollBy(0,1000)");
		Tryhere.click();
		ldriver.findElement (By.xpath("//textarea[@tabindex=0]")).sendKeys(ReadConfig.prop.getProperty("editorText"));

		//code.click();
		//pythonobj.getEditortext();
		Run.click();
	}	
	public  void clickImplementationusingarray() throws InterruptedException {
		Implementationusingarray.click();
		js.executeScript("window.scrollBy(0,1000)");
		Tryhere.click();
		ldriver.findElement (By.xpath("//textarea[@tabindex=0]")).sendKeys(ReadConfig.prop.getProperty("editorText"));
		Run.click();
		Thread.sleep(2000);

		
	}
	public  void clickQueueoperations() throws InterruptedException {
		Queueoperations.click();
		js.executeScript("window.scrollBy(0,1000)");
		Tryhere.click();
		ldriver.findElement (By.xpath("//textarea[@tabindex=0]")).sendKeys(ReadConfig.prop.getProperty("editorText"));

		//code.click();
		//	pythonobj.getEditortext();
		Run.click();
	}
	public  void clickPractiseQuestions() {
		PracticeQuestions.click();
		
	}
}
	
	
	
	
	
	
	

