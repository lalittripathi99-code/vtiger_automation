
package com.evaa.vtiger.runner;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.evaa.vtiger.testcases.LeadsTestScripts;
import com.evaa.vtiger.utils.WebUtil;

public class Runner {
public static void main(String[] args) {
	ExtentReports extreport=	new ExtentReports();
	ExtentSparkReporter extspark=  new ExtentSparkReporter("C:\\Users\\HP\\Desktop\\Extent_report.html");
	extreport.attachReporter(extspark);
	
		
		
	
	ExtentTest et=extreport.createTest("methodName");
	WebUtil wu= new WebUtil(et);
	
	
	LeadsTestScripts lts= new LeadsTestScripts();
	lts.vt001VerifyLeadWithRequiredFields();
	
	
	extreport.flush();
}
}
