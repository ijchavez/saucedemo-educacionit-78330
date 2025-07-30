package stepdefinitions;

import io.cucumber.java.en.*;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.advseleniumfunctions.DiscountPage;
import support.DriverManager;
import constants.Constants;

public class DiscountSteps {
	
    private WebDriver driver;
    DiscountPage discountPage;

    @Given("que ingreso a la página de descuentos")
    public void abrirPaginaDescuento() {
    	driver = DriverManager.getDriver();
        driver.get(Constants.NEOCITIES_URL + Constants.DISCOUNT_PATH);
        
        discountPage = new DiscountPage(driver);
    }

    @When("selecciono membresía {string}, monto {string}, método {string}, promoción especial {word}")
    public void ingresoDatos(String membresia, String monto, String metodo, String promo) {
        discountPage.setMembership(membresia);
        discountPage.setPurchaseAmount(monto);
        discountPage.setPaymentMethod(metodo);
        discountPage.setSpecialPromotion(promo.equalsIgnoreCase("activada"));
        discountPage.clickCalculate();
    }

    @Then("debería ver el resultado {string}")
    public void validarResultado(String porcentajeEsperado) {
        String result = discountPage.getDiscountResult();
        Assert.assertTrue(result.contains(porcentajeEsperado));
    }
}
