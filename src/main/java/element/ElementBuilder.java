package element;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Simple element wrapper for common interactions.
 */
public class ElementBuilder {

    private static final Logger logger = LoggerFactory.getLogger(ElementBuilder.class);

    private final AppiumDriver driver;
    private final ElementLocator locator;

    public ElementBuilder(AppiumDriver driver, ElementLocator locator) {
        this.driver = driver;
        this.locator = locator;
    }

    public WebElement find() {
        WebDriverWait wait = new WebDriverWait(driver, locator.getTimeout());
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator.getBy()));
    }

    public ElementBuilder click() {
        logger.debug("Clicking: {}", locator.getDescription());
        WebDriverWait wait = new WebDriverWait(driver, locator.getTimeout());
        wait.until(ExpectedConditions.elementToBeClickable(locator.getBy())).click();
        return this;
    }

    public ElementBuilder sendKeys(String text) {
        logger.debug("Typing in {}: {}", locator.getDescription(), text);
        WebElement element = find();
        element.click();  // Ensure focus
        element.sendKeys(text);
        return this;
    }

    public ElementBuilder clear() {
        WebElement element = find();
        element.click();  // Ensure focus
        element.clear();
        return this;
    }

    public ElementBuilder clearAndType(String text) {
        WebElement element = find();
        element.click();  // Click to focus first
        try {
            Thread.sleep(500);  // Small wait after focus
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        element.clear();
        try {
            Thread.sleep(300);  // Small wait after clear
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        element.sendKeys(text);
        logger.info("Typed '{}' in {}", text, locator.getDescription());
        return this;
    }

    /**
     * Type text character by character (for problematic fields).
     */
    public ElementBuilder typeSlowly(String text) {
        logger.debug("Typing slowly in {}: {}", locator.getDescription(), text);
        WebElement element = find();
        element.click();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        element.clear();
        for (char c : text.toCharArray()) {
            element.sendKeys(String.valueOf(c));
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        return this;
    }

    /**
     * Set value using Appium's setValue - works better with Flutter/hybrid apps.
     */
    public ElementBuilder setValue(String text) {
        logger.debug("Setting value in {}: {}", locator.getDescription(), text);
        WebElement element = find();
        element.click();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        // Clear existing text
        element.clear();
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        // Use sendKeys with the full text
        element.sendKeys(text);

        // Hide keyboard if Android
        if (driver instanceof AndroidDriver) {
            try {
                ((AndroidDriver) driver).hideKeyboard();
            } catch (Exception e) {
                // Keyboard might not be visible
            }
        }
        return this;
    }

    /**
     * Type using Android keyboard - most reliable for Flutter apps.
     */
    public ElementBuilder typeUsingKeyboard(String text) {
        logger.debug("Typing using keyboard in {}: {}", locator.getDescription(), text);
        WebElement element = find();

        // Click and focus
        element.click();
        try {
            Thread.sleep(1000);  // Wait for keyboard
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // Clear field first - select all and delete
        if (driver instanceof AndroidDriver) {
            AndroidDriver androidDriver = (AndroidDriver) driver;
            try {
                // Try to clear using select all + delete
                element.clear();
                Thread.sleep(300);
            } catch (Exception e) {
                logger.debug("Clear failed, continuing...");
            }
        }

        // Send keys
        element.sendKeys(text);

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        logger.info("Typed '{}' in {}", text, locator.getDescription());
        return this;
    }

    /**
     * Type using ADB shell command - most reliable for Flutter/hybrid apps.
     */
    public ElementBuilder typeUsingAdb(String text) {
        logger.debug("Typing using ADB in {}: {}", locator.getDescription(), text);
        WebElement element = find();

        // Click and focus the field
        element.click();
        try {
            Thread.sleep(1000);  // Wait for keyboard to appear
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // Clear existing text using ADB key events (Ctrl+A, Delete)
        try {
            // Execute ADB command to clear - select all and delete
            Runtime.getRuntime().exec(new String[]{
                "adb", "shell", "input", "keyevent", "KEYCODE_MOVE_END"
            }).waitFor();
            Thread.sleep(100);

            // Select all (Ctrl+A equivalent - hold shift and move to beginning)
            Runtime.getRuntime().exec(new String[]{
                "adb", "shell", "input", "keyevent", "--longpress", "67", "67", "67", "67", "67",
                "67", "67", "67", "67", "67", "67", "67", "67", "67", "67", "67", "67", "67", "67", "67"
            }).waitFor();
            Thread.sleep(200);
        } catch (Exception e) {
            logger.debug("Clear via ADB failed: {}", e.getMessage());
        }

        // Type text using ADB - escape special characters
        try {
            String escapedText = text
                .replace("\\", "\\\\")
                .replace(" ", "\\ ")
                .replace("\"", "\\\"")
                .replace("'", "\\'")
                .replace("&", "\\&")
                .replace("<", "\\<")
                .replace(">", "\\>")
                .replace("|", "\\|")
                .replace(";", "\\;")
                .replace("(", "\\(")
                .replace(")", "\\)")
                .replace("$", "\\$")
                .replace("`", "\\`")
                .replace("@", "\\@");

            Process process = Runtime.getRuntime().exec(new String[]{
                "adb", "shell", "input", "text", escapedText
            });
            process.waitFor();

            Thread.sleep(500);
            logger.info("Typed '{}' in {} using ADB", text, locator.getDescription());
        } catch (Exception e) {
            logger.error("ADB typing failed: {}", e.getMessage());
            // Fallback to sendKeys
            element.sendKeys(text);
        }

        return this;
    }

    public String getText() {
        return find().getText();
    }

    public String getTextSafe() {
        try {
            return getText();
        } catch (Exception e) {
            return "";
        }
    }

    public boolean isDisplayed() {
        return find().isDisplayed();
    }

    public boolean isDisplayedSafe() {
        try {
            return driver.findElement(locator.getBy()).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isEnabled() {
        return find().isEnabled();
    }

    public String getAttribute(String name) {
        return find().getAttribute(name);
    }
}