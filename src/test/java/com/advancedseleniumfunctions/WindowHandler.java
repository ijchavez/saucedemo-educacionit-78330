package com.advancedseleniumfunctions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class WindowHandler {
	public WebDriver driver;

	@Test
	public void getWindowHandlingTest() throws InterruptedException {
        driver = new ChromeDriver();
		driver.get("https://www.google.com/"); 
		driver.switchTo().newWindow(WindowType.TAB); 
		Thread.sleep(1000);
		driver.navigate().to("https://www.softwaretestingmaterial.com/");
		driver.switchTo().newWindow(WindowType.TAB); 
		Thread.sleep(1000);
		driver.navigate().to("https://www.saucedemo.com/v1/index.html");
		
		List<String> tabs = new ArrayList<>(driver.getWindowHandles());
		
		for (String ventana : tabs) { 
			driver.switchTo().window(ventana);
			System.out.println(ventana);
			Thread.sleep(1500);
			System.out.println("Título de la ventana actual: " + driver.getTitle());
			
		}
	}
	
	@Test
	public void windownHandlingTest() throws InterruptedException {
        driver = new ChromeDriver();
		driver.get("https://www.google.com/"); 
		driver.switchTo().newWindow(WindowType.TAB); 
		Thread.sleep(1000);
		driver.navigate().to("https://www.softwaretestingmaterial.com/");
		driver.get("https://www.google.com/"); 
		Thread.sleep(1000);
		driver.switchTo().newWindow(WindowType.WINDOW); 
		Thread.sleep(1000);
		driver.navigate().to("https://www.softwaretestingmaterial.com/");

	}
	

}
