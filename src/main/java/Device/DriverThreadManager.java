package Device;

import io.appium.java_client.AppiumDriver;

public final class DriverThreadManager {

    private DriverThreadManager() {}


    private static final ThreadLocal<AppiumDriver> driverThreadLocal = new ThreadLocal<>();

    public static void setDriver(AppiumDriver driver1) {
        driverThreadLocal.set(driver1);
    }

    public static AppiumDriver getDriver() {
        return driverThreadLocal.get();
    }

    public static void unLoad(){
        driverThreadLocal.remove();
    }
}
