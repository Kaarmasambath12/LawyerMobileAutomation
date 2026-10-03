package LawyerTestcase;

import base.BaseClass;
import org.testng.annotations.Test;
import lawyerPages.HomePage;
import lawyerPages.LoginPage;

public class AddBankAccountTestCase extends BaseClass {
    public LoginPage loginPage;
    public HomePage homePage;


    @Test
    public void addBankAccountTestCase() throws Exception {
        loginPage = new LoginPage();
        homePage = new HomePage();

        loginPage.clickLoginLink();
        loginPage.loginFunction();
      /* homePage.addBankAccountDetails("HDFC", "Karthik",
                "12345678912", "IDFC0000234" +
                "test", "Chennai");*/

        homePage.addAccountFunction();
    }

}