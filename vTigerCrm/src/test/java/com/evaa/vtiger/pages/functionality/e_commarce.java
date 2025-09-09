package com.evaa.vtiger.pages.functionality;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.reactivex.rxjava3.functions.Action;

public class e_commarce {
// http://localhost:8888/index.php
	public static void main(String[] args)  {
		
	ChromeDriver	driver= new ChromeDriver();
		driver.get("https://www.redbus.in/");
	Actions act=	new Actions(driver);
		
		WebElement from=driver.findElement(By.xpath("//div[text()='From']"));

	act.moveToElement(from).click().build().perform();
	
driver.findElement(By.xpath("//div[text()='Delhi']")).click();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
WebElement to=driver.findElement(By.xpath("//div[text()='To']"));
act.moveToElement(to).sendKeys("Mumbai").build().perform();		

driver.findElement(By.xpath("//div[text()='Mumbai']")).click();



	}
	
	
	
	
	
	
	
	
	
}
