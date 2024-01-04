package com.tutorials.qa.Listeners;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.tutorialsninja.qa.util.Extent_Reporter;

public class Listeners implements ITestListener {
	ExtentReports extentReport;
	ExtentTest eTest;
	
	@Override
	public void onStart(ITestContext context) {
		 extentReport = Extent_Reporter.generate_ExtentReport();
	}
	
	
	@Override
	public void onTestStart(ITestResult result) {
		String testname = result.getName();
		 eTest = extentReport.createTest(testname);
		 eTest.log(Status.INFO, testname+" Exceution started ");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		String testname = result.getName();
		eTest.log(Status.PASS, testname+" got successfully exceuted");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String testname = result.getName();
		
		
	WebDriver driver = null;
	try {
		driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
	} catch (IllegalArgumentException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IllegalAccessException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (NoSuchFieldException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SecurityException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	   File Srcscreenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	   String destination = System.getProperty("user.dir")+"\\Screenshots\\"+testname+".png";
	   try {
		FileHandler.copy(Srcscreenshot,new File(destination));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   eTest.addScreenCaptureFromPath(destination);
	   eTest.log(Status.INFO,result.getThrowable());
	   eTest.log(Status.FAIL, testname+" got Failed");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String testname = result.getName();
		eTest.log(Status.INFO,result.getThrowable());
		eTest.log(Status.SKIP, testname+" got skiped");
	}

	@Override
	public void onFinish(ITestContext context) {
		extentReport.flush();
	}

}
