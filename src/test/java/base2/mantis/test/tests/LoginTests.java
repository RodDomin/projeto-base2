package base2.mantis.test.tests;

import base2.mantis.test.flows.LoginFlows;

import base2.mantis.test.pageobjects.HomePage;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import base2.mantis.test.bases.TestBase;
import base2.mantis.test.pageobjects.LoginPage;

import java.util.Properties;

public class LoginTests extends TestBase<LoginPage> {
	private final LoginFlows flows;

	public LoginTests() {
		page = new LoginPage();
		flows = new LoginFlows(page);
	}

	@Override
	protected String pageUrl() {
		return page.URL;
	}

	@Test
	public void it_should_load_login_password_after_submit() {
		Properties loginProperties = page.getProperties();

		String userName = loginProperties.getProperty("username");

		flows.submitUserName(userName);

		assertEquals(page.getCurrentUrl(), page.PASSWORD_URL);
	}

	@Test
	public void it_should_login_when_password_is_correct() {
		Properties loginProperties = page.getProperties();

		String userName = loginProperties.getProperty("username");
		String password = loginProperties.getProperty("password");

		flows.logIn(userName, password);

		assertEquals(page.getCurrentUrl(), new HomePage().URL);
	}

	@Test
	public void it_should_not_login_when_username_or_password_is_wrong() {
		String userName = "anyUser";
		String password = "wrongPassword";

		flows.logIn(userName, password);

		assertTrue(page.getCurrentUrl().contains(page.URL));
		assertTrue(page.errorPresent());
	}
}
