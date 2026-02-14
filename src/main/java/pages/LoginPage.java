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
import utilities.ActionUtilities;

import java.io.IOException;
import java.time.Duration;


public class LoginPage  extends ActionUtilities {
    String text = "Logout";

    public LoginPage() {

        PageFactory.initElements(new AppiumFieldDecorator(DriverThreadManager.getDriver()), this);
    }

    @FindBy(xpath = "//android.widget.Button[@text='Allow']")
    public WebElement notificationAllowButton;

    @FindBy(xpath = "//android.view.View[@content-desc='Login']")
    public WebElement loginLink;

    @FindBy(xpath = "//android.widget.EditText[@password='false']")
    public WebElement mobileNumberField;

    @FindBy(xpath = "//android.widget.EditText[@password='true']")
    public WebElement passwordField;

    @FindBy(xpath = "//android.widget.Button[@content-desc=\"Login\"]")
    public WebElement loginButton;

    @FindBy(xpath = "//android.widget.ImageView[@content-desc=\"Profile\n" +
            "Tab 5 of 5\"]")
    public WebElement profileIcon;

    @FindBy(xpath = "//*[contains(@text,'Logout') or contains(@content-desc,'Logout')]")
    public WebElement logoutButton;

    @AndroidFindBy(accessibility = "Confirm")
    public WebElement confirmButton;


    public void clickNotificationAllow() throws IOException {
        click(notificationAllowButton);

    }

    public void clickLoginLink() throws IOException {
        click(loginLink);

    }

    public void enterMobileNumber() throws IOException {
        sendKey(mobileNumberField, ReadConfig.prop.getProperty("MobileNumber"));
        //mobileNumberField.sendKeys("9524557835");

    }

    public void enterPassword() throws IOException {
        sendKey(passwordField, ReadConfig.prop.getProperty("Password"));
        // passwordField.sendKeys("Kasthuri@09");
    }

    public void clickLoginButton() throws IOException {
        click(loginButton);
    }

    public void notificationFunction() throws IOException {
        try {
            if (notificationAllowButton.isDisplayed()) {
                clickNotificationAllow();
            }
        } catch (Exception e) {
            clickLoginLink();
        }
    }


    // ===== Complete Login Flow =====

    public void loginFunction() throws IOException, InterruptedException {
        click(mobileNumberField);
        enterMobileNumber();
        click(passwordField);
        enterPassword();
        closeKeyboard();
        Thread.sleep(2000);
        clickLoginButton();
    }

    public void logoutFunction() throws IOException, InterruptedException {
       /* click(profileIcon);
        scrollToText("Logout");
        click(logoutButton);
        click(confirmButton);
*/

        click(profileIcon);

        WebDriverWait wait = new WebDriverWait(DriverThreadManager.getDriver(), Duration.ofSeconds(15));
        System.out.println("scroll started");

        // Scroll until Logout is visible
        scrollToText(text);
        System.out.println("scroll stopped");
        wait.until(ExpectedConditions.elementToBeClickable(confirmButton)).click();
    }
}
