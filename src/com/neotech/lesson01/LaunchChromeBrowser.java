package com.neotech.lesson01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LaunchChromeBrowser {

	public static void main(String[] args) throws InterruptedException {

	// we have added everything we need on the communication path
		//we added selenium language binding (Selenium Java Libs)
		//we added chromedriver
	//all we have to do now, is to use Selenium classes to call
		//the chromedriver and open/close the chrome browser
		
		//full path: C:\Users\sabah\eclipse-workspace\Selenium5\drivers\chromedriver.exe
		//relative path: drivers/chromedriver.exe
		
		
		//if java cannot find our chromedriver location
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe" );
		//which driver I want to use, where that is located
		
		//for mac users: "drivers/chromedriver
		
		//open the browser
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.neotechacademy.com/");
		//pause the execution for 5000 milliseconds -> 5 seconds
		Thread.sleep(5000);
		
		//close the browser
		driver.quit();
		
		
	//	driver.close();
	}

}
