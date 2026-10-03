package lawyerPages;

import Device.DriverThreadManager;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.ActionUtilities;
import utilities.ADBUtil;
import utilities.OTPUtility;

import java.io.IOException;
import java.time.Duration;


public class RegisterPage extends ActionUtilities {

    WebDriverWait wait = new WebDriverWait(
            DriverThreadManager.getDriver(),
            Duration.ofSeconds(20));

    public RegisterPage() {
        PageFactory.initElements(new AppiumFieldDecorator(DriverThreadManager.getDriver()), this);
    }

    @FindBy(xpath = "//android.widget.Button[@content-desc=\"register_bottom_button\"]")
    public WebElement landingRegister;

    @FindBy(xpath = "//android.widget.Button[@resource-id=''][@index=1]")
    public WebElement backButton;

    @FindBy(xpath = "//android.widget.EditText[@resource-id='first_name_text_field']")
    public WebElement firstNameField;

    @FindBy(xpath = "//android.widget.EditText[@resource-id='middle_ name_text_field']")
    public WebElement middleNameField;

    @FindBy(xpath = "//android.widget.EditText[@resource-id='last_name_text__field']")
    public WebElement lastNameField;

    @FindBy(xpath = "//android.widget.EditText[@resource-id='mobile_number_textfield']")
    public WebElement mobileNumberField;

    @AndroidFindBy(xpath = "//android.widget.Button[@bounds='[969,1019][1049,1166]']")
    public WebElement sendOtpButton;

    @FindBy(xpath = "//android.widget.EditText[@bounds='[212,1214][304,1361]']")
    public WebElement otpField1;

    @FindBy(xpath = "//android.widget.EditText[@bounds='[325,1214][417,1361]']")
    public WebElement otpField2;

    @FindBy(xpath = "//android.widget.EditText[@bounds='[438,1214][530,1361]']")
    public WebElement otpField3;

    @FindBy(xpath = "//android.widget.EditText[@bounds='[551,1214][642,1361]']")
    public WebElement otpField4;

    @FindBy(xpath = "//android.widget.EditText[@bounds='[663,1214][755,1361]']")
    public WebElement otpField5;

    @FindBy(xpath = "//android.widget.EditText[@bounds='[776,1214][868,1361]']")
    public WebElement otpField6;

    @FindBy(xpath = "//android.widget.EditText[@resource-id='email_text_field']")
    public WebElement emailField;

    @FindBy(xpath = "//android.widget.EditText[@resource-id='password_text_field']")
    public WebElement passwordField;

    @FindBy(xpath = "//android.widget.EditText[@resource-id='confirm_password_text_field']")
    public WebElement confirmPasswordField;

    @FindBy(xpath = "//android.widget.CheckBox[@resource-id='terms_agree_check_box']")
    public WebElement termsCheckBox;

    @FindBy(xpath = "//android.widget.Button[@content-desc='terms_text_icon_button']")
    public WebElement termsTextButton;

    @FindBy(xpath = "//android.widget.Button[@resource-id='register_button']")
    public WebElement registerButton;

    @FindBy(xpath = "//android.widget.Button[@resource-id='login_text_icon_button']")
    public WebElement loginLink;


    public void clickLandingRegisterButton() throws IOException {
        wait.until(ExpectedConditions.elementToBeClickable(landingRegister));
        click(landingRegister);
    }

    public void enterFirstName(String firstName) throws Exception {
        clickLandingRegisterButton();
        wait.until(ExpectedConditions.visibilityOf(firstNameField));
        wait.until(ExpectedConditions.elementToBeClickable(firstNameField));
        click(firstNameField);
        Thread.sleep(300);
        ADBUtil.typeText(firstName);
        Thread.sleep(300);
    }

    public void enterMiddleName(String middleName) throws Exception {
        wait.until(ExpectedConditions.visibilityOf(middleNameField));
        wait.until(ExpectedConditions.elementToBeClickable(middleNameField));
        click(middleNameField);
        Thread.sleep(300);
        ADBUtil.typeText(middleName);
        Thread.sleep(300);
    }

    public void enterLastName(String lastName) throws Exception {
        wait.until(ExpectedConditions.visibilityOf(lastNameField));
        wait.until(ExpectedConditions.elementToBeClickable(lastNameField));
        click(lastNameField);
        Thread.sleep(300);
        ADBUtil.typeText(lastName);
        Thread.sleep(300);
    }

    public void enterMobileNumber(String mobileNumber) throws Exception {
        wait.until(ExpectedConditions.visibilityOf(mobileNumberField));
        wait.until(ExpectedConditions.elementToBeClickable(mobileNumberField));
        click(mobileNumberField);
        Thread.sleep(300);
        ADBUtil.typeText(mobileNumber);
        Thread.sleep(300);
    }

    public void clickSendOtpButton() throws IOException {
        wait.until(ExpectedConditions.elementToBeClickable(sendOtpButton));
        click(sendOtpButton);
    }

    public void enterOTP(String otp) throws Exception {
        if (otp.length() != 6) {
            throw new IllegalArgumentException("OTP must be 6 digits");
        }

        wait.until(ExpectedConditions.visibilityOf(otpField1));
        click(otpField1);
        Thread.sleep(200);
        ADBUtil.typeText(String.valueOf(otp.charAt(0)));
        Thread.sleep(200);

        wait.until(ExpectedConditions.elementToBeClickable(otpField2));
        click(otpField2);
        Thread.sleep(200);
        ADBUtil.typeText(String.valueOf(otp.charAt(1)));
        Thread.sleep(200);

        wait.until(ExpectedConditions.elementToBeClickable(otpField3));
        click(otpField3);
        Thread.sleep(200);
        ADBUtil.typeText(String.valueOf(otp.charAt(2)));
        Thread.sleep(200);

        wait.until(ExpectedConditions.elementToBeClickable(otpField4));
        click(otpField4);
        Thread.sleep(200);
        ADBUtil.typeText(String.valueOf(otp.charAt(3)));
        Thread.sleep(200);

        wait.until(ExpectedConditions.elementToBeClickable(otpField5));
        click(otpField5);
        Thread.sleep(200);
        ADBUtil.typeText(String.valueOf(otp.charAt(4)));
        Thread.sleep(200);

        wait.until(ExpectedConditions.elementToBeClickable(otpField6));
        click(otpField6);
        Thread.sleep(200);
        ADBUtil.typeText(String.valueOf(otp.charAt(5)));
        Thread.sleep(200);
    }

    public void enterEmail(String email) throws Exception {
        wait.until(ExpectedConditions.visibilityOf(emailField));
        wait.until(ExpectedConditions.elementToBeClickable(emailField));
        click(emailField);
        Thread.sleep(300);
        ADBUtil.typeText(email);
        Thread.sleep(300);
    }

    public void enterPassword(String password) throws Exception {
        wait.until(ExpectedConditions.visibilityOf(passwordField));
        wait.until(ExpectedConditions.elementToBeClickable(passwordField));
        click(passwordField);
        Thread.sleep(300);
        ADBUtil.typeText(password);
        Thread.sleep(300);
    }

    public void enterConfirmPassword(String confirmPassword) throws Exception {
        wait.until(ExpectedConditions.visibilityOf(confirmPasswordField));
        wait.until(ExpectedConditions.elementToBeClickable(confirmPasswordField));
        click(confirmPasswordField);
        Thread.sleep(300);
        ADBUtil.typeText(confirmPassword);
        Thread.sleep(300);
    }

    public void checkTermsCheckBox() throws IOException {
        wait.until(ExpectedConditions.elementToBeClickable(termsCheckBox));
        if (!termsCheckBox.isSelected()) {
            click(termsCheckBox);
        }
    }

    public void clickRegisterButton() throws IOException {
        wait.until(ExpectedConditions.elementToBeClickable(registerButton));
        hideKeyboardIfDisplayed();
        click(registerButton);
    }

    public void clickLoginLink() throws IOException {
        wait.until(ExpectedConditions.elementToBeClickable(loginLink));
        click(loginLink);
    }

    public void clearOTPFields() throws IOException {
        otpField1.clear();
        otpField2.clear();
        otpField3.clear();
        otpField4.clear();
        otpField5.clear();
        otpField6.clear();
    }

    public void enterOTPAutomatically(String mobileNumber, OTPUtility.OTPSource source) throws Exception {
        String otp = OTPUtility.getOTPWithRetry(mobileNumber, source, 5, 3);
        if (otp != null && otp.length() == 6) {
            enterOTP(otp);
        } else {
            throw new Exception("Failed to retrieve valid OTP for mobile: " + mobileNumber);
        }
    }

    public void registerUserWithAutoOTP(String firstName, String middleName, String lastName,
                                       String mobileNumber, String email, String password,
                                       String confirmPassword, OTPUtility.OTPSource otpSource) throws Exception {
        enterFirstName(firstName);
        enterMiddleName(middleName);
        enterLastName(lastName);
        enterMobileNumber(mobileNumber);
        clickSendOtpButton();
        wait.until(ExpectedConditions.visibilityOf(otpField1));
        enterOTPAutomatically(mobileNumber, otpSource);
        enterEmail(email);
        enterPassword(password);
        enterConfirmPassword(confirmPassword);
        checkTermsCheckBox();
        clickRegisterButton();
    }

    public void registerUser(String firstName, String middleName, String lastName,
                            String mobileNumber, String otp, String email, String password, String confirmPassword) throws Exception {
        enterFirstName(firstName);
        enterMiddleName(middleName);
        enterLastName(lastName);
        enterMobileNumber(mobileNumber);
        clickSendOtpButton();
        wait.until(ExpectedConditions.visibilityOf(otpField1));
        enterOTP(otp);
        enterEmail(email);
        enterPassword(password);
        enterConfirmPassword(confirmPassword);
        checkTermsCheckBox();
        clickRegisterButton();
    }

}