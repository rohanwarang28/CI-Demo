package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.crm.qa.util.TestUtil;

public class TestBase {

	
	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase() {
		
		prop = new Properties();
		FileInputStream ip;
		try {
			ip = new FileInputStream("D:\\my_newworkspace\\FreeCRMTestApp\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void initialization() {
		
		String browsername = prop.getProperty("browser");
		
		
		if(browsername.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver","C:\\Users\\SIT\\AppData\\Roaming\\npm\\node_modules\\chromedriver\\lib\\chromedriver"
					+ "\\chromedriver.exe");
		
			driver=new ChromeDriver();
			
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.pageLoadTime,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.implicitWait, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
		
	}
	
}
