package base2.mantis.test.bases;

import base2.mantis.test.flows.LoginFlows;
import base2.mantis.test.pageobjects.LoginPage;
import base2.mantis.test.utils.PropertiesUtils;
import org.junit.jupiter.api.BeforeEach;

import java.util.Properties;

public abstract class AuthenticatedTestBase<T extends PageBase> extends TestBase<T> {
    @BeforeEach()
    public void initialize() {
        page.open(new LoginPage().URL);

        Properties properties = PropertiesUtils.load("login");
        LoginFlows flows = new LoginFlows(new LoginPage());

        flows.logIn(
                properties.getProperty("username"),
                properties.getProperty("password"));

        page.navigateTo(pageUrl());
    }
}
