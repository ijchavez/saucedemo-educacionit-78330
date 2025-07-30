package com.advancedseleniumfunctions.orderstatetests;

import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.WebDriver;
import pages.advseleniumfunctions.OrderStatePage;
import support.DriverManager;
import constants.Constants;

public class OrderStateTests {

    private WebDriver driver;
    private OrderStatePage orderStatePage;
    private static final String PROCESSING = "Processing";
    private static final String SHIPPED = "Shipped";
    private static final String DELIVERED = "Delivered";
    private static final String CANCELLED = "Cancelled";
    private static final String INVALID_TRANSITION = "Invalid transition";

    @BeforeMethod
    public void setUp() {
        DriverManager.initDriver();
        driver = DriverManager.getDriver();
        driver.get(Constants.NEOCITIES_URL + Constants.STATE_PATH);
        orderStatePage = new OrderStatePage(driver);
    }

    @Test
    public void testValidTransition_PendingToProcessing() {
        orderStatePage.clickConfirmPayment();
        
        Assert.assertEquals(orderStatePage.getOrderStatus(), PROCESSING);
        Assert.assertFalse(orderStatePage.isErrorVisible());
    }

    @Test
    public void testValidTransition_ProcessingToShipped() {
        orderStatePage.clickConfirmPayment();
        orderStatePage.clickMarkAsShipped();
        
        Assert.assertEquals(orderStatePage.getOrderStatus(), SHIPPED);
        Assert.assertFalse(orderStatePage.isErrorVisible());
    }

    @Test
    public void testValidTransition_ShippedToDelivered() {
        orderStatePage.clickConfirmPayment();
        orderStatePage.clickMarkAsShipped();
        orderStatePage.clickMarkAsDelivered();
        
        Assert.assertEquals(orderStatePage.getOrderStatus(), DELIVERED);
        Assert.assertFalse(orderStatePage.isErrorVisible());
    }

    @Test
    public void testValidTransition_PendingToCancelled() {
        orderStatePage.clickCancelOrder();
        
        Assert.assertEquals(orderStatePage.getOrderStatus(), CANCELLED);
        Assert.assertFalse(orderStatePage.isErrorVisible());
    }

    @Test
    public void testInvalidTransition_PendingToDelivered() {
        orderStatePage.clickMarkAsDelivered();
        
        Assert.assertTrue(orderStatePage.isErrorVisible());
        Assert.assertTrue(orderStatePage.getErrorMessage().contains(INVALID_TRANSITION));
    }

    @Test
    public void testInvalidTransition_ProcessingToDelivered() {
        orderStatePage.clickConfirmPayment();
        orderStatePage.clickMarkAsDelivered();
        
        Assert.assertTrue(orderStatePage.isErrorVisible());
        Assert.assertTrue(orderStatePage.getErrorMessage().contains(INVALID_TRANSITION));
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
