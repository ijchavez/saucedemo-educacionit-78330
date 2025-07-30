package stepdefinitions;

import io.cucumber.java.en.*;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.advseleniumfunctions.ProductFilteringPage;
import support.DriverManager;
import constants.Constants;

import java.util.List;

public class ProductFilteringSteps {
    private WebDriver driver;
    ProductFilteringPage productFilteringPage;

    @Given("que abro la página de productos")
    public void abrirPagina() {
        driver = DriverManager.getDriver();
        driver.get(Constants.NEOCITIES_URL + Constants.SELENIUM_TEST_PAGES_PATH  +  Constants.DROPDOWN_TABLE_PATH);
        
        productFilteringPage = new ProductFilteringPage(driver);
    }

    @When("selecciono la categoría {string}")
    public void seleccionarCategoria(String categoria) {
    	productFilteringPage.selectCategory(categoria);
    }

    @Then("debería ver los productos:")
    public void verificarProductos(io.cucumber.datatable.DataTable dataTable) {
        List<String> esperados = dataTable.asList();
        List<String> visibles = productFilteringPage.getProductNames();
        for (String prod : esperados) {
            Assert.assertTrue(visibles.contains(prod), "No se encontró: " + prod);
        }
    }
}
