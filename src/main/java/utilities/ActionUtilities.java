package utilities;

import Device.DriverThreadManager;
import com.aventstack.extentreports.MediaEntityBuilder;
import io.appium.java_client.AppiumBy;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import report.ExtentReport;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Base64;

import static Device.DriverThreadManager.*;

public class gActionUtilities {

    public static void sendKeys(WebElement element, String data, String fieldValue) throws InterruptedException, IOException {
        try{
            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(30));
            wait.until(ExpectedConditions.visibilityOf(element));
            element.clear();
            element.sendKeys(data);
            Thread.sleep(200);
            ExtentReport.test.pass("The data: " + data + "entered successfully: " + fieldValue);
            ExtentReport.test.pass(MediaEntityBuilder.createScreenCaptureFromBase64String(captureScreen()).build());

        }catch (Exception e){
            ExtentReport.test.fail("The data:" + data + " not entered successfully: " + fieldValue);
            ExtentReport.test.fail(MediaEntityBuilder.createScreenCaptureFromBase64String(captureScreen()).build());
        }

    }

    public static void click(WebElement element, String fieldValue) throws InterruptedException, IOException {
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(30));
            wait.until(ExpectedConditions.elementToBeClickable(element)).click();
            ExtentReport.test.pass("The " + fieldValue + " clicked successfully ");
            ExtentReport.test.pass(MediaEntityBuilder.createScreenCaptureFromBase64String(captureScreen()).build());
        }catch (Exception e){
            ExtentReport.test.fail("The " + fieldValue + " is not clicked ");
            ExtentReport.test.fail(MediaEntityBuilder.createScreenCaptureFromBase64String(captureScreen()).build());
        }

    }

    public static void scrollUp(String element){
        getDriver().findElement(
                new AppiumBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0))" +
                        ".scrollIntoView(new UiSelector()" + ".textMatches(\"" + element + "\").instance(0))"));
    }

    public static String captureScreen() throws IOException {
        File sourceFile = ((TakesScreenshot) DriverThreadManager.getDriver()).getScreenshotAs(OutputType.FILE);
        File destinationFile = new File("src/../images/screenshot" +System.currentTimeMillis()+ ".png");
        FileUtils.copyFile(sourceFile, destinationFile);
        byte[] imageByte = IOUtils.toByteArray(new FileInputStream(destinationFile));
        return Base64.getEncoder().encodeToString(imageByte);
    }

    public static String getBase64(){
       return ((TakesScreenshot) DriverThreadManager.getDriver()).getScreenshotAs(OutputType.BASE64);
    }
}
