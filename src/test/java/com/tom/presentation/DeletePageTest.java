package com.tom.presentation;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;

public class DeletePageTest {

	private static WebDriver driver;
	
	@Before
	public void setUp() {
		
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Thoma\\IdeaProjects\\geckodriver-v0.20.0-win64\\geckodriver.exe");
		driver = new FirefoxDriver(firefox);
	}
	
	@Test
	public void testDeleteThroughUI() throws InterruptedException {
		
		driver.get("localhost:8080/accountapp/getpage.html");
		
		WebElement delete = driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/th[5]/button"));
		
		delete.click();
		
		Thread.sleep(2000);
		
		WebElement receipt = driver.findElement(By.id("receipt"));
		
		Boolean display = receipt.isDisplayed();
		
		assertTrue(display);
		
	}
	
	@After
	public void tearDown() {
		
		driver.quit();
	}

}
