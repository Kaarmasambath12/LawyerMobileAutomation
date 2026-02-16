package base;

import Device.DriverImplementation;
import helper.VideoRecorderUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;


public class BaseClass {

    private static final Logger log = (Logger) LogManager.getLogger(BaseClass.class);


    @BeforeMethod(alwaysRun = true)
    public void setUpTest() throws MalformedURLException {
        DriverImplementation.initDriver();
        VideoRecorderUtil.startRecording();
        log.info("Driver Initialization Started");
    }

    @AfterMethod
    public void tearDownTest(ITestResult result){
        VideoRecorderUtil.stopRecording(result.getName());
        DriverImplementation.quitDriver();
    }


}
