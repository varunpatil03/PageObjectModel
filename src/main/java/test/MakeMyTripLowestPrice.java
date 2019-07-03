package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MakeMyTripLowestPrice {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\varun.prakash.patil\\Documents\\Preparation 3.0\\chromedriver_win32\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		//driver.manage().deleteAllCookies();
		driver.get("https://www.makemytrip.com/flight/search?itinerary=BOM-DEL-05/07/2019&tripType=O&paxType=A-1_C-0_I-0&intl=false&=&cabinClass=E");
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		List<WebElement> list=new ArrayList<WebElement>();
		Thread.sleep(5000);
		driver.switchTo().frame("webpush-bubble");
		driver.findElement(By.xpath("//button[@id='deny']")).click();
		System.out.println("-------------");
		driver.switchTo().defaultContent();
		
		list=driver.findElements(By.xpath("//div[@class='fli-list-body-section']//span[@class='actual-price']//span[@class='INR']/parent::span"));
		
		for(WebElement element: list) {
			System.out.println(element.getText().replaceAll("Rs ", "").replaceAll(",", ""));
		}
		
		lowestPrice(list, driver);
		
		

	}
	
	public static void lowestPrice(List<WebElement> a, WebDriver driver) {
		List<Integer> price=new ArrayList<>();
		for(WebElement element: a) {
			price.add(Integer.valueOf(element.getText().replaceAll("Rs ", "").replaceAll(",", "")));
		}
		
		Collections.sort(price);
		String lowestprice=price.get(0).toString();
		lowestprice=lowestprice.substring(0, 1)+","+lowestprice.substring(1, 4);
		System.out.println("Clicking element:"+lowestprice);
		driver.findElement(By.xpath("//div[@class='fli-list-body-section']//span[@class='actual-price']//span[@class='INR']/parent::span[text()='"+lowestprice+"']/parent::span/parent::p/parent::div/following-sibling::div/button")).click();
		
		}
		
		
	}
