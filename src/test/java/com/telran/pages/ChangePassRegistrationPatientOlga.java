package com.telran.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Iakov Volf,Oleg
 */
public class ChangePassRegistrationPatientOlga extends Page {

    public ChangePassRegistrationPatientOlga(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    //fields

    @FindBy(id = "MainContent_ChangeUserPassword_ChangePasswordContainerID_CurrentPassword")
    WebElement changePasswordCurrentPassword;
    @FindBy(id = "MainContent_ChangeUserPassword_ChangePasswordContainerID_NewPassword")
    WebElement changePasswordNewPassword;
    @FindBy(id = "MainContent_ChangeUserPassword_ChangePasswordContainerID_ConfirmNewPassword")
    WebElement changePasswordConfirmNewPassword;
    @FindBy(id = "MainContent_ChangeUserPassword_ChangePasswordContainerID_ChangePasswordPushButton")
    WebElement changePasswordPushButton;

    @FindBy(xpath = "//a[contains(text(),'המשך >')]")
    WebElement gotoFillProfile;

    @FindBy(id = "id=MainContent_firstNameTxt")
    WebElement firstNameTxt;
    @FindBy(id = "MainContent_lastNameTxt")
    WebElement lastNameTxt;

    @FindBy(id = "ctl00_MainContent_birthdayTxt_dateInput")
    WebElement dateBirthday;


    @FindBy(id = "MainContent_PersonalIdTxt")
    WebElement personalIdTxt;

    @FindBy(id = "ctl00_MainContent_ContactPhoneTxt")
    WebElement contactPhoneTxt;

    @FindBy(id = "MainContent_AddressTxt")
    WebElement addressTxt;

    @FindBy(id = "MainContent_HouseNumberTxt")
    WebElement houseNumberTxt;

    @FindBy(id = "MainContent_CityTxt")
    WebElement cityTxt;

    @FindBy(id = "MainContent_CreateUserButton")
    WebElement createUserButton;

    //public ProfilePage profilePage;
//
//    public ChangePassRegistrationPatientOlga(WebDriver driver) {
//        super(driver);
//        this.PAGE_URL = "http://dhclinicappv2stg.item-soft.co.il/SitePages/createUser.aspx?ReturnUrl=HomePage";
//        PageFactory.initElements(driver, this);
//    }
//
//
//    public ChangePassRegistrationPatientOlga openRegistrationPage(WebDriver driver) {
//        driver.get(PAGE_URL);
//        return this;
//    }

//Fill the fileds

//    Page Change password
    public ChangePassRegistrationPatientOlga fillCurrentPassword(String pass) {
        setElementText(changePasswordCurrentPassword, pass);
        return this;
    }
    public ChangePassRegistrationPatientOlga fillNewPassword(String pass) {
        setElementText(changePasswordNewPassword, pass);
        return this;
    }
    public ChangePassRegistrationPatientOlga fillConfirmNewPassword(String pass) {
        setElementText(changePasswordConfirmNewPassword, pass);
        return this;
    }

    public ChangePassRegistrationPatientOlga waitUntilGoToNextPageLoaded() {
        try {
            waitUntilElementIsLoaded(changePasswordPushButton);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }

//    Page after Change password

    public ChangePassRegistrationPatientOlga waitUntilFillProfilePageIsLoaded() {
        try {
            waitUntilElementIsLoaded(gotoFillProfile);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }
//    Page Fill Profile User
    public ChangePassRegistrationPatientOlga fillFirstNameTxt(String firstName) {
        setElementText(firstNameTxt, firstName);
        return this;
    }
    public ChangePassRegistrationPatientOlga fillLastNameTxt(String lastName) {
        setElementText(lastNameTxt, lastName);
        return this;
    }
    public ChangePassRegistrationPatientOlga fillDateBirthday(String date) {
        setElementText(dateBirthday, date);
        return this;
    }
    public ChangePassRegistrationPatientOlga fillPersonalId(String personalId) {
        setElementText(personalIdTxt, personalId);
        return this;
    }
    public ChangePassRegistrationPatientOlga fillcontactPhone(String personalId) {
        setElementText(contactPhoneTxt, personalId);
        return this;
    }
    public ChangePassRegistrationPatientOlga fillAdress(String address) {
        setElementText(addressTxt, address);
        return this;
    }
    public ChangePassRegistrationPatientOlga fillHouseNumber(String houseNumber) {
        setElementText(houseNumberTxt, houseNumber);
        return this;
    }
    public ChangePassRegistrationPatientOlga fillCity(String city) {
        setElementText(cityTxt, city);
        return this;
    }

    public void clickOnSubmitButton() {
        clickElement(createUserButton);

    }


}
