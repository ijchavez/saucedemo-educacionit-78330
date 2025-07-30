package com.advancedseleniumfunctions;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;


public class FakerExampleRegister {
	public class NetworkConditions {
		WebDriver driver;
		String url = "https://seleniumjavalocators.neocities.org/pages/registro";
        Faker faker;
        
		@BeforeMethod
		public void setUp() {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("start-maximized");		

			driver = new ChromeDriver(options);
			driver.get(url);
			
			faker = new Faker();
			
		}
		@Test
		public void geoLocationTest() throws InterruptedException {
	        
			driver.findElement(By.id("name")).sendKeys(faker.name().fullName());
			driver.findElement(By.name("email")).sendKeys(faker.internet().emailAddress());
			driver.findElement(By.id("username")).sendKeys(faker.beer().name());
			
			String pwd = faker.internet().password();
			
			driver.findElement(By.id("password")).sendKeys(pwd);
			driver.findElement(By.id("confirmPassword")).sendKeys(pwd);		
			
			driver.findElement(By.id("mostrarMensajeBtn")).click();
			
			String message = driver.findElement(By.id("mensajeInicioSesion")).getText();
			
			System.out.println(message);
			
			
		}
		@AfterMethod
		public void tearDown() {
			driver.close();
			
		}
	}

}
