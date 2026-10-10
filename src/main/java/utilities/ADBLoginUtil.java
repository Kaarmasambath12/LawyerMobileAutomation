package utilities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import Device.DriverThreadManager;

/**
 * ADB-based login utility for direct text input
 * Uses ADB for text input + WebElement locators for buttons
 */
public class ADBLoginUtil {

    // Mobile number field coordinates from XML: bounds="[63,942][1017,1089]"
    private static final int MOBILE_FIELD_X = 540;  // Center of field
    private static final int MOBILE_FIELD_Y = 1015; // Center of field

    // Password field coordinates from XML: bounds="[63,1136][1017,1283]"
    private static final int PASSWORD_FIELD_X = 540;  // Center of field
    private static final int PASSWORD_FIELD_Y = 1209; // Center of field

    private static final WebDriverWait wait = new WebDriverWait(
            DriverThreadManager.getDriver(),
            Duration.ofSeconds(15)
    );

    /**
     * Enter mobile number using ADB
     * Direct approach: tap field + send input via ADB
     */
    public static boolean enterMobileNumber(String mobileNumber) {
        System.out.println("\n[ADB LOGIN] Entering Mobile Number");
        System.out.println("Mobile: " + mobileNumber);

        try {
            // Step 1: Tap field to focus
            System.out.println("  [Step 1] Tapping field at (" + MOBILE_FIELD_X + ", " + MOBILE_FIELD_Y + ")");
            ADBUtil.tap(MOBILE_FIELD_X, MOBILE_FIELD_Y);
            Thread.sleep(800);  // Wait for field to gain focus

            // Step 2: Send input via ADB
            System.out.println("  [Step 2] Sending text via ADB...");
            if (ADBUtil.enterTextViaADB(mobileNumber)) {
                System.out.println("✓ Mobile number entered successfully");
                return true;
            } else {
                System.out.println("✗ Mobile number input failed");
                return false;
            }

        } catch (Exception e) {
            System.out.println("✗ Error entering mobile number: " + e.getMessage());
            return false;
        }
    }

    /**
     * Enter password using ADB
     * Direct approach: tap field + send input via ADB
     */
    public static boolean enterPassword(String password) {
        System.out.println("\n[ADB LOGIN] Entering Password");

        try {
            // Step 1: Tap field to focus
            System.out.println("  [Step 1] Tapping field at (" + PASSWORD_FIELD_X + ", " + PASSWORD_FIELD_Y + ")");
            ADBUtil.tap(PASSWORD_FIELD_X, PASSWORD_FIELD_Y);
            Thread.sleep(800);  // Wait for field to gain focus

            // Step 2: Send input via ADB
            System.out.println("  [Step 2] Sending text via ADB...");
            if (ADBUtil.enterTextViaADB(password)) {
                System.out.println("✓ Password entered successfully");
                return true;
            } else {
                System.out.println("✗ Password input failed");
                return false;
            }

        } catch (Exception e) {
            System.out.println("✗ Error entering password: " + e.getMessage());
            return false;
        }
    }

    /**
     * Click login button using WebElement locator (not coordinates)
     */
    public static boolean clickLoginButton(WebElement loginButton) {
        System.out.println("\n[ADB LOGIN] Clicking Login Button");

        try {
            // Step 1: Hide keyboard
            System.out.println("  [Step 1] Hiding keyboard...");
            hideKeyboard();
            Thread.sleep(500);

            System.out.println("  [Step 1b] Tapping outside keyboard area...");
            ADBUtil.tap(540, 500);
            Thread.sleep(500);

            // Step 2: Wait for keyboard to fully hide
            System.out.println("  [Step 2] Waiting for keyboard to fully hide...");
            Thread.sleep(800);

            // Step 3: Click login button using WebElement locator
            System.out.println("  [Step 3] Clicking login button using locator...");
            wait.until(ExpectedConditions.elementToBeClickable(loginButton));
            System.out.println("  ✓ Login button is clickable");

            loginButton.click();
            System.out.println("  ✓ Login button clicked");
            Thread.sleep(1000);

            System.out.println("✓ Login button clicked successfully");
            return true;

        } catch (Exception e) {
            System.out.println("✗ Error clicking login button: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Complete login flow using ADB + WebElement locators
     */
    public static boolean performLogin(String mobileNumber, String password) {
        System.out.println("\n" + "=".repeat(80));
        System.out.println("ADB LOGIN FLOW - Text via ADB, Click via Locators");
        System.out.println("=".repeat(80));

        try {
            // Step 1: Enter mobile number via ADB
            if (!enterMobileNumber(mobileNumber)) {
                System.out.println("✗ Login failed at mobile number step");
                return false;
            }

            Thread.sleep(500);

            // Step 2: Enter password via ADB
            if (!enterPassword(password)) {
                System.out.println("✗ Login failed at password step");
                return false;
            }

            Thread.sleep(500);

            System.out.println("\n" + "=".repeat(80));
            System.out.println("✓ LOGIN FLOW COMPLETED SUCCESSFULLY");
            System.out.println("=".repeat(80) + "\n");
            return true;

        } catch (Exception e) {
            System.out.println("✗ Login flow error: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Hide keyboard using multiple ADB methods
     */
    private static void hideKeyboard() throws Exception {
        try {
            // Method 1: Use input keyevent BACK (keyevent 4)
            System.out.println("    [Hiding keyboard] Sending BACK keyevent...");
            Process p1 = Runtime.getRuntime().exec("adb shell input keyevent 4");
            p1.waitFor();
            System.out.println("    ✓ BACK keyevent sent");

            Thread.sleep(300);

            // Method 2: Additional BACK to ensure keyboard is closed
            Process p2 = Runtime.getRuntime().exec("adb shell input keyevent 4");
            p2.waitFor();
            System.out.println("    ✓ Additional BACK keyevent sent");

            Thread.sleep(300);

        } catch (Exception e) {
            System.out.println("    ⚠ Keyboard hide warning: " + e.getMessage());
            // Continue anyway - button might still be clickable
        }
    }

}