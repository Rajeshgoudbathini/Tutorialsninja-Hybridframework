package com.tutorials.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {
WebDriver driver;

	//WebElements
	@FindBy(xpath="//a[text()='Edit your account information']")
	private WebElement EditYourAccountInformationOption;
	
	
	//Constructor
	public  AccountPage(WebDriver driver) { 
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public boolean GetStatusOfEditYourAccountInformationOption() { 	
		boolean displaystatus = EditYourAccountInformationOption.isDisplayed();
		return displaystatus;
	}
}
