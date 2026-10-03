package LawyerTestcase;

import base.BaseClass;
import org.testng.annotations.Test;
import lawyerPages.RegisterPage;


public class RegisterTestCase extends BaseClass {
    public RegisterPage registerPage;


    @Test(priority = 1)
    public void registerWithValidData() throws Exception {
        registerPage = new RegisterPage();

        String firstName = "Karthik";
        String middleName = "Kumar";
        String lastName = "Sambath";
        String mobileNumber = "9003349787";
        String otp = "123456";
        String email = "karthik.test@example.com";
        String password = "Test@1234";
        String confirmPassword = "Test@1234";

        registerPage.registerUser(firstName, middleName, lastName, mobileNumber, otp, email, password, confirmPassword);
    }

   /* @Test(priority = 2)
    public void registerWithoutFirstName() throws Exception {
        registerPage = new RegisterPage();

        String firstName = "";
        String middleName = "Kumar";
        String lastName = "Sambath";
        String mobileNumber = "9876543211";
        String otp = "123456";
        String email = "test1@example.com";
        String password = "Test@1234";
        String confirmPassword = "Test@1234";
        registerPage.clickLandingRegisterButton();
        registerPage.enterFirstName(firstName);
        registerPage.enterMiddleName(middleName);
        registerPage.enterLastName(lastName);
        registerPage.enterMobileNumber(mobileNumber);
        registerPage.clickSendOtpButton();
        registerPage.enterOTP(otp);
        registerPage.enterEmail(email);
        registerPage.enterPassword(password);
        registerPage.enterConfirmPassword(confirmPassword);
        registerPage.checkTermsCheckBox();

    }

    @Test(priority = 3)
    public void registerWithoutMiddleName() throws Exception {
        registerPage = new RegisterPage();

        String firstName = "Raj";
        String middleName = "";
        String lastName = "Kumar";
        String mobileNumber = "9876543212";
        String otp = "123456";
        String email = "test2@example.com";
        String password = "Test@1234";
        String confirmPassword = "Test@1234";

        registerPage.clickLandingRegisterButton();
        registerPage.enterFirstName(firstName);
        registerPage.enterMiddleName(middleName);
        registerPage.enterLastName(lastName);
        registerPage.enterMobileNumber(mobileNumber);
        registerPage.clickSendOtpButton();
        registerPage.enterOTP(otp);
        registerPage.enterEmail(email);
        registerPage.enterPassword(password);
        registerPage.enterConfirmPassword(confirmPassword);
        registerPage.checkTermsCheckBox();
        registerPage.clickRegisterButton();
    }

    @Test(priority = 4)
    public void registerWithInvalidEmail() throws Exception {
        registerPage = new RegisterPage();

        String firstName = "John";
        String middleName = "Jacob";
        String lastName = "Doe";
        String mobileNumber = "9876543213";
        String otp = "123456";
        String email = "invalidemail";
        String password = "Test@1234";
        String confirmPassword = "Test@1234";

        registerPage.clickLandingRegisterButton();
        registerPage.enterFirstName(firstName);
        registerPage.enterMiddleName(middleName);
        registerPage.enterLastName(lastName);
        registerPage.enterMobileNumber(mobileNumber);
        registerPage.clickSendOtpButton();
        registerPage.enterOTP(otp);
        registerPage.enterEmail(email);
        registerPage.enterPassword(password);
        registerPage.enterConfirmPassword(confirmPassword);
        registerPage.checkTermsCheckBox();
        registerPage.clickRegisterButton();
    }

    @Test(priority = 5)
    public void registerWithMismatchedPasswords() throws Exception {
        registerPage = new RegisterPage();

        String firstName = "Jane";
        String middleName = "Mary";
        String lastName = "Smith";
        String mobileNumber = "9876543214";
        String otp = "123456";
        String email = "jane.test@example.com";
        String password = "Test@1234";
        String confirmPassword = "Test@5678";

        registerPage.clickLandingRegisterButton();
        registerPage.enterFirstName(firstName);
        registerPage.enterMiddleName(middleName);
        registerPage.enterLastName(lastName);
        registerPage.enterMobileNumber(mobileNumber);
        registerPage.clickSendOtpButton();
        registerPage.enterOTP(otp);
        registerPage.enterEmail(email);
        registerPage.enterPassword(password);
        registerPage.enterConfirmPassword(confirmPassword);
        registerPage.checkTermsCheckBox();
        registerPage.clickRegisterButton();
    }

    @Test(priority = 6)
    public void registerWithoutTermsAgreement() throws Exception {
        registerPage = new RegisterPage();

        String firstName = "Alice";
        String middleName = "Ann";
        String lastName = "Brown";
        String mobileNumber = "9876543215";
        String otp = "123456";
        String email = "alice.test@example.com";
        String password = "Test@1234";
        String confirmPassword = "Test@1234";


        registerPage.clickLandingRegisterButton();
        registerPage.enterFirstName(firstName);
        registerPage.enterMiddleName(middleName);
        registerPage.enterLastName(lastName);
        registerPage.enterMobileNumber(mobileNumber);
        registerPage.clickSendOtpButton();
        registerPage.enterOTP(otp);
        registerPage.enterEmail(email);
        registerPage.enterPassword(password);
        registerPage.enterConfirmPassword(confirmPassword);
        registerPage.clickRegisterButton();
    }

    @Test(priority = 7)
    public void registerWithShortPassword() throws Exception {
        registerPage = new RegisterPage();

        String firstName = "Bob";
        String middleName = "Bruce";
        String lastName = "Lee";
        String mobileNumber = "9876543216";
        String otp = "123456";
        String email = "bob.test@example.com";
        String password = "123";
        String confirmPassword = "123";

        registerPage.clickLandingRegisterButton();

        registerPage.enterFirstName(firstName);
        registerPage.enterMiddleName(middleName);
        registerPage.enterLastName(lastName);
        registerPage.enterMobileNumber(mobileNumber);
        registerPage.clickSendOtpButton();
        registerPage.enterOTP(otp);
        registerPage.enterEmail(email);
        registerPage.enterPassword(password);
        registerPage.enterConfirmPassword(confirmPassword);
        registerPage.checkTermsCheckBox();
        registerPage.clickRegisterButton();
    }

    @Test(priority = 8)
    public void registerWithInvalidMobileNumber() throws Exception {
        registerPage = new RegisterPage();

        String firstName = "Tom";
        String middleName = "Thomas";
        String lastName = "Hardy";
        String mobileNumber = "123";
        String otp = "123456";
        String email = "tom.test@example.com";
        String password = "Test@1234";
        String confirmPassword = "Test@1234";

        registerPage.clickLandingRegisterButton();
        registerPage.enterFirstName(firstName);
        registerPage.enterMiddleName(middleName);
        registerPage.enterLastName(lastName);
        registerPage.enterMobileNumber(mobileNumber);
        registerPage.clickSendOtpButton();
        registerPage.enterOTP(otp);
        registerPage.enterEmail(email);
        registerPage.enterPassword(password);
        registerPage.enterConfirmPassword(confirmPassword);
        registerPage.checkTermsCheckBox();
        registerPage.clickRegisterButton();
    }

    @Test(priority = 9)
    public void registerWithWrongOTP() throws Exception {
        registerPage = new RegisterPage();

        String firstName = "Wrong";
        String middleName = "OTP";
        String lastName = "Test";
        String mobileNumber = "9876543217";
        String wrongOtp = "000000";
        String email = "wrong.otp@example.com";
        String password = "Test@1234";
        String confirmPassword = "Test@1234";


        registerPage.clickLandingRegisterButton();
        registerPage.enterFirstName(firstName);
        registerPage.enterMiddleName(middleName);
        registerPage.enterLastName(lastName);
        registerPage.enterMobileNumber(mobileNumber);
        registerPage.clickSendOtpButton();
        registerPage.enterOTP(wrongOtp);
        registerPage.enterEmail(email);
        registerPage.enterPassword(password);
        registerPage.enterConfirmPassword(confirmPassword);
        registerPage.checkTermsCheckBox();
        registerPage.clickRegisterButton();
    }

    @Test(priority = 10)
    public void testOTPResend() throws Exception {
        registerPage = new RegisterPage();

        String firstName = "Resend";
        String middleName = "OTP";
        String lastName = "Test";
        String mobileNumber = "9876543218";
        String otp = "123456";

        registerPage.clickLandingRegisterButton();
        registerPage.enterFirstName(firstName);
        registerPage.enterMiddleName(middleName);
        registerPage.enterLastName(lastName);
        registerPage.enterMobileNumber(mobileNumber);
        registerPage.clickSendOtpButton();
        registerPage.clickSendOtpButton();
        registerPage.enterOTP(otp);
    }*/
}