package com.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	private WebDriver driver;
	LandingPage landingpage;
	
	//Page Factory - OR:
		@FindBy(linkText="Read the guide")
		WebElement link;
	
	
	public HomePage(WebDriver driver){
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	
	public LandingPage clickLink() throws InterruptedException, IOException{
		link.click();
		return new LandingPage(driver);
	}

}
