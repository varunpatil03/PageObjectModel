package com.qa.pages;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBaseWithThreadLocal;
import com.qa.base.TestBase;



public class LoginPage extends TestBase{
	Logger log = Logger.getLogger(LoginPage.class);
	private WebDriver driver;
	
	//Page Factory - OR:
	@FindBy(name="login")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(name="commit")
	WebElement loginBtn;
	
	
	//Initializing the Page Objects:
	public LoginPage(WebDriver driver) throws InterruptedException, IOException{
		
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	//Actions:
	
	public HomePage login(String un, String pwd){
		driver.get("https://github.com/login");
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();   	
		return new HomePage(driver);
	}
	
}
