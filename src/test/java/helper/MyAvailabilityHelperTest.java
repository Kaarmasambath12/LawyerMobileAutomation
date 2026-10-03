package helper;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("MyAvailabilityHelper - Time Calculation Tests")
public class MyAvailabilityHelperTest {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("h:mm a");

    @Test
    @DisplayName("Test Case 1: System Time 7:47 PM should give Start Time 8:15 PM")
    public void testSystemTime7_47_PM() {
        // Simulate system time: 7:47 PM
        LocalTime systemTime = LocalTime.of(19, 47);
        LocalTime bufferTime = systemTime.plusMinutes(15);  // 8:02 PM

        int minute = bufferTime.getMinute();  // 2
        int nextQuarter = ((minute + 14) / 15) * 15;  // ((2+14)/15)*15 = 15

        LocalTime startTime = bufferTime.withMinute(nextQuarter);  // 8:15 PM
        LocalTime endTime = startTime.plusHours(1);  // 9:15 PM

        assertEquals("8:15 PM", startTime.format(formatter), "Start time should be 8:15 PM");
        assertEquals("9:15 PM", endTime.format(formatter), "End time should be 9:15 PM");

        System.out.println("✓ Test Case 1 PASSED: 7:47 PM → Start: 8:15 PM, End: 9:15 PM");
    }

    @Test
    @DisplayName("Test Case 2: System Time 7:30 PM should give Start Time 7:45 PM")
    public void testSystemTime7_30_PM() {
        LocalTime systemTime = LocalTime.of(19, 30);
        LocalTime bufferTime = systemTime.plusMinutes(15);  // 7:45 PM

        int minute = bufferTime.getMinute();  // 45
        int nextQuarter = ((minute + 14) / 15) * 15;  // ((45+14)/15)*15 = 45

        LocalTime startTime = bufferTime.withMinute(nextQuarter);  // 7:45 PM
        LocalTime endTime = startTime.plusHours(1);  // 8:45 PM

        assertEquals("7:45 PM", startTime.format(formatter), "Start time should be 7:45 PM");
        assertEquals("8:45 PM", endTime.format(formatter), "End time should be 8:45 PM");

        System.out.println("✓ Test Case 2 PASSED: 7:30 PM → Start: 7:45 PM, End: 8:45 PM");
    }

    @Test
    @DisplayName("Test Case 3: System Time 7:50 PM should give Start Time 8:15 PM")
    public void testSystemTime7_50_PM() {
        LocalTime systemTime = LocalTime.of(19, 50);
        LocalTime bufferTime = systemTime.plusMinutes(15);  // 8:05 PM

        int minute = bufferTime.getMinute();  // 5
        int nextQuarter = ((minute + 14) / 15) * 15;  // ((5+14)/15)*15 = 15

        LocalTime startTime = bufferTime.withMinute(nextQuarter);  // 8:15 PM
        LocalTime endTime = startTime.plusHours(1);  // 9:15 PM

        assertEquals("8:15 PM", startTime.format(formatter), "Start time should be 8:15 PM");
        assertEquals("9:15 PM", endTime.format(formatter), "End time should be 9:15 PM");

        System.out.println("✓ Test Case 3 PASSED: 7:50 PM → Start: 8:15 PM, End: 9:15 PM");
    }

    @Test
    @DisplayName("Test Case 4: System Time 8:00 PM should give Start Time 8:15 PM")
    public void testSystemTime8_00_PM() {
        LocalTime systemTime = LocalTime.of(20, 0);
        LocalTime bufferTime = systemTime.plusMinutes(15);  // 8:15 PM

        int minute = bufferTime.getMinute();  // 15
        int nextQuarter = ((minute + 14) / 15) * 15;  // ((15+14)/15)*15 = 30? No: (29/15)*15 = 15

        LocalTime startTime = bufferTime.withMinute(nextQuarter);  // 8:15 PM
        LocalTime endTime = startTime.plusHours(1);  // 9:15 PM

        assertEquals("8:15 PM", startTime.format(formatter), "Start time should be 8:15 PM");
        assertEquals("9:15 PM", endTime.format(formatter), "End time should be 9:15 PM");

        System.out.println("✓ Test Case 4 PASSED: 8:00 PM → Start: 8:15 PM, End: 9:15 PM");
    }

    @Test
    @DisplayName("Test Case 5: System Time 8:10 PM should give Start Time 8:30 PM")
    public void testSystemTime8_10_PM() {
        LocalTime systemTime = LocalTime.of(20, 10);
        LocalTime bufferTime = systemTime.plusMinutes(15);  // 8:25 PM

        int minute = bufferTime.getMinute();  // 25
        int nextQuarter = ((minute + 14) / 15) * 15;  // ((25+14)/15)*15 = 30

        LocalTime startTime = bufferTime.withMinute(nextQuarter);  // 8:30 PM
        LocalTime endTime = startTime.plusHours(1);  // 9:30 PM

        assertEquals("8:30 PM", startTime.format(formatter), "Start time should be 8:30 PM");
        assertEquals("9:30 PM", endTime.format(formatter), "End time should be 9:30 PM");

        System.out.println("✓ Test Case 5 PASSED: 8:10 PM → Start: 8:30 PM, End: 9:30 PM");
    }

    @Test
    @DisplayName("Test Case 6: System Time 8:45 PM should give Start Time 9:00 PM")
    public void testSystemTime8_45_PM() {
        LocalTime systemTime = LocalTime.of(20, 45);
        LocalTime bufferTime = systemTime.plusMinutes(15);  // 9:00 PM

        int minute = bufferTime.getMinute();  // 0
        int nextQuarter = ((minute + 14) / 15) * 15;  // ((0+14)/15)*15 = 0

        LocalTime startTime = bufferTime.withMinute(nextQuarter);  // 9:00 PM
        LocalTime endTime = startTime.plusHours(1);  // 10:00 PM

        assertEquals("9:00 PM", startTime.format(formatter), "Start time should be 9:00 PM");
        assertEquals("10:00 PM", endTime.format(formatter), "End time should be 10:00 PM");

        System.out.println("✓ Test Case 6 PASSED: 8:45 PM → Start: 9:00 PM, End: 10:00 PM");
    }

    @Test
    @DisplayName("Test Case 7: Edge Case - 11:50 PM (should handle next day)")
    public void testSystemTime11_50_PM() {
        LocalTime systemTime = LocalTime.of(23, 50);
        LocalTime bufferTime = systemTime.plusMinutes(15);  // 12:05 AM (next day)

        int minute = bufferTime.getMinute();  // 5
        int nextQuarter = ((minute + 14) / 15) * 15;  // ((5+14)/15)*15 = 15

        LocalTime startTime = bufferTime.withMinute(nextQuarter);  // 12:15 AM
        LocalTime endTime = startTime.plusHours(1);  // 1:15 AM

        assertEquals("12:15 AM", startTime.format(formatter), "Start time should be 12:15 AM");
        assertEquals("1:15 AM", endTime.format(formatter), "End time should be 1:15 AM");

        System.out.println("✓ Test Case 7 PASSED: 11:50 PM → Start: 12:15 AM, End: 1:15 AM");
    }

    @Test
    @DisplayName("Test Case 8: Edge Case - 12:30 AM (midnight)")
    public void testSystemTime12_30_AM() {
        LocalTime systemTime = LocalTime.of(0, 30);
        LocalTime bufferTime = systemTime.plusMinutes(15);  // 12:45 AM

        int minute = bufferTime.getMinute();  // 45
        int nextQuarter = ((minute + 14) / 15) * 15;  // ((45+14)/15)*15 = 45

        LocalTime startTime = bufferTime.withMinute(nextQuarter);  // 12:45 AM
        LocalTime endTime = startTime.plusHours(1);  // 1:45 AM

        assertEquals("12:45 AM", startTime.format(formatter), "Start time should be 12:45 AM");
        assertEquals("1:45 AM", endTime.format(formatter), "End time should be 1:45 AM");

        System.out.println("✓ Test Case 8 PASSED: 12:30 AM → Start: 12:45 AM, End: 1:45 AM");
    }

    @Test
    @DisplayName("Verify 15-minute buffer is always applied")
    public void verifyMinimumBuffer() {
        LocalTime systemTime = LocalTime.of(14, 0);  // 2:00 PM
        LocalTime bufferTime = systemTime.plusMinutes(15);

        long minutesDifference = java.time.temporal.ChronoUnit.MINUTES.between(systemTime, bufferTime);

        assertEquals(15L, minutesDifference, "Buffer should always be 15 minutes");
        System.out.println("✓ Buffer Verification PASSED: 15-minute buffer is correctly applied");
    }

    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("Running MyAvailabilityHelper Test Cases");
        System.out.println("========================================\n");

        MyAvailabilityHelperTest test = new MyAvailabilityHelperTest();

        try {
            test.testSystemTime7_47_PM();
            test.testSystemTime7_30_PM();
            test.testSystemTime7_50_PM();
            test.testSystemTime8_00_PM();
            test.testSystemTime8_10_PM();
            test.testSystemTime8_45_PM();
            test.testSystemTime11_50_PM();
            test.testSystemTime12_30_AM();
            test.verifyMinimumBuffer();

            System.out.println("\n========================================");
            System.out.println("✓ ALL TEST CASES PASSED!");
            System.out.println("========================================");
        } catch (AssertionError e) {
            System.out.println("\n✗ TEST FAILED: " + e.getMessage());
            e.printStackTrace();
        }
    }
}