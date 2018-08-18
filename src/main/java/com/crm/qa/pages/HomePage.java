package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase{
	
	@FindBy(xpath="//td[contains(text(),'User: rohan warang')]")
	WebElement headerText;
	
	@FindBy(partialLinkText="CONTACTS")
	WebElement contactsLink;
    
	@FindBy(linkText="New Contact")
	WebElement newContactlink;
	
	public HomePage() {
		
		PageFactory.initElements(driver, this);
	
	}
	
	public String homePageTitle() {
		
		return driver.getTitle();
	}
	
	
	public boolean username() {
	
		return headerText.isDisplayed();
	}
	
	
	public ContactsPage clickContactLink() {

		driver.switchTo().frame("mainpanel");

		contactsLink.click();
		
		return new ContactsPage();	
	}
	
	public void clickNewContactLink() {
	
		
		Actions action =new Actions(driver);
		action.moveToElement(contactsLink).build().perform();
	    newContactlink .click();
		
		
	}
	
	
	
}
