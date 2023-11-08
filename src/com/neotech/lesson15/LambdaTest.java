package com.neotech.lesson15;

import com.neotech.pages.LambdaRegisterPage;
import com.neotech.utils.CommonMethods;

public class LambdaTest extends CommonMethods{
	/*
	 * Go to https://accounts.lambdatest.com/register Find the Password Element and
	 * enter a password Find the Show span as a nephew of the password element and
	 * click on it Find the Business Email as a cousin of the password element and
	 * enter an email Close the browser
	 */
	
	//For this task, create two classes: LambdaTest, LambdaRegisterPage
	//Use POM in the Register page.
	//Don't find any of the elements on the LambdaTest page!!!
	/*
	 * //there are two ways how to deal with this task: 
		//1. Solve the task on the LambdaTest.java (including the elements) and then 
		//take the elements to the LambdaRegisterPage.java
		
		//2. Go step by step, find an element, add it directly to LambdaRegisterPage.java
		//then use it in LambdaTest ....
	 */

	public static void main(String[] args) throws InterruptedException {
		// https://accounts.lambdatest.com/register
		
		setUp();
		LambdaRegisterPage register = new 
				LambdaRegisterPage();

		sendText(register.passwordBox,"test123");
		
		jsClick(register.show);
		
		sendText(register.businessEmail, "test123@gmail.com");

		wait(2);
		
		
		
		
		
		tearDown();

	}

}
