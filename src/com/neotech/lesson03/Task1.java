package com.neotech.lesson03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task1 {

	public final static String url = "https://www.facebook.com/";

	
	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get(url);
		
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("john123");
		driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("john123");
		
		//clicking on login button
		//1.  //button[@name='login']
		//2. //button[@type='submit']
		//3. //button[@id='u_0_5_mU'] ---> this is generated, next time I try to test might be different
		//4. //button[contains(@id, 'u_0')]
		
		driver.findElement(By.xpath("//button[contains(@id, 'u_0')]")).click();
		
		Thread.sleep(5000);
		
		driver.quit();
	}

}
