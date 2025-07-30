package support;

import java.util.Collections;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverManager {
	private static final String START_MAXIMIZED = "--start-maximized";
	private static final String DISABLE_GPU = "--disable-gpu";
	private static final String INCOGNITO = "--incognito";
	private static final String DISABLE_EXTENSIONS = "--disable-extensions";
	private static final String DISABLE_NOTIFICATIONS = "--disable-notifications";
	private static final String DISABLE_INFOBARS = "disable-infobars";

	private static WebDriver driver;

	private static ChromeDriver getChromeDriverForLocalTest() {
		final ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments(
				START_MAXIMIZED, DISABLE_INFOBARS, 
				DISABLE_EXTENSIONS, DISABLE_NOTIFICATIONS,
				DISABLE_GPU, INCOGNITO);
		disableInfobarForChrome(chromeOptions);

		return new ChromeDriver(chromeOptions);
	}

	private static void disableInfobarForChrome(final ChromeOptions chromeOptions) {
		chromeOptions.setExperimentalOption("useAutomationExtension", false);
		chromeOptions.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));

	}

	public static void initDriver() {
		driver = getChromeDriverForLocalTest();
		driver.manage().window().maximize();
	}

	public static WebDriver getDriver() {
		return driver;
	}

	public static void quitDriver() {
		if (driver != null) {
			driver.quit();
		}
	}
}
