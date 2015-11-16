package com.telran.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.Random;

/**
 * Created by Iakov Volf
 */
public class CreateNewPatientPage extends Page {

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

    @FindBy(id = "ctl00_MainContent_AddEditAccount1_BtnSearch_input")
    WebElement sendFirstEmailButton;

    @FindBy(id = "ctl00_MainContent_AddEditAccount1_BtnSearch_input")
    WebElement sendSecondEmailButton;

    @FindBy(id = "btnAddLink")
    WebElement addNewAdultButton;

    @FindBy(id = "ctl00_MainContent_AddEditAccount1_TxtSearchRoles_Arrow")
    WebElement chooseAdultTypeButton;

    @FindBy(xpath = "//*[@id='ctl00_MainContent_AddEditAccount1_TxtSearchRoles_DropDown']/div/ul/li[3]")
    WebElement teacherAdultFromList;

    @FindBy(xpath = "//*[@id='popup']/div[6]/iframe")
    WebElement frameNewPatient;

//*[@id='popup']/div[6]/iframe


    @FindBy(id = "ctl00_MainContent_AddEditAccount1_RDDL_Therapists")
    WebElement buttonChooseTherapist;

    @FindBy(id = "ctl00_MainContent_AddEditAccount1_RDTmeetingdate_dateInput")
    WebElement inputMeetingDate;

    @FindBy(id = "MainContent_AddEditAccount1_TBMeetingMinutes")
    WebElement inputMeetingTime;

    @FindBy(id = "MainContent_AddEditAccount1_SaveAccount")
    WebElement buttonSaveAccount;

    //public ProfilePage profilePage;

    public CreateNewPatientPage(WebDriver driver) {
        super(driver);
        this.PAGE_URL = "http://dhclinicappv2stg.item-soft.co.il/SitePages/createUser.aspx?ReturnUrl=HomePage";
        PageFactory.initElements(driver, this);
    }

    public CreateNewPatientPage openCreatePAtinetPage(WebDriver driver) {
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


    public String generateFirstName() {
        Random rn = new Random();
        int num = rn.nextInt(1000) + 1;
        String name = "First" + num;
        return name;
    }

    public CreateNewPatientPage fillFirstNameField(String name) {
        setElementText(inputName, name);
        return this;
    }

    public String generateLastName() {
        Random rn = new Random();
        int num = rn.nextInt(1000) + 1;
        String name = "Last" + num;
        return name;
    }

    public CreateNewPatientPage fillLastNamefield(String name) {
        setElementText(inputLastName, name);
        return this;
    }

    public String generateParentEmail() {
        Random rn = new Random();
        int num = rn.nextInt(1000) + 1;
        String ParentEmail = "hore" + num + "@yopmail.com";
        return ParentEmail;
    }

    public String generateTeacherEmail() {
        Random rn = new Random();
        int num = rn.nextInt(1000) + 1;
        String Email = "hore" + num + "@yopmail.com";
        return Email;
    }

    public String generateZeut() {
        String number = createId();
        return number;
    }

    public CreateNewPatientPage fillZeutAutomatic() {
        String number = generateZeut();
        setElementText(inputZeut, number);
        return this;
    }

    public CreateNewPatientPage fillZeutfield(String zeut) {
        setElementText(inputZeut, zeut);
        return this;
    }


    public CreateNewPatientPage fillBirthDayfield(String date) {
        setElementText(inputBirthDay, date);
        return this;
    }

    public CreateNewPatientPage fillWeightfield(String weight) {
        setElementText(inputWeight, weight);
        return this;
    }

    public CreateNewPatientPage filltEmailField(String email) {
        setElementText(inputEmail, email);
        return this;
    }

    public CreateNewPatientPage chooseWeightUnit(String weight) {
        selectValueInDropdownbyText(chooseWeightUnit, weight);
        return this;
    }

    public CreateNewPatientPage chooseDoctor(String doctor) {
        selectValueInDropdownbyText(chooseWeightUnit, doctor);
        return this;
    }

    public CreateNewPatientPage sendFirstEmail() {
        clickElement(sendFirstEmailButton);
        return this;
    }

    public CreateNewPatientPage addTeacher() {
        clickElement(addNewAdultButton);
        return this;
    }

    public CreateNewPatientPage fillMeetingDateAndTime(String dateMiting) {
        setElementText(inputMeetingDate, dateMiting);
        return this;
    }


    public CreateNewPatientPage waitUntilPageIsLoaded() throws IOException, InterruptedException {
        waitUntilElementIsLoaded(buttonSaveAccount);
        return this;
    }

    public boolean alertFillDate() {
        return exists(fillingAlert);
    }

    // methods, that fills all fields except TZ and Emails

    public void createPatientOneParent(String TZ, String Email) throws IOException, InterruptedException {
        driver.switchTo().frame(frameNewPatient);
        waitUntilPageIsLoaded();
        fillFirstNameField("PatientChildFirst");
        fillLastNamefield("PatientChildLast");
        fillZeutfield(TZ);
        fillWeightfield("2");
        fillBirthDayfield("09/04/2014");
        filltEmailField(Email);
        sendFirstEmail();
        fillMeetingDateAndTime("02/12/2015 20:00");
        clickSaveAccount();


    }
}