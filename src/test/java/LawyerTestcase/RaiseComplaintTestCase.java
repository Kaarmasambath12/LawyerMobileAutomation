package LawyerTestcase;

import base.BaseClass;
import org.testng.annotations.Test;
import lawyerPages.ComplaintPage;
import lawyerPages.LoginPage;

public class RaiseComplaintTestCase extends BaseClass {
    public LoginPage loginPage;
    public ComplaintPage complaintPage;


    @Test
    public void raiseComplaintTestCase() throws Exception {
        loginPage = new LoginPage();
        complaintPage = new ComplaintPage();

        loginPage.clickNotificationAllow();
        loginPage.clickLoginLink();
        loginPage.loginFunction();
        complaintPage.raiseComplaint("testing");
        complaintPage.isPendingComplaintDisplayed();
        complaintPage.isComplaintCompletedDisplayed();
    }

}