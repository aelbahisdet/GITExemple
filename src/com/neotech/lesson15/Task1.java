package com.neotech.lesson15;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.neotech.utils.CommonMethods;

public class Task1 extends CommonMethods{
	/*
	 * Go to https://the-internet.herokuapp.com/key_presses
Press TAB, ESC & ENTER
	 */

	public static void main(String[] args) throws InterruptedException {
		// https://the-internet.herokuapp.com/key_presses
		setUp();
		
WebElement searchBox = driver.findElement(By.id("target"));
		
		searchBox.sendKeys(Keys.ESCAPE);
		wait(2);
		
		searchBox.sendKeys(Keys.TAB);
		wait(2);
		
		
		searchBox.sendKeys("Test");
		
		searchBox.sendKeys(Keys.ENTER);
		
		wait(2);
		
		//key chaining
		//searchBox.sendKeys(Keys.TAB.ESCAPE.ENTER);
		
		
		
		tearDown();

	}

}
