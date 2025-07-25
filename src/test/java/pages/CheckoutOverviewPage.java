package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import support.DriverManager;

public class CheckoutOverviewPage {

    private WebDriver driver = DriverManager.getDriver();
    private static final By FINISH_BUTTON = By.xpath("//a[@href='./checkout-complete.html']");
    
    public CheckoutOverviewPage(WebDriver driver) {
        this.driver = driver;
    }

    public FinishPage clickOnCheckoutButton() {
    	driver.findElement(FINISH_BUTTON).click();
    	return new FinishPage(driver);
    	
    }
    
}
