package element;

import org.openqa.selenium.By;

import java.time.Duration;

/**
 * Simple element locator with description for logging.
 */
public class ElementLocator {

    private final By by;
    private final String description;
    private final Duration timeout;

    public ElementLocator(By by, String description) {
        this(by, description, Duration.ofSeconds(10));
    }

    public ElementLocator(By by, String description, Duration timeout) {
        this.by = by;
        this.description = description;
        this.timeout = timeout;
    }

    public By getBy() {
        return by;
    }

    public String getDescription() {
        return description;
    }

    public Duration getTimeout() {
        return timeout;
    }

    public ElementLocator withTimeout(Duration newTimeout) {
        return new ElementLocator(by, description, newTimeout);
    }

    // Factory methods
    public static ElementLocator id(String id, String description) {
        return new ElementLocator(By.id(id), description);
    }

    public static ElementLocator xpath(String xpath, String description) {
        return new ElementLocator(By.xpath(xpath), description);
    }

    public static ElementLocator text(String text, String description) {
        return new ElementLocator(By.xpath("//*[@text='" + text + "']"), description);
    }

    public static ElementLocator accessibilityId(String accessibilityId, String description) {
        return new ElementLocator(
                By.xpath("//*[@content-desc='" + accessibilityId + "' or @name='" + accessibilityId + "']"),
                description
        );
    }

    public static ElementLocator className(String className, String description) {
        return new ElementLocator(By.className(className), description);
    }

    @Override
    public String toString() {
        return description + " (" + by + ")";
    }
}