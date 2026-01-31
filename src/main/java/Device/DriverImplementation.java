package Device;

import config.ReadConfig;
import io.appium.java_client.AppiumDriver;
import java.net.MalformedURLException;

import static Device.DriverThreadManager.*;
import static java.util.Objects.isNull;


public final class DriverImplementation {

    private DriverImplementation(){}



    public static void initDriver() throws MalformedURLException {
        if (isNull(getDriver())){
            new ReadConfig();
            AppiumDriver driver = DriverFactory.get(ReadConfig.prop.getProperty("deviceType"));
            setDriver(driver);
        }
    }

    public static void quitDriver(){
        if(getDriver()!=null){
            getDriver().quit();
            unLoad();
            }
    }


}
