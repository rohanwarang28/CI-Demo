package com.crm.qa.testcases;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase{
	
	LoginPage loginpage;
	HomePage homepage;
	ContactsPage contactspage;
	
	public ContactsPageTest() {
		
		super();
	}
	
	@BeforeTest
	public void setUp() {
		
		initialization();
		
		loginpage=new LoginPage();
		contactspage=new ContactsPage();
		
		homepage=loginpage.Login(prop.getProperty("username"), prop.getProperty("password"));
	
	}
	
	
	@DataProvider
	public Object[][] getCRMTestData() throws IOException {
		
		Object data[][]=TestUtil.getTestData("D:\\my_newworkspace\\FreeCRMTestApp\\src\\main\\java\\com\\qa\\crm\\Testdata", "CRMTestData.xlsx", "Sheet1");
		return data;
	}
	
	@Test(dataProvider="getCRMTestData")
	public void validateCreateNewContact(String title,String fname,String lname,String company) {
		
		contactspage=homepage.clickContactLink();
		
		homepage.clickNewContactLink();
		
		contactspage.createNewContact(title,fname,lname,company);
	}
	
	
	@AfterTest
	public void tearDown() {
		
		driver.quit();
	}
	

}
