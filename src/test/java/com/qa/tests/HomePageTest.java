package com.qa.tests;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.HomePage;
import com.qa.pages.LandingPage;
import com.qa.pages.LoginPage;

public class HomePageTest extends TestBase {
	
	
	Logger log = Logger.getLogger(LoginPageTest.class);
	protected WebDriver driver;
	LoginPage loginpage;
	HomePage homepage;
	LandingPage landingpage;
	
	@BeforeMethod
	public void init() throws InterruptedException, IOException {
		driver=initDriver();
		loginpage=new LoginPage(driver);
		//homepage=new HomePage(driver); // No need to initialize all the pages with driver since page classes are already doing it
		homepage=loginpage.login("varunpatil03", "github@123", "varunpatil03");
	}
	
	@Test
	public void clickMyRecord() throws InterruptedException, IOException {
		landingpage=homepage.clickLink();
		Thread.sleep(5000);
	}

}
