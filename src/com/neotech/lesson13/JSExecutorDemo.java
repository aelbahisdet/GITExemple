package com.neotech.lesson13;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.neotech.utils.CommonMethods;
import com.neotech.utils.ConfigsReader;

public class JSExecutorDemo extends CommonMethods {

	public static void main(String[] args) throws InterruptedException {
		// https://hrm.neotechacademy.com/

		
		
		setUp();
		
		WebElement username = driver.findElement(By.id("txtUsername"));
		WebElement password = driver.findElement(By.id("txtPassword"));
		
		sendText(username, ConfigsReader.getProperty("username"));
		sendText(password, ConfigsReader.getProperty("password"));
		
		wait(2);
		
		
		//create a JavascriptExecutor object
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		js.executeScript("arguments[0].style.backgroundColor='blue';"
				+ "arguments[1].style.backgroundColor='red';", username, password);
		
		wait(5);
		
		js.executeScript("arguments[0].click()", 
				driver.findElement(By.xpath("//button[@type='submit']")));
		
		//go to employee list
		//navigate to PIM
		click(driver.findElement(By.id("menu_pim_viewPimModule")));
				
		//click on Employee List
		click(driver.findElement(By.linkText("Employee List")));
		
		wait(4);
		
		//scroll with JS - using pixels ---> scroll down by 1500px
		js.executeScript("window.scrollBy(0, 1500)");
		
		//scrolling up
		js.executeScript("window.scrollBy(0,-100)");
		
		
		//scroll into view 
		
		WebElement home = driver.findElement(By.id("home-menu-trigger"));
		
		
		js.executeScript("arguments[0].scrollIntoView(true)", home);
		
		wait(5);
		
		tearDown();
	}

}
