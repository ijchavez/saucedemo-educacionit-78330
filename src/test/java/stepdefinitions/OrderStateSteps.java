package stepdefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import pages.advseleniumfunctions.OrderStatePage;
import support.DriverManager;
import constants.Constants;
import static org.testng.Assert.*;

public class OrderStateSteps {

    private WebDriver driver;
    private OrderStatePage orderStatePage;

    @Given("el usuario está en la pantalla de estado de orden")
    public void el_usuario_esta_en_la_pantalla() {
        driver = DriverManager.getDriver();
        driver.get(Constants.NEOCITIES_URL + Constants.STATE_PATH);
        orderStatePage = new OrderStatePage(driver);
    }

    @When("confirma el pago")
    public void confirma_pago() {
        orderStatePage.clickConfirmPayment();
    }

    @When("cancela la orden")
    public void cancela_orden() {
        orderStatePage.clickCancelOrder();
    }

    @When("marca la orden como enviada")
    public void marca_como_enviada() {
        orderStatePage.clickMarkAsShipped();
    }

    @When("marca la orden como entregada")
    public void marca_como_entregada() {
        orderStatePage.clickMarkAsDelivered();
    }

    @Then("el estado de la orden debe ser {string}")
    public void validar_estado(String estadoEsperado) {
        assertEquals(orderStatePage.getOrderStatus(), estadoEsperado);
    }

    @Then("no debe mostrarse mensaje de error")
    public void sin_error() {
        assertFalse(orderStatePage.isErrorVisible());
    }

    @Then("debe mostrarse un mensaje de error")
    public void mostrar_error() {
        assertTrue(orderStatePage.isErrorVisible());
        assertTrue(orderStatePage.getErrorMessage().contains("Invalid transition"));
    }
}
