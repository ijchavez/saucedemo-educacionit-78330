package com.advancedseleniumfunctions;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;

public class FakerDemo {
	
	@Test
    public static void fakerDemo(){
		// https://github.com/DiUS/java-faker?tab=readme-ov-file
        Faker faker = new Faker();

        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String fullName = faker.name().fullName();
        String email = faker.internet().emailAddress();
        String phoneNumber = faker.phoneNumber().cellPhone();
        String birthDate = faker.date().birthday().toString();
        String address = faker.address().fullAddress();

        String creditCard = faker.finance().creditCard();
        String iban = faker.finance().iban();

        System.out.println("=== Datos generados con Faker ===");
        System.out.println("Nombre: " + firstName);
        System.out.println("Apellido: " + lastName);
        System.out.println("Nombre completo: " + fullName);
        System.out.println("Email: " + email);
        System.out.println("Teléfono: " + phoneNumber);
        System.out.println("Dirección: " + address);
        System.out.println("Fecha de nacimiento: " + birthDate);
        System.out.println("Tarjeta de crédito: " + creditCard);
        System.out.println("IBAN: " + iban);
    }
}
