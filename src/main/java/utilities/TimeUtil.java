package utilities;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class TimeUtil {
    public static String getNextQuarterHour() {

        LocalTime now = LocalTime.now();

        int minute = now.getMinute();

        int nextQuarter = ((minute / 15) + 1) * 15;

        if (nextQuarter == 60) {
            now = now.plusHours(1);
            nextQuarter = 0;
        }

        LocalTime slot = LocalTime.of(now.getHour(), nextQuarter);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("h:mm a");

        return slot.format(formatter);
    }

    public static String getEndTime(String startTime) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("h:mm a");

        LocalTime start = LocalTime.parse(startTime, formatter);

        LocalTime end = start.plusHours(1);

        return end.format(formatter);
    }
}
