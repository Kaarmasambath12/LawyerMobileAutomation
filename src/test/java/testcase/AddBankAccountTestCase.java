package testcase;

import base.BaseClass;
import org.testng.annotations.Test;
import pages.ConsultationsPage;
import pages.HomePage;
import pages.LoginPage;

import java.io.IOException;

public class AddBankAccountTestCase extends BaseClass {
    public LoginPage loginPage;
    public HomePage homePage;


    @Test
    public void addBankAccountTestCase() throws InterruptedException, IOException, ClassNotFoundException {
        loginPage = new LoginPage();
        homePage = new HomePage();

        loginPage.notificationFunction();
        loginPage.loginFunction();
        homePage.addBankAccountDetails("test", "test", "test", "test" +
                "test", "test");
    }

}