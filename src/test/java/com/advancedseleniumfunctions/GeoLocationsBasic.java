package com.advancedseleniumfunctions;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.advancedseleniumfunctions.utilities.LocatorType;
import com.advancedseleniumfunctions.utilities.WaitUtilities;

@Listeners(extentreports.TestListener.class)
public class GeoLocationsBasic {
	WebDriver driver;
	String url = "https://www.gps-coordinates.net/my-location";
	
	@BeforeMethod
	public void setUp(ITestContext context) throws InterruptedException {

	    driver = GeoEnabledDriverFactory.createDriverWithLocationPermission();

	    context.setAttribute("WebDriver", driver);

	    GeoEnabledDriverFactory.setFakeLocation(driver, 35.8235, -78.8256);
	    driver.get(url);
	}
	@Test
	public void geoLocationTest() throws InterruptedException {
		List<WebElement> addressList = WaitUtilities.waitForListVisibilityByLocator(driver, 10, LocatorType.XPATH, "//div[@class='col-md-6']//p");
		Assert.assertTrue(addressList.size() > 0);
		Thread.sleep(3000);
		for(WebElement address : addressList) {
			System.out.println(address.getText());
			System.out.println("================");
			
		}
		Assert.assertTrue(addressList.get(1).getText().contains("NC"));
	}
	

	@AfterMethod
	public void tearDown() {
		driver.close();
		
	}
}
