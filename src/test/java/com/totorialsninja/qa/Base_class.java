package com.totorialsninja.qa;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Base_class {

	WebDriver driver;
	public Properties prop;
	public Properties dataprop;
	
	public Base_class() { 
		
	       prop = new Properties();
	 File file = new File(System.getProperty("user.dir")+"\\src\\test\\resource\\com\\tutorialsninja\\qa\\config\\fixeddata.properties");
	 
	      dataprop = new Properties();
	 File propfile = new File(System.getProperty("user.dir")+"\\src\\test\\resource\\com\\tutorials\\qa\\testdata\\basicdata.properties");
	 
	 try {
		FileInputStream datafis = new FileInputStream(propfile);
			dataprop.load(datafis);
	} catch (Exception e) {
		e.printStackTrace();
	}
		
	
		try {
			FileInputStream fis = new FileInputStream(file);
			prop.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public WebDriver Initilize_browser(String browser) { 
		
		if(browser.equals("chrome")) {
			driver=new ChromeDriver();
		}else if (browser.equals("edge")) {
			driver=new EdgeDriver();
		}else if (browser.equals("firefox")) {
			driver=new FirefoxDriver();
		}else if(browser.equals("safari")){ 
			driver=new SafariDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		return driver;
	}
	
}
