package base2.mantis.test.utils;

import base2.mantis.test.flows.LoginFlows;
import base2.mantis.test.pageobjects.LoginPage;

import java.util.Properties;

public class AuthUtils {
    public static void authenticate() {
        Properties properties = PropertiesUtils.load("login");
        LoginFlows flows = new LoginFlows(new LoginPage());

        flows.logIn(properties.getProperty("username"), properties.getProperty("password"));
    }
}
