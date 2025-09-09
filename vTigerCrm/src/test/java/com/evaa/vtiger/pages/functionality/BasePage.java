package com.evaa.vtiger.pages.functionality;

import org.openqa.selenium.WebElement;

import com.evaa.vtiger.utils.WebUtil;

public class BasePage {

	private WebUtil wu;
	public BasePage (WebUtil wuobject) {
		wu=wuobject;
	}
	
	
private WebElement searchButton;	
	
private WebElement searchTextbox;

private WebElement deleteButton;

private WebElement sendMailButton;

private WebElement massEditButton;
private WebElement saveButton;

private WebElement editButton;
	
	
public void saveButton() {
	wu.click(saveButton, " save button");
}
	
	
	
	
	
	
	
	
	
	
	
}
