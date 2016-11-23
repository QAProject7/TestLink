package com.telran.pages.TelRan7;

import com.telran.pages.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


/**
 * Created by
 */
public class AnatolyRegPage extends Page {
    // private static Logger Log = Logger.getLogger(LogLog4j.class.getName());


    //fields
    @FindBy(id = "MainContent_RegisterUser_CreateUserStepContainer_UserName")
    WebElement usernameField;

    @FindBy(id = "MainContent_RegisterUser_CreateUserStepContainer_Password")
    WebElement passwordField;

    @FindBy(id = "MainContent_RegisterUser_CreateUserStepContainer_firstNameTxt")
    WebElement fNameField;

    @FindBy(id = "MainContent_RegisterUser_CreateUserStepContainer_lastNameTxt")
    WebElement lNameField;

    @FindBy(id = "MainContent_RegisterUser_CreateUserStepContainer_Email")
    WebElement emailField;

    @FindBy(id = "MainContent_RegisterUser_CreateUserStepContainer_ConfirmPassword")
    WebElement confirmPasswordField;

    @FindBy(id = "MainContent_RegisterUser_CreateUserStepContainer_PersonalIdTxt")
    WebElement idField;

    @FindBy(id = "ctl00_MainContent_RegisterUser_CreateUserStepContainer_birthdayTxt_dateInput")
    WebElement birthdayDateField;

    @FindBy(id = "ctl00_MainContent_RegisterUser_CreateUserStepContainer_birthdayTxt")
    WebElement birthdayField;

    @FindBy(id = "ctl00_MainContent_RegisterUser_CreateUserStepContainer_ContactCellTxt")
    WebElement telephoneField;

    @FindBy(id = "MainContent_RegisterUser_CreateUserStepContainer_AddressTxt")
    WebElement streetField;

    @FindBy(id = "MainContent_RegisterUser_CreateUserStepContainer_HouseNumberTxt")
    WebElement homeField;

    @FindBy(id = "MainContent_RegisterUser_CreateUserStepContainer_CityTxt")
    WebElement cityField;

    @FindBy(id = "MainContent_RegisterUser_CreateUserStepContainer_clinicNameTxt")
    WebElement clinicField;

    @FindBy(id = "MainContent_AddNewUser")
    WebElement addDoctorButton;

    public AnatolyRegPage(WebDriver driver) {
        super(driver);
        baseUrl = "http://dhclinicappv2stg.item-soft.co.il";
        this.PAGE_URL = baseUrl + "/SitePages/createUser.aspx?ReturnUrl=HomePage";
        PageFactory.initElements(driver, this);
    }


    //check alert presence
    public void FillUserName(String login) {
        setElementText(usernameField, login);
    }

    public void FillPassword(String password) {
        setElementText(passwordField, password);
    }

    public void AddDoctorClick() {
        clickElement(addDoctorButton);
    }

    public void WaitRegPageIsLoaded() {
        waitUntilIsLoadedCustomTime(addDoctorButton, 10);
    }

    public void AddDoctor() {
        WaitRegPageIsLoaded();
        FillPassword("Pass123");
        FillUserName("testDoctor1");
        setElementText(confirmPasswordField, "Pass123");
        setElementText(fNameField, "fname1");
        setElementText(lNameField, "lname1");
        setElementText(emailField, "abc@mail.com");
        setElementText(idField, "710574831");
        setElementText(birthdayDateField, "01.01.1980");
        setElementText(birthdayField, "1980-01-01");
        setElementText(telephoneField, "052-1234567");
        setElementText(streetField, "herzl");
        setElementText(homeField, "1");
        setElementText(cityField, "tel aviv");
        setElementText(clinicField, "clinic1");
        AddDoctorClick();
    }
}