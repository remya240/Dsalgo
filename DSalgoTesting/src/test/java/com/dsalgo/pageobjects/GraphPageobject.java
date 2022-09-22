package com.dsalgo.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.dsalgo.testcases.ReadConfig;

public class GraphPageobject  {
	WebDriver ldriver; 
	JavascriptExecutor js;
	public  GraphPageobject(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver,this);
		this.js=(JavascriptExecutor)this.ldriver;
	}
	@FindBy(xpath="//h5[text()='Graph']/../a")WebElement GraphgetStarted;	
	@FindBy(xpath="//ul/a[text()='Graph']")WebElement Graph;	
	@FindBy(xpath="//a[text()='Graph Representations']")WebElement GraphRepresentations;	
	@FindBy(xpath="//a[text()='Practice Questions']")WebElement PracticeQuestions;	
	@FindBy(xpath="//button[text()='Run']")WebElement Run;	
	@FindBy(xpath="//a[text()='Try here>>>']")WebElement Tryhere;
	
	//@FindBy(xpath ="//textarea[@tabindex=0]")WebElement textbox;
	//@FindBy(css="#answer_form > div > div > div.CodeMirror-scroll")WebElement code;
	//public ReadConfig pythonobj= new ReadConfig();

	public  void clickGraph() throws InterruptedException
	{
		GraphgetStarted.click();
		Graph.click();
		Tryhere.click();
		Thread.sleep(2000);
		ldriver.findElement (By.xpath("//textarea[@tabindex=0]")).sendKeys(ReadConfig.prop.getProperty("editorText"));
		Run.click();
		Thread.sleep(2000);
	}
	
	public  void clickGraphRepresentations() throws InterruptedException {
		GraphRepresentations.click();
		js.executeScript("window.scrollBy(0,1000)");
		Tryhere.click();
		ldriver.findElement (By.xpath("//textarea[@tabindex=0]")).sendKeys(ReadConfig.prop.getProperty("editorText"));
         Thread.sleep(2000);
		Run.click();
	}
	
	public  void clickPractiseQuestions() {
		PracticeQuestions.click();
	}
	
	
}
	
	
	
	
	
	
	

