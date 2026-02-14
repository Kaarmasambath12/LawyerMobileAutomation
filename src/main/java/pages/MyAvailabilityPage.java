package pages;

import Device.DriverThreadManager;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ActionUtilities;

import java.io.IOException;

import static helper.MyAvailabilityHelper.*;


public class MyAvailabilityPage extends ActionUtilities {

    public MyAvailabilityPage() {

        PageFactory.initElements(new AppiumFieldDecorator(DriverThreadManager.getDriver()), this);
    }

    @FindBy(xpath = "//android.widget.ImageView[@content-desc=\"Availability\n" +
            "Tab 3 of 5\"]")
    public WebElement myAvailabilityIcon;

    @FindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.Button")
    public WebElement plusIcon;

    @FindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]")
    public WebElement selectDate;

    @FindBy(xpath = "//android.widget.Button[@content-desc=\"OK\"]")
    public WebElement okButton;

    @FindBy(xpath = "//android.widget.Button[@content-desc=\"Start Time\"]")
    public WebElement startTime;

    @FindBy(xpath = "//android.widget.Button[@content-desc=\"8:00 AM\"]")
    public WebElement selectStartTime;

    @FindBy(xpath = "//android.widget.Button[@content-desc=\"9:00 AM\"]")
    public WebElement selectEndTime;

    @FindBy(xpath = "//android.widget.Button[@content-desc=\"End Time\"]")
    public WebElement endTimeSelect;

    @FindBy(xpath = "//android.widget.Button[@content-desc=\"Create\"]")
    public WebElement createButton;

    @FindBy(xpath = "//android.widget.Button[@content-desc=\"Confirm\"]")
    public WebElement confirmButton;

    @FindBy(xpath = "//android.view.View[@content-desc=\"Day Wise\"]")
    public WebElement dayWiseButton;

    @FindBy(xpath = "//android.view.View[@content-desc=\"Start Time\n" +
            "08:00 AM\n" +
            "End Time\n" +
            "09:00 AM\"]/android.widget.ImageView[2]")
    public WebElement editButton;

    @FindBy(xpath = "//android.widget.Button[@content-desc=\"9:00 AM\"]")
    public WebElement editSelectEndTime;

    @FindBy(xpath = "//android.widget.Button[@content-desc=\"9:15 AM\"]")
    public WebElement newEndTime;

    @FindBy(xpath = "//android.widget.Button[@content-desc=\"Update\"]")
    public WebElement updateButton;






    public void selectStartAndEndTime() throws InterruptedException {

        // Generate start time
        String startingTime = selectNextQuarterTime();

        String startXpath = String.format(
                "//android.widget.Button[@content-desc='%s']",
                startingTime);

        DriverThreadManager.getDriver()
                .findElement(AppiumBy.xpath(startXpath))
                .click();

        Thread.sleep(2000);

        endTimeSelect.click();

        // Generate end time
        String endTime = getEndTime(startingTime);

        String endXpath = String.format(
                "//android.widget.Button[@content-desc='%s']",
                endTime);

        DriverThreadManager.getDriver()
                .findElement(AppiumBy.xpath(endXpath))
                .click();
    }


    public void setMyAvailabilityFunction() throws IOException, InterruptedException {
        click(myAvailabilityIcon);
        click(plusIcon);
        click(selectDate);
        click(okButton);
        click(startTime);
        selectStartAndEndTime();
        click(createButton);
        click(confirmButton);
    }

    public void setDayWiseAvailabilityFunction() throws IOException, InterruptedException {
        click(myAvailabilityIcon);
        click(plusIcon);
        click(selectDate);
        selectTomorrowDate();
        click(okButton);
        selectSlotForTomorrow();
        click(startTime);
       click(selectStartTime);
       Thread.sleep(2000);
       click(endTimeSelect);
       click(selectEndTime);
        click(createButton);
        click(confirmButton);

    }

    public void editDayWiseSlotFunction() throws IOException {
        click(myAvailabilityIcon);
        click(dayWiseButton);
        click(editButton);
        click(editSelectEndTime);
        click(newEndTime);
        click(updateButton);
        click(confirmButton);

    }

    public void clickSlotEditIcon(String startTime, String endTime) {

        String xpath = String.format(
                "//android.view.View[contains(@content-desc,'Start Time') " +
                        "and contains(@content-desc,'%s') " +
                        "and contains(@content-desc,'%s')]" +
                        "/android.widget.ImageView[3]",
                startTime,
                endTime
        );

        DriverThreadManager.getDriver()
                .findElement(AppiumBy.xpath(xpath))
                .click();
    }

    public void editDateWiseSlotFunction() throws IOException, InterruptedException {
        Thread.sleep(2000);
        click(myAvailabilityIcon);
        Thread.sleep(2000);
        String startTime = selectNextQuarterTime();
        String endTime = getEndTime(startTime);
        clickSlotEditIcon(startTime, endTime);
        click(updateButton);
    }

}
