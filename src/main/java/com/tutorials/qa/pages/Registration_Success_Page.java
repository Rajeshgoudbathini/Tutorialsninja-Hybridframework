package com.tutorials.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Registration_Success_Page {
WebDriver driver;


//WebElements [or]Declaration
	@FindBy(xpath = "	//div[@id=\"content\"]//h1")
	private WebElement AccountSuccessMessage;
	
	
	//Constructor[or]Initialization
	public Registration_Success_Page(WebDriver driver) { 	
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//Declaration
	
	public String AccountSuccessMessage() { 
	String accountcreated = AccountSuccessMessage.getText();
		return accountcreated;
	  }
	}
