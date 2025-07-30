package pages.advseleniumfunctions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import support.DriverManager;

public class LoginPage {

    private WebDriver driver = DriverManager.getDriver();

    private static final By USERNAME = By.id("username");
    private static final By PASSWORD = By.id("password");
    private static final By LOGIN_BUTTON = By.tagName("button");
    private static final By MESSAGE = By.id("message");

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

    public void clickLogin() {
        driver.findElement(LOGIN_BUTTON).click();
    }

    public String getMessageText() {
        return driver.findElement(MESSAGE).getText();
    }
}
