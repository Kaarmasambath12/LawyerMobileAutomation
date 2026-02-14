package testcase;

import base.BaseClass;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MyAvailabilityPage;

import java.io.IOException;

public class EditDateWiseSlotBookingTestCase extends BaseClass {
    public LoginPage loginPage;
    public MyAvailabilityPage myAvailabilityPage;


    @Test
    public void editDateWiseSlotBookingTestCase() throws InterruptedException, IOException {
        loginPage = new LoginPage();
        myAvailabilityPage = new MyAvailabilityPage();

        loginPage.notificationFunction();
        loginPage.loginFunction();
        myAvailabilityPage.editDateWiseSlotFunction();


    }


}
