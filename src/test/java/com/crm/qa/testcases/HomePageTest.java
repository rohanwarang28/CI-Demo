package com.crm.qa.testcases;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class HomePageTest extends TestBase{

	LoginPage loginpage;

	HomePage homepage;
	
	ContactsPage contactspage;
	
	public HomePageTest() {
		
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginpage = new LoginPage();
		homepage = loginpage.Login(prop.getProperty("username"), prop.getProperty("password"));
		contactspage=new ContactsPage();
	}
	
	
	@Test
	public void validateHomePageTitle() {
		
		Assert.assertEquals(homepage.homePageTitle(), "CRMPRO");
	}
	
	@Test
	public void validateUsername() {
		
		driver.switchTo().frame("mainpanel");
		boolean unamedisp = homepage.username();
		Assert.assertTrue(unamedisp);
		
	}
	
	@Test
	public void verifyContactsLinkTest() {
		
		contactspage = homepage.clickContactLink();
		Assert.assertTrue(contactspage.contactsBar());
		//return contactspage;
	}
	

	
	@AfterMethod
	public void tearDown() {
		
		driver.quit();
	}
}
