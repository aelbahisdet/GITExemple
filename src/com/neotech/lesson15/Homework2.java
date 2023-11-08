package com.neotech.lesson15;

import com.neotech.pages.LoginPageUsingFactory;
import com.neotech.utils.CommonMethods;
import com.neotech.utils.ConfigsReader;

public class Homework2 extends CommonMethods {

	public static void main(String[] args) throws InterruptedException {
		/*
		 * TC 2: Orange HRM wrong password validation 
		 * 1. Go to https://hrm.neotechacademy.com/ 
		 * 2. Enter valid username and wrong password 
		 * 3. Click on login button 
		 * 4. Verify error message with text "Invalid credentials" is displayed
		 */
		
		
setUp();
		
		
		LoginPageUsingFactory loginPage = new LoginPageUsingFactory();
		
		sendText(loginPage.username, ConfigsReader.getProperty("username"));
		sendText(loginPage.password, "Wrong Password");
		
		wait(2);
		
	//	click(loginPage.loginBtn);
		
		jsClick(loginPage.loginBtn);
		
		
		wait(2);
		
		if(loginPage.invalidMsg.isDisplayed())
		{
			System.out.println("Test Passed!");
		}
		else
		{
			System.out.println("Test Failed!");
		}
		
		

		tearDown();
	}

}
