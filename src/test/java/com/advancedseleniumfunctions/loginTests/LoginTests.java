package com.advancedseleniumfunctions.loginTests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import constants.Constants;
import pages.advseleniumfunctions.LoginPage;
import support.DriverManager;

public class LoginTests {
    private WebDriver driver;
    private LoginPage loginPage;

    @BeforeMethod
    public void setUp() {
        DriverManager.initDriver();
        driver = DriverManager.getDriver();
        driver.get(Constants.NEOCITIES_URL + Constants.SELENIUM_TEST_PAGES_PATH + Constants.LOGIN_PATH);

        loginPage = new LoginPage(driver);
    }
	@Test
	public void successfulLoginTest() {
        loginPage.enterUsername("activo");
        loginPage.enterPassword("1234");
        loginPage.clickLogin();
        
        Assert.assertEquals("Login exitoso", loginPage.getMessageText());     
	}
    
	@Test
	public void suspendedLoginTest() {
        loginPage.enterUsername("suspendido");
        loginPage.enterPassword("4567");
        loginPage.clickLogin();
        
        Assert.assertEquals("Tu cuenta está suspendida", loginPage.getMessageText());     	
	}
	
	@Test
	public void blockedLoginTest() {
        loginPage.enterUsername("bloqueado");
        loginPage.enterPassword("8901");
        loginPage.clickLogin();
        
        Assert.assertEquals("Tu cuenta ha sido bloqueada", loginPage.getMessageText());     	
	}
	
	@Test
	public void invalidUserLoginTest() {
        loginPage.enterUsername("otro");
        loginPage.enterPassword("1234");
        loginPage.clickLogin();
        
        Assert.assertEquals("Credenciales inválidas", loginPage.getMessageText());     	
	}
	
	@Test
	public void invalidCredentialsLoginTest() {
        loginPage.enterUsername("activo");
        loginPage.enterPassword("0000");
        loginPage.clickLogin();
        
        Assert.assertEquals("Credenciales inválidas", loginPage.getMessageText());     	
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
