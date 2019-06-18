package com.qa.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;


public class LoginPageTest {
	
	WebDriver driver;
	LoginPage loginpage;
	
	public LoginPageTest() {
		driver=TestBase.getWebDriver();
		loginpage=new LoginPage(driver);
	}
	
	
	@Test
	public static HomePage LoginTest() {
		loginpage.login("varunpatil03","github@123");
		return new HomePage();
	}

	

}
