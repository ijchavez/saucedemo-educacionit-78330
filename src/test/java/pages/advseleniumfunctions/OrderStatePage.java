package pages.advseleniumfunctions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderStatePage {
    private WebDriver driver;

    private static final By ORDER_STATUS = By.id("order-status");
    private static final By MESSAGE_BOX = By.id("message-box");

    private static final By CONFIRM_PAYMENT_BUTTON = By.xpath("//button[text()='Confirm Payment']");
    private static final By CANCEL_ORDER_BUTTON = By.xpath("//button[text()='Cancel Order']");
    private static final By MARK_AS_SHIPPED_BUTTON = By.xpath("//button[text()='Mark as Shipped']");
    private static final By MARK_AS_DELIVERED_BUTTON = By.xpath("//button[text()='Mark as Delivered']");

    public OrderStatePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickConfirmPayment() {
        driver.findElement(CONFIRM_PAYMENT_BUTTON).click();
    }

    public void clickCancelOrder() {
        driver.findElement(CANCEL_ORDER_BUTTON).click();
    }

    public void clickMarkAsShipped() {
        driver.findElement(MARK_AS_SHIPPED_BUTTON).click();
    }

    public void clickMarkAsDelivered() {
        driver.findElement(MARK_AS_DELIVERED_BUTTON).click();
    }

    public String getOrderStatus() {
        return driver.findElement(ORDER_STATUS)
        		.getText()
        		.trim();
    }

    public String getErrorMessage() {
        return driver.findElement(MESSAGE_BOX)
        		.getText()
        		.trim();
    }

    public boolean isErrorVisible() {
        return !driver.findElement(MESSAGE_BOX)
        		.getAttribute("class")
        		.contains("hidden");
    }
}
