package com.neotech.lesson07;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.neotech.utils.BaseClass;

public class Homework3 extends BaseClass {

	public static void main(String[] args) throws InterruptedException {
//        Open chrome browser
//        Go to "https://semantic-ui.com/modules/dropdown.html"
//        Scroll down to "Multiple Selection"
//        Click on drop down and select "CSS" and "HTML"
//        Verify value has been selected
//        Deselect 1 of the options from the dropdown
//        Quit browser

		setUp();

		Thread.sleep(1000);

		driver.findElement(By.xpath("//div[@data-tab='definition']/div[8]/div")).click();
		Thread.sleep(2000);

		// Click on CSS
		driver.findElement(By.xpath("//div[@data-tab='definition']//div[text()='CSS']")).click();
		Thread.sleep(3000);

		// Click on HTML
		driver.findElement(By.xpath("//div[@data-tab='definition']//div[text()='HTML']")).click();
		Thread.sleep(3000);

		// Verify that CSS has been selected
		WebElement element = driver.findElement(By.xpath("//div[@data-tab='definition']/div[8]/div/a[1]"));
		String txt = element.getText();

		if (txt.equals("CSS")) {
			System.out.println("Test passed!");
		} else {
			System.out.println("Test failed!");
		}

		// Remove the CSS option
		driver.findElement(By.xpath("//a[@data-value='css']/i")).click();
		Thread.sleep(3000);

		tearDown();

	}

}
