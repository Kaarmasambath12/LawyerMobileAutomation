package report;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import constants.FrameworkConstants;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public final class ExtentReport {  //no need to extent this class

    private ExtentReport() {
    }
    private static ExtentReports extent;


    public static void initReports() {
            if (Objects.isNull(extent)) {
            extent = new ExtentReports();
            ExtentSparkReporter spark = new ExtentSparkReporter(FrameworkConstants.getExtentReportPath()); //html file will be generated
            spark.config().setTheme(Theme.DARK);
            spark.config().setDocumentTitle("Automation Report");
            spark.config().setReportName("Extent report demo");
            extent.attachReporter(spark);
        }
    }

    public static void flushReport() throws IOException {
        extent.flush();  //unless you call this method, your report will not be written with logs
        ExtentManager.unLoad();
       Desktop.getDesktop().browse(new File(FrameworkConstants.getExtentReportPath()).toURI());
    }

    public static void createTest(String testCaseName, String deviceName, String authorName) {
        ExtentManager.setExtentTest(extent.createTest(testCaseName).assignAuthor(authorName).assignDevice(deviceName));
    }







}
