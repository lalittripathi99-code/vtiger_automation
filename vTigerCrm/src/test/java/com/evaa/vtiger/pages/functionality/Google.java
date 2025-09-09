package com.evaa.vtiger.pages.functionality;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Google {
public static void main(String[] args) {
	WebDriver driver= new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
	driver.get("https:/www.google.com/");
	driver.findElement(By.xpath("//textarea[@id='APjFqb']")).sendKeys("phone");
	driver.findElement(By.xpath("//span/b[text()=' under 15000']")).click();
	
	
}
}
