package testcase;

import base.BaseClass;
import org.testng.annotations.Test;
import pages.ConsultationsPage;
import pages.LoginPage;

import java.io.IOException;

public class ConsultationFilterTestCase extends BaseClass {
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
        consultationsPage.applyConsultationFilterFunction();
    }

}