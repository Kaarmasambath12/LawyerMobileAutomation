package listeners;

import helper.EmailUtil;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;
import report.ExtentLogger;
import report.ExtentReport;

import static appiumServerManager.StartAppium.startServer;
import static appiumServerManager.StopAppium.stopServer;


public class ListenersClass implements ITestListener, ISuiteListener {

    public void onStart(ISuite suite) {
        startServer();
        ExtentReport.initReports();
    }
    public void onFinish(ISuite suite){
        stopServer();
        try {
            ExtentReport.flushReport();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        EmailUtil.sendReport();
    }

    public void onTestStart(ITestResult result){
        ExtentReport.createTest(result.getMethod().getMethodName(),"Windows", "Karthikeyan Sambath");
    }

    public void onTestSuccess(ITestResult result){
        ExtentLogger.pass(result.getMethod().getMethodName() + " is passed");

    }

    public void onTestFailure(ITestResult result){
        try {
            ExtentLogger.fail(result.getMethod().getMethodName() + " is failed");
           // ExtentLogger.fail(String.valueOf(result.getThrowable()));
        } catch (Exception e) {
            //throw new RuntimeException(e);
            e.getStackTrace();
        }
    }
    public void onTestSkipped(ITestResult result){
        ExtentLogger.skip(result.getMethod().getMethodName()+ " is skipped");
    }
}
