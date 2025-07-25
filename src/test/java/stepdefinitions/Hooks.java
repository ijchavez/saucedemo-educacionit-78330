package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import support.DriverManager;

public class Hooks {

    @Before
    public void setUp() {
        DriverManager.initDriver();
    }

    @After
    public void tearDown() {
        DriverManager.quitDriver();
    }
}
