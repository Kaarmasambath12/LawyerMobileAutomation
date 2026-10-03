package LawyerTestcase;

import base.BaseClass;
import org.testng.annotations.Test;
import lawyerPages.ConsultationsPage;
import lawyerPages.LoginPage;

public class ConsultationCancellationTestCase extends BaseClass {
    public LoginPage loginPage;
    public ConsultationsPage consultationsPage;


    @Test
    public void consultationCancellationTestCase() throws Exception {
        loginPage = new LoginPage();
        consultationsPage = new ConsultationsPage();

        loginPage.clickNotificationAllow();
        loginPage.clickLoginLink();
        loginPage.loginFunction();
        loginPage.clickLoginButton();
        consultationsPage.cancelConsultationFunction();
    }

}