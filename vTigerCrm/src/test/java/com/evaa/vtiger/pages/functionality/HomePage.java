package com.evaa.vtiger.pages.functionality;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.evaa.vtiger.pages.OR.HomePageOR;
import com.evaa.vtiger.utils.WebUtil;

public class HomePage extends HomePageOR {
	public static WebUtil wu=null;
	public HomePage(WebUtil wuObject) {
		super(wuObject);
	wu=wuObject;
	//PageFactory.initElements(wu.getDriver(), this);
	}
	
//	@FindBy(xpath="//input[@class='searchBox']")
//	public WebElement searchBox;
//	
//	@FindBy(xpath="//a[text()='Calendar")
//	public WebElement Calendar;
//	
//	@FindBy(xpath="//a[text()='Leads']")
//	public WebElement Leads;
//	
//	@FindBy(xpath="//a[text()='Organizations']")
//	public WebElement Organizations;
//	
//	@FindBy(xpath="//a[text()='Contacts']")
//	public WebElement Contacts;
//	
//	@FindBy(xpath="//a[text()='Opportunities']")
//	public WebElement Opportunities;
//	
//	@FindBy(xpath="//a[text()='Products']")
//	public WebElement Products;
//	
//	@FindBy(xpath="//a[text()='Documents']")
//	public WebElement Documents;
//	
//	@FindBy(xpath="//a[text()='Email']")
//	public WebElement Email;
//	
//	@FindBy(xpath="//a[text()='Trouble Tickets']")
//	public WebElement TroubleTickets;
//	
//	@FindBy(xpath="//a[text()='Dashboard']")
//	public WebElement dashboard;
	public void searchBox() {
		//WebElement weSearchBoxLink=	wu.getWebElement("//input[@class='searchBox']", " search box");
		wu.inputData(getSearchBox(), "search box", "lalit");
		}
	
	public void goToCalender() {
	//WebElement weCalendarLink=	wu.getWebElement("//a[text()='Calendar", "Calendar");
	wu.click(getCalendar(), "calendar module");
	}
	public void goToLeadsPage() {
	//WebElement weLeadsLink=	wu.getWebElement("//a[text()='Leads']", "Leads");
		wu.click(getLeads(), "Leads module");
	}
	public void goToOrganizationPage() {
			//WebElement weOrganizationLink=	wu.getWebElement("//a[text()='Organizations']", "Organization Module");
			wu.click(getOrganizations(), "Organization module");
			}
	public void goToContacts() {
	//	WebElement weContactsLink=	wu.getWebElement("//a[text()='Contacts']", " Contacts");
		wu.click(getContacts(), " contacts module");
		}
		
	public void goToOpportunities() {
		//WebElement weOpportunitiesLink=	wu.getWebElement("//a[text()='Opportunities']", "Opportunities");
		wu.click(getOpportunities(), "Opportunities module");
		}
	
	public void goToProducts() {
		//WebElement weProductsLink=	wu.getWebElement("//a[text()='Products']", "Products");
		wu.click(getProducts(), "Products module");
		}
	
	public void goToDocuments() {
		//WebElement weDocumentsLink=	wu.getWebElement("//a[text()='Documents']", " Documents");
		wu.click(getDocuments(), " Documents module");
		}
	public void goToEmail() {
		//WebElement weEmailLink=	wu.getWebElement("//a[text()='Email']", " Email");
		wu.click(getEmail(), " Email module");
		}
	
	public void goToTroubleTickets() {
		//WebElement weTroubleTicketsLink=	wu.getWebElement("//a[text()='Trouble Tickets']", " Trouble Tickets");
		wu.click(getTroubleTickets(), " Trouble Tickets module");
		}
	
	public void goToDashboard() {
		//WebElement weDashboardLink=	wu.getWebElement("//a[text()='Dashboard']", " Dashboard");
		wu.click(getDashboard(), " Dashboard module");
		}
//	public void moveToMore() {
	//	wu.actionsMoveToElement("//a[text()='More'", "More Link");
	//}
	public void goToCampaignsPage() {
		wu.actionsMoveToElement("//a[text()='More'", "More Link");
		WebElement weCampaignsLink=	wu.getWebElement("//a[text()='Campaigns']", "Campaigns Module");
			wu.click(weCampaignsLink, "Campaigns module");

		}
		
		
}
