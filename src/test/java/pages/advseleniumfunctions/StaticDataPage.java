package pages.advseleniumfunctions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import support.DriverManager;

import java.util.ArrayList;
import java.util.List;

public class StaticDataPage {

    private WebDriver driver = DriverManager.getDriver();

    private static final By AGE_DROPDOWN = By.id("ageFilter");
    private static final By TABLE_ROWS = By.cssSelector("#staticTable tbody tr");

    public StaticDataPage(WebDriver driver) {
        this.driver = driver;
    }
    
    public void selectAgeFilter(String ageFilter) {
        WebElement dropdown = driver.findElement(AGE_DROPDOWN);
        Select select = new Select(dropdown);
        select.selectByValue(ageFilter);
    }
    
    public List<Integer> getVisibleAges() {
        List<Integer> ages = new ArrayList<>();
        List<WebElement> rows = driver.findElements(TABLE_ROWS);

        for (int i = 0; i < rows.size(); i++) {
            WebElement row = rows.get(i);
            if (row.isDisplayed()) {
                List<WebElement> cells = row.findElements(By.tagName("td"));
                String ageText = cells.get(1).getText();
                int age = Integer.parseInt(ageText);
                ages.add(age);
            }
        }

        return ages;
    }

}
