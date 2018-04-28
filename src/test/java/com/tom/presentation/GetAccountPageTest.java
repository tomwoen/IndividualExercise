package com.tom.presentation;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GetAccountPageTest {

	private static WebDriver driver;
	
	@Before
	public void setUp() {
		
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Thoma\\IdeaProjects\\geckodriver-v0.20.0-win64\\geckodriver.exe");
		driver = new FirefoxDriver(firefox);
	}
		
	
	@Test
	public void testGetAccountsUI() {
		
		driver.get("localhost:8080/accountapp/getpage.html");
		
		WebElement account = driver.findElement(By.id("1"));
		
		boolean display = account.isDisplayed();
		
		assertTrue(display);

	}
	
	@After
	public void tearDown() {
		
		driver.quit();
	}
	
}