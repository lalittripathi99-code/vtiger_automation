package com.evaa.vtiger.pages.functionality;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.evaa.vtiger.pages.OR.LoginPageOR;
import com.evaa.vtiger.utils.WebUtil;

public class LoginPage extends LoginPageOR {

	private  WebUtil wu;
	public LoginPage(WebUtil wuObject) {
		super(wuObject);
	wu=wuObject;
	//PageFactory.initElements(wu.getDriver(), this);
	}
    


//***********************launch Browser and hit url*************************
	public void loginPageVtiger() {
	
		
		
		wu.openUrl("http://localhost:8888/");
		
	}
//*********************** user name **************************	
public void InputUserName() {
	//WebElement weInputUsername= wu.getWebElement("//input[@name='user_name']", " user name");
	wu.inputData(getUserName(), " user name", "admin");
}
	//******************** user password ******************************
public void InputUserPassword() {
	//WebElement weInputUserpassword= wu.getWebElement("//input[@name='user_password']", " user password");
	wu.inputData(getUserPassword(), " user password", "admin");
}
	//**************submit button****************************
public void submitButton() {
	//WebElement wesubmitbutton= wu.getWebElement("//input[@id='submitButton']", "submit button");
	wu.click(getSubmitButton(), " submit button");
}
	
	
	
	
	
	
	
}
