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

    public void fillUserName(String userName) {
        setElementText(userNameField, userName);
    }

    public void fillFirstName(String firstName) {
        setElementText(firstNameField, firstName);
    }

    public void fillLastName(String lastName) {
        setElementText(lastNameField, lastName);
    }

    public void fillEmail(String email) {
        setElementText(emailField, email);
    }

    public void fillPassword(String password) {
        setElementText(passwordField, password);
    }

    public void fillConfirmPassword(String confirmPassword) {
        setElementText(confirmPasswordField, confirmPassword);
    }

    public void fillPersonalId(String personalId) {
        setElementText(personalIdField, personalId);
    }

    public void fillClinicName(String clinicName) {
        setElementText(clinicNameField, clinicName);
    }

    public void fillBirthday(String birthday) {
        setElementText(birthdayField, birthday);
    }

    public void fillContactCell(String contactCell) {
        setElementText(contactCellField, contactCell);
    }

    public void fillStreet(String street) {
        setElementText(streetField, street);
    }

    public void fillHouseNumber(String houseNumber) {
        setElementText(houseNumberField, houseNumber);
    }

    public void fillCity(String city) {
        setElementText(cityField, city);
    }

    public void clickOnAddNewDoctor() {
        clickElement(addNewUserButton);
    }

    public void doctorRegistration(String userName, String firstName, String lastName,
                                   String email, String password, String confirmPassword,
                                   String personalId, String clinicName, String birthday,
                                   String contactCell, String street, String houseNumber, String city) {
        waitUntilLoginPageIsLoaded();
        clickOnDoctorRegistrationLink();
        waitUntilDoctorRegistrationPageIsLoaded();
        fillUserName(userName);
        fillFirstName(firstName);
        fillLastName(lastName);
        fillEmail(email);
        fillPassword(password);
        fillConfirmPassword(confirmPassword);
        fillPersonalId(personalId);
        fillClinicName(clinicName);
        fillBirthday(birthday);
        fillContactCell(contactCell);
        fillStreet(street);
        fillHouseNumber(houseNumber);
        fillCity(city);
        clickOnAddNewDoctor();
    }
}
