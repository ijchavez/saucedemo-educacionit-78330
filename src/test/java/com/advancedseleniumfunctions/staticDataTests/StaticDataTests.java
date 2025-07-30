package com.advancedseleniumfunctions.staticDataTests;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.advancedseleniumfunctions.utilities.Utilities;

import constants.Constants;
import pages.advseleniumfunctions.StaticDataPage;
import support.DriverManager;

public class StaticDataTests {

    private static WebDriver driver;
    StaticDataPage staticDataPage;

    @BeforeMethod
    public void setUp() {
        DriverManager.initDriver();
        driver = DriverManager.getDriver();
        driver.get(Constants.NEOCITIES_URL + Constants.SELENIUM_TEST_PAGES_PATH  +  Constants.DATATABLE_PATH);
        
        staticDataPage = new StaticDataPage(driver);
    }

    @Test
    public void testFilter_0_20() {
        staticDataPage.selectAgeFilter("0-20");
        List<Integer> ages = staticDataPage.getVisibleAges();

        for (int i = 0; i < ages.size(); i++) {
            int age = ages.get(i);
            Assert.assertTrue(Utilities.AgeComparisson(0, 20, age), "Edad fuera de rango: " + age);
        }
    }

    @Test
    public void testFilter_21_40() {
        staticDataPage.selectAgeFilter("21-40");
        List<Integer> ages = staticDataPage.getVisibleAges();

        for (int i = 0; i < ages.size(); i++) {
            int age = ages.get(i);
            Assert.assertTrue(Utilities.AgeComparisson(21, 40, age), "Edad fuera de rango: " + age);
        }
    }

    @Test
    public void testFilter_41_55() {
        staticDataPage.selectAgeFilter("41-55");
        List<Integer> ages = staticDataPage.getVisibleAges();

        for (int i = 0; i < ages.size(); i++) {
            int age = ages.get(i);
            Assert.assertTrue(Utilities.AgeComparisson(41, 55, age), "Edad fuera de rango: " + age);
        }
    }

    @Test
    public void testFilter_60Plus() {
        staticDataPage.selectAgeFilter("60+");
        List<Integer> ages = staticDataPage.getVisibleAges();

        for (int i = 0; i < ages.size(); i++) {
            int age = ages.get(i);
            Assert.assertTrue(Utilities.AgeComparisson(60, age), "Edad fuera de rango: " + age);
        }
    }

    @Test
    public void testFilter_All() {
        staticDataPage.selectAgeFilter("all");
        List<Integer> ages = staticDataPage.getVisibleAges();

        Assert.assertTrue(ages.size() >= 17, "No se muestran todos los registros.");
    }

    
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
