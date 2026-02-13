package constants;

public final class FrameworkConstants {

    private FrameworkConstants() {}


    private static final String propertyFilePath = System.getProperty("user.dir") +
            "/config/configuration.properties";

    private static final String apkFilePath = System.getProperty("user.dir") +
            "/src/test/resources/apkFiles/Lawyer.apk";

    private static final String extentReportPath = System.getProperty("user.dir") +
            "/ExtentReport/ExtentReportResults.html";

    private static final String excelFilePath = System.getProperty("user.dir") +
            "/excelFiles/Book1.xlsx";

    private static final int explicitWait = 10;

    private static final int pageLoadTimeOut = 10;


    public static int getPageLoadTimeOut(){
        return pageLoadTimeOut;
    }
    public static int getExplicitWait(){
        return explicitWait;
    }

    public static String getapkFilePath(){
        return apkFilePath;
    }


    public static String getPropertyFilePath(){
        return propertyFilePath;
    }

    public static String getExtentReportPath(){
        return extentReportPath;
    }

    public static String getExcelFilePath() { return excelFilePath; }



}
