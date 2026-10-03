package LawyerTestcase;

import base.BaseClass;
import org.testng.annotations.Test;
import lawyerPages.ConsultationsPage;
import lawyerPages.LoginPage;

public class ConsultationCompleteAndCancelledCheckTestCase extends BaseClass {
    public LoginPage loginPage;
    public ConsultationsPage consultationsPage;


    @Test
    public void consultationCompleteAndCancelledCheckTestCase() throws Exception {
        loginPage = new LoginPage();
        consultationsPage = new ConsultationsPage();

        loginPage.clickNotificationAllow();
        loginPage.clickLoginLink();
        loginPage.loginFunction();
        loginPage.clickLoginButton();
        consultationsPage.verifyCompletedAndCancelledMeetData();
    }

}