package base2.mantis.test.bases;

import base2.mantis.test.utils.PropertiesUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import base2.mantis.test.utils.DriverUtils;

import java.util.Properties;

public class PageBase {
	protected WebDriver web = DriverUtils.getDriver();
	
	public void close() {
		web.quit();
	}
	
	public void open(String url) {
		web = DriverUtils.getDriver();
		web.get(url);
	}

	protected WebElement getElement(By by) {
		return web.findElement(by);
	}

	protected boolean elementExists(By by) {
		return web.findElements(by).size() != 0;
	}

	protected void sendKeys(WebElement element, String text) {
		element.sendKeys(text);
	}

	protected void sendKeys(By by, String text) {
		getElement(by).sendKeys(text);
	}

	protected void click(WebElement element) {
		element.click();
	}
	
	protected String getText(WebElement element) {
		return element.getText();
	}

	public String getCurrentUrl() {
		return web.getCurrentUrl();
	}

	public Properties getPageProperties(String page) {
		return PropertiesUtils.load(page);
	}

	public void navigateTo(String url) {
		web.navigate().to(url);
	}
}
