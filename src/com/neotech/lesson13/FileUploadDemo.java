package com.neotech.lesson13;

import org.openqa.selenium.By;

import com.neotech.utils.CommonMethods;

public class FileUploadDemo extends CommonMethods {

	public static void main(String[] args) throws InterruptedException {
		// https://the-internet.herokuapp.com/
		
		setUp();

		
		click(driver.findElement(By.linkText("File Upload")));
		
		String filePath = System.getProperty("user.dir") + "/screenshots/Lesson13/Homework2.png";
		
		sendText(driver.findElement(By.id("file-upload")), filePath);
		
		wait(4);
		
		click(driver.findElement(By.id("file-submit")));
		
		wait(4);
		
		tearDown();
			
	}

}
