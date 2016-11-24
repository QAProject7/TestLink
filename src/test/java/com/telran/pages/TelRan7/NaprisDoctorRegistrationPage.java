package com.telran.pages.TelRan7;

import com.telran.pages.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Napris on 24.11.2016.
 */
public class NaprisDoctorRegistrationPage extends Page {

    //fields
    @FindBy(id = "MainContent_RegisterUser_CreateUserStepContainer_UserName")
    WebElement userNameField;

    @FindBy(id = "MainContent_RegisterUser_CreateUserStepContainer_firstNameTxt")
    WebElement firstNameField;

    @FindBy(id = "MainContent_RegisterUser_CreateUserStepContainer_lastNameTxt")
    WebElement lastNameField;

    @FindBy(id = "MainContent_RegisterUser_CreateUserStepContainer_Email")
    WebElement emailField;

    @FindBy(id = "MainContent_RegisterUser_CreateUserStepContainer_Password")
    WebElement passwordField;

    @FindBy(id = "MainContent_RegisterUser_CreateUserStepContainer_ConfirmPassword")
    WebElement confirmPasswordField;

    @FindBy(id = "MainContent_RegisterUser_CreateUserStepContainer_PersonalIdTxt")
    WebElement personalIdField;

    @FindBy(id = "MainContent_RegisterUser_CreateUserStepContainer_clinicNameTxt")
    WebElement clinicNameField;

    @FindBy(id = "ctl00_MainContent_RegisterUser_CreateUserStepContainer_birthdayTxt_dateInput")
    WebElement birthdayField;

    @FindBy(id = "ctl00_MainContent_RegisterUser_CreateUserStepContainer_ContactCellTxt")
    WebElement contactCellField;

    @FindBy(id = "MainContent_RegisterUser_CreateUserStepContainer_AddressTxt")
    WebElement streetField;

    @FindBy(id = "MainContent_RegisterUser_CreateUserStepContainer_HouseNumberTxt")
    WebElement houseNumberField;

    @FindBy(id = "MainContent_RegisterUser_CreateUserStepContainer_CityTxt")
    WebElement cityField;

    //buttons
    @FindBy(id = "MainContent_AddNewUser")
    WebElement addNewUserButton;

    //links
    @FindBy(id = "MainContent_LoginUser_RegisterHyperLink")
    WebElement doctorRegistrationLink;

    //constructor
    public NaprisDoctorRegistrationPage(WebDriver driver) {
        super(driver);
        this.PAGE_URL = "http://dhclinicappv2stg.item-soft.co.il/Login.aspx";
        PageFactory.initElements(driver, this);
    }

    //methods
    public void waitUntilLoginPageIsLoaded() {
        waitUntilIsLoadedCustomTime(doctorRegistrationLink, 10);
    }

    public void clickOnDoctorRegistrationLink() {
        clickElement(doctorRegistrationLink);
    }

    public void waitUntilDoctorRegistrationPageIsLoaded() {
        waitUntilIsLoadedCustomTime(addNewUserButton, 10);
    }

    public void fillUserName() {
        setElementText(userNameField, "userName");
    }

    public void fillFirstName() {
        setElementText(firstNameField, "firstName");
    }

    public void fillLastName() {
        setElementText(lastNameField, "lastName");
    }

    public void fillEmail() {
        setElementText(emailField, "email");
    }

    public void fillPassword() {
        setElementText(passwordField, "password");
    }

    public void fillConfirmPassword() {
        setElementText(confirmPasswordField, "confirmPassword");
    }

    public void fillPersonalId() {
        setElementText(personalIdField, "personalId");
    }

    public void fillClinicName() {
        setElementText(clinicNameField, "clinicName");
    }

    public void fillBirthday() {
        setElementText(birthdayField, "birthday");
    }

    public void fillContactCell() {
        setElementText(contactCellField, "contactCell");
    }

    public void fillStreet() {
        setElementText(streetField, "street");
    }

    public void fillHouseNumber() {
        setElementText(houseNumberField, "houseNumber");
    }

    public void fillCity() {
        setElementText(cityField, "city");
    }

    public void clickOnAddNewDoctor() {
        clickElement(addNewUserButton);
    }

    public void doctorRegistration() {
        waitUntilLoginPageIsLoaded();
        clickOnDoctorRegistrationLink();
        waitUntilDoctorRegistrationPageIsLoaded();
        fillUserName();
        fillFirstName();
        fillLastName();
        fillEmail();
        fillPassword();
        fillConfirmPassword();
        fillPersonalId();
        fillClinicName();
        fillBirthday();
        fillContactCell();
        fillStreet();
        fillHouseNumber();
        fillCity();
        clickOnAddNewDoctor();
    }
}
