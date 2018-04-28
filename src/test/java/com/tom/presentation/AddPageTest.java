package com.tom.presentation;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddPageTest {

	private static WebDriver driver;
	
	@Before
	public void setUp() {
		
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Thoma\\IdeaProjects\\geckodriver-v0.20.0-win64\\geckodriver.exe");
		driver = new FirefoxDriver(firefox);
		
	}
	
	@Test
	public void testAddAccountThroughUI() throws InterruptedException {
		
		driver.get("localhost:8080/account-app/addpage.html");
		
		WebElement firstName = driver.findElement(By.id("fname"));
		firstName.sendKeys("Tom");
		
		WebElement lastName = driver.findElement(By.id("lname"));
		lastName.sendKeys("Owen");
		
		WebElement accNumber = driver.findElement(By.id("accNo"));
		accNumber.sendKeys("1234");
		
		WebElement submit = driver.findElement(By.xpath("/html/body/div[2]/form/input"));
		submit.click();
		
		Thread.sleep(2000);
		
		WebElement receipt = driver.findElement(By.id("receipt"));
		boolean display = receipt.isDisplayed();
		
		assertTrue(display);
	}
	
	@After
	public void tearDown () {
		
		driver.quit();
	}

}
