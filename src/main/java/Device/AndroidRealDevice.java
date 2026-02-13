package Device;

import constants.FrameworkConstants;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class AndroidRealDevice implements interfaceDriver{
    @Override
    public AppiumDriver getDriver() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.APP, FrameworkConstants.getapkFilePath());
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "13");
        capabilities.setCapability("udid", "12a0ac04");
        capabilities.setCapability("deviceName", "realme 9 Pro 5G");
        capabilities.setCapability("appPackage", "com.ionicframework.myschneiderretailer");
        capabilities.setCapability("appActivity", "com.schneider.retailexperienceapp.screens.SplashScreenActivity");
        capabilities.setCapability("unlockType", "pin");
        capabilities.setCapability("unlockKey", "123456");
        capabilities.setCapability("skipDeviceInitialization", true);
        capabilities.setCapability("skipServerInstallation", true);
        return new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

    }
}
