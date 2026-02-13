package listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class RetryFailedTests implements IRetryAnalyzer, ITestListener {

    private int failedCount =0;
    private static int retries = 2;

    @Override
    public boolean retry(ITestResult iTestResult) {
        if(failedCount<retries){
            failedCount++;
            return true;
        }
        return false;
    }
}

