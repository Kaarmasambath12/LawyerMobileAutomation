package pages;

import Device.DriverThreadManager;
import dataDriven.XLUtilities;
import helper.MyAvailabilityHelper;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.ActionUtilities;
import utilities.ADBUtil;



import java.io.IOException;
import java.sql.DriverManager;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class HomePage extends ActionUtilities {

    public WebDriverWait wait;

    public HomePage() {

        PageFactory.initElements(new AppiumFieldDecorator(DriverThreadManager.getDriver()), this);
    }

    @FindBy(xpath = "//android.widget.Button[@content-desc=\"add_bank_button\"]")
    public WebElement addBankButton;

    @FindBy(xpath = "//android.widget.Button[@content-desc=\"my_earn_add_acc_button\"]")
    public WebElement addBankAccountButton;

    @FindBy(xpath = "//android.widget.EditText[@resource-id=\"account_holder_text_field\"]")
    public WebElement accountHolderNameField;

    @FindBy(xpath = "//android.widget.EditText[@resource-id=\"bank_name_text_field\"]")
    public WebElement bankNameField;

    @FindBy(xpath = "//android.widget.EditText[@resource-id=\"account_number_field\"]")
    public WebElement accountNumberField;

    @FindBy(xpath = "//android.widget.EditText[@resource-id=\"confirm_account_field\"]")
    public WebElement confirmAccountNumberField;

    @FindBy(xpath = "//android.widget.EditText[@resource-id=\"ifc_code_text_field\"]")
    public WebElement iFSCCodeField;

    @FindBy(xpath = "//android.widget.EditText[@resource-id=\"branch_name_text_field\"]")
    public WebElement branchNameField;

    @FindBy(xpath = "//android.widget.EditText[@resource-id=\"branch_name_text_field\"]")
    public WebElement accountTypeField;

    @FindBy(xpath = "//android.widget.Button[@content-desc=\"SAVINGS\"]")
    public WebElement savingAccountDropDown;

    @FindBy(xpath = "//android.widget.Button[@content-desc=\"add_acount_button\"]")
    public WebElement addBankAccount;

    @FindBy(xpath = "//android.widget.Button[@content-desc=\"my_earn_add_upi_button\"]")
    public WebElement addUPI;

    @FindBy(xpath = "//android.widget.EditText[@resource-id=\"upi_id_text_field\"]")
    public WebElement UPIID;

    @FindBy(xpath = "//android.widget.EditText[@resource-id=\"confirm_upi_text_field\"]")
    public WebElement confirmUPIID;

    @FindBy(xpath = "//android.widget.Button[@content-desc=\"add_upi_button\"]")
    public WebElement addUPIButton;

    @FindBy(xpath = "//android.widget.Button[@content-desc=\"add_upi_Confirm_button\"]")
    public WebElement confirmButton;

    @FindBy(xpath = "//android.widget.Button[@content-desc=\"transaction_see_more_button\"]")
    public WebElement seeMore;

    @FindBy(xpath = "//android.widget.ImageView[@content-desc=\"trans_filter_icon_button\"]")
    public WebElement filterButton;

    @FindBy(xpath = "//android.widget.EditText[@text=\"trans_fil_start_date_field\"]/android.view.View")
    public WebElement startDate;

    @FindBy(xpath = "//android.widget.Button[@content-desc=\"OK\"]")
    public WebElement okButton;

    @FindBy(xpath = "//android.widget.EditText[@text=\"filter_end_date_field\"]/android.view.View")
    public WebElement endDate;

    @FindBy(xpath = "//android.widget.Button[@content-desc=\"transaction_filter_button\"]")
    public WebElement filterButtonClick;

    @FindBy(xpath = "//android.view.View[@content-desc=\"Received Amount\n" +
            "Tab 2 of 3\"]")
    public WebElement receivedAmountTab;

    @FindBy(xpath = "//android.view.View[@content-desc=\"Penalty Paid\n" +
            "Tab 3 of 3\"]")
    public WebElement penaltyAmountTab;

    @FindBy(xpath = "//android.view.View[@content-desc=\"₹488.20\n" +
            "12 Mar 2026\n" +
            "TXN-20260312-F284-4D80D0\"]")
    public WebElement transactionClick;

    @FindBy(xpath = "//android.widget.Button[@content-desc=\"transaction_receipt_download_button\"]")
    public WebElement downloadReport;

    @FindBy(xpath = "//android.widget.Button[@content-desc=\"cons_sum_see_more_button\"]")
    public WebElement seeMoreText;

    @FindBy(xpath = "//android.widget.Button[@content-desc=\"Week 4\"]")
    public WebElement weekFour;

    @FindBy(xpath = "//android.widget.Button[@content-desc=\"Week 3\"]")
    public WebElement weekThree;

    @FindBy(xpath = "//android.view.View[@content-desc=\"Monthly\n" +
            "Tab 2 of 3\"]")
    public WebElement monthData;

    @FindBy(xpath = "//android.view.View[@content-desc=\"Yearly\n" +
            "Tab 3 of 3\"]")
    public WebElement yearData;

    @FindBy(xpath = "//android.view.View[@content-desc=\"back_button\"]/android.widget.Button")
    public WebElement backButton;



    public void scrollToTodaySlotSeeMoreButton() {
        DriverThreadManager.getDriver().findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true))" +
                        ".scrollIntoView(new UiSelector().description(\"today_slot_see_more_button\"));"
        ));
    }







    public void addBankAccountDetails(String bankName, String accountHolder,
                                      String accountNumber, String ifscCode,
                                      String branchName) throws IOException, ClassNotFoundException {

        click(addBankButton);

        click(addBankAccountButton);

        click(accountHolderNameField);

        click(bankNameField);

        click(accountNumberField);

        click(confirmAccountNumberField);

        click(iFSCCodeField);

        click(branchNameField);

        click(accountTypeField);

        click(savingAccountDropDown);

        click(addBankAccount);
    }

    public void addAccountFunction() throws Exception {

        // Account Holder Name
       // ADBUtil.tap(540, 450);
        click(addBankButton);
        Thread.sleep(2000);
        click(addBankAccountButton);
        Thread.sleep(2000);
        ADBUtil.typeText("Karthikeyan");

        // Bank Name
        ADBUtil.tap(540, 635);
        ADBUtil.typeText("HDFC Bank");

        // Account Number
        ADBUtil.tap(540, 825);
        ADBUtil.typeText("123456789012");

        // Confirm Account Number
        ADBUtil.tap(540, 1015);
        ADBUtil.typeText("123456789012");

        // IFSC Code
        ADBUtil.tap(540, 1205);
        ADBUtil.typeText("HDFC0001234");

        // Branch Name
        ADBUtil.tap(540, 1395);
        ADBUtil.typeText("Bangalore");

        // Account Type
        ADBUtil.tap(540, 1595);

        // Select Account Type
        // Example: Savings
        click(savingAccountDropDown);

        // Set As Primary Account
        ADBUtil.tap(80, 1735);

        // Verification checkbox
        ADBUtil.tap(80, 1830);

        // Add Account
        ADBUtil.tap(540, 2080);
    }



    public void addUPIDetails(String upiId) throws IOException {

        click(addBankButton);

        click(addUPI);

        click(UPIID);
        UPIID.sendKeys(upiId);

        click(confirmUPIID);
        confirmUPIID.sendKeys(upiId);

        click(addUPIButton);

        click(confirmButton);
    }

    public void selectTodayDate() throws IOException {

        String todayDate = MyAvailabilityHelper.getTodayDateForCalendar();

        By todayLocator = By.xpath("//android.widget.Button[@content-desc='" + todayDate + "']");

        click(DriverThreadManager.getDriver().findElement(todayLocator));
    }

    public void selectPastTenDaysDate() throws IOException {

        LocalDate pastDate = LocalDate.now().minusDays(10);

        String formattedDate = pastDate
                .format(DateTimeFormatter.ofPattern("d, EEEE, MMMM d, yyyy"));

        By pastDateLocator = By.xpath("//android.widget.Button[contains(@content-desc,'" + formattedDate + "')]");

        click(DriverThreadManager.getDriver().findElement(pastDateLocator));
    }

    public void filterTransactionAndDownloadReceipt() throws IOException {
        click(addBankButton);

        click(seeMore);

        click(filterButton);

        click(startDate);
        selectPastTenDaysDate();   // method you created earlier
        click(okButton);

        click(endDate);
        selectTodayDate();    // method you created earlier
        click(okButton);

        click(filterButtonClick);

        click(receivedAmountTab);

        click(transactionClick);

        click(downloadReport);
    }

    // Click See More
    public void clickSeeMore() {
        seeMoreText.click();
    }

    // Select Week 4
    public void selectWeekFour() {
        weekFour.click();
    }

    // Select Week 3
    public void selectWeekThree() {
        weekThree.click();
    }

    // Click Monthly Tab
    public void clickMonthlyTab() {
        monthData.click();
    }

    // Click Yearly Tab
    public void clickYearlyTab() {
        yearData.click();
    }

    // Click Back Button
    public void clickBackButton() {
        backButton.click();
    }


}