package testcase;

import base.BaseClass;
import org.testng.annotations.Test;
import pages.ConsultationsPage;
import pages.LoginPage;

import java.io.IOException;

public class ConsultationCompleteAndCancelledCheckTestCase extends BaseClass {
    public LoginPage loginPage;
    public ConsultationsPage consultationsPage;


    @Test
    public void consultationCompleteAndCancelledCheckTestCase() throws InterruptedException, IOException {
        loginPage = new LoginPage();
        consultationsPage = new ConsultationsPage();

        loginPage.notificationFunction();
        loginPage.loginFunction();
        consultationsPage.verifyCompletedAndCancelledMeetData();
    }

}