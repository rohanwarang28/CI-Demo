package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase{
	
	@FindBy(xpath="//td[contains(text(),'Contacts')]")
	WebElement contactsBar;
	
	@FindBy(linkText="New Contact")
	WebElement NewContactLink;
	
	 @FindBy(xpath="//input[@type='text' and @id='first_name']")
	 WebElement fname;
	
	 @FindBy(xpath="//input[@type='text' and @id='surname']")
	 WebElement lname;
	 
	 @FindBy(xpath="//input[@type='text' and @name='client_lookup']")
	 WebElement companyName;
	
	 @FindBy(xpath="//input[@type='submit' and @value='Save']")
	 WebElement saveBtn;
	
	
	public ContactsPage() {
		
		PageFactory.initElements(driver, this);
	}
	
	
	public boolean contactsBar() {
		
		return contactsBar.isDisplayed();
	}
	
	public void createNewContact(String title,String firstname,String lastname,String company) {
		
		Select select=new Select(driver.findElement(By.name("title")));
		select.selectByVisibleText(title);
		fname.sendKeys(firstname);
		lname.sendKeys(lastname);
		companyName.sendKeys(company);
		saveBtn.click();
		
	}

}
