package Device;

import io.appium.java_client.AppiumDriver;

import java.net.MalformedURLException;

public interface interfaceDriver {
    AppiumDriver getDriver() throws MalformedURLException;
}
