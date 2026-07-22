package testcase;

import base.BaseClass;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MyAvailabilityPage;

import java.io.IOException;

public class SlotBookingTestCase extends BaseClass {
    public LoginPage loginPage;
    public MyAvailabilityPage myAvailabilityPage;


    @Test
    public void slotBookingTestCase() throws Exception {
        loginPage = new LoginPage();
        myAvailabilityPage = new MyAvailabilityPage();

        loginPage.clickLoginLink();
        loginPage.loginFunction();
        myAvailabilityPage.setMyAvailabilityFunction();
        myAvailabilityPage.selectTimeSlots();


    }


}
