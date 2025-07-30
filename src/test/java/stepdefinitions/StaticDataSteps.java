package stepdefinitions;

import constants.Constants;
import io.cucumber.java.en.*;
import org.testng.Assert;
import pages.advseleniumfunctions.StaticDataPage;
import support.DriverManager;
import com.advancedseleniumfunctions.utilities.Utilities;

import java.util.List;

public class StaticDataSteps {

    StaticDataPage staticDataPage;

    @Given("el usuario abre la página de datos estáticos")
    public void abrirPagina() {
        DriverManager.getDriver().get(Constants.NEOCITIES_URL + Constants.DATATABLE_PATH);
        staticDataPage = new StaticDataPage(DriverManager.getDriver());
    	
    }

    @When("selecciona el filtro {string}")
    public void seleccionarFiltro(String filtro) {
        staticDataPage.selectAgeFilter(filtro);
    }

    @Then("todas las edades visibles deben estar entre {int} y {int}")
    public void validarRango(int min, int max) {
        List<Integer> edades = staticDataPage.getVisibleAges();
        for (int edad : edades) {
            Assert.assertTrue(Utilities.AgeComparisson(min, max, edad), "Edad fuera de rango: " + edad);
        }
    }

    @Then("todas las edades visibles deben ser {int} o más")
    public void validarMayoresDe(int min) {
        List<Integer> edades = staticDataPage.getVisibleAges();
        for (int edad : edades) {
            Assert.assertTrue(Utilities.AgeComparisson(min, edad), "Edad menor a " + min + ": " + edad);
        }
    }

    @Then("deben mostrarse todos los registros")
    public void validarTodosLosRegistros() {
        List<Integer> edades = staticDataPage.getVisibleAges();
        Assert.assertTrue(edades.size() >= 17, "No se muestran todos los registros");
    }
}
