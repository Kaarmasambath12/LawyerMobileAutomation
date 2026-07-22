package testcase;

import base.BaseClass;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MyAvailabilityPage;

import java.io.IOException;

public class DayWiseSlotBookingTestCase extends BaseClass {
    public LoginPage loginPage;
    public MyAvailabilityPage myAvailabilityPage;


    @Test
    public void dayWiseSlotBookingTestCase() throws Exception {
        loginPage = new LoginPage();
        myAvailabilityPage = new MyAvailabilityPage();

        loginPage.clickLoginLink();
        loginPage.loginFunction();
        myAvailabilityPage.setDayWiseAvailabilityFunction();


    }


}
