package com.advancedseleniumfunctions.productFilteringTests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.advseleniumfunctions.ProductFilteringPage;
import support.DriverManager;
import constants.Constants;

import java.util.List;

public class ProductFilteringTests {

    private static WebDriver driver;
    ProductFilteringPage productFilteringPage;

    @BeforeMethod
    public void setUp() {
        DriverManager.initDriver();
        driver = DriverManager.getDriver();
        driver.get(Constants.NEOCITIES_URL + Constants.SELENIUM_TEST_PAGES_PATH  +  Constants.DROPDOWN_TABLE_PATH);
        
        productFilteringPage = new ProductFilteringPage(driver);
    }

    @Test
    public void testFrutaFilter() {
    	productFilteringPage.selectCategory("fruta");
        List<String> names = productFilteringPage.getProductNames();
        Assert.assertTrue(names.contains("Manzana"));
        Assert.assertTrue(names.contains("Banana"));
    }

    @Test
    public void testVerduraFilter() {
    	productFilteringPage.selectCategory("verdura");
        List<String> names = productFilteringPage.getProductNames();
        Assert.assertTrue(names.contains("Zanahoria"));
        Assert.assertTrue(names.contains("Lechuga"));
    }
    
	@AfterMethod
	public void tearDown() {
		//driver.quit();
	}
	
}
