package pages;

import Device.DriverThreadManager;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ActionUtilities;
import utilities.TimeUtil;

import java.io.IOException;



public class MyAvailabilityPage extends ActionUtilities {

    public MyAvailabilityPage() {

        PageFactory.initElements(new AppiumFieldDecorator(DriverThreadManager.getDriver()), this);

    }

    String startTimes = TimeUtil.getNextQuarterHour();
    String endTime = TimeUtil.getEndTime(startTimes);


    @FindBy(xpath = "//android.widget.Button[@content-desc=\"Availability\n" +
            "Availability\"]")
    public WebElement myAvailabilityIcon;

    @FindBy(xpath = "//android.widget.Button[@content-desc=\"add_avl2_floating_button\"]")
    public WebElement plusIcon;

    @FindBy(xpath = "//android.widget.EditText[@resource-id=\"select_slot_date_field\"]")
    public WebElement selectDate;

    @FindBy(xpath = "//android.widget.Button[@content-desc=\"OK\"]")
    public WebElement okButton;

    @FindBy(xpath = "//android.widget.Button[@content-desc=\"Start Time\"]")
    public WebElement startTime;

    @FindBy(xpath = "//android.widget.Button[@content-desc=\"End Time\"]")
    public WebElement selectEndTime;


    @FindBy(xpath = "//android.widget.Button[@content-desc=\"availability_create_button\"]")
    public WebElement confirmButton;

    @FindBy(xpath = "//android.widget.Button[@content-desc=\"slot_confirm_success_button\"]")
    public WebElement confirmOkButton;

    @FindBy(xpath = "//android.view.View[@content-desc=\"account_detail_confirm\n" +
            "Set this Slot all day\"]")
    public WebElement selectAllDay;

    @FindBy(xpath = "//android.view.View[@content-desc=\"day_select_tab\n" +
            "Day Wise\"]")
    public WebElement dayWiseButton;







    public void setMyAvailabilityFunction() throws IOException, InterruptedException {
        click(myAvailabilityIcon);
        click(plusIcon);
        click(selectDate);
        click(okButton);

    }

    public void selectTimeSlots() throws IOException, InterruptedException {
        click(startTime);

        String startTime = TimeUtil.getNextQuarterHour();
        String endTime = TimeUtil.getEndTime(startTime);

        Thread.sleep(2000);
        DriverThreadManager.getDriver().findElement(
                By.xpath("//android.widget.Button[@content-desc='" + startTime + "']")
        ).click();

        Thread.sleep(2000);

        click(selectEndTime);

        DriverThreadManager.getDriver().findElement(
                By.xpath("//android.widget.Button[@content-desc='" + endTime + "']")
        ).click();

        Thread.sleep(2000);

        click(confirmButton);
        Thread.sleep(2000);

        click(confirmOkButton);
    }

    public void setDayWiseAvailabilityFunction() throws IOException, InterruptedException {
        click(myAvailabilityIcon);
        click(plusIcon);
        click(startTime);
        click(selectAllDay);

        String startTime = TimeUtil.getNextQuarterHour();
        String endTime = TimeUtil.getEndTime(startTime);

        Thread.sleep(2000);
        DriverThreadManager.getDriver().findElement(
                By.xpath("//android.widget.Button[@content-desc='" + startTime + "']")
        ).click();

        Thread.sleep(2000);

        click(selectEndTime);

        DriverThreadManager.getDriver().findElement(
                By.xpath("//android.widget.Button[@content-desc='" + endTime + "']")
        ).click();

        Thread.sleep(2000);

        click(confirmButton);
        Thread.sleep(2000);

        click(confirmOkButton);
        Thread.sleep(2000);
        click(dayWiseButton);
    }



}
