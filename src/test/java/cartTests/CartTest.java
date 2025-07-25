package cartTests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import pages.CartPage;
import pages.CheckoutOverviewPage;
import pages.CheckoutPage;
import pages.FinishPage;
import pages.InventoryPage;
import pages.LoginPage;
import support.DriverManager;

public class CartTest {
    private WebDriver driver;
    private LoginPage loginPage;
    private InventoryPage inventoryPage;
    private CartPage cartPage;
    private CheckoutPage checkoutPage;
    private CheckoutOverviewPage checkoutOverviewPage;
    private FinishPage finishPage;
    
    Faker faker;
    
    @BeforeMethod
    public void setUp() {
        DriverManager.initDriver();
        driver = DriverManager.getDriver();
        driver.get("https://www.saucedemo.com/v1/index.html");

        loginPage = new LoginPage(driver);
        inventoryPage = loginPage.clickLogin("standard_user", "secret_sauce");
        faker = new Faker();
        
    }
    
    @Test
    public void cartTest() {
    	inventoryPage.addProductToCartByName("Sauce Labs Backpack");
    	
    	cartPage = inventoryPage.clickOnShoppingCartIcon();
    	
    	checkoutPage = cartPage.clickOnCheckoutButton();
    	checkoutPage.fillCheckoutFirstName(faker.name().firstName());
    	checkoutPage.fillCheckoutLastName(faker.name().lastName());
    	checkoutPage.fillCheckoutZipCode(faker.address().zipCode());
    	
    	checkoutOverviewPage = checkoutPage.clickOnCheckoutButton();
    	
    	finishPage = checkoutOverviewPage.clickOnCheckoutButton();
    	
    	finishPage.checkCompleteHeader("THANK YOU FOR YOUR ORDER");
    	finishPage.checkCompleteText("Your order has been dispatched, and will arrive just as fast as the pony can get there!");
    	
    }
}
