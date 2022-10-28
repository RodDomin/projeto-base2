package base2.mantis.test.flows;

import base2.mantis.test.pageobjects.LoginPage;

public class LoginFlows {
    private final LoginPage loginPage;

    public LoginFlows(LoginPage loginPage) {
        this.loginPage = loginPage;
    }

    public void submitUserName(String userName) {
        loginPage.fillUserName(userName);
        loginPage.submit();
    }

    public void logIn(String userName, String password) {
        submitUserName(userName);

        loginPage.fillPassword(password);
        loginPage.submit();
    }
}
