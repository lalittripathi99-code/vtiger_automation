package com.evaa.vtiger.pages.OR;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.evaa.vtiger.pages.functionality.BasePage;
import com.evaa.vtiger.utils.WebUtil;

public class HomePageOR extends BasePage {

	private WebUtil wu;
	public HomePageOR(WebUtil wuObject) {
		super(wuObject);
		wu=wuObject;
		PageFactory.initElements(wu.getDriver(), this);
	}
	
	
	@FindBy(xpath="//input[@class='searchBox']")
	private WebElement searchBox;

	public WebElement getSearchBox() {
		return searchBox;
	}
	
	@FindBy(xpath="//a[text()='Calendar")
	private WebElement Calendar;
	public WebElement getCalendar() {
		return Calendar;
	}
	
	@FindBy(xpath="//a[text()='Leads']")
	private WebElement Leads;
	public WebElement getLeads() {
		return Leads;
	}
	
	@FindBy(xpath="//a[text()='Organizations']")
	private WebElement Organizations;
	public WebElement getOrganizations() {
		return Organizations;
	}
	
	@FindBy(xpath="//a[text()='Contacts']")
	private WebElement Contacts;
	public WebElement getContacts() {
		return Contacts;
	}
	
	@FindBy(xpath="//a[text()='Opportunities']")
	private WebElement Opportunities;
	public WebElement getOpportunities() {
		return Opportunities;
	}
	
	@FindBy(xpath="//a[text()='Products']")
	private WebElement Products;
	public WebElement getProducts() {
		return Products;
	}
	
	@FindBy(xpath="//a[text()='Documents']")
	private WebElement Documents;
	public WebElement getDocuments() {
		return Documents;
	}
	
	@FindBy(xpath="//a[text()='Email']")
	private WebElement Email;
	public WebElement getEmail() {
		return Email;
	}
	
	@FindBy(xpath="//a[text()='Trouble Tickets']")
	private WebElement TroubleTickets;
	public WebElement getTroubleTickets() {
		return TroubleTickets;
	}
	
	@FindBy(xpath="//a[text()='Dashboard']")
	private WebElement dashboard;
	public WebElement getDashboard() {
		return dashboard;
	}
	
}
