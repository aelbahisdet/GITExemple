package com.neotech.lesson12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.neotech.utils.CommonMethods;

public class ActionsClassDemo extends CommonMethods {

	public static void main(String[] args) throws InterruptedException {
		// https://www.amazon.com/
		
		
		setUp();
		
		Actions action = new Actions(driver);
		
		
		action.moveToElement(driver.findElement(
				By.id("nav-link-accountList-nav-line-1"))).perform();
		
		
		wait(5);
		
		WebElement el = driver.findElement(By.id("nav-flyout-ya-newCust"));
		
		if(el.getText().contains("Start"))
		{
			System.out.println("Menu was displayed!");
		}
		else
		{
			System.out.println("Menu was NOT displayed!");
		}
		
		
		//how do we perform a right click?
		action.contextClick(el).perform();
		
		wait(3);
		
		
		WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
		//go to the search box, click on it, send text, and double click
		action.moveToElement(searchBox).click()
		.sendKeys("iPhone 15").doubleClick().perform();
		
		//we can also perform the above statement in multiple lines
		//action.moveToElement(searchBox).click().sendKeys("iphone 15").perform();
		//wait(5);
		//action.doubleClick().perform();
		
		
		
		wait(5);
		
		tearDown();

	}

}
