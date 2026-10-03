package lawyerPages;

import Device.DriverThreadManager;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ActionUtilities;

import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class MyAvailabilityPage extends ActionUtilities {

    // ============================================================
    // CONSTRUCTOR
    // ============================================================

    public MyAvailabilityPage() {
        PageFactory.initElements(
                new AppiumFieldDecorator(DriverThreadManager.getDriver()),
                this
        );
    }


    @FindBy(id = "nav_availability_tab_active")
    public WebElement myAvailabilityIcon;
    @FindBy(id = "add_avl2_floating_button")
    public WebElement plusIcon;
    @FindBy(id = "select_slot_date_field")
    public WebElement selectDate;
    @FindBy(xpath = "//android.widget.Button[@content-desc='OK' and @enabled='true'][last()]")
    public WebElement okButton;
    @FindBy(xpath = "//android.widget.Button[@content-desc='Start Time']")
    public WebElement startTime;
    @FindBy(xpath = "//android.widget.Button[@content-desc='End Time']")
    public WebElement selectEndTime;
    @FindBy(id = "availability_create_button")
    public WebElement confirmButton;
    @FindBy(id = "slot_confirm_success_button")
    public WebElement confirmOkButton;

    @FindBy(id = "account_detail_confirm")
    public WebElement selectAllDay;
    @FindBy(id = "day_select_tab")
    public WebElement dayWiseButton;
    @FindBy(id = "slot_confirm_cancel_button")
    public WebElement confirmCancelButton;
    @FindBy(id = "back_button")
    public WebElement backButton;

    public void slotBookingMethod() throws IOException, InterruptedException {
        click(myAvailabilityIcon);
        Thread.sleep(2000);
        click(plusIcon);
        Thread.sleep(2000);
        click(selectDate);
        Thread.sleep(1000);
        click(okButton);
        Thread.sleep(2000);
    }

    public void selectTimeSlots()
            throws IOException, InterruptedException {
        String startTimeValue = getDynamicStartTime();
        selectStartTime();
        selectEndTime(startTimeValue);
    }

    public String getDynamicStartTime() {
        LocalTime now = LocalTime.now();

        LocalTime bufferTime = now.plusMinutes(15);
        int minute = bufferTime.getMinute();

        int nextQuarter = ((minute + 14) / 15) * 15;

        LocalTime startTime;

        if (nextQuarter >= 60) {
            startTime = bufferTime
                    .plusHours(1)
                    .withMinute(0)
                    .withSecond(0)
                    .withNano(0);
        } else {
            startTime = bufferTime
                    .withMinute(nextQuarter)
                    .withSecond(0)
                    .withNano(0);
        }

        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("h:mm a", Locale.ENGLISH);

        return startTime.format(formatter);
    }

    public String getDynamicEndTime(String startTimeValue) {
        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("h:mm a", Locale.ENGLISH);
        LocalTime startTime =
                LocalTime.parse(startTimeValue, formatter);
        LocalTime endTime =
                startTime.plusHours(1);
        return endTime.format(formatter);
    }

    public void selectStartTime()
            throws IOException, InterruptedException {
        String startTimeValue = getDynamicStartTime();
        System.out.println("Start Time: " + startTimeValue);
        click(startTime);
        Thread.sleep(1000);
        By startTimeLocator = By.xpath(
                "//android.widget.Button[@content-desc=\"" + startTimeValue + "\" and @clickable=\"true\"]");

        explicitlyWaitForElementToBeClickable(startTimeLocator);
        DriverThreadManager.getDriver().findElement(startTimeLocator).click();
    }

    public void selectEndTime(String startTimeValue)
            throws IOException, InterruptedException {
        String endTimeValue =
                getDynamicEndTime(startTimeValue);
        System.out.println("End Time: " + endTimeValue);
        click(selectEndTime);
        Thread.sleep(1000);
        By endTimeLocator = By.xpath(
                "//android.widget.Button[@content-desc=\"" + endTimeValue + "\" and @clickable=\"true\"]");

        explicitlyWaitForElementToBeClickable(endTimeLocator);
        DriverThreadManager.getDriver().findElement(endTimeLocator).click();
    }

    public void confirmButtonMethod() throws IOException {
        click(confirmButton);
        click(confirmOkButton);
    }


    public void deleteSlot(String date) throws Exception {
        By deleteButtonLocator = By.xpath(
                "//android.view.View[@content-desc=\"" + date + "\"]" +
                        "/following-sibling::android.widget.ImageView[@clickable='true'][1]");

        explicitlyWaitForElementToBeClickable(deleteButtonLocator);
        DriverThreadManager.getDriver().findElement(deleteButtonLocator).click();
    }

    public void bookSlotDayWise() throws IOException, InterruptedException {
        click(myAvailabilityIcon);
        Thread.sleep(2000);
        click(dayWiseButton);
        Thread.sleep(2000);
        click(plusIcon);
        Thread.sleep(2000);
        click(selectDate);
        Thread.sleep(1000);
        click(okButton);
        Thread.sleep(2000);
    }
}