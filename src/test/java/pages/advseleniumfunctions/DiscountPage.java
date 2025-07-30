package pages.advseleniumfunctions;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import support.DriverManager;

public class DiscountPage {
    private WebDriver driver = DriverManager.getDriver();

    private static final By MEMBERSHIP_DROPDOWN = By.id("membership");
    private static final By PURCHASE_AMOUNT_INPUT = By.id("purchaseAmount");
    private static final By PAYMENT_METHOD_DROPDOWN = By.id("paymentMethod");
    private static final By SPECIAL_PROMO_CHECKBOX = By.id("specialPromotion");
    private static final By CALCULATE_BUTTON = By.xpath("//button[contains(text(),'Calcular Descuento')]");
    private static final By RESULT_DIV = By.id("result");

    public DiscountPage(WebDriver driver) {
        this.driver = driver;
    }
    
    public void setMembership(String membership) {
        new Select(driver.findElement(MEMBERSHIP_DROPDOWN)).selectByValue(membership);
    }

    public void setPurchaseAmount(String amount) {
        driver.findElement(PURCHASE_AMOUNT_INPUT).clear();
        driver.findElement(PURCHASE_AMOUNT_INPUT).sendKeys(amount);
    }

    public void setPaymentMethod(String method) {
        new Select(driver.findElement(PAYMENT_METHOD_DROPDOWN)).selectByValue(method);
    }

    public void setSpecialPromotion(boolean enabled) {
        WebElement checkbox = driver.findElement(SPECIAL_PROMO_CHECKBOX);
        if (checkbox.isSelected() != enabled) {
            checkbox.click();
        }
    }

    public void clickCalculate() {
        driver.findElement(CALCULATE_BUTTON).click();
    }

    public String getDiscountResult() {
        return driver.findElement(RESULT_DIV).getText();
    }
}
