package com.evaa.vtiger.testcases;
import java.lang.reflect.Method;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.evaa.vtiger.pages.functionality.BasePage;
import com.evaa.vtiger.pages.functionality.CreateNewLeadsPage;
import com.evaa.vtiger.pages.functionality.HomePage;
import com.evaa.vtiger.pages.functionality.LeadsPage;
import com.evaa.vtiger.pages.functionality.LoginPage;
import com.evaa.vtiger.utils.WebUtil;

public class LeadsTestScripts  {
	private WebUtil wu;
	private ExtentReports extreport;
	@BeforeSuite
	public void beforeSuite() {
		// it will run first of all and once a time
		//foe example we work to initialize extentTest report
		 extreport=	new ExtentReports();
		ExtentSparkReporter extspark=  new ExtentSparkReporter("Extent_report.html");
		extreport.attachReporter(extspark);
		
	}
//	@BeforeTest
//	public void test() {
//	// it will run first 	
//	}
	
//@BeforeClass
//	public void launchBrowser() {
//		// launch browser    --- it will run @beforeTest
//	
//	}
//	
	                                                          // order to run
	@BeforeMethod                                             //  @beforeSuite
public void loginBefore(Method mt) {                                   //  @beforeTest
 String ctName=	mt.getName();
		 ExtentTest et=extreport.createTest(ctName);
		 wu=new WebUtil(et); 
			wu.launchBrowser("chrome");		                   //   @beforeClass
	}                                                         //   @beforeMethod
	@AfterMethod                                              //   @test
public void logOutafter() {                                  //   @AfterMethod
	// logout
 //wu.closeCurrentBrowser(" close current running browser");		                                                      //   @AfterClass
}                                                            //    @AfterTest  
//	@AfterClass                                              //    @AfterSuite
//	public void closeBrowser() {
//		// close all the browser
//	}
//	@AfterTest
//	public void afterTest() {
//		// it will run after @AfterClass 
//	}
	@AfterSuite
	public void afterSuite() {
		// it will run at the end of all
		// we can work to flush extent test
		extreport.flush();
	}
	
@Test
	public void vt001VerifyLeadWithRequiredFields() {
	

	LoginPage lp=	new LoginPage(wu);
	lp.loginPageVtiger();
	lp.InputUserName();
	lp.InputUserPassword();
	lp.submitButton();  
	
	HomePage hp= new HomePage(wu);
	hp.goToLeadsPage();
	LeadsPage lead= new LeadsPage(wu);
	lead.createNewLeads();
 	CreateNewLeadsPage cnl= new CreateNewLeadsPage(wu);
 
 	cnl.verifyWithRequiredField();
	}
	@Test
	public void vt002VerifyLeadWithAllFields() {
		LoginPage lp=	new LoginPage(wu);
		lp.loginPageVtiger();
		lp.InputUserName();
		lp.InputUserPassword();
		lp.submitButton();  
		
		HomePage hp= new HomePage(wu);
		hp.goToLeadsPage();
		LeadsPage lead= new LeadsPage(wu);
		lead.createNewLeads();
		CreateNewLeadsPage cnl= new CreateNewLeadsPage(wu);
		
		cnl.verifyWithAllFields();
	}
	

}
