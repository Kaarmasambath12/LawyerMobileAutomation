package pages;

import Device.DriverThreadManager;
import dataDriven.XLUtilities;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.ActionUtilities;

import java.io.IOException;

public class ProfilePage extends ActionUtilities {

    String text1 = "Professional Details";


    public ProfilePage() {

        PageFactory.initElements(new AppiumFieldDecorator(DriverThreadManager.getDriver()), this);
    }

    @FindBy(xpath = "//android.widget.ImageView[@content-desc=\"Profile\n" +
            "Tab 5 of 5\"]")
    public WebElement profileIcon;

    @FindBy(xpath = "//android.widget.Button[@content-desc=\"profile_navigate_button\"]")
    public WebElement profileButton;

    @FindBy(xpath = "//android.widget.Button[@content-desc=\"profile_navigate_button\"]")
    public WebElement firstName;

    @FindBy(xpath = "//android.widget.EditText[@text=\"pro_middle_name_text_field\"]/android.widget.EditText")
    public WebElement middleName;

    @FindBy(xpath = "//android.widget.EditText[@text=\"V\"]")
    public WebElement lastName;

    @FindBy(xpath = "//android.widget.EditText[@text=\"Thllagar nagar\"]")
    public WebElement addressField;

    @FindBy(xpath = "//android.widget.EditText[@text=\"select_state_field\"]/android.widget.EditText")
    public WebElement clearState;

    @FindBy(xpath = "//android.view.View[@content-desc=\"Maharashtra\"]")
    public WebElement selectState;

    @FindBy(xpath = "//android.widget.EditText[@text=\"select_district_field\"]/android.widget.EditText")
    public WebElement selectDistrict;

    @FindBy(xpath = "//android.widget.EditText[@text=\"select_city_field\"]/android.widget.EditText")
    public WebElement selectCity;

    @FindBy(xpath = "//android.widget.EditText[@text=\"685828\"]")
    public WebElement pinNumberField;

    @FindBy(xpath = "//android.widget.EditText[@text=\"B.Com\"]")
    public WebElement qualification;

    @FindBy(xpath = "//android.view.View[@content-desc=\"choose_specialization_text_field\n" +
            "Select Specialization *\"]")
    public WebElement selectSpecialization;

    @FindBy(xpath = "//android.widget.CheckBox[@content-desc=\"Criminal law\"]")
    public WebElement selectLaw;

    @FindBy(xpath = "//android.widget.Button[@content-desc=\"OK\"]")
    public WebElement okButton;

    @FindBy(xpath = "//android.widget.EditText[@text=\"TN/0987/123\"]")
    public WebElement barCouncil;

    @FindBy(xpath = "//android.widget.Button[@content-desc=\"profile_update_button\"]")
    public WebElement saveButton;

    // Open Profile
    public void openProfile() throws IOException {
        click(profileIcon);
        click(profileButton);
    }

    // Enter Name Details
    public void enterNameDetails(String middle, String last) throws IOException {
        sendKey(middleName, middle);
        sendKey(lastName, last);
    }

    // Enter Address
    public void enterAddressDetails(String address, String state, String district, String city, String pin) throws IOException {

        // Address
        sendKey(addressField, address);

        // State
        click(clearState);
        DriverThreadManager.getDriver().findElement(By.xpath("//android.view.View[@content-desc='" + state + "']")).click();

        // District
        click(selectDistrict);
        DriverThreadManager.getDriver().findElement(By.xpath("//android.view.View[@content-desc='" + district + "']")).click();

        // City
        click(selectCity);
        DriverThreadManager.getDriver().findElement(By.xpath("//android.view.View[@content-desc='" + city + "']")).click();

        // PIN
        sendKey(pinNumberField, pin);
    }

    // Select Specialization
    public void selectSpecialization() throws IOException {
        click(selectSpecialization);
        click(selectLaw);
        click(okButton);
    }

    // Enter Qualification & Bar Council
    public void enterProfessionalDetails(String qualificationText, String barCouncilNumber) throws IOException {
        sendKey(qualification, qualificationText);
        sendKey(barCouncil, barCouncilNumber);
    }

    // Save Profile
    public void clickSave() throws IOException {
        click(saveButton);
    }



}