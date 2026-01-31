package Device;

import constants.FrameworkConstants;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class AndroidEmulator implements interfaceDriver{
    @Override
    public AndroidDriver getDriver() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");  //optional
        options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);  //Optional
        options.setDeviceName("EmulatorDevice");
        options.setApp(FrameworkConstants.getapkFilePath());
        return new AndroidDriver(new URL("http://127.0.0.1:4723"), options);


        /*DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.APP, FrameworkConstants.getapkFilePath());
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("platformVersion", "11");
        capabilities.setCapability("deviceName", "EmulatorDevice");
        capabilities.setCapability("appPackage", "com.ionicframework.myschneiderretailer");
        capabilities.setCapability("appActivity", "com.schneider.retailexperienceapp.screens.SplashScreenActivity");
        capabilities.setCapability("skipDeviceInitialization", true);
        capabilities.setCapability("skipServerInstallation", true);
        return new AppiumDriver(new URL("http://127.0.0.1:4723/"), capabilities); */


    }
}
