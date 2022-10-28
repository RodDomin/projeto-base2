package base2.mantis.test.pageobjects;

import base2.mantis.test.bases.PageBase;
import org.openqa.selenium.By;

import java.util.Properties;

public class LoginPage extends PageBase {
	public String URL = "https://mantis-prova.base2.com.br/login_page.php";
	public String PASSWORD_URL = "https://mantis-prova.base2.com.br/login_password_page.php";

	private final By userName = By.cssSelector("input[id=username]");
	private final By password = By.cssSelector("input[id=password]");

	private final By submit = By.cssSelector("input[type=submit]");

	private final By errorAlert = By.cssSelector(".alert-danger p");

	public void fillUserName(String data) {
		sendKeys(getElement(userName), data);
	}

	public void fillPassword(String data) {
		sendKeys(getElement(password), data);
	}

	public void submit() {
		click(getElement(submit));
	}

	public Properties getProperties() {
		return getPageProperties("login");
	}

	public boolean errorPresent() {
		return elementExists(errorAlert);
	}
}
