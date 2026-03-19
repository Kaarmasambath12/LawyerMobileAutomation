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
import java.security.cert.X509Certificate;
import java.time.Duration;

public class ConsultationsPage extends ActionUtilities {

    public ConsultationsPage() {

        PageFactory.initElements(new AppiumFieldDecorator(DriverThreadManager.getDriver()), this);
    }

    @FindBy(xpath = "//android.widget.ImageView[@content-desc=\"Consultation\n" +
            "Tab 2 of 5\"]")
    public WebElement consultationMenu;

    @AndroidFindBy(accessibility = "continue_to_consultation_button")
    public WebElement continueButton;

    @FindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.widget.Button[1]")
    public WebElement closeButton;

    @AndroidFindBy(accessibility = "cons_floating_button")
    public WebElement filterIcon;

    @FindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View/android.widget.EditText[1]")
    public WebElement startDate;

    @FindBy(xpath = "//android.widget.Button[@content-desc=\"OK\"]")
    public WebElement okButton;

    @FindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View/android.widget.EditText[2]")
    public WebElement endDate;

    @FindBy(xpath = "//android.widget.Button[@content-desc=\"select_duration_field\n" +
            "Duration\"]")
    public WebElement duration;

    @FindBy(xpath = "//android.widget.Button[@content-desc=\"ALL\"]")
    public WebElement allFilter;

    @FindBy(xpath = "//android.widget.Button[@content-desc=\"select_specialization_field\n" +
            "Specialization\"]")
    public WebElement specializationSelection;

    @FindBy(xpath = "//android.widget.Button[@content-desc=\"ALL\"]")
    public WebElement getAllFilter;

    @FindBy(xpath = "//android.widget.Button[@content-desc=\"consultation_filter_button\"]")
    public WebElement filterButton;

    @FindBy(xpath = "//android.view.View[@content-desc=\"Completed Meet\n" +
            "Tab 2 of 3\"]")
    public WebElement completedMeet;

    @FindBy(xpath = "//android.view.View[@content-desc=\"Cancelled Meet\n" +
            "Tab 3 of 3\"]")
    public WebElement cancelledMeet;

    @FindBy(xpath = "//android.widget.ImageView[@content-desc=\"cancel_con_icon\"]")
    public WebElement cancelButton;

    @FindBy(xpath = "//android.widget.EditText")
    public WebElement cancelTextArea;

    @FindBy(xpath = "//android.widget.Button[@content-desc=\"consultation_cancel_success_button\"]")
    public WebElement cancelFinalButton;


    public void clickConsultationAndVerifyContinueIsDisabled() {

        WebDriverWait wait = new WebDriverWait(DriverThreadManager.getDriver(), Duration.ofSeconds(10));

        // Click Consultation menu
        wait.until(ExpectedConditions.elementToBeClickable(consultationMenu)).click();

        // Wait until Continue button is visible
        wait.until(ExpectedConditions.visibilityOf(continueButton));

        // Verify Continue button is disabled
        if (continueButton.isEnabled()) {
            throw new AssertionError("Continue button is ENABLED. Expected it to be DISABLED.");
        } else {
            System.out.println("Continue button is correctly DISABLED.");
            closeButton.click();
        }
    }

    public void applyConsultationFilterFunction() throws IOException, InterruptedException, IOException {

        click(filterIcon);

        click(startDate);
        click(okButton);

        click(endDate);
        click(okButton);

        click(duration);
        click(allFilter);

        click(specializationSelection);
        click(getAllFilter);

        click(filterButton);
    }

    public void verifyCompletedAndCancelledMeetData()
            throws IOException, InterruptedException {

        click(completedMeet);

        click(cancelledMeet);

    }

    public void cancelConsultationFunction()
            throws IOException, InterruptedException {

        // Open Consultation Menu
        click(consultationMenu);

        // Click Cancel Icon
        click(cancelButton);

        // Enter Cancel Reason
        cancelTextArea.sendKeys("Cancelling due to personal reason");

        // Click Final Cancel Button
        click(cancelFinalButton);
    }


}
