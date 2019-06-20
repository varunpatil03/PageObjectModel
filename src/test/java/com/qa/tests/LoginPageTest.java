package com.qa.tests;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qa.base.TestBaseWithThreadLocal;
import com.qa.extentreports.ExtentReporterNG;
import com.qa.base.TestBase;
import com.qa.pages.HomePage;
import com.qa.pages.LandingPage;
import com.qa.pages.LoginPage;

@Listeners(ExtentReporterNG.class)
public class LoginPageTest extends TestBase{
	
	

	Logger log = Logger.getLogger(LoginPageTest.class);
	protected WebDriver driver;
	LoginPage loginpage;
	HomePage homepage;
	LandingPage landingpage;
	
	public LoginPageTest(){
		
	}
	
	@BeforeMethod
	public void init() throws InterruptedException, IOException {
		driver=initDriver();
		loginpage=new LoginPage(driver);
	}
	
	@Test
	public void LoginTest() throws InterruptedException {
		homepage=loginpage.login("varunpatil03", "github@123");
		Thread.sleep(5000);
		Assert.assertFalse(true);
	}

	

}
