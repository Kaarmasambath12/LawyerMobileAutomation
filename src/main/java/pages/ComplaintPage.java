package pages;

import Device.DriverThreadManager;
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

public class ComplaintPage extends ActionUtilities {

    public WebDriverWait wait;

    public ComplaintPage() {

        PageFactory.initElements(new AppiumFieldDecorator(DriverThreadManager.getDriver()), this);
    }

    @FindBy(xpath = "//android.widget.ImageView[@content-desc=\"Complaints\n" +
            "Tab 4 of 5\"]")
    public WebElement complaintTab;

    @FindBy(xpath = "//android.widget.Button[@content-desc=\"com_floating_button\"]")
    public WebElement plusButton;

    @FindBy(xpath = "//android.widget.EditText[@text=\"complaint_details_field\"]/android.widget.EditText")
    public WebElement raiseComplaint;

    @FindBy(xpath = "//android.widget.Button[@content-desc=\"complaint_create_button\"]")
    public WebElement raiseComplaintButton;

    @FindBy(xpath = "//android.view.View[@content-desc=\"COMPLETED\"]")
    public WebElement completedCompliant;

    @FindBy(xpath = "//android.view.View[@content-desc=\"PENDING\"]")
    public WebElement pendingComplaint;

    public void raiseComplaint(String complaintText) {

        wait.until(ExpectedConditions.visibilityOf(complaintTab)).click();

        wait.until(ExpectedConditions.visibilityOf(plusButton)).click();

        wait.until(ExpectedConditions.visibilityOf(raiseComplaint)).sendKeys(complaintText);

        wait.until(ExpectedConditions.visibilityOf(raiseComplaintButton)).click();
    }

    public boolean isComplaintCompletedDisplayed() {
        return completedCompliant.isDisplayed();
    }

    public boolean isPendingComplaintDisplayed() {
        return pendingComplaint.isDisplayed();
    }


}
