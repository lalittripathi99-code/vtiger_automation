package com.evaa.vtiger.pages.functionality;

import com.evaa.vtiger.pages.OR.CreateNewLeadsPageOR;
import com.evaa.vtiger.utils.WebUtil;

public class CreateNewLeadsPage extends CreateNewLeadsPageOR {
	
public WebUtil wu=null;
public CreateNewLeadsPage(WebUtil wuObject) {
	super(wuObject);
	wu=wuObject;
	
}

public void verifyWithRequiredField() {

wu.inputData(getLastName(), " last name textbox", " TRIPATHI");

wu.inputData(getCompanyName(), "company textbox", "DONOR");
saveButton();
}

public void verifyWithAllFields() {
	wu.inputData(getFirstName(), " first name textbox", "LALIT");
	wu.inputData(getLastName(), " last name textbox", " TRIPATHI");
	wu.inputData(getTitle(), " title", "PRATAP");
	wu.dropdownSelectByVisibleText(getLeadsource(), " lead source", "Web Site");
}




















}
