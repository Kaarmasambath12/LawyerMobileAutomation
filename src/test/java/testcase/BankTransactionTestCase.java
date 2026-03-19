package testcase;

import base.BaseClass;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

import java.io.IOException;

public class BankTransactionTestCase extends BaseClass {
    public LoginPage loginPage;
    public HomePage homePage;


    @Test
    public void bankTransactionTestCase() throws InterruptedException, IOException, ClassNotFoundException {
        loginPage = new LoginPage();
        homePage = new HomePage();

        loginPage.notificationFunction();
        loginPage.loginFunction();
        homePage.filterTransactionAndDownloadReceipt();
    }

}