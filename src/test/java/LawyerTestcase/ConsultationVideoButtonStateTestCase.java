package LawyerTestcase;

import base.BaseClass;
import org.testng.annotations.Test;
import lawyerPages.ConsultationsPage;
import lawyerPages.LoginPage;

public class ConsultationVideoButtonStateTestCase extends BaseClass {
    public LoginPage loginPage;
    public ConsultationsPage consultationsPage;


    @Test
    public void consultationVideoButtonStateTestCase() throws Exception {
        loginPage = new LoginPage();
        consultationsPage = new ConsultationsPage();

        loginPage.clickNotificationAllow();
        loginPage.clickLoginLink();
        loginPage.loginFunction();
        loginPage.clickLoginButton();
        consultationsPage.clickConsultationAndVerifyContinueIsDisabled();
    }

}