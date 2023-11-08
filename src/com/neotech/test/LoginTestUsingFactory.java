package com.neotech.test;

import com.neotech.pages.DashboardPageUsingFactory;
import com.neotech.pages.LoginPageUsingFactory;
import com.neotech.utils.CommonMethods;
import com.neotech.utils.ConfigsReader;

public class LoginTestUsingFactory extends CommonMethods {

	public static void main(String[] args) throws InterruptedException {
		// https://hrm.neotechacademy.com/
		setUp();

		// At this point we are NOT locating the elements
		// We are telling how the elements will be located
		LoginPageUsingFactory login = new LoginPageUsingFactory();
		DashboardPageUsingFactory dashboard = new DashboardPageUsingFactory();

		// sending username
		sendText(login.username, ConfigsReader.getProperty("username"));

		// sending password
		sendText(login.password, ConfigsReader.getProperty("password"));

		// click the login button
		login.loginBtn.click();

		// Validate the logo after login

		if (dashboard.logo.isDisplayed()) {
			System.out.println("Test Passed!");
		} else {
			System.out.println("Test Failed!!!");
		}

		// Lets validate that "Jacqueline White" is displayed
		String expectedName = "Jacqueline White";
		String actualName = dashboard.name.getText();

		if (actualName.equals(expectedName)) {
			System.out.println(expectedName + " is displayed");
		} else {
			System.out.println(expectedName + " is not displayed!");
		}

		wait(3);
		tearDown();

	}

}
