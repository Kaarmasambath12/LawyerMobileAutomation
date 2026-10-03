package LawyerTestcase;

import base.BaseClass;
import org.testng.annotations.Test;
import lawyerPages.LoginPage;
import lawyerPages.MyAvailabilityPage;

public class SlotBookingTestCase extends BaseClass {
    public LoginPage loginPage;
    public MyAvailabilityPage myAvailabilityPage;


    @Test
    public void slotBookingTestCase() throws Exception {
        loginPage = new LoginPage();
        myAvailabilityPage = new MyAvailabilityPage();

        loginPage.clickLoginLink();
        loginPage.loginFunction();
        myAvailabilityPage.slotBookingMethod();
        myAvailabilityPage.selectTimeSlots();
        myAvailabilityPage.confirmButtonMethod();


    }


}
