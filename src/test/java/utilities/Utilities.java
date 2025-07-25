package utilities;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.HasDevTools;
import org.openqa.selenium.devtools.v138.emulation.Emulation;
import org.openqa.selenium.devtools.v138.network.Network;
import org.openqa.selenium.devtools.v138.network.model.ConnectionType;

public class Utilities {
	public static void setCoordinates(WebDriver driver, Object latitude, Object longitude) {
		Map<String, Object> coordenadas = new HashMap<>();
		coordenadas.put("latitude", latitude);
		coordenadas.put("longitude", longitude);
		coordenadas.put("accuracy", 1);
		
		((ChromiumDriver) driver).executeCdpCommand("Emulation.setGeolocationOverride", coordenadas);
	}
	public static void devToolsCreateSession(WebDriver driver) {
		DevTools devTools = ((HasDevTools) driver).getDevTools();
		devTools.createSession();
		
	}
	public static void setCoordinatesAlternative(WebDriver driver, Number latitude, Number longitude) {
		DevTools devTools = ((HasDevTools) driver).getDevTools();
		devTools.createSession();
		devTools.send(Emulation.setGeolocationOverride(Optional.of(latitude),
		Optional.of(longitude), Optional.of(1), java.util.Optional.empty(), java.util.Optional.empty(), java.util.Optional.empty(), java.util.Optional.empty()));
		
	}
	public static void setNetworkConditions(WebDriver driver, ConnectionType connectionType) {
		DevTools devTools = ((HasDevTools) driver).getDevTools();
		devTools.createSession();
		devTools.send(Network.emulateNetworkConditions(true, 250, -1, -1, Optional.of(connectionType), java.util.Optional.empty(), java.util.Optional.empty(), java.util.Optional.empty()));

	}
	public static boolean AgeComparisson(int minAge, int maxAge, int age) {
		return age >= minAge && age <= maxAge;
	}
	public static boolean AgeComparisson(int minAge, int age) {
		return age >= minAge;
	}
}
