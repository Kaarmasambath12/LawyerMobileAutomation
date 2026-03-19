package appiumServerManager;

import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

import java.io.File;
import java.time.Duration;
import java.util.HashMap;

public class StartAppium {

    public static AppiumDriverLocalService service;

    public static void startServer(){


        /*HashMap<String, String> env = new HashMap<>();
        env.put("ANDROID_HOME", "C:\\Users\\Admin\\AppData\\Local\\Android\\Sdk");
        env.put("JAVA_HOME", "C:\\Program Files\\Java\\jdk-11");
        env.put("PATH", System.getenv("PATH"));

        UiAutomator2Options caps = new UiAutomator2Options();
        caps.setCapability("platformName", "Android");
        caps.setCapability("deviceName", "emulator-5554");
        caps.setCapability("appPackage", "com.example.m_lawyer");
        caps.setCapability("appActivity", "com.example.m_lawyer.MainActivity");
*/


        AppiumServiceBuilder builder = new AppiumServiceBuilder()
                .usingDriverExecutable(new File("C:\\Program Files\\nodejs\\node.exe"))
                .withAppiumJS(new File("C:\\Users\\Admin\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
                .withIPAddress("127.0.0.1")
                .usingPort(4723)
                .withTimeout(Duration.ofSeconds(50))   // better than millis
                .withLogFile(new File("appium_logs.txt"))
                .withLogOutput(System.out)
                .withArgument(GeneralServerFlag.SESSION_OVERRIDE)
                .withArgument(GeneralServerFlag.LOG_LEVEL, "info");

        service = AppiumDriverLocalService.buildService(builder);

        service.start();

        if (service.isRunning()) {
            System.out.println("Appium Server started successfully!");
            System.out.println("URL: " + service.getUrl());
        }
    }

}
