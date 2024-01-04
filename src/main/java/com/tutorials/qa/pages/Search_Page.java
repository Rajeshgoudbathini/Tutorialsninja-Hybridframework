package com.tutorials.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Search_Page {
WebDriver driver;

	@FindBy(xpath="//div[@id=\"content\"]//h2//following-sibling::p")
	private WebElement No_Product_Match_Warning_Message;
	
	@FindBy(xpath="//div[@id=\"content\"]//h2//following-sibling::p")
	private WebElement No_Data_Entered_Warning_Message;
	
	@FindBy(linkText="HP LP3065")
	private WebElement Random_VaildProduct;
	
	public Search_Page(WebDriver driver) { 
	    this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	//Actions
	
	public String Retrive_No_Product_Match_Warning_Message() { 
	String productnotmatched = No_Product_Match_Warning_Message.getText();
	return productnotmatched;
	}
	
	public String Retrive_No_Data_Entered_Warning_Message() { 
		String nodataentered = No_Data_Entered_Warning_Message.getText();
		return nodataentered;
		}
	
	public boolean Search_Random_VaildProduct() { 
		 boolean vaildproduct = Random_VaildProduct.isDisplayed();
		return vaildproduct;
		}
}
