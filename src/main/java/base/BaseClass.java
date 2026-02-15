package base;

import Device.DriverImplementation;
import helper.VideoRecorderUtil;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;


public class BaseClass {


    @BeforeMethod(alwaysRun = true)
    public void setUpTest() throws MalformedURLException {
        DriverImplementation.initDriver();
        VideoRecorderUtil.startRecording();
    }

    @AfterMethod
    public void tearDownTest(ITestResult result){
        VideoRecorderUtil.stopRecording(result.getName());
        DriverImplementation.quitDriver();
    }


}
