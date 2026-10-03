package LawyerTestcase;

import base.BaseClass;
import org.testng.annotations.Test;
import lawyerPages.HomePage;
import lawyerPages.LoginPage;

public class HomeScreenTestCase extends BaseClass {
    public LoginPage loginPage;
    public HomePage homePage;


    @Test
    public void homeScreenTestCase() throws Exception {
        loginPage = new LoginPage();
        homePage = new HomePage();

        loginPage.clickNotificationAllow();
        loginPage.clickLoginLink();
        loginPage.loginFunction();
        homePage.clickSeeMore();
        homePage.selectWeekFour();
        homePage.selectWeekThree();
        homePage.clickMonthlyTab();
        homePage.clickYearlyTab();
        homePage.clickBackButton();
        homePage.scrollToTodaySlotSeeMoreButton();



    }

}