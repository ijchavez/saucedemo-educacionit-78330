package pages.advseleniumfunctions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import support.DriverManager;

import java.util.ArrayList;
import java.util.List;

public class ProductFilteringPage {

    private WebDriver driver = DriverManager.getDriver();

    private static final By CATEGORY_DROPDOWN = By.id("category");
    private static final By PRODUCT_ROWS = By.cssSelector("#productTable tbody tr");
    private static final By NAME_CELL = By.cssSelector("td:nth-child(1)");
    private static final By PRICE_CELL = By.cssSelector("td:nth-child(2)");
    private static final By DETAIL_BUTTON = By.cssSelector("td:nth-child(3) button");

    public ProductFilteringPage(WebDriver driver) {
        this.driver = driver;
    }
    
    public void selectCategory(String category) {
        WebElement dropdown = driver.findElement(CATEGORY_DROPDOWN);
        Select select = new Select(dropdown);
        select.selectByValue(category);
    }

    public List<String> getProductNames() {
        List<String> names = new ArrayList<>();
        for (WebElement row : driver.findElements(PRODUCT_ROWS)) {
            names.add(row.findElement(NAME_CELL).getText());
        }
        return names;
    }

    public List<String> getProductPrices() {
        List<String> prices = new ArrayList<>();
        for (WebElement row : driver.findElements(PRODUCT_ROWS)) {
            prices.add(row.findElement(PRICE_CELL).getText());
        }
        return prices;
    }

    public void clickDetailButtonFor(String productName) {
        for (WebElement row : driver.findElements(PRODUCT_ROWS)) {
            String name = row.findElement(NAME_CELL).getText();
            if (name.equals(productName)) {
                row.findElement(DETAIL_BUTTON).click();
                break;
            }
        }
    }
}
