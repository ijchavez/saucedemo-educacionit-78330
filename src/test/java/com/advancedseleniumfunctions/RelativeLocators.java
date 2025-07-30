package com.advancedseleniumfunctions;

import static org.openqa.selenium.support.locators.RelativeLocator.with;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class RelativeLocators {
	
	public WebDriver driver;
	@Test
	public void test() {
        driver = new ChromeDriver();

        driver.get("https://seleniumjavalocators.neocities.org/selenium_test_pages/relative_paths/relative_paths");

        // Ejemplos
        WebElement campoCentral = driver.findElement(By.id("campo-centro"));

        WebElement botonArriba = driver.findElement(with(By.tagName("button")).above(campoCentral));
        WebElement botonAbajo  = driver.findElement(with(By.tagName("button")).below(campoCentral));

        WebElement botonCentral = driver.findElement(By.id("boton-central"));
        WebElement textoIzq = driver.findElement(with(By.tagName("span")).toLeftOf(botonCentral));
        WebElement textoDer = driver.findElement(with(By.tagName("span")).toRightOf(botonCentral));

        WebElement cerca = driver.findElement(with(By.tagName("span")).near(botonCentral));

        // Demo: imprimir textos
        System.out.println("Botón arriba: " + botonArriba.getText());
        System.out.println("Botón abajo: " + botonAbajo.getText());
        System.out.println("Texto izquierda: " + textoIzq.getText());
        System.out.println("Texto derecha: " + textoDer.getText());
        System.out.println("Cercano al botón central: " + cerca.getText());

        driver.quit();
	}
}
