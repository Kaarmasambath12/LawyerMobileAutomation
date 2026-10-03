package utilities;

public class ADBUtil {

    public static void tap(int x, int y) {
        try {
            Process process = Runtime.getRuntime().exec(
                    "adb shell input tap " + x + " " + y
            );
            process.waitFor();
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void typeText(String text) {
        try {
            // Send entire text at once - more reliable for phone numbers and special chars
            String[] cmd = {"adb", "shell", "input", "text", text};
            Process process = Runtime.getRuntime().exec(cmd);
            int exitCode = process.waitFor();

            if (exitCode == 0) {
                System.out.println("✓ Text entered successfully: " + text);
                Thread.sleep(500);
            } else {
                System.out.println("✗ Failed to enter text. Exit code: " + exitCode);
            }
        } catch (Exception e) {
            System.out.println("✗ Error typing text: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void pressEnter() {
        try {
            Runtime.getRuntime()
                    .exec("adb shell input keyevent 66")
                    .waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void pressKeyCode(int keyCode) {
        try {
            Runtime.getRuntime()
                    .exec("adb shell input keyevent " + keyCode)
                    .waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Enter text into a field using ADB - optimized for phone numbers and special characters
     * @param text - Text to enter (e.g., phone number like "9876543210")
     * @return true if successful, false otherwise
     */
    public static boolean enterTextViaADB(String text) {
        try {
            // Validate input
            if (text == null || text.isEmpty()) {
                System.out.println("✗ Text cannot be empty");
                return false;
            }

            // Method 1: Using array format (handles special characters better)
            String[] cmd = {"adb", "shell", "input", "text", text};
            Process process = Runtime.getRuntime().exec(cmd);
            int exitCode = process.waitFor();

            if (exitCode == 0) {
                System.out.println("✓ ADB text input successful: " + text);
                Thread.sleep(500);  // Wait for input to register
                return true;
            } else {
                System.out.println("✗ ADB command failed with exit code: " + exitCode);
                return false;  // Don't fallback - let TextInputUtil handle it
            }
        } catch (Exception e) {
            System.out.println("✗ Error entering text via ADB: " + e.getMessage());
            return false;
        }
    }

    /**
     * Fallback method - Enter text using Appium's sendKeys (if ADB fails)
     */
    private static boolean enterTextViaAppium(String text) {
        try {
            System.out.println("⚠ Falling back to Appium sendKeys method");
            // This would require passing WebElement - implemented in ActionUtilities instead
            System.out.println("✓ Use ActionUtilities.sendKey(element, text) instead");
            return false;
        } catch (Exception e) {
            System.out.println("✗ Error: " + e.getMessage());
            return false;
        }
    }
}
