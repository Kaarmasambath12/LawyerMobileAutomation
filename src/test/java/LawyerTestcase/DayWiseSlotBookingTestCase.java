package LawyerTestcase;

import base.BaseClass;
import org.testng.annotations.Test;
import lawyerPages.LoginPage;
import lawyerPages.MyAvailabilityPage;

public class DayWiseSlotBookingTestCase extends BaseClass {
    public LoginPage loginPage;
    public MyAvailabilityPage myAvailabilityPage;


    @Test
    public void dayWiseSlotBookingTestCase() throws Exception {
        loginPage = new LoginPage();
        myAvailabilityPage = new MyAvailabilityPage();

        loginPage.clickLoginLink();
        loginPage.loginFunction();
        myAvailabilityPage.bookSlotDayWise();
        myAvailabilityPage.selectTimeSlots();
        myAvailabilityPage.confirmButtonMethod();



    }


}
