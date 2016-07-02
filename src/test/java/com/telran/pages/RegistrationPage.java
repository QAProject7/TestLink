package com.telran.pages;

import com.telran.LogLog4j;
import jsr166e.ThreadLocalRandom;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.Random;



/**
 * Created by Iakov Volf,Oleg
 * Modified by Tatiana
 */
public class RegistrationPage extends Page {
    private static Logger Log = Logger.getLogger(LogLog4j.class.getName());
    private static Random rnd = new Random();

    //fields
    @FindBy(id = "MainContent_RegisterUser_CreateUserStepContainer_UserName")
    WebElement usernameField;

    @FindBy(id = "MainContent_RegisterUser_CreateUserStepContainer_firstNameTxt")
    WebElement firstNameField;

    @FindBy(id = "MainContent_RegisterUser_CreateUserStepContainer_lastNameTxt")
    WebElement lastNameField;

    @FindBy(id = "MainContent_RegisterUser_CreateUserStepContainer_Email")
    WebElement emailField;


    @FindBy(id = "MainContent_RegisterUser_CreateUserStepContainer_Password")
    WebElement passwordField;

    @FindBy(id = "MainContent_RegisterUser_CreateUserStepContainer_ConfirmPassword")
    WebElement confirmPassField;

    @FindBy(id = "MainContent_RegisterUser_CreateUserStepContainer_PersonalIdTxt")
    WebElement teudatField;


    @FindBy(id = "ctl00_MainContent_RegisterUser_CreateUserStepContainer_birthdayTxt_dateInput")
    WebElement birthDateField;

    @FindBy(id = "ctl00_MainContent_RegisterUser_CreateUserStepContainer_ContactCellTxt")
    WebElement mobilePhoneField;

    @FindBy(id="ctl00_MainContent_RegisterUser_CreateUserStepContainer_ContactPhoneTxt")//number of home telephone
    WebElement housePhoneField;

    @FindBy(id = "MainContent_RegisterUser_CreateUserStepContainer_AddressTxt")
    WebElement streetNameField;

    @FindBy(id = "MainContent_RegisterUser_CreateUserStepContainer_HouseNumberTxt") //number of building
    WebElement houseNumberField;

    @FindBy(id = "MainContent_RegisterUser_CreateUserStepContainer_CityTxt")
    WebElement cityField;

    //Select
    @FindBy(id = "MainContent_RegisterUser_CreateUserStepContainer_rolesDDl")
    WebElement selectMedProvider;  //combo tafkid

    @FindBy (id="MainContent_RegisterUser_CreateUserStepContainer_clinicNameTxt")
    WebElement clinicName;

    @FindBy(id = "MainContent_RegisterUser_CreateUserStepContainer_OrganizationDDL")
    WebElement selectclinicType; //combo name of clinic organization

    @FindBy(id = "ctl00_MainContent_RegisterUser_CreateUserStepContainer_RadCaptcha1_CaptchaTextBox")
    WebElement capchaField;

    @FindBy(id="ctl00_MainContent_RegisterUser_CreateUserStepContainer_RadCaptcha1_CaptchaImageUP")
    WebElement capchaImg;


    //Alerts *********************************
    /*
    @FindBy(id = "MainContent_RegisterUser_CreateUserStepContainer_UserNameRequired")
    WebElement usernameAlert;  //  shem meshtamesh hova

    @FindBy( id="MainContent_RegisterUser_CreateUserStepContainer_RegularExpressionValidator2")
    WebElement otiiotIMisparimBilvadAlert;
    */


    //buttons
    @FindBy(id = "MainContent_LinkButton1")
    WebElement cancelButton;
    @FindBy(id = "MainContent_AddNewUser")
    WebElement submitButton;
    @FindBy(id = "MainContent_RegisterUser_CreateUserStepContainer_FirsNameRequired")
    private WebElement firstNameAlert;

    @FindBy(id="MainContent_ItemLinkButton3")
    WebElement addNewPatientButton;


    //checkboxs
    @FindBy(id = "MainContent_RegisterUser_CreateUserStepContainer_IsClinicAdmin")
    private WebElement agreeCheckbox;

    //System Alerts
    @FindBy (xpath = "//span[@id='MainContent_RegisterUser_CreateUserStepContainer_UserNameRequired']")  // shem meshtamesh hova
    private WebElement wrongUsernameAlert;

    @FindBy( id="MainContent_RegisterUser_CreateUserStepContainer_RegularExpressionValidator2")
    WebElement otiiotIMisparimBilvadUsernameAlert;

    @FindBy(xpath = "//span[@id='MainContent_RegisterUser_CreateUserStepContainer_FirsNameRequired']")
    WebElement wrongFirstNameAlert;

    @FindBy( id="MainContent_RegisterUser_CreateUserStepContainer_RegularExpressionValidator1")
    WebElement otiiotBilvadFirstNameAlert;

    @FindBy(xpath = "//span[@id='MainContent_RegisterUser_CreateUserStepContainer_LastNameRequired']")
    WebElement wrongLastNameAlert;

    @FindBy(id="MainContent_RegisterUser_CreateUserStepContainer_RegularExpressionValidator3")
    WebElement otiiotBilvadLastName;

    @FindBy (xpath = "//span[@id='MainContent_RegisterUser_CreateUserStepContainer_EmailRequired']")
    private WebElement wrongEmailAlert;

    @FindBy (id="MainContent_RegisterUser_CreateUserStepContainer_regexEmailValid")
    WebElement formatMailWrong;

    @FindBy(xpath = "//*[@id='MainContent_RegisterUser_CreateUserStepContainer_PasswordRequired']")
    WebElement wrongPasswordAlert;

    @FindBy (id="MainContent_RegisterUser_CreateUserStepContainer_CustomValidator3")
    WebElement passwordWrong;

    @FindBy(xpath = "//span[@id='MainContent_RegisterUser_CreateUserStepContainer_ConfirmPasswordRequired']")//ishyr sisma hova
    WebElement wrongConfirmPasswordAlert;

    @FindBy (id="MainContent_RegisterUser_CreateUserStepContainer_PasswordCompare")//haiav leathim l sisma
    WebElement wrongConfirmPassword;

    @FindBy(xpath = "//span[@id='MainContent_RegisterUser_CreateUserStepContainer_RequiredFieldValidator1']")//mispar zeyt hova
    WebElement wrongValidatorIDAlert;

    @FindBy(id="MainContent_RegisterUser_CreateUserStepContainer_CVPersonalId")//mispar zeyt lo hyki
    WebElement wrongValidatorID;

    @FindBy(xpath = "//span[@id='MainContent_RegisterUser_CreateUserStepContainer_RequiredFieldValidator2']")
    WebElement wrongValidatorMobileAlert;

    @FindBy(xpath = "//span[@id='MainContent_RegisterUser_CreateUserStepContainer_RequiredFieldValidator3']") //rehov hova
    WebElement wrongValidatorStreetAlert;

    @FindBy(id="MainContent_RegisterUser_CreateUserStepContainer_RegularExpressionValidator4")  //lo iaxol leahil tavim miuhadim
    WebElement streetWrong;

    @FindBy(xpath = "//span[@id='MainContent_RegisterUser_CreateUserStepContainer_RequiredFieldValidator4']")
    WebElement wrongValidatorBaitAlert;

    @FindBy(id="MainContent_RegisterUser_CreateUserStepContainer_RegularExpressionValidator5")//lo iaxol leahil tavim miuhadim
    WebElement wrongBait;

    @FindBy(xpath = "//span[@id='MainContent_RegisterUser_CreateUserStepContainer_RequiredFieldValidator5']")//ir hova
    WebElement wrongValidatorHouseAlert;

    @FindBy(id="MainContent_RegisterUser_CreateUserStepContainer_RegularExpressionValidator7") //lo iaxol leahil tavim miuhadim
            WebElement wrongValidatorCountryAlert;

    @FindBy(xpath = "//span[@id='ctl00_MainContent_RegisterUser_CreateUserStepContainer_RadCaptcha1_ctl00']") // captcha lo hyki
    WebElement ErrorCaptcha;



    //public ProfilePage profilePage;

    public RegistrationPage(WebDriver driver) {
        super(driver);
        this.PAGE_URL = baseUrl + "/SitePages/createUser.aspx?ReturnUrl=HomePage";
        PageFactory.initElements(driver, this);
    }


    public RegistrationPage openRegistrationPage(WebDriver driver) {
        Log.info("Open registration page");
        driver.get(PAGE_URL);
        return this;
    }


    //generators
    public String generateZeut() {
        String number = createId();
        Log.info("Doctor's Zeut generated is <" + number + ">");
        return number;
    }

    private static String getRandomString(final int length) {
        String chars = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder buf = new StringBuilder();
        for (int i=0; i<length; i++) {
            buf.append(chars.charAt(rnd.nextInt(chars.length())));
        }
        return buf.toString();
    }

    public String generateDoctorUsername() {
        String rand = getRandomString(3);
        String username = "doctor"+rand;
        Log.info("Doctor's Username generated is <" + username + ">");
        return username;
    }

    public String generateDoctorEmail(String username) {
        int rand = ThreadLocalRandom.current().nextInt(100, 9999);
        String email = username+ rand + "@yopmail.com";
        Log.info("Doctor's Email generated is <" + email + ">");
        return email;
    }

    //Fill the fileds

    public RegistrationPage fillUsernameField(String username) {
        Log.info("Filling Doctor username field with <" + username + ">");
        setElementText(usernameField, username);
        return this;
    }


    public RegistrationPage fillEmailField(String email) {
        Log.info("Filling Doctor email field with <" + email + ">");
        setElementText(emailField, email);
        return this;
    }

    public RegistrationPage fillPasswordField(String password) {
        Log.info("Filling Doctor password field with <" + password + ">");
        setElementText(passwordField, password);
        return this;
    }

    public RegistrationPage fillConfPasswordField(String password) {
        Log.info("Filling Doctor confirm password field with <" + password + ">");
        setElementText(confirmPassField, password);
        return this;
    }

    public RegistrationPage fillFirstNameField(String firstName) {
        Log.info("Filling Doctor firstName field with <" + firstName + ">");

        setElementText(firstNameField, firstName);
        return this;
    }

    public RegistrationPage fillLastNameField(String lastName) {
        Log.info("Filling Doctor lastName field with <" + lastName + ">");
        setElementText(lastNameField, lastName);
        return this;
    }

    public RegistrationPage fillIdField(String id) {
        Log.info("Filling Doctor id field with <" + id + ">");
        setElementText(teudatField, id);
        return this;
    }

    public RegistrationPage fillStreetField(String street) {
        Log.info("Filling Doctor street field with <" + street + ">");
        setElementText(streetNameField, street);
        return this;
    }

    public RegistrationPage fillMobile(String street) {
        Log.info("Filling Doctor mobile field with <" + street + ">");
        setElementText(mobilePhoneField, street);
        return this;
    }

    public RegistrationPage fillHouseField(String house) {
        Log.info("Filling Doctor house number field with <" + house + ">");
        setElementText(houseNumberField, house);
        return this;
    }

    public RegistrationPage fillHousePhoneField(String housePhoneNumber){
        Log.info("Filling Doctor house phone number <" + housePhoneNumber + ">");
        setElementText(housePhoneField,housePhoneNumber);
        return this;
    }
    public RegistrationPage fillCityField(String city) {
        Log.info("Filling Doctor house number field with <" + city + ">");
        setElementText(cityField, city);
        return this;
    }


    public RegistrationPage choosePrivateDoctor() {
        selectValueInDropdown(selectclinicType, "2");
          Log.info("entering last name from the list: " + "lastName" + " "); //lastName
        return this;
    }

    public RegistrationPage chooseClinic(String name) {
        Log.info("Filling Doctor Clinic number field with <" + name + ">");
        selectValueInDropdownbyText(selectclinicType, name);
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

    public void registerDoctor(String username, String id) {
        fillUsernameField(username);
        fillPasswordField("LinkCare!!11");
        fillConfPasswordField("LinkCare!!11");
        fillEmailField(generateDoctorEmail(username));
        fillCityField("Tel Aviv");
        fillFirstNameField("userName" + username);
        fillMobile("052-0001110");
        fillLastNameField("lastName" + username);
        fillHouseField("44");
        fillStreetField("Shenkin");
        fillIdField(id);
        clickOnSubmitButton();
    }

    public void registerDoctorAuto(String username) {
        fillUsernameField(username);
        fillPasswordField("LinkCare!!11");
        fillConfPasswordField("LinkCare!!11");
        fillEmailField(generateDoctorEmail(username));
        fillCityField("Tel Aviv");
        fillFirstNameField("userName" + username);
        fillMobile("052-0001110");
        fillLastNameField("lastName" + username);
        fillHouseField("44");
        fillStreetField("Shenkin");
        fillIdField(generateZeut());
       // clickOnSubmitButton();
    }
    public RegistrationPage clickAddPatientButton() {
        clickElement(addNewPatientButton);
        return this;
    }
    public boolean isOnRegistrationPage() {
        return exists(submitButton);
    }

    //check alert presence

    public boolean alertMessageNotValidUserName() {
        return exists(wrongUsernameAlert);
    }

    public boolean alertMessageNotValidFirstName() {
        return exists(wrongFirstNameAlert);
    }

    public boolean alertMessageNotValidLastName() {
        return exists(wrongLastNameAlert);
    }

    public String getTextElement(WebElement element) {

        String text_elemen;
        text_elemen = element.getText();

        return text_elemen;
    }

/*
    public String gettext() {return getTextElement(ErrorCaptcha); }
    public String gettext() {return getTextElement(ErrorCaptcha); }
    public String gettext() {return getTextElement(ErrorCaptcha); }
    public String gettext() {return getTextElement(ErrorCaptcha); }
    public String gettext() {return getTextElement(ErrorCaptcha); }
    public String gettext() {return getTextElement(ErrorCaptcha); }
    public String gettext() {return getTextElement(ErrorCaptcha); }
    public String gettext() {return getTextElement(ErrorCaptcha); }
    public String gettext() {return getTextElement(ErrorCaptcha); }
*/
    public void waitForCaptcha() {
        Log.info("Waiting of Captcha mesaage");
        waitUntilIsLoaded(ErrorCaptcha);
    }


    public boolean checkFirstNameEmptyFieldMessage() {
        return verifyTextBoolean(wrongUsernameAlert, "The first name field is required.");
    }

    public boolean checkLastNameEmptyFieldMessage() {
        return verifyTextBoolean(lastNameField, "The last name field is required.");
    }

    public boolean checkEmailEmptyFieldMessage() {
        return verifyTextBoolean(emailField, "The email field is required.");
    }
    public boolean checkEmailInvalidFieldMessage() {
        return verifyTextBoolean(wrongEmailAlert, "The email format is invalid.");
    }
}

