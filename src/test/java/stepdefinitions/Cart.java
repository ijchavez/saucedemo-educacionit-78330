package stepdefinitions;

import org.openqa.selenium.WebDriver;

import com.github.javafaker.Faker;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CartPage;
import pages.CheckoutOverviewPage;
import pages.CheckoutPage;
import pages.FinishPage;
import pages.InventoryPage;
import pages.LoginPage;
import support.DriverManager;

public class Cart {
    private WebDriver driver;
    private LoginPage loginPage;
    private InventoryPage inventoryPage;
    private CartPage cartPage;
    private CheckoutPage checkoutPage;
    private CheckoutOverviewPage checkoutOverviewPage;
    private FinishPage finishPage;
    
    Faker faker;
	@Given("que el usuario se encuentra en la página de login")
	public void que_el_usuario_se_encuentra_en_la_página_de_login() {
        driver = DriverManager.getDriver();
        driver.get("https://www.saucedemo.com/v1/index.html");

        loginPage = new LoginPage(driver);

        faker = new Faker();
	}

	@When("el usuario inicia sesión con usuario {string} y contraseña {string}")
	public void el_usuario_inicia_sesión_con_usuario_y_contraseña(String username, String password) {
        inventoryPage = loginPage.clickLogin(username, password);
	}

	@When("agrega el producto {string} al carrito")
	public void agrega_el_producto_al_carrito(String product) {
    	inventoryPage.addProductToCartByName(product);

	}

	@When("accede al carrito")
	public void accede_al_carrito() {
    	cartPage = inventoryPage.clickOnShoppingCartIcon();
	}

	@When("presiona el botón de Checkout")
	public void presiona_el_botón_de_checkout() {
    	checkoutPage = cartPage.clickOnCheckoutButton();
	}

	@When("completa el formulario de compra con datos válidos")
	public void completa_el_formulario_de_compra_con_datos_válidos() {
    	checkoutPage.fillCheckoutFirstName(faker.name().firstName());
    	checkoutPage.fillCheckoutLastName(faker.name().lastName());
    	checkoutPage.fillCheckoutZipCode(faker.address().zipCode());
    	checkoutOverviewPage = checkoutPage.clickOnCheckoutButton();
	}

	@When("confirma la orden")
	public void confirma_la_orden() {
    	finishPage = checkoutOverviewPage.clickOnCheckoutButton();
	}

	@Then("debería ver el mensaje {string}")
	public void debería_ver_el_mensaje(String expectedHeader) {
    	finishPage.checkCompleteHeader(expectedHeader);
	}

	@Then("el texto {string}")
	public void el_texto(String expectedText) {
    	finishPage.checkCompleteText(expectedText);
	}
}
