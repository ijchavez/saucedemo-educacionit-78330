package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import support.DriverManager;

public class CartPage {

    private WebDriver driver = DriverManager.getDriver();
    private static final By CHECKOUT_BUTTON = By.xpath("//a[@class = 'btn_action checkout_button']");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public CheckoutPage clickOnCheckoutButton() {
    	driver.findElement(CHECKOUT_BUTTON).click();

    	return new CheckoutPage(driver);
    	
    }
}
