package com.advancedseleniumfunctions;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.advancedseleniumfunctions.utilities.LocatorType;
import com.advancedseleniumfunctions.utilities.Utilities;
import com.advancedseleniumfunctions.utilities.WaitUtilities;

public class GeoLocationsShoppingCart {
	WebDriver driver;
	String url = "https://oldnavy.gap.com/stores";
	
	@BeforeMethod
	public void setUp() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");		

		driver = new ChromeDriver(options);
		
		Utilities.setCoordinatesAlternative(driver, 35.8235, -78.8256);
		//Utilities.setCoordinates(driver, 30.307982, -97.893803); //, TX
		driver.get(url);
		
	}
	@Test
	public void geoLocationTest() throws InterruptedException {
		List<WebElement> addressList = WaitUtilities.waitForListVisibilityByLocator(driver, 10, LocatorType.XPATH, "//div[@class='address']");
		Assert.assertTrue(addressList.size() > 0);
		
		for(WebElement address : addressList) {
			System.out.println(address.getText());
			System.out.println("================");
			
			Assert.assertTrue(address.getText().contains(", NC"));
			
		}
	}
	@AfterMethod
	public void tearDown() {
		driver.close();
		
	}
}
