package com.telran.pages;


import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

/**
 * Created by Olga K.
 */
public class ChangePassRegistrationPatientOlgaPage extends Page {

    public static Logger Log = Logger.getLogger(ChangePassRegistrationPatientOlgaPage.class.getName());
    public static String firstName = "Moshe";

    //fields
    public static String lastName = "Levi";
    public static String password = "LinkCare!1";
    public static String passwordResult = "LinkCare!!11";
    public static String address = "Herzl";
    public static String city = "Ashdod";
    public static String houseNumber = "33";
    public static String date = "1990-11-05";
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
    @FindBy(id = "MainContent_firstNameTxt")
    WebElement firstNameTxt;
    @FindBy(id = "MainContent_lastNameTxt")
    WebElement lastNameTxt;
    @FindBy(id = "MainContent_Email")
    WebElement emailTxt;
    @FindBy(id = "ctl00_MainContent_birthdayTxt")
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
    //Errors
    @FindBy (xpath= "//*[@id='MainContent_ChangeUserPassword_ChangePasswordContainerID_ChangeUserPasswordValidationSummary']/ul/li[contains(text(),'סיסמא קודמת חובה')]")
    WebElement errorEmptyPass;
    @FindBy (xpath= "//*[@id='MainContent_ChangeUserPassword_ChangePasswordContainerID_ChangeUserPasswordValidationSummary']/ul/li[contains(text(),'סיסמא חדשה חובה')]")
    WebElement errorEmptyPassNew;
    @FindBy (xpath= "//*[@id='MainContent_ChangeUserPassword_ChangePasswordContainerID_ChangeUserPasswordValidationSummary']/ul/li[contains(text(),'אימות סיסמא חובה')]")
    WebElement errorEmptyPassRepeat;
    @FindBy (xpath= "//*[@id='MainContent_ChangeUserPassword_ChangePasswordContainerID_ChangeUserPasswordValidationSummary']/ul/li[contains(text(),'אשור הסיסמה החדשה חייב להתאים לערך הסיסמה החדש')]")
    WebElement errorPassNotSame;
    @FindBy(id = "MainContent_FirsNameRequired")
    WebElement firstNameRequired;
    @FindBy(id = "MainContent_LastNameRequired")
    WebElement lastNameRequired;
    @FindBy(id = "MainContent_EmailRequired")
    WebElement emailRequired;
    @FindBy(id = "MainContent_regexEmailValid")
    WebElement emailInvalidRequired;
    @FindBy(id = "MainContent_RequiredFieldValidator1")
    WebElement requiredTZ;
    @FindBy(id = "MainContent_CVPersonalId")
    WebElement requiredTZInvalid;
    @FindBy(id = "MainContent_RequiredFieldValidator2")
    WebElement requiredTelephone;
    @FindBy(id = "MainContent_RequiredFieldValidator5")
    WebElement requiredHomeNumber;
    @FindBy(id = "MainContent_RequiredFieldValidator3")
    WebElement requiredStreet;
    @FindBy(id = "MainContent_RequiredFieldValidator4")
    WebElement requiredTown;

    public ChangePassRegistrationPatientOlgaPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    //Fill the fileds MainContent_ChangeUserPassword_ChangePasswordContainerID_ChangeUserPasswordValidationSummary
//wait until page is loaded
    public ChangePassRegistrationPatientOlgaPage waitUntilPassChangePageLoaded() {
        try {
            waitUntilElementIsLoaded(changePasswordCurrentPassword);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
    }
        return this;
    }

    //    Page Change password
    public ChangePassRegistrationPatientOlgaPage fillCurrentPassword(String pass) {
        setElementText(changePasswordCurrentPassword, pass);
        return this;
    }


//    Page after Change password

    public ChangePassRegistrationPatientOlgaPage fillNewPassword(String pass) {
        setElementText(changePasswordNewPassword, pass);
        return this;
    }

    public ChangePassRegistrationPatientOlgaPage fillConfirmNewPassword(String pass) {
        setElementText(changePasswordConfirmNewPassword, pass);
        return this;
    }

    public void clickOnChangePassButton() {
        clickElement(changePasswordPushButton);

    }

    public boolean isErrorEmptyPass() {
        return exists(errorEmptyPass);
    }

    public boolean isErrorEmptyPassNew() {
        return exists(errorEmptyPassNew);
    }

    public boolean isErrorEmptyPassRepeat() {
        return exists(errorEmptyPassRepeat);
    }

    public boolean isErrorPassNotSame() {
        return exists(errorPassNotSame);
    }

    public boolean isNoIntermediatePage() {
        return exists(gotoFillProfile);
    }

    public ChangePassRegistrationPatientOlgaPage waitUntilGoToNextPageLoaded() {
        try {
            waitUntilElementIsLoaded(gotoFillProfile);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }

    public void clickOnGotoFillProfile() {
        clickElement(gotoFillProfile);

    }

    //    Page Fill Profile User
    public ChangePassRegistrationPatientOlgaPage waitUntilFillProfilePageIsLoaded() {
        try {
            waitUntilElementIsLoaded(firstNameTxt);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }

    public ChangePassRegistrationPatientOlgaPage fillFirstNameTxt(String firstName) {
        setElementText(firstNameTxt, firstName);
        return this;
    }

    public ChangePassRegistrationPatientOlgaPage fillLastNameTxt(String lastName) {
        setElementText(lastNameTxt, lastName);
        return this;
    }

    public ChangePassRegistrationPatientOlgaPage fillEmail(String email) {
        setElementText(emailTxt, email);
        return this;
    }

    public ChangePassRegistrationPatientOlgaPage fillDateBirthday(String date) {
        setElementText(dateBirthday, date);
        return this;
    }

    public ChangePassRegistrationPatientOlgaPage fillPersonalId(String personalId) {
        setElementText(personalIdTxt, personalId);
        return this;
    }

    public ChangePassRegistrationPatientOlgaPage fillcontactPhone(String personalId) {
        setElementText(contactPhoneTxt, personalId);
        return this;
    }

    public ChangePassRegistrationPatientOlgaPage fillAdress(String address) {
        setElementText(addressTxt, address);
        return this;
    }

    public ChangePassRegistrationPatientOlgaPage fillHouseNumber(String houseNumber) {
        setElementText(houseNumberTxt, houseNumber);
        return this;
    }

    public ChangePassRegistrationPatientOlgaPage fillCity(String city) {
        setElementText(cityTxt, city);
        return this;
    }

    public void clickOnSubmitButton() {
        clickElement(createUserButton);

    }

    public String generateId (){
        return createId();
    }

    public boolean isErEmptyFirstName() {
        return exists(firstNameRequired);
    }

    public boolean isErEmptyLastName() {
        return exists(lastNameRequired);
    }

    public boolean isErEmptyEmail() {
        return exists(emailRequired);
    }

    public boolean isErInvalidEmail() {
        return exists(emailInvalidRequired);
    }

    public boolean isErEmptyTZ() {
        return exists(requiredTZ);
    }

    public boolean isErTZInvalid() {
        return exists(requiredTZInvalid);
    }

    public boolean isErEmptyTelephone() {
        return exists(requiredTelephone);
    }

    public boolean isErEmptyHomeNumber() {
        return exists(requiredHomeNumber);
    }

    public boolean isErEmptyStreet() {
        return exists(requiredStreet);
    }

    public boolean isErEmptyTown() {
        return exists(requiredTown);
    }

    public void fillAllChangePassAndProfile(String tz, String email){
        fillCurrentPassword(password);
        fillNewPassword(passwordResult);
        fillConfirmNewPassword(passwordResult);
        clickOnChangePassButton();
        waitUntilGoToNextPageLoaded();
        clickOnGotoFillProfile();
        waitUntilFillProfilePageIsLoaded();
        fillFirstNameTxt(firstName);
        fillLastNameTxt(lastName);
        fillDateBirthday(date);
        fillEmail(email);
        fillPersonalId(tz);
        fillcontactPhone(tz);
        fillAdress(address);
        fillHouseNumber(houseNumber);
        fillCity(city);
        clickOnSubmitButton();
    }
    public void fillOnlyProfile(String tz, String email){
        waitUntilFillProfilePageIsLoaded();
        fillFirstNameTxt(firstName);
        fillLastNameTxt(lastName);
        fillDateBirthday(date);
        fillEmail(email);
        fillPersonalId(tz);
        fillcontactPhone(tz);
        fillAdress(address);
        fillHouseNumber(houseNumber);
        fillCity(city);
        clickOnSubmitButton();
    }
    public void fillChangePass(){
        fillCurrentPassword(password);
        fillNewPassword(passwordResult);
        fillConfirmNewPassword(passwordResult);
        clickOnChangePassButton();
        waitUntilGoToNextPageLoaded();
        clickOnGotoFillProfile();
        waitUntilFillProfilePageIsLoaded();
    }
}
