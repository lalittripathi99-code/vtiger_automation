package com.evaa.vtiger.utils;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.MoveTargetOutOfBoundsException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.UnexpectedTagNameException;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class WebUtil {

	// Generic methods or utility methods or wrapper methods\\
	private WebDriver driver;
	
	public WebDriver getDriver() {                            //getter method for webdriver
		return driver;
	}
    int i;
   private ExtentTest et=null;
   
  public WebUtil(ExtentTest et) {
	 this.et=et;
  }
  
   
   public ExtentTest getExtentTest(){
	   return et;
   }
   
   public void jsClick(WebElement we) {
	   JavascriptExecutor jse= (JavascriptExecutor) driver;
	   jse.executeScript("arguments[0].click();", we);
   }
   
  public void jsInputData(WebElement we, String value) {
	  JavascriptExecutor jse= (JavascriptExecutor) driver;
	  jse.executeScript("arguments[0].value='"+value+"'", we);
  }
   
 public void jsScrollByAmount(int x, int y) {
	 JavascriptExecutor jse=(JavascriptExecutor) driver;
	 jse.executeScript("window.scrollBy("+x+","+y+")");
 }
   
 public void jsScrollToBottom() {
	 JavascriptExecutor jse=(JavascriptExecutor) driver;
	 jse.executeScript("document.body.scrollHight");
 }  
   
 public void jsScrollToElement(WebElement we) {
	 JavascriptExecutor jse=(JavascriptExecutor) driver;
	 jse.executeScript("arguments[o].scrollIntoView(true);", we);
 }
   
   
   
   
   
   
   
   
   
   
   
   
	// **************************launch browser**********************************\\
	public void launchBrowser(String browserName) {
		if (browserName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
			et.log(Status.INFO, browserName + " browser launched successfully");
		} else if (browserName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
			et.log(Status.INFO, browserName + " browser launched successfully");
		} else if (browserName.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
			et.log(Status.INFO, browserName + " browser launched successfully");
		} else {
			et.log(Status.FAIL, browserName + " browser name is not matching. please cheack");
		}
	}

	// *************************open url *********************************\\

	public void openUrl(String url) {
		driver.get(url);
		et.log(Status.INFO, url + "\n" + " opened succesfully");
	}
	
	//*************************getTitle**************************\\
	public void getTitle () {
	String weTitle=	driver.getTitle();
	et.log(Status.INFO, weTitle+" is the title of current URL");
	}
	//********************get URL************************
	
	public void getURL () {
		String weURL=	driver.getCurrentUrl();
		et.log(Status.INFO, weURL+" is the title of current URL");
		}
	
	//**********************Get text******************\\
	public void getInnerText(WebElement we) {
		String innerText=we.getText();
		et.log(Status.INFO, innerText+" is find in inner text");
	}
	
	//***********************get attribute********************\\
	public void getAttributeValue(WebElement we,  String attributeName) {
	String attributeValue=	we.getAttribute(attributeName);
	et.log(Status.INFO, attributeValue+" is the value of "+attributeName);
	}
	
	//**************************is enable**********************\\
	public void validateElementIsEnable(WebElement we) {
	Boolean actualStatus=	we.isEnabled();
	if(actualStatus==true) {
		et.log(Status.PASS, "actual--"+actualStatus+" && expected "+true );
	}else {
		et.log(Status.FAIL, "actual--"+actualStatus+" && expected "+true );
	  }
	}
	
	public void validateElementIsDisable(WebElement we) {
		Boolean actualStatus=	we.isEnabled();
		if(actualStatus==false) {
			et.log(Status.PASS, "actual--"+actualStatus+" && expected "+false );
		}else {
			et.log(Status.FAIL, "actual--"+actualStatus+" && expected "+false);
		  }
		}
	
	public void validatePageTitle(String expectedTitle) {
		String actualTitle=driver.getTitle();
		if(actualTitle.equalsIgnoreCase(expectedTitle)) {
			et.log(Status.PASS, "actual--"+actualTitle+" && expected "+expectedTitle );
		}else {
			et.log(Status.FAIL, "actual--"+actualTitle+" && expected "+expectedTitle);
		  }
		}
	
	
	
	//**************************is displayed**********************\\
		public void validateElementIsVisible(WebElement we) {
		Boolean actualStatus=	we.isDisplayed();
		if(actualStatus==true) {
			et.log(Status.PASS, "actual--"+actualStatus+" && expected "+true );
		}else {
			et.log(Status.FAIL, "actual--"+actualStatus+" && expected "+true );
		  }
		}
	
		public void validateElementIsInvisible(WebElement we) {
			Boolean actualStatus=	we.isDisplayed();
			if(actualStatus==false) {
				et.log(Status.PASS, "actual--"+actualStatus+" && expected "+false);
			}else {
				et.log(Status.FAIL, "actual--"+actualStatus+" && expected "+false );
			  }
			}
		
		public void validateDropdownSelectedText(WebElement we, String expectedSelectedText) {
		Select select=	new Select(we);
		String actualSelectedText=select.getFirstSelectedOption().getText();
		if(actualSelectedText.equalsIgnoreCase(expectedSelectedText)) {
			et.log(Status.PASS, "actual--"+actualSelectedText+" && expected "+expectedSelectedText );
		}else {
			et.log(Status.FAIL, "actual--"+actualSelectedText+" && expected "+expectedSelectedText);
		  }
		}
		
		
		
		
		
		//**************************is selected**********************\\
		public void isSelectedStatus(WebElement we) {
		Boolean status=	we.isSelected();
		if(status==true) {
			et.log(Status.PASS, status+" is selected");
		}else {
			et.log(Status.FAIL, status+" is not selected");
		  }
		}
		
		//*******************Get size****************\\
		public void getSize(WebElement we, ExtentTest et) {
		org.openqa.selenium.Dimension size=	we.getSize();
	double hight=	size.getHeight();
	et.log(Status.INFO, hight+" is hight of element");
	double width= size.getWidth();
	et.log(Status.INFO, width+" is width of element");
		}
		//************************maximize*********************
		
		
		public void maximize () {
			driver.manage().window().maximize();
			et.log(Status.INFO, " page maximize done ");
			}
		//************************minimize*********************
		
		
				public void minimize () {
					driver.manage().window().minimize();
					et.log(Status.INFO, " page minimize done ");
					}
	//*********************set size***************************
				
				public void setSize(int width, int hight) {
			org.openqa.selenium.Dimension dim=new org.openqa.selenium.Dimension(width, hight);
			driver.manage().window().setSize(dim);
				}
				//*****************STATIC WAIT**********************
				
	public void staticWait(int timeInSeconds) {
		try {
			Thread.sleep(timeInSeconds*1000);
			et.log(Status.INFO, " static wait done");
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}
				
				
	//******************************IMPLICIT WAIT****************************\\
	
	public void implicitWait(int maxTime) {
		try {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(maxTime));
		et.log(Status.INFO, " implicit wait done");
		}catch(Exception e) {
			et.log(Status.INFO, e.getMessage()+ " timeOut exception occured");
		}
	}
	
	
	public void changePageLoadTimeout(int maxTime) {
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(maxTime));
	}
	
	
	
	
	
	//**********************************EXPLICIT WAIT********************\\
	
	public void explicitWaitforElementVisibility(WebElement we, int maxTime) {
	WebDriverWait wt=	new WebDriverWait(driver, Duration.ofMillis(maxTime));
	wt.until(ExpectedConditions.visibilityOf(we));
	}
	
	public void explicitWaitforElementInvisibility(WebElement we, int maxTime) {
		WebDriverWait wt=	new WebDriverWait(driver, Duration.ofMillis(maxTime));
		wt.until(ExpectedConditions.invisibilityOf(we));
		}
	
	public void explicitWaitforElementEnable(WebElement we, int maxTime) {
		WebDriverWait wt=	new WebDriverWait(driver, Duration.ofMillis(maxTime));
		wt.until(ExpectedConditions.elementToBeClickable(we));
		}
	
	public void explicitWaitforElementDisable(WebElement we, int maxTime) {
		WebDriverWait wt=	new WebDriverWait(driver, Duration.ofMillis(maxTime));
		wt.until(ExpectedConditions.not(ExpectedConditions.elementToBeClickable(we)));
		}
	
	public void explicitWaitforTextInElement(WebElement we, int maxTime, String text) {
		WebDriverWait wt=	new WebDriverWait(driver, Duration.ofMillis(maxTime));
		wt.until(ExpectedConditions.textToBePresentInElement(we, text));
		}
	
	///*********************fluent wait***************************************\\
	
	public void fluentWaitPollingEvery(int maxTime) {
FluentWait flt=	new FluentWait<WebDriver>(driver);
flt.pollingEvery(Duration.ofMillis(maxTime));
	}
	
	
	public void fluentWaitWithTimeout(int maxTime) {
		FluentWait flt=	new FluentWait<WebDriver>(driver);
		flt.withTimeout(Duration.ofMillis(maxTime));
	}
	
	public void fluentWaitForIgnoringException() {
		FluentWait flt=	new FluentWait<WebDriver>(driver);
		flt.ignoring(NoSuchElementException.class);
	}
	
	
	
	
//************************close method*********************************\\
	public void closeCurrentBrowser(String elementName) {
		try {
			driver.close();
			et.log(Status.INFO, elementName + " closed sucessfully");
		} catch (Exception e) {
			et.log(Status.FAIL, e.getMessage() + elementName + " not closed");
		}
	}

//***********************Quit method*****************************\\
	public void closeAllBrowser(String elementName) {
		try {
			driver.quit();
			et.log(Status.INFO, elementName + " closed sucessfully");
		} catch (Exception e) {
			et.log(Status.FAIL, e.getMessage() + elementName + " not closed");
		}
	}

	// *******************************WebElement methods********************************* \\
	public WebElement getWebElement( String xpathValue, String elementName) {

		WebElement we = null;
		try {
			we = driver.findElement(By.xpath(xpathValue));
			et.log(Status.INFO, elementName + "\n" + "element found successfully");

		} catch (NullPointerException e) {
			driver.findElement(By.xpath("//input[@name='user_name']"));
			et.log(Status.INFO, e.getMessage() + "\n" + "webDriver object is null. please check");

		} catch (NoSuchElementException e) {
			et.log(Status.INFO, e.getMessage() + "\n" + elementName + " not found on the page. please check");

		} catch (InvalidSelectorException e) {
			et.log(Status.INFO, e.getMessage() + "\n" + elementName + " xpath or locator is incorrect. please check");

		} catch (Exception e) {
			et.log(Status.INFO, e.getMessage());
		}
		return we;

	}

	public void inputData(WebElement we, String elementName,  String value) {
		
		try {
			we.sendKeys(value);
			et.log(Status.INFO, value + " typed in" + "\n" + elementName + " successfully");
		} catch (NullPointerException e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].value='" + value + "'", we);
			et.log(Status.INFO, e.getMessage() + value + " typed in" + elementName + "successfully by javaScript");
		} catch (ElementClickInterceptedException e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].value='" + value + "'", we);
			et.log(Status.INFO, e.getMessage() + value + " typed in" + elementName + "successfully by javaScript");
		} catch (ElementNotInteractableException e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].value='" + value + "'", we);
			et.log(Status.INFO, e.getMessage() + value + " typed in" + elementName + "successfully by javaScript");
		} catch (StaleElementReferenceException e) {
			we.sendKeys(value);
			et.log(Status.INFO, e.getMessage() + "\n" + "staleElement exception found please check");
		} catch (Exception e) {
			et.log(Status.INFO, e.getMessage() + "\n" + "exception found please check");
		}

	}

	public void click(WebElement we , String elementName) {

		try {
			we.click();
			et.log(Status.INFO, elementName + "\n" + " clicked successfully");

		} catch (NullPointerException e) {
			e.getMessage();
		} catch (ElementClickInterceptedException e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click()", we);
			et.log(Status.INFO, e.getMessage() + elementName + "clicked by javaScript");
		} catch (ElementNotInteractableException e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click()", we);
			et.log(Status.INFO, e.getMessage() + elementName + "clicked by javaScript");
		} catch (StaleElementReferenceException e) {
			we.click();
			et.log(Status.INFO, e.getMessage());
		} catch (Exception e) {
			et.log(Status.INFO, e.getMessage());
		}
	}
	
	public void clickToAllElements(String xpath) {
	List<WebElement>	list=driver.findElements(By.xpath(xpath));
	for(WebElement we: list) {
		we.click();;
	  }
	et.log(Status.INFO, " succesfully clicked on all elements");
	}
	
	public List<String> getAllElementsText(String xpath) {
		List<WebElement>	list=driver.findElements(By.xpath(xpath));
		List<String> elementsTextList=	new ArrayList<String>();
		for(WebElement we: list) {
		String innerText=	we.getText();
			elementsTextList.add(innerText);
		  }
		return elementsTextList;
		}
	
	//*************************Frame**************************
	
	
	
	public void switchToFrame(int index) {
		driver.switchTo().frame(index);
	}
	
	public void switchToFrame(String nameOrId) {
		driver.switchTo().frame(nameOrId);
	}
	
	public void switchToFrame(WebElement we) {
		driver.switchTo().frame(we);
	}
	
	
	//******************VALIDATION**************************
	
	public void validateInnerText(WebElement we, String expectedText) {
		String actualText=we.getText();
		if(actualText.equalsIgnoreCase(expectedText)) {
			et.log(Status.PASS, "actual"+actualText+"expected"+expectedText);
		}else {
			et.log(Status.FAIL, "actual"+actualText+"expected"+expectedText);
		}
		
	}
	
	public void validateAttribute(WebElement we, String expectedAttribue, String attributeName) {
		String actualAttribute=we.getAttribute(attributeName);
		if(actualAttribute.equalsIgnoreCase(expectedAttribue)) {
			et.log(Status.PASS, "actual"+actualAttribute+"expected"+expectedAttribue);
		}else {
			et.log(Status.FAIL, "actual"+actualAttribute+"expected"+expectedAttribue);
		}
		
	}
	
	
	
	
	
	
	
	// ****************************Dropdown methods********************************\\
	
	
	

	public void dropdownSelectByVisibleText(WebElement we, String elementName, String visibleText) {

		try {
			Select DdSelect = new Select(we);
			DdSelect.selectByVisibleText(visibleText);
			et.log(Status.INFO, visibleText + "seleced by visible text");
		} catch (NoSuchElementException e) {
			et.log(Status.INFO, e.getMessage() + "\n" + elementName
					+ " the option or dropdown  not found on the page. please check");
		} catch (UnexpectedTagNameException e) {
			et.log(Status.INFO, e.getMessage() + "\n" + elementName + " element is not a select tag. please check");

		} catch (ElementNotInteractableException e) {
			et.log(Status.INFO, e.getMessage() + "\n" + elementName + " dropdownn not intractable yet. please check");

		} catch (StaleElementReferenceException e) {
			Select DdSelect = new Select(we);
			DdSelect.selectByVisibleText(visibleText);
			et.log(Status.INFO, e.getMessage() + "\n" + elementName + " stale element . please check");

		} catch (Exception e) {
			et.log(Status.INFO, e.getMessage());
		}

	}

	public void dropdownSelectByIndex(WebElement we, String elementName, int indexNumber) {

		try {
			Select DdSelect = new Select(we);
			DdSelect.selectByIndex(indexNumber);
			et.log(Status.INFO, indexNumber + "seleced by index number");
		} catch (NoSuchElementException e) {
			et.log(Status.INFO, e.getMessage() + "\n" + elementName
					+ " the option or dropdown  not found on the page. please check");
		} catch (UnexpectedTagNameException e) {
			et.log(Status.INFO, e.getMessage() + "\n" + elementName + " element is not a select tag. please check");

		} catch (ElementNotInteractableException e) {
			et.log(Status.INFO, e.getMessage() + "\n" + elementName + " dropdownn not intractable yet. please check");

		} catch (StaleElementReferenceException e) {
			Select DdSelect = new Select(we);
			DdSelect.selectByIndex(indexNumber);
			et.log(Status.INFO, e.getMessage() + "\n" + elementName + " stale element . please check");

		} catch (Exception e) {
			et.log(Status.INFO, e.getMessage());
		}

	}

	public void dropdownSelectByValueAttribute(WebElement we, String elementName,
			String attributeValue) {

		try {
			Select DdSelect = new Select(we);
			DdSelect.selectByValue(attributeValue);
			et.log(Status.INFO, attributeValue + "seleced by value of value attribute");
		} catch (NoSuchElementException e) {
			et.log(Status.INFO, e.getMessage() + "\n" + elementName
					+ " the option or dropdown  not found on the page. please check");
		} catch (UnexpectedTagNameException e) {
			et.log(Status.INFO, e.getMessage() + "\n" + elementName + " element is not a select tag. please check");

		} catch (ElementNotInteractableException e) {
			et.log(Status.INFO, e.getMessage() + "\n" + elementName + " dropdownn not intractable yet. please check");

		} catch (StaleElementReferenceException e) {
			Select DdSelect = new Select(we);
			DdSelect.selectByValue(attributeValue);
			et.log(Status.INFO, e.getMessage() + "\n" + elementName + " stale element . please check");

		} catch (Exception e) {
			et.log(Status.INFO, e.getMessage());
		}

	}

	public void dropdownGetFirstSelectedOption(WebElement we,  String elementName) {

		try {
			Select DdSelect = new Select(we);
			WebElement selectedValue = DdSelect.getFirstSelectedOption();
			selectedValue.getText();
			et.log(Status.INFO,  "selected value");
		} catch (NoSuchElementException e) {
			et.log(Status.INFO, e.getMessage() + "\n" + elementName
					+ " the option or dropdown  not found on the page. please check");
		} catch (UnexpectedTagNameException e) {
			et.log(Status.INFO, e.getMessage() + "\n" + elementName + " element is not a select tag. please check");

		} catch (ElementNotInteractableException e) {
			et.log(Status.INFO, e.getMessage() + "\n" + elementName + " dropdownn not intractable yet. please check");

		} catch (Exception e) {
			et.log(Status.INFO, e.getMessage());
		}

	}

public void isMultipleDropdownStatus(WebElement we) {
Select sel=	new Select(we);
boolean status=sel.isMultiple();
if(status==true) {
	et.log(Status.INFO, " is multiple dropdown");
}else {
	et.log(Status.INFO, " is not multiple drropdown");
}
}	
	
	
	
	
	
	
	// *********************Actions class methods *******************************\\

	public void actionsMoveToElement(String xpath, String elementName) {
		Actions act = new Actions(driver);
		WebElement weAct = getWebElement(xpath, elementName);
		try {
			act.moveToElement(weAct).build().perform();
			et.log(Status.INFO, "move to element on " + elementName);
		} catch (NoSuchElementException e) {
			et.log(Status.INFO,
					e.getMessage() + "\n" + elementName + " no such element found on the page. please check");
		} catch (MoveTargetOutOfBoundsException e) {
			et.log(Status.INFO, e.getMessage() + "\n" + elementName
					+ " mouse move target is invalid due to size/location. please check");
		} catch (StaleElementReferenceException e) {
			et.log(Status.INFO, e.getMessage() + "\n" + elementName
					+ "the element is no longer i.e page is reloaded. please check ");
		} catch (ElementNotInteractableException e) {
			et.log(Status.INFO, e.getMessage() + "\n" + elementName + " element is hidden or disableed. please check");
		} catch (NullPointerException e) {
			et.log(Status.INFO, e.getMessage() + "\n" + elementName + " the webElement is null. please check");
		} catch (Exception e) {
			et.log(Status.INFO, e.getMessage());
		}

	}

	
	
	public void actionsClick(String elementName) {
		Actions act = new Actions(driver);

		try {
			act.click().build().perform();

			et.log(Status.INFO, "move to element on " + elementName);
		} catch (NoSuchElementException e) {
			et.log(Status.INFO,
					e.getMessage() + "\n" + elementName + " no such element found on the page. please check");
		} catch (MoveTargetOutOfBoundsException e) {
			et.log(Status.INFO, e.getMessage() + "\n" + elementName
					+ " mouse move target is invalid due to size/location. please check");
		} catch (StaleElementReferenceException e) {
			et.log(Status.INFO, e.getMessage() + "\n" + elementName
					+ "the element is no longer i.e page is reloaded. please check ");
		} catch (ElementNotInteractableException e) {
			et.log(Status.INFO, e.getMessage() + "\n" + elementName + " element is hidden or disableed. please check");
		} catch (NullPointerException e) {
			et.log(Status.INFO, e.getMessage() + "\n" + elementName + " the webElement is null. please check");
		} catch (Exception e) {
			et.log(Status.INFO, e.getMessage());
		}

	}

	public void actionsDoubleClick(WebElement weAct, String xpath, String elementName) {
		Actions act = new Actions(driver);
		
		try {
			act.doubleClick(weAct).build().perform();
			et.log(Status.INFO, "move to element on " + elementName);
		} catch (NoSuchElementException e) {
			et.log(Status.INFO,
					e.getMessage() + "\n" + elementName + " no such element found on the page. please check");
		} catch (MoveTargetOutOfBoundsException e) {
			et.log(Status.INFO, e.getMessage() + "\n" + elementName
					+ " mouse move target is invalid due to size/location. please check");
		} catch (StaleElementReferenceException e) {
			et.log(Status.INFO, e.getMessage() + "\n" + elementName
					+ "the element is no longer i.e page is reloaded. please check ");
		} catch (ElementNotInteractableException e) {
			et.log(Status.INFO, e.getMessage() + "\n" + elementName + " element is hidden or disableed. please check");
		} catch (NullPointerException e) {
			et.log(Status.INFO, e.getMessage() + "\n" + elementName + " the webElement is null. please check");
		} catch (Exception e) {
			et.log(Status.INFO, e.getMessage());
		}

	}

	public void actionsRightClick(String xpath, String elementName) {
		Actions act = new Actions(driver);
		WebElement weAct = getWebElement(xpath, elementName);
		try {
			act.contextClick(weAct).build().perform();
			et.log(Status.INFO, "move to element on " + elementName);
		} catch (NoSuchElementException e) {
			et.log(Status.INFO,
					e.getMessage() + "\n" + elementName + " no such element found on the page. please check");
		} catch (MoveTargetOutOfBoundsException e) {
			et.log(Status.INFO, e.getMessage() + "\n" + elementName
					+ " mouse move target is invalid due to size/location. please check");
		} catch (StaleElementReferenceException e) {
			et.log(Status.INFO, e.getMessage() + "\n" + elementName
					+ "the element is no longer i.e page is reloaded. please check ");
		} catch (ElementNotInteractableException e) {
			et.log(Status.INFO, e.getMessage() + "\n" + elementName + " element is hidden or disableed. please check");
		} catch (NullPointerException e) {
			et.log(Status.INFO, e.getMessage() + "\n" + elementName + " the webElement is null. please check");
		} catch (Exception e) {
			et.log(Status.INFO, e.getMessage());
		}

	}

	public void actionsSendKeys(WebElement weAct, String xpath, String elementName, String text) {
		Actions act = new Actions(driver);

		try {
			act.sendKeys(weAct, text).build().perform();
			et.log(Status.INFO, "move to element on " + elementName);
		} catch (NoSuchElementException e) {
			et.log(Status.INFO,
					e.getMessage() + "\n" + elementName + " no such element found on the page. please check");
		} catch (MoveTargetOutOfBoundsException e) {
			et.log(Status.INFO, e.getMessage() + "\n" + elementName
					+ " mouse move target is invalid due to size/location. please check");
		} catch (StaleElementReferenceException e) {
			et.log(Status.INFO, e.getMessage() + "\n" + elementName
					+ "the element is no longer i.e page is reloaded. please check ");
		} catch (ElementNotInteractableException e) {
			et.log(Status.INFO, e.getMessage() + "\n" + elementName + " element is hidden or disableed. please check");
		} catch (NullPointerException e) {
			et.log(Status.INFO, e.getMessage() + "\n" + elementName + " the webElement is null. please check");
		} catch (Exception e) {
			et.log(Status.INFO, e.getMessage());
		}

	}

}
