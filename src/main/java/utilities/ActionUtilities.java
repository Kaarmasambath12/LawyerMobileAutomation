package utilities;


import Device.DriverThreadManager;
import constants.FrameworkConstants;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.function.Function;




public class ActionUtilities {
    public static Select select;
    public static JavascriptExecutor js;
    public static Actions actions;

    public void click(WebElement element) throws IOException {

        new FluentWait<>(DriverThreadManager.getDriver())
                .withTimeout(Duration.ofSeconds(FrameworkConstants.getPageLoadTimeOut()))
                .pollingEvery(Duration.ofSeconds(FrameworkConstants.getExplicitWait()))
                .ignoring(NoSuchElementException.class)
                .ignoring(ElementClickInterceptedException.class)
                .ignoring(StaleElementReferenceException.class)
                .until((Function<WebDriver, Object>) driver -> {
                    element.click();
                    return true;
                });
    }

    public void sendKey(WebElement element, String value) throws IOException {
        new FluentWait<>(DriverThreadManager.getDriver())
                .withTimeout(Duration.ofSeconds(FrameworkConstants.getPageLoadTimeOut()))
                .pollingEvery(Duration.ofSeconds(FrameworkConstants.getExplicitWait()))
                .ignoring(NoSuchElementException.class)
                .ignoring(ElementClickInterceptedException.class)
                .ignoring(StaleElementReferenceException.class)
                .until((Function<WebDriver, Object>) driver -> {
                    element.clear();
                    element.sendKeys(value);
                    return true;
                });
    }

    public static String captureScreen() throws IOException {
        return ((TakesScreenshot) DriverThreadManager.getDriver()).getScreenshotAs(OutputType.BASE64);
    }

    public void scrollToText(String visibleText) {

        DriverThreadManager.getDriver().findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true))"
                        + ".scrollIntoView(new UiSelector().text(\"" + visibleText + "\"))"
        ));
    }

    public void closeKeyboard() {

        try {
            AndroidDriver driver =
                    (AndroidDriver) DriverThreadManager.getDriver();

            if (driver.isKeyboardShown()) {
                driver.hideKeyboard();
            }

        } catch (Exception e) {
            try {
                ((AndroidDriver) DriverThreadManager.getDriver())
                        .pressKey(new KeyEvent(AndroidKey.BACK));
            } catch (Exception ignored) {
                System.out.println("Keyboard already closed.");
            }
        }
    }



    public WebElement waitForElement(WebElement element) {
        WebDriverWait wait = new WebDriverWait(DriverThreadManager.getDriver(), Duration.ofSeconds(15));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public WebElement waitForClickable(WebElement element) {
        WebDriverWait wait = new WebDriverWait(DriverThreadManager.getDriver(), Duration.ofSeconds(15));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    protected void explicitlyWaitForElementToBeClickable(By by) {
        new WebDriverWait(DriverThreadManager.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitWait()))
                .until(ExpectedConditions.elementToBeClickable(by));
    }

    protected void explicitlyWaitForElementToBeSelected(By by) {
        new WebDriverWait(DriverThreadManager.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitWait()))
                .until(ExpectedConditions.elementToBeSelected(by));
    }

    public void selectDropDownText(WebElement element, String value) {
        select = new Select(element);
        select.selectByVisibleText(value);
    }

    public void selectDropDownValue(WebElement element, String value) {
        select = new Select(element);
        select.selectByValue(value);
    }
    public static void selectDropDownIndex(WebElement element, int value)  {
        select = new Select(element);
        select.selectByIndex(value);
    }

    public static void selectDropDownGetOptions(By element, String value) throws IOException {
        select = new Select(DriverThreadManager.getDriver().findElement(By.xpath("element")));
        List<WebElement> dropDown = select.getOptions();
        System.out.println("print the selected value " + dropDown.size());
        for (WebElement drop : dropDown) {
            System.out.println("print all selected value" + drop);
        }
    }
    public static void mouseHoverElement(By element){
        actions = new Actions(DriverThreadManager.getDriver());
        WebElement inputField=  DriverThreadManager.getDriver().findElement(By.xpath("element"));
        actions.moveToElement(inputField).click().build().perform();


    }
    public static void rightClickElement(By element){
        actions = new Actions(DriverThreadManager.getDriver());
        WebElement inputField=  DriverThreadManager.getDriver().findElement(By.xpath("element"));
        actions.contextClick(inputField).build().perform();
    }
    public static void dragAndDropElement(By element1, By element2){
        actions = new Actions(DriverThreadManager.getDriver());
        WebElement source =  DriverThreadManager.getDriver().findElement(By.xpath("element1"));
        WebElement target =  DriverThreadManager.getDriver().findElement(By.xpath("element2"));
        actions.clickAndHold(source).moveToElement(target).release().build().perform();
    }

    public static void brokenLink(){
        List<WebElement> links = DriverThreadManager.getDriver().findElements(By.tagName("a"));
        for (WebElement link : links) {
            String url = link.getAttribute("href");
            verifyLink(url);
        }
    }

    public static void verifyLink(String url) {
        try {
            URL link = new URL(url);
            HttpURLConnection httpURLConnection = (HttpURLConnection) link.openConnection();
            httpURLConnection.setConnectTimeout(3000); // Set connection timeout to 3 seconds
            httpURLConnection.connect();


            if (httpURLConnection.getResponseCode() == 200) {
                System.out.println(url + " - " + httpURLConnection.getResponseMessage());
            } else {
                System.out.println(url + " - " + httpURLConnection.getResponseMessage() + " - " + "is a broken link");
            }
        } catch (Exception e) {
            System.out.println(url + " - " + "is a broken link");
        }
    }

    public static void dynamicTableDataWithLoop(WebElement element, WebElement tableAck, String text) throws InterruptedException {
        List<WebElement> allData=DriverThreadManager.getDriver().findElements(By.xpath("element"));
        System.out.println(allData.size());
        for (WebElement ele : allData) {
            String value = ele.getText();
            System.out.println(value);
            if (value.contains(text)) {
                Thread.sleep(6000);
                tableAck.click();
                System.out.println("notification clicked successfully");
                Thread.sleep(10000);
                break;
            }
        }
    }

    //scrolling page till find the element
    public static void scrollToFindElement(WebElement element) {
        js = (JavascriptExecutor)DriverThreadManager.getDriver();
        js.executeScript("arguments[0].scrollIntoView();", element);
        System.out.println(js.executeScript("return window.pageYOffset")); //will print the size of pixel it's scrolled
    }

    //scroll by using pixel and this method is vertical scroll
    public static void verticalScrollByUsingPixel(){
        js= (JavascriptExecutor)DriverThreadManager.getDriver();
        js.executeScript("window.scrollBy(0,1000)","");
        System.out.println(js.executeScript("return window.pageYOffset")); //will print the size of pixel it's scrolled
    }

    //scroll by using pixel and this method is horizontal scroll
    public static void horizontalScrollByUsingPixel(){
        js= (JavascriptExecutor)DriverThreadManager.getDriver();
        js.executeScript("window.scrollBy(1000,0)","");
        System.out.println(js.executeScript("return window.pageXOffset")); //will print the size of pixel it's scrolled
    }

    //scroll page till bottom
    public static void scrollTillBottom(){
        js= (JavascriptExecutor)DriverThreadManager.getDriver();
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");  //scrollWidth for horizontal scroll
        System.out.println(js.executeScript("return window.pageYOffset")); //will print the size of pixel it's scrolled

    }
    //scrolling up to initial position
    public static void scrollToInitialPosition(){
        js= (JavascriptExecutor)DriverThreadManager.getDriver();
        js.executeScript("window.scrollTo(0,-document.body.scrollHeight)"); //scrollWidth for horizontal scroll
        System.out.println(js.executeScript("return window.pageYOffset")); //will print the size of pixel it's scrolled

    }

    //Whenever element intercepted exception for click and sendKeys
    public static void sendKeyByUsingJavaScriptExecutor(WebElement element, String sendValue){
        js= (JavascriptExecutor)DriverThreadManager.getDriver();
        js.executeScript("arguments[0].setAttribute('value', "+sendValue+")", element);
    }

    //click method by using javascript
    public static void clickByUsingJavaScriptExecutor(WebElement element){
        js= (JavascriptExecutor)DriverThreadManager.getDriver();
        js.executeScript("arguments[0].click()", element);
    }

    //zoom method by using javascript
    public static void zoomMethod(){
        js= (JavascriptExecutor)DriverThreadManager.getDriver();
        js.executeScript("document.body.style.zoom='50%'");  //set zoom 50 percentage
    }

    //dynamic drop down or auto-suggestion drop down
    public static void dynamicDropdown(WebElement element, String text){
        List <WebElement> list = DriverThreadManager.getDriver().findElements(By.xpath("element"));
        System.out.println(list.size());
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i).getText());
            if(list.get(i).getText().equals(text)){
                list.get(i).click();
                break;
            }
        }
    }

    //select month and year and date method
    public static void selectFutureDate(String month, String year, String dates){
        while (true){
            String currentMonth = DriverThreadManager.getDriver().findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
            String currentYear = DriverThreadManager.getDriver().findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();

            if(currentMonth.equals(month) && currentYear.equals(year)){
                break;
            }
            DriverThreadManager.getDriver().findElement(By.xpath("//span[@class='ui-icon-circle-triangle-e']")).click();  //next button in calendar
            //previous button is required need to find the xpath
        }
        List<WebElement> allDate = DriverThreadManager.getDriver().findElements(By.xpath("//table[@class='ui-datepicker-calendar]//tbody//tr//td"));
        for(WebElement date: allDate){
            if(date.getText().equals(dates)){
                date.click();
                break;
            }
        }
    }

    public static void selectPastDate(String month, String year, String dates) {
        while (true) {
            String currentMonth = DriverThreadManager.getDriver().findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
            String currentYear = DriverThreadManager.getDriver().findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();

            if (currentMonth.equals(month) && currentYear.equals(year)) {
                break;
            }
            //DriverFactory.getDriver().findElement(By.xpath("//span[@class='ui-icon-circle-triangle-e']")).click();  //next button in calendar
            //previous button is required need to find the xpath
        }
        List<WebElement> allDate = DriverThreadManager.getDriver().findElements(By.xpath("//table[@class='ui-datepicker-calendar]//tbody//tr//td"));
        for (WebElement date : allDate) {
            if (date.getText().equals(dates)) {
                date.click();
                break;
            }
        }
    }




}




