package listeners;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;
import report.ExtentLogger;
import report.ExtentReport;


public class ListenersClass implements ITestListener, ISuiteListener {

    public void onStart(ISuite suite) {
        ExtentReport.initReports();
    }
    public void onFinish(ISuite suite){
        try {
            ExtentReport.flushReport();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
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
