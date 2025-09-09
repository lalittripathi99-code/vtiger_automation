package com.evaa.vtiger.testcases;
import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.evaa.vtiger.pages.functionality.HomePage;
import com.evaa.vtiger.pages.functionality.LoginPage;
import com.evaa.vtiger.utils.WebUtil;

public class ProductsScripts {
	@Test
	public void vt001VeifyCreateProductsAllFields(ExtentTest et)  {
		
	WebUtil wu= new WebUtil(et);
	wu.launchBrowser("chrome");
	
	LoginPage lp= new LoginPage(wu);
	lp.loginPageVtiger();
	lp.InputUserName();
	lp.InputUserPassword();
	lp.submitButton();
	
	HomePage hp= new HomePage(wu);
	hp.goToProducts();
	
	//WebDriver driver=new ChromeDriver();
//		
//		WebUtil wt=	new WebUtil();
//		wt.launchBrowser("chrome", et);
//		wt.openUrl( "http://localhost:8881/", et);
//		wt.getTitle(et);
//		wt.implicitWait(60, et);
//		wt.inputData("//input[@type='text']","userName",  et, "admin");
//	    wt.inputData("//input[@type='password']", "user password",  et, "admin");
//	    WebElement  weSubmitButton = wt.getWebElement(et, "//input[@id='submitButton']","submit button" );
//       wt.click(weSubmitButton, "submit button");
//	  WebElement weOpportunity =  wt.getWebElement(et, "//a[text()='Opportunities']", "opportunities");
//        wt.click(weOpportunity, "opportunities" );
//     WebElement weCreateOpportunity =   wt.getWebElement(et, "//img[@title='Create Opportunity...']",  " create opportunity");
//        wt.click(weCreateOpportunity,  " create opportunity");
//        wt.inputData("//input[@name='potentialname']", "opportunity name", et,"krishna" );
//        wt.close(et, "page");
//        
     
	
	}
	
	
	
	public void vt002verifyCreateProductRequiredFields() {
		
	}
	
public void vt003verifyCreateProductWithoutRequiredFields() {
		
	}
}
