package com.advancedseleniumfunctions;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v138.emulation.Emulation;

public class GeoEnabledDriverFactory {

    /**
     * Crea un ChromeDriver con permisos de geolocalización habilitados automáticamente.
     * Se puede usar para acceder a páginas que solicitan ubicación sin mostrar el popup del navegador.
     *
     * @return Instancia de WebDriver con permisos de geolocalización habilitados.
     */
    public static WebDriver createDriverWithLocationPermission() {
        ChromeOptions options = new ChromeOptions();

        // Permitir automáticamente el uso de la ubicación
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("profile.default_content_setting_values.geolocation", 1); // 1 = Allow

        options.setExperimentalOption("prefs", prefs);
        options.addArguments("--start-maximized");

        return new ChromeDriver(options);
    }

    /**
     * Establece una ubicación simulada (latitud y longitud) en el navegador.
     * Esto permite que el sitio piense que el usuario está en esa ubicación.
     *
     * @param driver    El WebDriver ya inicializado (debe ser ChromeDriver).
     * @param latitude  Latitud simulada (por ejemplo: 34.0522).
     * @param longitude Longitud simulada (por ejemplo: -118.2437).
     */
    public static void setFakeLocation(WebDriver driver, double latitude, double longitude) {
        DevTools devTools = ((ChromeDriver) driver).getDevTools();
        devTools.createSession();

        devTools.send(Emulation.setGeolocationOverride(
                Optional.of(latitude),
                Optional.of(longitude),
                Optional.of(1.0),
                Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty()
        ));
    }
}
