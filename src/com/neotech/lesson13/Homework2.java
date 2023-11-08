package com.neotech.lesson13;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import com.google.common.io.Files;
import com.neotech.utils.CommonMethods;
import com.neotech.utils.ConfigsReader;

public class Homework2 extends CommonMethods {

	public static void main(String[] args) throws InterruptedException {

		/*
		 * Go to https://hrm.neotechacademy.com/ 
		 * Log in using our custom methods 
		 * Go to PIM menu 
		 * Add an employee 
		 * Go to Employee List 
		 * Get the list of the employees (Using tables - tr and td) 
		 * Loop to search for the employee you added 
		 * When you find the employee - click on it. 
		 * Take a screenshot
		 */
		
		
		setUp();
		
		//login
		sendText(driver.findElement(By.id("txtUsername")), 
				ConfigsReader.getProperty("username"));
		sendText(driver.findElement(By.id("txtPassword")),
				ConfigsReader.getProperty("password"));
		click(driver.findElement(By.xpath("//button[@type='submit']")));
		
		
		//navigate to PIM
		click(driver.findElement(By.id("menu_pim_viewPimModule")));
		
		
		//click on Add Employee
		click(driver.findElement(By.linkText("Add Employee")));
		
		//it took some time - might need to wait for it
		
	//	wait(2);
		
		waitForVisibility(driver.findElement(By.id("first-name-box")));
		
		//send new employee data		
		sendText(driver.findElement(By.id("first-name-box")), "ogulcan");
		sendText(driver.findElement(By.id("last-name-box")), "toprak");
		
		//select a dropdown element
		selectDropdown(driver.findElement(By.id("location")), "Australian Regional HQ");
		
		//get the employee id
		String empID = driver.findElement(By.id("employeeId")).getAttribute("value");
		
		System.out.println("Employee Id: " + empID);
		
		//click on save 
		click(driver.findElement(By.id("modal-save-button")));
		
		//wait for the employee to be added
		waitForVisibility(driver.findElement(By.id("pimPersonalDetailsForm")));
		
		
		//now lets go to employee list
		click(driver.findElement(By.linkText("Employee List")));
		
		
		boolean found = false;
		
		while(!found)
		{
			wait(2);
			
			//get all id's on the page
			List<WebElement> idList = driver.findElements(By.xpath("//table[@id='employeeListTable']/tbody/tr/td[2]"));
		
		//compare to find the id of the new employee
			for (WebElement el : idList)
			{
				if (el.getText().equals(empID))
				{
					found = true;
					el.click();
					break;
				}
			}
			
			
			//If I come at this point and the found is False, the employee is not on this page
			
			if (!found)//go to the next page
			{
				System.out.println("I will check on the next page!");
				click(driver.findElement(By.xpath("//i[text()='chevron_right']")));
			}
		
		
		}
		
		
		//wait for the personal details form to show
		
		waitForVisibility(driver.findElement(By.id("pimPersonalDetailsForm")));
		
		
		
		//take a screenshot
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		
		File sourceFile = ts.getScreenshotAs(OutputType.FILE);
		
		try {
			Files.copy(sourceFile, new File("screenshots/Lesson13/Homework2.png"));
		} catch (IOException e) {
			System.out.println("Screenshot was not saved....");
		}
		
		wait(2);
		

	
		
		
		
		tearDown();
	}

}
