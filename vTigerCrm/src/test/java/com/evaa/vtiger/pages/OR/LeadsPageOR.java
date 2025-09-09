package com.evaa.vtiger.pages.OR;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.evaa.vtiger.pages.functionality.BasePage;
import com.evaa.vtiger.utils.WebUtil;

public class LeadsPageOR extends BasePage {

	
	private WebUtil wu;
	public LeadsPageOR(WebUtil wuObject) {
		super(wuObject);
		wu=wuObject;
		PageFactory.initElements(wu.getDriver(), this);
	}
	
	@FindBy(xpath="//img[@title='Create Lead...']")
	private WebElement createNewLead;	
	public WebElement getCreateNewLead() {
		return createNewLead;
	}
	
	
	
	
	
	
	
	
	
}
