package com.evaa.vtiger.pages.OR;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.evaa.vtiger.pages.functionality.BasePage;
import com.evaa.vtiger.utils.WebUtil;

public class LoginPageOR extends BasePage {

	///***************OBJECT REPOSATORY**************
	
private WebUtil wu;
public LoginPageOR(WebUtil wuObject) {
	super(wuObject);
	wu=wuObject;
	PageFactory.initElements(wu.getDriver(), this);
}
	
@FindBy(xpath="//input[@name='user_name']")
private WebElement userName;



@FindBy(xpath="//input[@name='user_password']")
private WebElement userPassword;


@FindBy(xpath="//input[@id='submitButton']")
private WebElement submitButton;	
	
// getter method for webElement which will used in Login Page	
public WebElement getUserName() {
	return userName;	
}	
	
public WebElement getUserPassword() {
	return userPassword;
}
	
public WebElement getSubmitButton() {
	return submitButton;
}
		
	
}
