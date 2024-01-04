package com.totorialsninja.qa;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.tutorials.qa.pages.Home_page;
import com.tutorials.qa.pages.Search_Page;

public class SearchTest extends Base_class {
	
	
	public SearchTest(){ 
		super();
	}
	
	public	WebDriver driver;
	
	@BeforeMethod
	public void setup() { 
	   driver=Initilize_browser(prop.getProperty("browser"));
		driver.get(prop.getProperty("url"));
	}
	
	
	@AfterMethod
	public void teardown() { 
		driver.quit();
	}
	
	@Test(priority = 1)
	public void verify_searchwith_vaildproduct() { 
		Home_page home_page =new Home_page(driver);
		home_page.Search_Product_Insearchfield(dataprop.getProperty("VaildProduct"));
		Search_Page search_page=home_page.Click_SearchButton();
		
		  // search_page.Search_Random_VaildProduct();
       		Assert.assertTrue(search_page.Search_Random_VaildProduct());
	}
	
//     @Test(priority = 2)
//	public void verify_with_invaild_product() { 
// 		Home_page home_page =new Home_page(driver);
//    	 home_page.Search_Product_Insearchfield(dataprop.getProperty("Invaliddata"));
//    	 Search_Page search_page=home_page.Click_SearchButton();
//    	 
//		String actual = search_page.Retrive_No_Product_Match_Warning_Message();
//		String expected = dataprop.getProperty("NoMatchProduct");
//		Assert.assertEquals(actual,expected,"No product in search results message is displayed");
//	
//	}
	
	//To fail use the below code 61-71
	
  @Test(priority = 2)
	public void verify_with_invaild_product() { 
		Home_page home_page =new Home_page(driver);
 	 home_page.Search_Product_Insearchfield(dataprop.getProperty("Invaliddata"));
 	 Search_Page search_page=home_page.Click_SearchButton();
 	 
		String actual = search_page.Retrive_No_Product_Match_Warning_Message();
		String expected = "abcd";
		Assert.assertEquals(actual,expected,"No product in search results message is displayed");
	
  }
     
	@Test(priority = 3,dependsOnMethods = {"verify_with_invaild_product"})  
	public void verify_search_resultswith_Nodata() { 
		
		Home_page home_page =new Home_page(driver);
		Search_Page search_page= home_page.Click_SearchButton();
   	    
		String actual = search_page.Retrive_No_Data_Entered_Warning_Message();
		String expected = dataprop.getProperty("NoProductInSearchMessage");
		Assert.assertEquals(actual,expected,"No product in search results message is displayes");
	}
}

