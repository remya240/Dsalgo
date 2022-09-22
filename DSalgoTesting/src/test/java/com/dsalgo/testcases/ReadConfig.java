package com.dsalgo.testcases;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;





public  class ReadConfig {
	
	//public static WebDriver driver;
	public static Properties prop;
	
	

	public ReadConfig() {
		File src= new File("./Configurations/config.properties");
		
		try {
			prop=new Properties();
			FileInputStream ip = new FileInputStream(src);
			prop=new Properties(); 
			prop.load(ip);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	public String getchromepath() {
		String chromepath=prop.getProperty("chromepath");
		return chromepath;
		
	}
			 
	public String getApplicationURL() {
		String url=prop.getProperty("URL");
		return url;
		
	}

	public String getApplicationusername() {
		String usename=prop.getProperty("username");
		return usename;
	}

	public String getApplicationpassword() {
		String password=prop.getProperty("password");
		return password;
		
	}
	public String getEditortext() {
		String editorText=prop.getProperty("editorText");
		return editorText;
	}


	
	
		
		
		
	}	


