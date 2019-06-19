package com.qa.base;
import java.io.IOException;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.apache.log4j.Logger;

/**
 * This class creates WebDriver sessions.
 * @author varun.prakash.patil
 *
 */

public class TestBase2 {
	
	Logger log = Logger.getLogger(TestBase2.class);
	
	private WebDriver driver;
	
	public TestBase2(WebDriver driver) {
		this.driver=driver;
	}
	
	
	
	public WebDriver initDriver() throws InterruptedException, IOException {
		
		// browser name value passed from Jenkins
		String browserName = System.getProperty("browser");
		System.out.println("---------------------"+browserName);
		
		
		if (browserName == null)
			browserName = "chrome";
		
		else if(browserName.equalsIgnoreCase("Firefox")){
			System.setProperty("webdriver.chrome.driver", "browserdrivers\\geckodriver.exe");
			driver=new FirefoxDriver();
			driver.manage().window().maximize();
		}
		
		else if(browserName.equalsIgnoreCase("chrome")){
				System.setProperty("webdriver.chrome.driver", "browserdrivers\\chromedriver.exe");
				driver=new ChromeDriver();
				driver.manage().window().maximize();
			}
		
		return driver;
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}

