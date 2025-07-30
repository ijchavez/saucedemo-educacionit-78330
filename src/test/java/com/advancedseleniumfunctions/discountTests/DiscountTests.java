package com.advancedseleniumfunctions.discountTests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.advseleniumfunctions.DiscountPage;
import support.DriverManager;
import constants.Constants;

public class DiscountTests {

    private static WebDriver driver;
    DiscountPage discountPage;

    @BeforeMethod
    public void setUp() {
        DriverManager.initDriver();
        driver = DriverManager.getDriver();
        driver.get(Constants.NEOCITIES_URL + Constants.DISCOUNT_PATH);
        discountPage = new DiscountPage(driver);
    }

    @Test
    public void testSpecialPromotion() {
        discountPage.setMembership("regular");
        discountPage.setPurchaseAmount("100");
        discountPage.setPaymentMethod("credit");
        discountPage.setSpecialPromotion(true);
        discountPage.clickCalculate();

        Assert.assertTrue(discountPage.getDiscountResult().contains("15%"));
    }

    @Test
    public void testPremiumWithPaypal() {
        discountPage.setMembership("premium");
        discountPage.setPurchaseAmount("100");
        discountPage.setPaymentMethod("paypal");
        discountPage.setSpecialPromotion(false);
        discountPage.clickCalculate();

        Assert.assertTrue(discountPage.getDiscountResult().contains("12%"));
    }

    @Test
    public void testRegularOver500Paypal() {
        discountPage.setMembership("regular");
        discountPage.setPurchaseAmount("600");
        discountPage.setPaymentMethod("paypal");
        discountPage.setSpecialPromotion(false);
        discountPage.clickCalculate();

        Assert.assertTrue(discountPage.getDiscountResult().contains("7%"));
    }

    @Test
    public void testPremiumNoPaypal() {
        discountPage.setMembership("premium");
        discountPage.setPurchaseAmount("100");
        discountPage.setPaymentMethod("credit");
        discountPage.setSpecialPromotion(false);
        discountPage.clickCalculate();

        Assert.assertTrue(discountPage.getDiscountResult().contains("10%"));
    }

    @Test
    public void testRegularOver500NoPaypal() {
        discountPage.setMembership("regular");
        discountPage.setPurchaseAmount("600");
        discountPage.setPaymentMethod("credit");
        discountPage.setSpecialPromotion(false);
        discountPage.clickCalculate();

        Assert.assertTrue(discountPage.getDiscountResult().contains("5%"));
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
