package testcase;

import base.BaseClass;
import dataDriven.DataProviderClass;
import org.testng.annotations.Test;
import pages.LoginPage;


import java.io.IOException;

public class LoginTestCase extends BaseClass {
    public LoginPage loginPage;


/*
    @Test
    public void loginTestCase() throws InterruptedException, IOException {
        loginPage.notificationFunction();
        loginPage.loginFunction();
      //  loginPage.logoutFunction();
    }*/

    @Test(dataProvider = "loginData",
            dataProviderClass = DataProviderClass.class)
    public void loginTestCaseWithTestData(String MobileNumber, String Password, String expectedStatus) throws IOException, InterruptedException {
        loginPage  = new LoginPage();
       Thread.sleep(2000);
        loginPage.notificationFunction();
        loginPage.loginFunctionWithTestData(MobileNumber, Password);
        System.out.println("Expected Result: " + expectedStatus);

    }


}
