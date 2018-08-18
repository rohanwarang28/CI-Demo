package com.crm.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{

	
	//page factory

	
	@FindBy(xpath = "//img[@alt='free crm logo']")
	WebElement logo;
	
	@FindBy(name = "username")
	WebElement uname;
	
	@FindBy(name = "password")
	WebElement pwd;
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement loginBtn;
	
	
	public LoginPage() {
		
		PageFactory.initElements(driver, this);
		
	}
	
	
	public String LoginPageTitle() {
		
		return driver.getTitle();
	}
	
	
	public boolean Logo() {
		
		return logo.isDisplayed();
	}
	
	public HomePage Login(String username,String password) {
		
		uname.sendKeys(username);
		pwd.sendKeys(password);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",loginBtn);
		
		return new HomePage();
		
	}
	
}
