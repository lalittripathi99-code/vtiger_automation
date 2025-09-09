package com.evaa.vtiger.pages.OR;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.evaa.vtiger.pages.functionality.BasePage;
import com.evaa.vtiger.utils.WebUtil;

public class CreateNewLeadsPageOR extends BasePage {
private WebUtil wu;
	public CreateNewLeadsPageOR(WebUtil wu) {
		super(wu);
		this.wu=wu;
	PageFactory.initElements(wu.getDriver(), this);
	}
	
	
	
	@FindBy(xpath="//input[@name='lastname']")
	private  WebElement lastName;
	public WebElement getLastName() {
		return lastName;
	}

	@FindBy(xpath="//input[@name='company']")
	private  WebElement companyName;
public WebElement getCompanyName() {
	return companyName;
}
	
	@FindBy(xpath="//input [@name='firstname']")
	private WebElement firstName;
	public WebElement getFirstName() {
		return firstName;
	}
	
	@FindBy(xpath="//input [@id='designation']")
    private WebElement title;
	public WebElement getTitle() {
		return title;
	}
	
	@FindBy(xpath="//select [@name='leadsource']")
	private WebElement leadsource;
	public WebElement getLeadsource() {
		return leadsource;
	}
	
	
	
	
	
	
	
	
	
	
}
