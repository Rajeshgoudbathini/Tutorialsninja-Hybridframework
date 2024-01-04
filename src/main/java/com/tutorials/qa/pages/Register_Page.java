package com.tutorials.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Register_Page {
	
	WebDriver driver;
	
	
	@FindBy(id = "input-firstname")
	private WebElement FirstNameTextField;
	
	@FindBy(id = "input-lastname")
	private WebElement LastNameTextField;
	
	@FindBy(name = "email")
	private WebElement EmailText;
	
	@FindBy(id = "input-telephone")
	private WebElement TelePhoneTextField;
	
	@FindBy(id = "input-password")
	private WebElement PasswordTextField;
	
	@FindBy(id = "input-confirm")
	private WebElement PasswordConcofmTextField;
	
	@FindBy(xpath = "//input[@name=\"agree\"]")
	private WebElement AggrementCheckBox;
	
	@FindBy(xpath = "//input[@value=\"Continue\"]")
	private WebElement ContinueButton;
	
	
	//warning messages
	@FindBy(xpath = "//div[@class=\"alert alert-danger alert-dismissible\"]")
	private WebElement Emailalreadyregistered;


	@FindBy(xpath="//div[contains(@class,'alert-dismissible')]")
	private WebElement PrivacyPolicyWarningMessage;
	
	@FindBy(xpath = "//input[@name=\"firstname\"]//following-sibling::div")
    private	WebElement FirstNameWarningMessage;
	

	@FindBy(xpath="//input[@id=\"input-lastname\"]//following-sibling::div")
	private WebElement LastNameWarningMessage;
	
	@FindBy(xpath="//input[@name=\"email\"]//following-sibling::div")
	private WebElement EmailWarningMessage;
	
	
	//
	public Register_Page(WebDriver driver) { 
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	
	
	//
	public void EnterFirstName(String firstname) { 
		FirstNameTextField.sendKeys(firstname);
		
	}
	
	public void EnterLastName(String lastname) { 
		LastNameTextField.sendKeys(lastname);
		
	}
	
	public void EnterEmail(String email) { 
		EmailText.sendKeys(email);
		
	}
	
	public void EnterTelephone(String telephone) { 
		TelePhoneTextField.sendKeys(telephone);
		
	}
	
	public void EnterPassword(String password) { 
		PasswordTextField.sendKeys(password);
		
	}
	
	public void EnterPasswordConform(String conformpassword) { 
		PasswordConcofmTextField.sendKeys(conformpassword);
		
	}
	
	public void ClickAggrementCheckBox() { 
		AggrementCheckBox.click();
		
	}
	
	public Registration_Success_Page ContinueButton() { 
		ContinueButton.click();
		return new Registration_Success_Page(driver);
		
	}
	
//Warning Messages	
	public String EmailAlreadyRegisteredWarningMessage() { 
		String emailwarning = Emailalreadyregistered.getText();
		return  emailwarning;
	}
	
	public String Retrive_PrivacyPolicyWarningMessage() { 	
		String privacypolicywarning = PrivacyPolicyWarningMessage.getText();
		return privacypolicywarning;
	}
	
	public String Retrive_FirstNameWarningMessage() { 	
		String firstnamewarning = FirstNameWarningMessage.getText();
		return firstnamewarning;
	}
	
	public String Retrive_LastNameWarningMessage() { 	
		String lastnamewarning = LastNameWarningMessage.getText();
		return lastnamewarning;
	}
	
	public String Retrive_EmailWarningMessage() { 	
		String emailwarning = EmailWarningMessage.getText();
		return emailwarning;
	}
	
	
}
