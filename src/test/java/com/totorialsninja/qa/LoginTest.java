package com.totorialsninja.qa;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.tutorials.qa.pages.AccountPage;
import com.tutorials.qa.pages.Home_page;
import com.tutorials.qa.pages.Login_Page;
import com.tutorialsninja.qa.util.Utilities;

public class LoginTest extends Base_class {
	
	public LoginTest() {
		super();
	}
	
public WebDriver driver;
	
	
	@BeforeMethod
	public void setup() { 
	driver=	Initilize_browser(prop.getProperty("browser"));
		driver.get(prop.getProperty("url"));
		
		Home_page homepage = new  Home_page(driver);
		   homepage.ClickOnMyAccount();
		   homepage.SelectLoginOption();
		
	}
	
	
	
	@AfterMethod
	public void teardown() { 
		driver.quit();
	}
	
   @Test(dataProvider = "validcreadentialssupplier")
	public  void verify_login_vaild_creadentials(String email,String password)   {
	
	Login_Page loginpage = new Login_Page(driver);
	   loginpage.EnterEmailAddress(email);
	   loginpage.EnterPassword(password);
	   AccountPage  account_Page=  loginpage.ClickLoginButton();
       account_Page.GetStatusOfEditYourAccountInformationOption();
	}
   
   @DataProvider(name="validcreadentialssupplier")
   
   public Object[][] provider() { 
	   
	  Object[][] data = Utilities.exceldata("Sheet1");
		  return data;
	  }
	  
	  
   
   @Test(priority = 2)
  	public  void verify_login_invalid_creadentials() {
	   Login_Page loginpage = new Login_Page(driver);
	   loginpage.EnterEmailAddress(Utilities.timestamp());
	   loginpage.EnterPassword(dataprop.getProperty("invalidpassword"));
	   loginpage.ClickLoginButton();
          
         String actual = loginpage.retriveEmailPasswordNotMatchedWarningText();
         String expectedresult = dataprop.getProperty("emailpasswordNoMatchWarning");
         Assert.assertTrue(actual.equals(expectedresult), "No match for E-Mail Address warning message not displayed");

  	}
   
   @Test(priority = 3)
 	public  void verifyLoginWithInvalidEmailAndValidPassword() {
	   
	   Login_Page loginpage = new Login_Page(driver);
	   loginpage.EnterEmailAddress(Utilities.timestamp());
	   loginpage.EnterPassword(prop.getProperty("password"));
	   loginpage.ClickLoginButton();
         
        String actual =  loginpage.retriveEmailPasswordNotMatchedWarningText();
        String expectedresult = dataprop.getProperty("emailpasswordNoMatchWarning");
        Assert.assertTrue(actual.equals(expectedresult), "No match for E-Mail Address warning message not displayed");

       //Note:Run 5 times at 6th time it should display exceeded number of attempts
 	}
   
   @Test(priority = 4)
 	public  void verifyLoginWithvalidEmailAndInValidPassword()  {
	   
	   Login_Page loginpage = new Login_Page(driver);
	   loginpage.EnterEmailAddress(prop.getProperty("emailID"));
	   loginpage.EnterPassword(dataprop.getProperty("invalidpassword"));
	   loginpage.ClickLoginButton();
         
        String actual =  loginpage.retriveEmailPasswordNotMatchedWarningText();
        String expectedresult = dataprop.getProperty("emailpasswordNoMatchWarning");
        Assert.assertTrue(actual.equals(expectedresult), "No match for E-Mail Address warning message not displayed");
     }
   
   
   
   @Test(priority = 4)
	public  void verifyLoginWithoutProvidingAnyFields()  {
	   
	   Login_Page loginpage = new Login_Page(driver);
	   loginpage.ClickLoginButton();
        
       String actual =  loginpage.retriveEmailPasswordNotMatchedWarningText();
       String expectedresult = dataprop.getProperty("emailpasswordNoMatchWarning");
       Assert.assertTrue(actual.equals(expectedresult), "No match for E-Mail Address warning message not displayed");
    }
  
}



 
 
 
 
 
 