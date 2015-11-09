package LoginPageArtem;

import com.telran.pages.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Iakov Volf,Oleg
 */
public class RegistrationPage extends Page {

    //private static Logger Log = Logger.getLogger(LogLog4j.class.getName());
    //fields
    @FindBy(id = "MainContent_RegisterUser_CreateUserStepContainer_UserName")
    WebElement usernameField;

    @FindBy(id = "MainContent_RegisterUser_CreateUserStepContainer_Email")
    WebElement emailField;


    @FindBy(id = "MainContent_RegisterUser_CreateUserStepContainer_Password")
    WebElement passwordField;
    @FindBy(id = "MainContent_RegisterUser_CreateUserStepContainer_ConfirmPassword")
    WebElement confirmPassField;

    @FindBy(id = "MainContent_RegisterUser_CreateUserStepContainer_firstNameTxt")
    WebElement firstNameField;

    @FindBy(id = "MainContent_RegisterUser_CreateUserStepContainer_lastNameTxt")
    WebElement lastNameField;

    @FindBy(id = "MainContent_RegisterUser_CreateUserStepContainer_PersonalIdTxt")
    WebElement teudatField;


    @FindBy(id = "ctl00_MainContent_RegisterUser_CreateUserStepContainer_birthdayTxt_dateInput")
    WebElement birthDateField;

    @FindBy(id = "ctl00_MainContent_RegisterUser_CreateUserStepContainer_ContactCellTxt")
    WebElement mobilePhoneField;

    @FindBy(id = "MainContent_RegisterUser_CreateUserStepContainer_AddressTxt")
    WebElement streetNameField;

    @FindBy(id = "MainContent_RegisterUser_CreateUserStepContainer_HouseNumberTxt")
    WebElement houseNumberField;

    @FindBy(id = "MainContent_RegisterUser_CreateUserStepContainer_CityTxt")
    WebElement cityField;

    //Select
    @FindBy(id = "MainContent_RegisterUser_CreateUserStepContainer_rolesDDl")
    WebElement selectMedProvider;

    @FindBy(id = "MainContent_RegisterUser_CreateUserStepContainer_OrganizationDDL")
    WebElement selectclinicType;

    //Alerts
    @FindBy(id = "MainContent_RegisterUser_CreateUserStepContainer_UserNameRequired")
    WebElement usernameAlert;
    //buttons
    @FindBy(id = "MainContent_LinkButton1")
    WebElement cancelButton;
    @FindBy(id = "MainContent_AddNewUser")
    WebElement submitButton;
    @FindBy(id = "MainContent_RegisterUser_CreateUserStepContainer_FirsNameRequired")
    private WebElement firstNameAlert;


    //checkboxs
    @FindBy(id = "MainContent_RegisterUser_CreateUserStepContainer_IsClinicAdmin")
    private WebElement agreeCheckbox;


    //public ProfilePage profilePage;

    public RegistrationPage(WebDriver driver) {
        super(driver);
        this.PAGE_URL = "http://dhclinicappv2stg.item-soft.co.il/SitePages/createUser.aspx?ReturnUrl=HomePage";
        PageFactory.initElements(driver, this);
    }


    public RegistrationPage openRegistrationPage(WebDriver driver) {
        driver.get(PAGE_URL);
        return this;
    }

//Fill the fileds

    public RegistrationPage fillUsernameField(String username) {
        setElementText(usernameField, username);
        return this;
    }

    public RegistrationPage fillEmailField() {
        int rand = ThreadLocalRandom.current().nextInt(0, 10000 + 1);
        String email = "doctor" + rand + "@yopmail.com";
        setElementText(emailField, email);
        return this;
    }

    public RegistrationPage fillPasswordField(String password) {
        setElementText(passwordField, password);
        // Log.info("entering password from the list: " + password + " ");
        return this;
    }

    public RegistrationPage fillConfPasswordField(String password) {
        setElementText(confirmPassField, password);
        // Log.info("entering password from the list: " + password + " ");
        return this;
    }

    public RegistrationPage fillFirstNameField(String firstName) {
        setElementText(firstNameField, firstName);
        //  Log.info("entering first name from the list: " + firstName + " ");
        return this;
    }

    public RegistrationPage fillLastNameField(String lastName) {
        setElementText(lastNameField, lastName);
        //   Log.info("entering last name from the list: " + lastName + " ");
        return this;
    }

    public RegistrationPage fillIdField() {
        String id = createId();
        setElementText(teudatField, id);
        //   Log.info("entering last name from the list: " + lastName + " ");
        return this;
    }

    public RegistrationPage fillStreetField(String street) {
        setElementText(streetNameField, street);
        //   Log.info("entering last name from the list: " + lastName + " ");
        return this;
    }

    public RegistrationPage fillMobile(String street) {
        setElementText(mobilePhoneField, street);
        //   Log.info("entering last name from the list: " + lastName + " ");
        return this;
    }

    public RegistrationPage fillHouseField(String house) {
        setElementText(houseNumberField, house);
        //   Log.info("entering last name from the list: " + lastName + " ");
        return this;
    }

    public RegistrationPage fillCityField(String city) {
        setElementText(cityField, city);
        //   Log.info("entering last name from the list: " + lastName + " ");
        return this;
    }

    public RegistrationPage choosePrivateDoctor() {
        selectValueInDropdown(selectclinicType, "2");
        //   Log.info("entering last name from the list: " + lastName + " ");
        return this;
    }

    public RegistrationPage chooseClinic(String name) {
        selectValueInDropdownbyText(selectclinicType, name);
        //   Log.info("entering last name from the list: " + lastName + " ");
        return this;
    }

    public RegistrationPage waitUntilRegPageIsLoaded() {
        try {
            waitUntilElementIsLoaded(submitButton);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }

    public void clickOnSubmitButton() {
        clickElement(submitButton);

    }

    public void clickOnCancelButton() {
        clickElement(cancelButton);

    }


    public boolean isOnRegistrationPage() {
        return exists(submitButton);
    }

    //check alert presence

    public boolean alertMessageNotValidUserName() {
        return exists(usernameAlert);
    }

    public boolean alertMessageNotValidFirsrName() {
        return exists(firstNameAlert);
    }

}
