package com.qa.tests;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.base.TestBase2;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;


public class LoginPageTest extends TestBase2 {
	Logger log = Logger.getLogger(LoginPageTest.class);
	WebDriver driver;
	LoginPage loginpage;
	
	public LoginPageTest(WebDriver driver){
		super(driver);
		System.out.println("------------");
		loginpage=new LoginPage(driver);
		this.driver=driver;
	}
	
	
	@Test
	public HomePage LoginTest() {
		loginpage.login("varunpatil03","github@123");
		return new HomePage();
	}

	

}
