package LawyerTestcase;

import base.BaseClass;
import org.testng.annotations.Test;
import lawyerPages.HomePage;
import lawyerPages.LoginPage;

public class BankTransactionTestCase extends BaseClass {
    public LoginPage loginPage;
    public HomePage homePage;


    @Test
    public void bankTransactionTestCase() throws Exception {
        loginPage = new LoginPage();
        homePage = new HomePage();

        loginPage.clickNotificationAllow();
        loginPage.clickLoginLink();
        loginPage.loginFunction();
        loginPage.clickLoginButton();
        homePage.filterTransactionAndDownloadReceipt();
    }

}