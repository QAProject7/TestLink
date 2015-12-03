package com.telran.pages;

import com.telran.LogLog4j;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
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
    private static Logger Log = Logger.getLogger(LogLog4j.class.getName());
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

    @FindBy(xpath = "//*[@id='ctl00_MainContent_AddEditAccount1_TxtSearchRoles_DropDown']/div/ul/li[2]")
    WebElement teacherAdultFromList;

    @FindBy(xpath = "//*[@id='popup']/div[6]/iframe")
    WebElement frameNewPatient;

    @FindBy(xpath = "//*[@id='ctl00_DisplayImportantLinks1_myMenu']/ul/li[1]/a")
    WebElement questMenu;


//*[@id='popup']/div[6]/iframe


    @FindBy(id = "ctl00_MainContent_AddEditAccount1_RDDL_Therapists")
    WebElement buttonChooseTherapist;

    @FindBy(id = "ctl00_MainContent_AddEditAccount1_RDTmeetingdate_dateInput")
    WebElement inputMeetingDate;

    @FindBy(id = "MainContent_AddEditAccount1_TBMeetingMinutes")
    WebElement inputMeetingTime;

    @FindBy(id = "MainContent_AddEditAccount1_SaveAccount")
    WebElement buttonSaveAccount;

    @FindBy(id = "MainContent_AddEditAccount1_Label1")
    WebElement labelUserName;

    //public ProfilePage profilePage;

    public CreateNewPatientPage(WebDriver driver) {
        super(driver);
        this.PAGE_URL = baseUrl + "/SitePages/createUser.aspx?ReturnUrl=HomePage";
        PageFactory.initElements(driver, this);
    }




    public CreateNewPatientPage openCreatePAtinetPage(WebDriver driver) {
        driver.get(PAGE_URL);
        return this;
    }

//Fill the fileds


//methods that generate test data

    /*public String generateFirstName() {
        Random rn = new Random();
        int num = rn.nextInt(1000) + 1;
        String name = "First" + Integer.toString(num);
        return name;
    }*/

    /*public String generateLastName() {
        Random rn = new Random();
        int num = rn.nextInt(1000) + 1;
        String name = "Last" + num;
        return name;
    }*/

    public String generateParentEmail() {
        Random rn = new Random();
        int num = rn.nextInt(1000) + 1;
        String ParentEmail = "hore" + num + "@yopmail.com";
        return ParentEmail;
    }

    public String generateTeacherEmail() {
        Random rn = new Random();
        int num = rn.nextInt(1000) + 1;
        String Email = "more" + num + "@yopmail.com";
        Log.info("TeacherEmail generated is <" + Email + ">");
        return Email;
    }

    public String generateZeut() {
        String number = createId();
        Log.info("Zeut generated is <" + number + ">");
        return number;
    }

    public String createMeetingDate() {

        Random rn = new Random();
        int day = rn.nextInt(27) + 1;
        int month = rn.nextInt(11) + 1;
        int year = rn.nextInt(3) + 2016;
        String meetingDate = day + "/" + month + "/" + year + " 08:00";
        System.out.println(meetingDate);
        Log.info("MeetingDate generated is <" + meetingDate + ">");
        return meetingDate;
    }

    public String generateBirthDate() {
        Random rn = new Random();
        int day = rn.nextInt(27) + 1;
        int month = rn.nextInt(11) + 1;
        int year = rn.nextInt(3) + 2010;
        return day + "/" + month + "/" + year;
    }

    //methods that fill test data
    public CreateNewPatientPage fillFirstNameField(String name) {
        Log.info("Filling First Name <" + name + ">");
        setElementText(inputName, name);
        return this;
    }


    public CreateNewPatientPage fillLastNamefield(String name) {
        Log.info("Filling Last Name <" + name + ">");
        setElementText(inputLastName, name);
        return this;
    }


    public CreateNewPatientPage fillZeutAutomatic() {
        String number = generateZeut();
        setElementText(inputZeut, number);
        return this;
    }

    public CreateNewPatientPage fillZeutfield(String zeut) {
        Log.info("Filling Teudat zeut <" + zeut + ">");
        setElementText(inputZeut, zeut);
        return this;
    }


    public CreateNewPatientPage fillBirthDayfield(String date) throws IOException, InterruptedException {
        waitUntilElementIsLoaded(inputBirthDay);
        Log.info("Filling BirthDate <" + date + ">");
        setElementText(inputBirthDay, date);
        labelUserName.click();
        return this;
    }

    public CreateNewPatientPage fillWeightfield(String weight) {
        Log.info("Filling weight <" + weight + ">");
        setElementText(inputWeight, weight);
        return this;
    }

    public CreateNewPatientPage filltEmailField(String email) {
        Log.info("Filling Email <" + email + ">");
        setElementText(inputEmail, email);
        return this;
    }

    public CreateNewPatientPage chooseWeightUnit(String weight) {
        Log.info("Choosing Weight Unit <" + weight + ">");
        selectValueInDropdownbyText(chooseWeightUnit, weight);
        return this;
    }

    public CreateNewPatientPage chooseDoctor(String doctor) {
        Log.info("Choosing Doctor  <" + doctor + ">");
        selectValueInDropdownbyText(chooseWeightUnit, doctor);
        return this;
    }

    public CreateNewPatientPage sendAdultEmail() throws IOException, InterruptedException {
        Log.info("Waiting for button Send Email");
        waitUntilElementIsLoaded(sendFirstEmailButton);
        Log.info("Clicking button Send Email <" + sendFirstEmailButton + ">");
        clickElement(sendFirstEmailButton);
        //waitUntilIsLoaded(driver.findElement(By.id("ctl00_MainContent_AddEditAccount1_RadGrid2_ctl00")));
        return this;
    }

    public CreateNewPatientPage selectTypeTeacher() throws IOException, InterruptedException {
        Log.info("Selecting teacher type");
        Log.info("Waiting for Select adult type dropdown");
        waitUntilElementIsLoaded(chooseAdultTypeButton);
        Log.info("Clicking on <" + chooseAdultTypeButton + ">");
        clickElement(chooseAdultTypeButton);
        Log.info("Clicking on <" + teacherAdultFromList + ">");
        clickElement(teacherAdultFromList);
        return this;
    }

    public CreateNewPatientPage addTeacher() throws IOException, InterruptedException {
        Log.info("Waiting for <" + addNewAdultButton + ">");
        waitUntilElementIsLoaded(addNewAdultButton);
        Log.info("Clicking on <" + addNewAdultButton + ">");
        clickElement(addNewAdultButton);
        return this;
    }

    public CreateNewPatientPage fillMeetingDateAndTime(String dateMiting) throws IOException, InterruptedException {
        waitUntilElementIsLoaded(inputMeetingDate);
        Log.info("Filling meeting date with <" + dateMiting + ">");
        setElementText(inputMeetingDate, dateMiting);
        labelUserName.click();
        return this;
    }


    public CreateNewPatientPage waitUntilPageIsLoaded() throws IOException, InterruptedException {
        waitUntilElementIsLoaded(buttonSaveAccount);
        return this;
    }

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
        Log.info("Clicking on Save button <" + buttonSaveAccount + ">");
        clickElement(buttonSaveAccount);
    }

    //check alerts

    public boolean alertFillDate() {
        return exists(fillingAlert);
    }

    public CreateNewPatientPage profileFilling(String email, String id) {
        driver.get("http://dhclinicappv2stg.item-soft.co.il/Login.aspx");
        driver.findElement(By.id("MainContent_LoginUser_Password")).clear();
        driver.findElement(By.id("MainContent_LoginUser_Password")).sendKeys("LinkCare!!11");
        driver.findElement(By.id("MainContent_LoginUser_UserName")).clear();
        driver.findElement(By.id("MainContent_LoginUser_UserName")).sendKeys(email);
        driver.findElement(By.id("MainContent_LoginUser_Password")).clear();
        driver.findElement(By.id("MainContent_LoginUser_Password")).sendKeys("LinkCare!1");
        driver.findElement(By.id("MainContent_LoginUser_LoginButton")).click();
        driver.findElement(By.id("MainContent_ChangeUserPassword_ChangePasswordContainerID_CurrentPassword")).clear();
        driver.findElement(By.id("MainContent_ChangeUserPassword_ChangePasswordContainerID_CurrentPassword")).sendKeys("LinkCare!1");
        driver.findElement(By.id("MainContent_ChangeUserPassword_ChangePasswordContainerID_NewPassword")).clear();
        driver.findElement(By.id("MainContent_ChangeUserPassword_ChangePasswordContainerID_NewPassword")).sendKeys("LinkCare!!11");
        driver.findElement(By.id("MainContent_ChangeUserPassword_ChangePasswordContainerID_ConfirmNewPassword")).clear();
        driver.findElement(By.id("MainContent_ChangeUserPassword_ChangePasswordContainerID_ConfirmNewPassword")).sendKeys("LinkCare!!11");
        driver.findElement(By.id("MainContent_ChangeUserPassword_ChangePasswordContainerID_ChangePasswordPushButton")).click();
        driver.findElement(By.name("fakeusernameremembered")).clear();
        driver.findElement(By.name("fakeusernameremembered")).sendKeys("3339Doctor");
        driver.findElement(By.name("fakepasswordremembered")).clear();
        driver.findElement(By.name("fakepasswordremembered")).sendKeys("LinkCare!!11");
        driver.findElement(By.xpath("//form[@id='Form1']/div[2]/div[2]/div/div/a")).click();
        driver.findElement(By.id("MainContent_firstNameTxt")).clear();
        driver.findElement(By.id("MainContent_firstNameTxt")).sendKeys("Parent");
        driver.findElement(By.id("MainContent_lastNameTxt")).clear();
        driver.findElement(By.id("MainContent_lastNameTxt")).sendKeys("This");
        driver.findElement(By.id("MainContent_PersonalIdTxt")).clear();
        driver.findElement(By.id("MainContent_PersonalIdTxt")).sendKeys(id);
        driver.findElement(By.id("ctl00_MainContent_ContactPhoneTxt")).clear();
        driver.findElement(By.id("ctl00_MainContent_ContactPhoneTxt")).sendKeys("(123)-4567890");
        driver.findElement(By.id("ctl00_MainContent_ContactPhoneTxt")).clear();
        driver.findElement(By.id("ctl00_MainContent_ContactPhoneTxt")).sendKeys("(123)-4567890");
        driver.findElement(By.id("MainContent_AddressTxt")).clear();
        driver.findElement(By.id("MainContent_AddressTxt")).sendKeys("Henkin");
        driver.findElement(By.id("MainContent_HouseNumberTxt")).clear();
        driver.findElement(By.id("MainContent_HouseNumberTxt")).sendKeys("3");
        driver.findElement(By.id("MainContent_CityTxt")).clear();
        driver.findElement(By.id("MainContent_CityTxt")).sendKeys("TelAviv");
        driver.findElement(By.id("MainContent_CreateUserButton")).click();
        return this;
    }


    // methods, that fills all fields except TZ and Emails

    public void createPatientOneParent(String TZ, String Email) throws IOException, InterruptedException {
        //  driver.switchTo().frame(frameNewPatient);
        waitUntilPageIsLoaded();
        fillFirstNameField("PatientChildFirst");
        fillLastNamefield("PatientChildLast");
        fillZeutfield(TZ);
        fillWeightfield("5");
        filltEmailField(Email);
        sendAdultEmail();
        fillBirthDayfield(generateBirthDate());
        fillMeetingDateAndTime(createMeetingDate());
        clickElement(inputBirthDay);
        clickElement(inputMeetingDate);
        clickElement(addNewAdultButton);
        Log.info("Clicking 'Save' button");
        clickSaveAccount();
    }


    public void createPatientParentAndTeacher(String TZ, String Email, String EmailTeacher) throws IOException, InterruptedException {
        //  driver.switchTo().frame(frameNewPatient);
        waitUntilPageIsLoaded();
        fillFirstNameField("PatientChildFirst");
        fillLastNamefield("PatientChildLast");
        fillZeutfield(TZ);
        fillWeightfield("2");
        filltEmailField(Email);
        sendAdultEmail();
        addTeacher();
        selectTypeTeacher();
        filltEmailField(EmailTeacher);
        sendAdultEmail();
        fillMeetingDateAndTime(createMeetingDate());
        fillBirthDayfield(generateBirthDate());
        clickElement(inputBirthDay);
        clickElement(inputMeetingDate);
        clickElement(addNewAdultButton);
        clickSaveAccount();
    }


    //Check
    public void waitUntilPopupClosed() throws IOException, InterruptedException {
        waitUntilElementIsDisappeared("popup");
    }

    public boolean isPopUpClosed() {
        return !exists(driver.findElement(By.id("popup")));
    }


    public CreateNewPatientPage WaitUntilPatientPageIsLoaded() {
        waitUntilIsLoaded(questMenu);
        return this;
    }

    public boolean isOnPatientPage() {
        return exists(questMenu);
    }
}