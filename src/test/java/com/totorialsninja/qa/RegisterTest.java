package com.totorialsninja.qa;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorials.qa.pages.Home_page;
import com.tutorials.qa.pages.Register_Page;
import com.tutorials.qa.pages.Registration_Success_Page;
import com.tutorialsninja.qa.util.Utilities;


public class RegisterTest extends Base_class{

	public RegisterTest() { 
		super();
	}
	
	public	WebDriver driver;
	
	@BeforeMethod
	public void setup() { 
		
	driver=	Initilize_browser(prop.getProperty("browser"));
		driver.get(prop.getProperty("url"));
		
		Home_page homepage = new  Home_page(driver);
		   homepage.ClickOnMyAccount();
		   homepage.SelectRegisterOption();
		  
	}
	
	
	@AfterMethod
	public void teardown() { 
		driver.quit();
	}

	 @Test(priority = 1)
	public void Register_with_Mandatoryfields() {

		 Register_Page register_page = new Register_Page(driver);
		 register_page.EnterFirstName(dataprop.getProperty("firstname"));
		 register_page.EnterLastName(dataprop.getProperty("lastname"));
		 register_page.EnterEmail(Utilities.timestamp());
		 register_page.EnterTelephone(dataprop.getProperty("telephonenumber"));
		 register_page.EnterPassword(prop.getProperty("password"));
		 register_page.EnterPasswordConform(prop.getProperty("password"));
		 register_page.ClickAggrementCheckBox();
		 Registration_Success_Page registration_success_Page= register_page.ContinueButton();
		 
	// Registration_Success_Page registration_success_Page =new Registration_Success_Page(driver);
	String actual = registration_success_Page.AccountSuccessMessage();
	
	String expected =dataprop.getProperty("accountsuccessmessage");
	Assert.assertEquals(actual, expected,"Account created message not displayed");
	
	 }
	 
	 @Test(priority = 2)
	 public void verify_existing_email_with_registerpage() { 
		 
		 Register_Page register_page = new Register_Page(driver);
		 register_page.EnterFirstName(dataprop.getProperty("firstname"));
		 register_page.EnterLastName(dataprop.getProperty("lastname"));
		 register_page.EnterEmail(prop.getProperty("emailID"));
		 register_page.EnterTelephone(dataprop.getProperty("telephonenumber"));
		 register_page.EnterPassword(prop.getProperty("password"));
		 register_page.EnterPasswordConform(prop.getProperty("password"));
		 register_page.ClickAggrementCheckBox();
		 register_page.ContinueButton();
			
		String actual = register_page.EmailAlreadyRegisteredWarningMessage();
		String expectedresult=dataprop.getProperty("emailregisteredwarningmessage");

		Assert.assertTrue(actual.contains(expectedresult),"Expected email registered warning message not found");
			
	 }
	 @Test(priority = 3)
	 public void verifyRegisteraccount_withoutEntering_mandatoryfields() { 
		 Register_Page register_page = new Register_Page(driver);
		 register_page.ContinueButton();
			
		 String actual = register_page.Retrive_PrivacyPolicyWarningMessage();
		 String expected = dataprop.getProperty("PrivacyPolicyWarningMessage");
		Assert.assertTrue(actual.contains(expected),"Expected Warning message is not displayed");
			
			String actualfirstname = register_page.Retrive_FirstNameWarningMessage();
			 String expected1 = dataprop.getProperty("FirstNameWarningMessage");
			Assert.assertTrue(actualfirstname.contains(expected1),"Firstname Warning Message is NOt dislayed");
			
			String actual_lastname = register_page.Retrive_LastNameWarningMessage();		
			 String expected2 = dataprop.getProperty("LastNameWarningMessage");
			Assert.assertTrue(actual_lastname.contains(expected2),"Lastname warning message is not displayed");
			
			String actual_email = register_page.Retrive_EmailWarningMessage();		
			 String expected3 = dataprop.getProperty("EmailAperarNotValid");
			Assert.assertTrue(actual_email.contains(expected3),"email warning message is not displayed");
			
			
	 }
}
