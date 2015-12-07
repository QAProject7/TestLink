package com.telran.pages.PageTraining;

import com.telran.pages.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Iakov Volf,Oleg
 */
public class CreateNewPatient extends Page {

    @FindBy(xpath = "//*[@id='MainContent_AddEditAccount1_RBL_DepPatient']//*[contains(text(), 'ילד/ילדה')]")
    WebElement clickRadioEled;

    @FindBy(xpath = "//*[@id='MainContent_AddEditAccount1_ctl07'][contains(text(), 'נא להזין פרטים חסרים')]")
    WebElement fillingAlert;

    @FindBy(id = "MainContent_AddEditAccount1_firstNameTxt")
    WebElement inputName;

    @FindBy(id = "MainContent_AddEditAccount1_lastNameTxt")
    WebElement inputLastName;

    @FindBy(id = "MainContent_AddEditAccount1_PersonalPatientTxt")
    WebElement inputZeut;

    @FindBy(id = "MainContent_AddEditAccount1_RblGender_0")
    WebElement clickRadioZoher;

    @FindBy(id = "MainContent_AddEditAccount1_RblGender_1")
    WebElement clickRadioNikba;

    @FindBy(id = "ctl00_MainContent_AddEditAccount1_rdp_birthDate_dateInput")
    WebElement inputBirthDay;

    @FindBy(id = "MainContent_AddEditAccount1_rtb_Weight")
    WebElement inputWeight;

    @FindBy(id = "MainContent_AddEditAccount1_DDL_WeightUnit")
    WebElement chooseWeightUnit;

    @FindBy(id = "ctl00_MainContent_AddEditAccount1_RCBdomain")
    WebElement chooseDoctor;

    @FindBy(id = "ctl00_MainContent_AddEditAccount1_TxtsearchMail")
    WebElement inputEmail;

    @FindBy(id = "ctl00_MainContent_AddEditAccount1_RDDL_Therapists")
    WebElement buttonChooseTherapist;

    @FindBy(id = "ctl00_MainContent_AddEditAccount1_RDTmeetingdate_dateInput")
    WebElement inputMeetingDate;

    @FindBy(id = "MainContent_AddEditAccount1_TBMeetingMinutes")
    WebElement inputMeetingTime;

    @FindBy(id = "MainContent_AddEditAccount1_SaveAccount")
    WebElement buttonSaveAccount;

    //public ProfilePage profilePage;

    public CreateNewPatient(WebDriver driver) {
        super(driver);
        this.PAGE_URL = "http://dhclinicappv2stg.item-soft.co.il/SitePages/createUser.aspx?ReturnUrl=HomePage";
        PageFactory.initElements(driver, this);
    }

    public CreateNewPatient addingPatient(WebDriver driver) {
        driver.get(PAGE_URL);
        return this;
    }

//Fill the fileds

    public void clickRadioEled() {
        clickElement(clickRadioEled);
    }

    public void clickRadioZoher() {
        clickElement(clickRadioZoher);
    }

    public void clickRadioNikba() {
        clickElement(clickRadioNikba);
    }

    public void clickChooseTherapist() {
        clickElement(buttonChooseTherapist);
    }

    public void clickSaveAccount() {
        clickElement(buttonSaveAccount);
    }

    public CreateNewPatient inputName(String name) {
        setElementText(inputName, name);
        return this;
    }

    public CreateNewPatient inputLastName(String lastName) {
        setElementText(inputLastName, lastName);
        return this;
    }

    public CreateNewPatient inputZeut(String number) {
        setElementText(inputZeut, number);
        return this;
    }

    public CreateNewPatient inputBirthDay(String date) {
        setElementText(inputBirthDay, date);
        return this;
    }

    public CreateNewPatient inputWeight(String weight) {
        setElementText(inputWeight, weight);
        return this;
    }

    public CreateNewPatient inputEmail(String email) {
        setElementText(inputEmail, email);
        return this;
    }

    public CreateNewPatient chooseWeightUnit(String weight) {
        selectValueInDropdownbyText(chooseWeightUnit, weight);
        return this;
    }

    public CreateNewPatient chooseDoctor(String doctor) {
        selectValueInDropdownbyText(chooseWeightUnit, doctor);
        return this;
    }

    public CreateNewPatient inputMeetingDate(String dateMiting) {
        selectValueInDropdownbyText(inputMeetingDate, dateMiting);
        return this;
    }

    public CreateNewPatient inputMeetingTime(String meetingTime) {
        selectValueInDropdownbyText(inputMeetingTime, meetingTime);
        return this;
    }

    public boolean alertFillDate() {
        return exists(fillingAlert);
    }
}