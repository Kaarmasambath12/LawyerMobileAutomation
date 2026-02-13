package report;


import com.aventstack.extentreports.MediaEntityBuilder;

import java.io.IOException;

import static utilities.ActionUtilities.captureScreen;


public final class ExtentLogger {
    private ExtentLogger(){

    }
    public static void pass(String message){
        ExtentManager.getExtent().pass(message);
    }
    public static void fail(String message) throws IOException {
        ExtentManager.getExtent().fail(message, MediaEntityBuilder.createScreenCaptureFromBase64String(captureScreen()).build());
    }
    public static void skip(String message){
        ExtentManager.getExtent().skip(message);
    }
}
