package stepdefinitions;

import io.cucumber.java.en.*;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.advseleniumfunctions.LoginPage;
import support.DriverManager;
import constants.Constants;


public class LoginSteps {

    private WebDriver driver;
    private LoginPage loginPage;

    @Given("que abro la página de login")
    public void abrirPaginaDeLogin() {
        driver = DriverManager.getDriver();
        driver.get(Constants.NEOCITIES_URL + Constants.SELENIUM_TEST_PAGES_PATH + Constants.LOGIN_PATH);

        loginPage = new LoginPage(driver);
    }

    @When("ingreso usuario {string} y contraseña {string}")
    public void ingresoCredenciales(String user, String pass) {
        loginPage.enterUsername(user);
        loginPage.enterPassword(pass);
        loginPage.clickLogin();
    }

    @Then("debería ver el mensaje debajo {string}")
    public void validarMensaje(String esperado) {
        String real = loginPage.getMessageText();
        Assert.assertEquals(esperado, real);
    }
}
