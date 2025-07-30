package com.advancedseleniumfunctions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.v138.network.model.ConnectionType;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.advancedseleniumfunctions.utilities.Utilities;

public class NetworkConditions {
	WebDriver driver;
	String url = "https://www.saucedemo.com/v1/index.html";
	
	@BeforeMethod
	public void setUp() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");		

		driver = new ChromeDriver(options);
	    
		
	}
	@Test
	public void geoLocationTest() throws InterruptedException {
		Utilities.setNetworkConditions(driver, false, ConnectionType.CELLULAR3G);
		long start = System.currentTimeMillis();
	    driver.get(url);
	    long end = System.currentTimeMillis();
	    System.out.println("Cargó en (ms): " + (end - start));
			
		
	}
	@AfterMethod
	public void tearDown() {
		driver.close();
		
	}
}
