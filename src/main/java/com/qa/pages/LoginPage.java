package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class LoginPage {
	
	WebDriver driver;
	
	//Page Factory - OR:
	@FindBy(name="login")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(name="commit")
	WebElement loginBtn;
	
	
	//Initializing the Page Objects:
	public LoginPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
	
	public HomePage login(String un, String pwd){
		driver.get("https://github.com/login");
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
		    	
		return new HomePage();
	}
	
}
