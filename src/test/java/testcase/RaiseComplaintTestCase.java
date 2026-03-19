package testcase;

import base.BaseClass;
import org.testng.annotations.Test;
import pages.ComplaintPage;
import pages.ConsultationsPage;
import pages.LoginPage;

import java.io.IOException;

public class RaiseComplaintTestCase extends BaseClass {
    public LoginPage loginPage;
    public ComplaintPage complaintPage;


    @Test
    public void raiseComplaintTestCase() throws InterruptedException, IOException {
        loginPage = new LoginPage();
        complaintPage = new ComplaintPage();

        loginPage.notificationFunction();
        loginPage.loginFunction();
        complaintPage.raiseComplaint("testing");
        complaintPage.isPendingComplaintDisplayed();
        complaintPage.isComplaintCompletedDisplayed();
    }

}