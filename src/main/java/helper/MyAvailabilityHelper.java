package helper;
import Device.DriverThreadManager;
import io.appium.java_client.AppiumBy;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;

public class MyAvailabilityHelper {


    public static String getTomorrowDateDescription() {

        LocalDate tomorrow = LocalDate.now().plusDays(1);

        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("d, EEEE, MMMM d, yyyy", Locale.ENGLISH);

        return tomorrow.format(formatter);
    }

    public static String selectNextQuarterTime() {

        LocalTime now = LocalTime.now();

        int minutes = now.getMinute();
        int remainder = minutes % 15;
        int minutesToAdd = (remainder == 0) ? 15 : (15 - remainder);

        LocalTime nextQuarter = now.plusMinutes(minutesToAdd);

        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("h:mm a");

        return nextQuarter.format(formatter);
    }


    public static String getEndTime(String startingTime) {

        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("h:mm a");

        LocalTime start = LocalTime.parse(startingTime, formatter);

        LocalTime end = start.plusHours(1);

        return end.format(formatter);
    }

    public static void selectTomorrowDate() {

        String dateDescription = getTomorrowDateDescription();

        String dynamicXpath = String.format(
                "//android.widget.Button[@content-desc='%s']",
                dateDescription
        );

        DriverThreadManager.getDriver()
                .findElement(AppiumBy.xpath(dynamicXpath))
                .click();
    }

    public static String getTomorrowDayName() {

        LocalDate tomorrow = LocalDate.now().plusDays(1);

        return tomorrow.getDayOfWeek()
                .getDisplayName(TextStyle.FULL, Locale.ENGLISH);
    }

    public static void selectSlotForTomorrow() {

        String dayName = getTomorrowDayName();

        String dynamicXpath = String.format(
                "//android.view.View[@content-desc='Set this slot for all %s']",
                dayName
        );

        DriverThreadManager.getDriver()
                .findElement(AppiumBy.xpath(dynamicXpath))
                .click();
    }

}
