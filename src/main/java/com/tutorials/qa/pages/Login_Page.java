package com.tutorials.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_Page {

	WebDriver driver;
	
	@FindBy(id = "input-email")
	private WebElement EmailTextField;
	
	@FindBy(id = "input-password")
	private WebElement PasswordTextField;
	
	@FindBy(xpath = "//input[@value=\"Login\"]")
	private WebElement LoginButton;
	
	@FindBy(xpath="//div[contains(@class,'alert-dismissible')]")
	private WebElement EmailPasswordNotMatchingWarning;
	
	//Constructor
		public Login_Page(WebDriver driver) { 
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
		
		//Actions
		
		public void EnterEmailAddress(String emailText) { 
			
			EmailTextField.sendKeys(emailText);
		  }

		public void EnterPassword(String passwordText) { 
			
			PasswordTextField.sendKeys(passwordText);
		  }

		public AccountPage ClickLoginButton() { 
			
			LoginButton.click();
			return new AccountPage(driver);
		  }
		
		public String retriveEmailPasswordNotMatchedWarningText() { 
			String Warningtext = EmailPasswordNotMatchingWarning.getText();
			return Warningtext;
		}

	}
