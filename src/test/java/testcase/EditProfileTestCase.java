package testcase;

import base.BaseClass;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.ProfilePage;

import java.io.IOException;

import static utilities.ActionUtilities.scrollToText;

public class EditProfileTestCase extends BaseClass {
    public LoginPage loginPage;
    public ProfilePage profilePage;
    public String text="Professional Details";
    public String text2 = "Only .jpeg,.png,.pdf and .docs files are allowed. Maximum File size:  8.0 MB";


    @Test
    public void editProfileTestCase() throws InterruptedException, IOException, ClassNotFoundException {
        loginPage = new LoginPage();
        profilePage = new ProfilePage();

        loginPage.notificationFunction();
        loginPage.loginFunction();
        profilePage.openProfile();
        profilePage.enterNameDetails("Kumar", "V");
        profilePage.enterAddressDetails(
                "Chennai",
                "Maharashtra",
                "Pune",
                "Pimpri",
                "600001"
        );
        scrollToText(text);
        profilePage.enterProfessionalDetails("B.Com", "TN/0987/123");
        scrollToText(text2);
        profilePage.selectSpecialization();
        profilePage.clickSave();

    }

}