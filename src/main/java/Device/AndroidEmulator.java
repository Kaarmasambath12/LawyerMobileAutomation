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
        options.setAppPackage("com.example.m_lawyer");
        options.setAppActivity("com.example.m_lawyer.MainActivity");
        options.setAppWaitActivity("*");
        options.setNoReset(true);
        options.setAutoGrantPermissions(true);



        return new AndroidDriver(
                new URL("http://127.0.0.1:4723"),
                options
        );


       // return new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
    }


}
