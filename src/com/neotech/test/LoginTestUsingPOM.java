package com.neotech.test;

import com.neotech.pages.DashboardPage;
import com.neotech.pages.LoginPage;
import com.neotech.utils.CommonMethods;
import com.neotech.utils.ConfigsReader;

public class LoginTestUsingPOM extends CommonMethods {

	public static void main(String[] args) throws InterruptedException {
		// https://hrm.neotechacademy.com/
		setUp();

		// Lets locate the elements of the page
		LoginPage login = new LoginPage();

		// send the username
		sendText(login.username, ConfigsReader.getProperty("username"));

		// send the password
		sendText(login.password, ConfigsReader.getProperty("password"));

		// click the button
		login.loginBtn.click();

		// same thing using the click() in CommonMethods
		// click(login.loginBtn);

		wait(4);
		DashboardPage dashboard = new DashboardPage();
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

		wait(2);
		tearDown();
	}

}
