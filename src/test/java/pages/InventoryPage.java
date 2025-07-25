package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InventoryPage {

    private WebDriver driver;

    private static final By SHOPPING_CART_ICON = By.id("shopping_cart_container");
    private static final By ADD_TO_CART_BUTTON = By.cssSelector("button.btn_inventory");
    
    public InventoryPage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Agrega al carrito el producto según su nombre visible.
     * @param productName El nombre exacto del producto (case-sensitive)
     */
    public void addProductToCartByName(String productName) {
        String productXpath = String.format(
            "//div[@class='inventory_item'][.//div[@class='inventory_item_name' and text()='%s']]",
            productName
        );


        WebElement addToCartButton = 
        		utilities.WaitUtilities.waitForVisibility(
        				driver, 
        				15, 
        				driver.findElement(By.xpath(productXpath))).findElement(ADD_TO_CART_BUTTON);
        addToCartButton.click();
    }
    
    public CartPage clickOnShoppingCartIcon() {
    	driver.findElement(SHOPPING_CART_ICON).click();
    	
    	return new CartPage(driver);
    	
    }
}

