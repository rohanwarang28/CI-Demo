package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	
	LoginPage loginpage;
	HomePage homepage;

	public LoginPageTest() {
		
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		
		initialization();
		loginpage = new LoginPage();
	}
	
	
	
	@Test
	public void validateLoginPageTitle() {
		
		
		String title = loginpage.LoginPageTitle();
		Assert.assertEquals(title, "Free CRM software in the cloud powers sales and customer service");
		
	}
	
	@Test
	public void validateLoginPageLogo() {
		
		boolean logo = loginpage.Logo();
		Assert.assertEquals(logo, true);
	}
	
	
	@Test
	public void validateLogin() {
		
		homepage = loginpage.Login(prop.getProperty("username"),prop.getProperty("password"));
	}
	
	@AfterMethod
	public void tearDown() {
		
		driver.quit();
		
	}
}
