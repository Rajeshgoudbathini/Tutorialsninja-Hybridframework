package com.tutorialsninja.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Extent_Reporter {
	
	public static ExtentReports generate_ExtentReport() { 
		
		ExtentReports extentReports=new ExtentReports();
		File file=new File(System.getProperty("user.dir")+"\\test-output\\ExtentReports\\eReport.html");
		ExtentSparkReporter extentSparkReporter=new ExtentSparkReporter(file);
		
		extentSparkReporter.config().setTheme(Theme.DARK);
		extentSparkReporter.config().setDocumentTitle("Tutorialsninja Test Automation");
		extentSparkReporter.config().setDocumentTitle("TN Automation Report");
		extentSparkReporter.config().setTimeStampFormat("dd//MM//yyyy hh:mm:ss");
		
		extentReports.attachReporter(extentSparkReporter);
		
		Properties Properties=new Properties();
		File file2=new File(System.getProperty("user.dir")+"\\src\\test\\resource\\com\\tutorialsninja\\qa\\config\\fixeddata.properties");
		try {
			FileInputStream fileInputStream=new FileInputStream(file2);
			Properties.load(fileInputStream);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		extentReports.setSystemInfo("Application url ", Properties.getProperty("url"));
		extentReports.setSystemInfo("Browser name ", Properties.getProperty("browser"));
		extentReports.setSystemInfo("Emil used ", Properties.getProperty("emailID"));
		extentReports.setSystemInfo("Password used ", Properties.getProperty("password"));
		
		extentReports.setSystemInfo("Operating System", System.getProperty("os.name"));
		extentReports.setSystemInfo("Operating System version", System.getProperty("os.version"));
		extentReports.setSystemInfo("Author", System.getProperty("user.name"));
		
		return extentReports;
	}
}
