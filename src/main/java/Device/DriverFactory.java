package Device;

import io.appium.java_client.AppiumDriver;

import java.net.MalformedURLException;

public final class DriverFactory {

    private DriverFactory(){}


    public static AppiumDriver get(String Device) throws MalformedURLException {
        AppiumDriver driver = null;
        if(Device.equalsIgnoreCase("realme 9 Pro 5G")){
            driver = new AndroidRealDevice().getDriver();
        }
        else if(Device.equalsIgnoreCase("EmulatorDevice")){
            driver = new AndroidEmulator().getDriver();
        }
        return driver;
    }
}
