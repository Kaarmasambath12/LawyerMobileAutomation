package base;

import Device.DriverImplementation;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;


public class BaseClass {


    @BeforeMethod(alwaysRun = true)
    public void setUpTest() throws MalformedURLException {
        DriverImplementation.initDriver();
    }

    @AfterMethod
    public void tearDownTest(){
        DriverImplementation.quitDriver();
    }


}
