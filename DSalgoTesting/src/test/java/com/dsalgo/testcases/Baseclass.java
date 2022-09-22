package com.dsalgo.testcases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Baseclass {
    public static  ReadConfig  readconfig= new  ReadConfig ();
	public static String url=readconfig.getApplicationURL();
	public static String username=readconfig.getApplicationusername();
	public static String password=readconfig.getApplicationpassword();
	public  static WebDriver driver;
	public static Logger logger;
	

	
	@BeforeSuite
	public  void  setup() {
	
	    ExtentSparkReporter reporter = new ExtentSparkReporter("./TestReport.html");

		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);

		BasicConfigurator.configure();
		logger=Logger.getLogger("DSalgoTesting");
		PropertyConfigurator.configure("Log4j.properties");
		System.setProperty("webdriver.chrome.driver",readconfig.getchromepath());
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	
	@AfterSuite
	public void teardown() throws InterruptedException {
		//Thread.sleep(10000);
		//driver.quit();
	}
	
    public static void CaptureScreen(WebDriver driver, String name) throws IOException {
    	 logger.info("Taking Screenshot");
    	 TakesScreenshot screenshot=(TakesScreenshot)driver;
    	 File sourceFile=screenshot.getScreenshotAs(OutputType.FILE);
    	 //File destinationFile= new File(".\\screenshots\\homepage.png");
    	 File destinationFile= new File("/home/ajithcp/eclipse-workspace-java/DSalgoTesting/screenshots/"+name+".png");
    	 //FileUtils.copyFile(sourceFile,destinationFile);
    	 FileHandler.copy(sourceFile, destinationFile);
    	 System.out.println("Screenshot Taken");
    	 
     }
	
}		
			