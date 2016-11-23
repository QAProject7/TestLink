package com.telran.pages.TelRan7.vitaliy;

import com.telran.pages.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by vitaliy on 23.11.2016.
 */
public class DoctorRegistration extends Page {

    //Fields
    @FindBy(id = "MainContent_LoginUser_RegisterHyperLink")
    WebElement GoToDoctorRegistration;
    @FindBy(id = "MainContent_RegisterUser_CreateUserStepContainer_UserName")
    WebElement UserName;
    @FindBy(id = "MainContent_RegisterUser_CreateUserStepContainer_firstNameTxt")
    WebElement FirstName;
    @FindBy(id = "MainContent_RegisterUser_CreateUserStepContainer_lastNameTxt")
    WebElement LastName;
    @FindBy(id = "MainContent_RegisterUser_CreateUserStepContainer_Email")
    WebElement Email;
    @FindBy(id = "MainContent_RegisterUser_CreateUserStepContainer_Password")
    WebElement Passord;
    @FindBy(id = "MainContent_RegisterUser_CreateUserStepContainer_ConfirmPassword")
    WebElement RepeatThePassword;
    @FindBy(id = "MainContent_RegisterUser_CreateUserStepContainer_PersonalIdTxt")
    WebElement PersonalId;
    @FindBy(id = "MainContent_RegisterUser_CreateUserStepContainer_AddressTxt")
    WebElement Street;
    @FindBy(id = "MainContent_RegisterUser_CreateUserStepContainer_HouseNumberTxt")
    WebElement HouseNumber;
    @FindBy(id = "MainContent_RegisterUser_CreateUserStepContainer_CityTxt")
    WebElement City;
    @FindBy(id = "MainContent_AddNewUser")
    WebElement SaveNewDoctorButton;

    //Methods
    public DoctorRegistration(WebDriver driver) {
        super(driver);
        this.PAGE_URL = "http://dhclinicappv2stg.item-soft.co.il/Login.aspx";
        PageFactory.initElements(driver, this);
    }

    public void goToDoctorRegistration() {
        clickElement(GoToDoctorRegistration);
    }

    public void waitUntilIsLoadedCusTime() {
        waitUntilIsLoadedCustomTime(UserName, 10);
    }

    public void fillUserNameField() {
        setElementText(UserName, "username");
    }

    public void fillFirstNameField() {
        setElementText(FirstName, "firstname");
    }

    public void fillLastNameField() {
        setElementText(LastName, "lastname");
    }

    public void fillEmailField() {
        setElementText(Email, "gmail_email+258@gmail.com");
    }

    public void fillPasswordFields() {
        setElementText(Passord, "password");
        setElementText(RepeatThePassword, "password");
    }

    public void fillPersonalIdField() {
        setElementText(PersonalId, "124521475");

    }

    public void fillAdressFields() {
        setElementText(City, "City");
        setElementText(Street, "Street");
        setElementText(HouseNumber, "55");
    }

    public void clickOnSaveNewDoctorButton() {
        clickElement(SaveNewDoctorButton);
    }

    public void DoctorRegisttation() {
        goToDoctorRegistration();
        waitUntilIsLoadedCusTime();
        fillUserNameField();
        fillFirstNameField();
        fillLastNameField();
        fillEmailField();
        fillPasswordFields();
        fillPersonalIdField();
        fillAdressFields();
        clickOnSaveNewDoctorButton();
    }
}
