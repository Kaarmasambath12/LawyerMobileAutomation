package testcase;

import base.BaseClass;
import org.testng.annotations.Test;
import pages.LoginPage;
import report.ExtentReport;

import java.io.IOException;

public class LoginTestCase extends BaseClass {
    public LoginPage loginPage;

    @Test
    public void LoginTestCase() throws InterruptedException, IOException {
        loginPage = new LoginPage();
        loginPage.notificationFunction();
        loginPage.loginFunction();
        loginPage.logoutFunction();

    }


}
