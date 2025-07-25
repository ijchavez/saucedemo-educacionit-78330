package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import support.DriverManager;

public class LoginPage {

    private WebDriver driver = DriverManager.getDriver();
 
    private static final By USERNAME = By.id("user-name");
    private static final By PASSWORD = By.id("password");
    private static final By LOGIN_BUTTON = By.id("login-button");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterUsername(String username) {
        driver.findElement(USERNAME).clear();
        driver.findElement(USERNAME).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(PASSWORD).clear();
        driver.findElement(PASSWORD).sendKeys(password);
    }

    public InventoryPage clickLogin() {
        driver.findElement(LOGIN_BUTTON).click();
        return new InventoryPage(driver);
        
    }
    public InventoryPage clickLogin(final String username, final String password) {
    	enterUsername(username);
    	enterPassword(password);
        driver.findElement(LOGIN_BUTTON).click();
        
        return new InventoryPage(driver);
        
    }
    
}
