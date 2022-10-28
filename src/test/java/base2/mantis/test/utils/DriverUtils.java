package base2.mantis.test.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverUtils {
	private static WebDriver instance;

	public static WebDriver getDriver() {
		if (instance == null || hasQuit()) {
			initalize();
		}

		return instance;
	}

	private static void initalize() throws RuntimeException {
		Properties properties = PropertiesUtils.loadGlobal();

		System.setProperty("webdriver.chrome.driver", properties.getProperty("CHROME_DRIVER"));
		instance = new ChromeDriver();
	}

	private static boolean hasQuit() {
		return instance.toString().contains("(null)");
	}
}
