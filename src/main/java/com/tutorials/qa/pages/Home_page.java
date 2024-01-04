package com.tutorials.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home_page {
	WebDriver driver;
	
	//Elements
	@FindBy(xpath = "//a[@title=\"My Account\"]")
	private WebElement AccountDropMenu;
	
	@FindBy(xpath = "//a[text()='Login']")
	private WebElement Login;
	
	@FindBy(xpath = "//a[text()='Register']")
	private WebElement Register;
	
	@FindBy(xpath = "//input[@name=\"search\"]")
	private WebElement Search;
	
	@FindBy(xpath="//div[@id=\"search\"]//descendant::button")
	private WebElement SearchButton;
	
	//Constructor
	public Home_page(WebDriver driver) { 
	    this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	//Actions
	
	public void ClickOnMyAccount() { 
		AccountDropMenu.click();
	}
	
	public void SelectLoginOption() { 
		Login.click();
	}
	
	public void SelectRegisterOption() { 
		Register.click();
	}
	
	public void Search_Product_Insearchfield(String productname) { 
		Search.sendKeys(productname);
	}

	public Search_Page Click_SearchButton() { 
		SearchButton.click();
	 return new Search_Page(driver);
	}

}
