package com.neotech.lesson15;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.neotech.utils.CommonMethods;
import com.neotech.utils.ConfigsReader;

public class LogingWithAdvancedPath extends CommonMethods{

	public static void main(String[] args) throws InterruptedException {
		//https://hrm.neotechacademy.com/
		setUp();
		WebElement username = driver.findElement(By.xpath("//div[@class='input-field'][1]/input"));
		sendText(username, ConfigsReader.getProperty("username"));
		
		WebElement password = driver.findElement(By.xpath("//div[@class='input-field'][1]/following-sibling::div[1]/input"));
		sendText(password, ConfigsReader.getProperty("password"));
		
		WebElement loginBtn = driver.findElement(By.xpath("//following-sibling::div[1]/child::button"));
		//another example: //input[@id='txtPassword']/../following-sibling::div/button
		//another example: //div[@class='input-field'][1]/following-sibling::div[2]
		click(loginBtn);
		
		wait(2);
		
		
		
		
		
		
		tearDown();
		

	}

}
