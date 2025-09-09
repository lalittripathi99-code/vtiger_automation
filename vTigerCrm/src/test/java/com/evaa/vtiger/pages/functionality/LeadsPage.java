package com.evaa.vtiger.pages.functionality;

import com.evaa.vtiger.pages.OR.LeadsPageOR;
import com.evaa.vtiger.utils.WebUtil;

public class LeadsPage extends LeadsPageOR {
public WebUtil wu=null;
public LeadsPage(WebUtil wuObject) {
	super(wuObject);
	wu=wuObject;
//	PageFactory.initElements(wu.getDriver(), this);
}

//@FindBy(xpath="//img[@title='Create Lead...']")
//public WebElement createNewLead;


public void createNewLeads() {
//WebElement createNewLead=	wu.getWebElement("//img[@title='Create Lead...']", " create lead");
wu.click(getCreateNewLead(), " createLeadBT");
}

}
