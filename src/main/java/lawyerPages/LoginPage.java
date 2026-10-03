package lawyerPages;

import Device.DriverThreadManager;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.ADBUtil;
import utilities.ADBLoginUtil;
import utilities.ActionUtilities;

import java.io.IOException;
import java.time.Duration;


public class LoginPage  extends ActionUtilities {
    String text = "Logout";

    WebDriverWait wait = new WebDriverWait(
            DriverThreadManager.getDriver(),
            Duration.ofSeconds(20));

    public LoginPage() {

        PageFactory.initElements(new AppiumFieldDecorator(DriverThreadManager.getDriver()), this);
    }

    @FindBy(id = "com.android.permissioncontroller:id/permission_allow_button")
    public WebElement notificationAllowButton;

    @FindBy(xpath = "//android.widget.Button[@content-desc=\"bottom_login_icon\"]")
    public WebElement loginLink;

    @FindBy(xpath = "//android.widget.EditText[@resource-id=\"mobile_number_textfield\"]")
    public WebElement mobileNumberField;

    @FindBy(xpath = "//android.widget.EditText[@resource-id=\"login_password_text_field\"]")
    public WebElement passwordField;

    @FindBy(xpath = "//android.widget.Button[@content-desc=\"login_button\"]")
    public WebElement loginButton;

    @FindBy(xpath = "//android.widget.ImageView[@content-desc=\"Profile\n" +
            "Tab 5 of 5\"]")
    public WebElement profileIcon;

    @FindBy(xpath = "//*[contains(@text,'Logout') or contains(@content-desc,'Logout')]")
    public WebElement logoutButton;

    @AndroidFindBy(accessibility = "Confirm")
    public WebElement confirmButton;


    public void clickNotificationAllow() throws IOException {
        if (notificationAllowButton.isDisplayed()) {
            click(notificationAllowButton);
        }
    }

    public void clickLoginLink() throws IOException {
        wait.until(ExpectedConditions.elementToBeClickable(loginLink));
        click(loginLink);
    }

    public void loginFunction() throws Exception {
        // Use direct ADB login utility with WebElement locator for login button
        ADBLoginUtil.performLogin("9003349787", "Skarthi@3031");
    }


    public void clickLoginButton() throws IOException {
        wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        click(loginButton);
    }


}