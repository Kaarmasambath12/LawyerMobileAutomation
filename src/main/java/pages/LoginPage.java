package pages;

import Device.DriverThreadManager;
import config.ReadConfig;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.ADBUtil;
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

    @FindBy(xpath = "//*[@resource-id='bottom_login_icon']")
    public WebElement loginLink;

    @FindBy(xpath = "//*[@resource-id='mobile_number_textfield']")
    public WebElement mobileNumberField;

    @FindBy(xpath = "//*[@resource-id='login_password_text_field']")
    public WebElement passwordField;

    @FindBy(xpath = "//*[@resource-id='login_button']")
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

        // Mobile field
        ADBUtil.tap(540, 1015);
        ADBUtil.typeText("9003349787");

        Thread.sleep(1000);

        // Password field
        ADBUtil.tap(540, 1210);
        ADBUtil.tap(540, 1210);

        ADBUtil.typeText("Skarthi");
        ADBUtil.pressKeyCode(77); // @
        ADBUtil.typeText("3031");

        Thread.sleep(1000);

        // Login button
        ADBUtil.tap(540, 1500);
    }

    public void clickLoginButton() throws IOException {
        wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        click(loginButton);
    }


}