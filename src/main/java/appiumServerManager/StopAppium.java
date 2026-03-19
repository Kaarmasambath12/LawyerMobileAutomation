package appiumServerManager;

import io.appium.java_client.service.local.AppiumDriverLocalService;

public class StopAppium {

    public static AppiumDriverLocalService service;

    public static void stopServer() {
        if (service != null && service.isRunning()) {
            service.stop();
            System.out.println("Appium Server stopped.");
        }
    }
}
