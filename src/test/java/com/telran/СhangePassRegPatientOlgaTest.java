package com.telran;


import com.telran.pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;


public class СhangePassRegPatientOlgaTest {
    public static String firstName = "Moshe";
    public static String lastName = "Levi";
    public static String email = "";
    public static String password = "LinkCare!1";
    public static String passwordResult = "LinkCare!!11";
    public static String personalId;
    public static String address = "Herzl";
    public static String city = "Ashdod";
    public static String houseNumber = "33";
    public static String date = "1990-11-05";
    public WebDriver driver;
    public CreateNewPatientTest createNewPatientPage1;
    public CreateNewPatientPage createNewPatientPage;
    public ChangePassRegistrationPatientOlgaPage changePassPage;
    private String emailTeacher;
    private String driverPath = "C:\\Telran\\browserDriver\\";
    private LoginPage loginPage;
    private DoctorsPage doctorsPage;
    private ChronicQuestionnaire3VladimirPage paitientPage;

    @BeforeClass(alwaysRun = true)
    public void setup() {
//        driver = new FirefoxDriver();
        System.setProperty("webdriver.chrome.driver", driverPath + "chromedriver.exe");
        driver = new ChromeDriver();

        paitientPage = PageFactory.initElements(driver, ChronicQuestionnaire3VladimirPage.class);
        loginPage = PageFactory.initElements(driver, LoginPage.class);
        doctorsPage = PageFactory.initElements(driver, DoctorsPage.class);
        changePassPage = PageFactory.initElements(driver, ChangePassRegistrationPatientOlgaPage.class);
        createNewPatientPage1 = PageFactory.initElements(driver, CreateNewPatientTest.class);
        createNewPatientPage = PageFactory.initElements(driver, CreateNewPatientPage.class);

    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethodSetUp() throws IOException, InterruptedException {
//            personalId = createNewPatientPage.createId();
//            email = createNewPatientPage.generateParentEmail();
//            emailTeacher = createNewPatientPage.generateTeacherEmail();
        loginPage.openLoginPage()
                .login("7070Doctor", "LinkCare!!11");
        doctorsPage.isOnMainPage();
//            driver.manage().window().maximize();
        doctorsPage.clickOnAddPatient();
        createNewPatientPage.createPatientOneParent(personalId, email);
        loginPage.clickLogOut();
        loginPage.openLoginPage()
                .fillUsernameField(email)
                .fillPasswordField(password)
                .clickOnLoginButton();
    }

    @Test (groups = {"positive","smoke"})
    public void loginFirstPatient() throws IOException, InterruptedException {
            changePassPage
                    .waitUntilPassChangePageLoaded()
                    .fillCurrentPassword(password)
                    .fillNewPassword(passwordResult)
                    .fillConfirmNewPassword(passwordResult)
                    .clickOnChangePassButton();
            changePassPage
                    .waitUntilGoToNextPageLoaded()
                    .clickOnGotoFillProfile();
            changePassPage
                    .waitUntilFillProfilePageIsLoaded()
                    .fillFirstNameTxt(firstName)
                    .fillLastNameTxt(lastName)
                    .fillDateBirthday(date)
                    .fillEmail(email)
                    .fillPersonalId(personalId)
                    .fillcontactPhone(personalId)
                    .fillAdress(address)
                    .fillHouseNumber(houseNumber)
                    .fillCity(city)
                    .clickOnSubmitButton();
        Assert.assertTrue(paitientPage.isAvailable(), "Patients page isn't opening");
            Reporter.log("Profile created successfully");
    }

    //    @Test (groups = {"negative","smoke"})
    public void negativeEmptyPass(){
            changePassPage.clickOnChangePassButton();
            Assert.assertTrue(changePassPage.isErrorEmptyPass(), "Not found alert: Empty Pass ");
    }

    //    @Test
    public void negativeEmptyPassNew(){
            changePassPage.clickOnChangePassButton();
            Assert.assertTrue(changePassPage.isErrorEmptyPassNew(), "Not found alert: Empty Pass New");
    }

    //    @Test
    public void negativeEmptyPassRepeat(){
            changePassPage.clickOnChangePassButton();
            Assert.assertTrue(changePassPage.isErrorEmptyPassRepeat(), "Not found alert: Empty Pass Repeat  ");
    }

    //    @Test (groups = {"negative","smoke"})
    public void negativePassNotSame(){
        try {
            changePassPage
                    .fillCurrentPassword(password)
                    .fillNewPassword("QWEqwe123")
                    .fillConfirmNewPassword("qwe")
                    .clickOnChangePassButton();
            Assert.assertTrue(changePassPage.isErrorPassNotSame(), "Not found alert: Pass Not Same  ");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //    @Test (groups = {"negative","smoke"})
    public void negativeNoIntermediatePage(){
            changePassPage
                    .fillCurrentPassword(password)
                    .fillNewPassword(passwordResult)
                    .fillConfirmNewPassword(passwordResult)
                    .clickOnChangePassButton();

            Assert.assertTrue(changePassPage.isNoIntermediatePage(), "Not found alert: No Intermediate Page");
    }

    //    @Test
    public void negativeEmptyFirstName() throws IOException, InterruptedException {
            changePassPage
                    .fillCurrentPassword(password)
                    .fillNewPassword(passwordResult)
                    .fillConfirmNewPassword(passwordResult)
                    .clickOnChangePassButton();
            changePassPage
                    .waitUntilGoToNextPageLoaded()
                    .clickOnGotoFillProfile();
            changePassPage
                    .waitUntilFillProfilePageIsLoaded()
                    .clickOnSubmitButton();

            Assert.assertTrue(changePassPage.isErEmptyFirstName(), "Not found alert: Empty First Name");
    }

    //    @Test
    public void negativeEmptyLastName() throws IOException, InterruptedException {
            changePassPage
                    .fillCurrentPassword(password)
                    .fillNewPassword(passwordResult)
                    .fillConfirmNewPassword(passwordResult)
                    .clickOnChangePassButton();
            changePassPage
                    .waitUntilGoToNextPageLoaded()
                    .clickOnGotoFillProfile();
            changePassPage
                    .waitUntilFillProfilePageIsLoaded()
                    .clickOnSubmitButton();
            Assert.assertTrue(changePassPage.isErEmptyLastName(), "Not found alert: Empty Last Name");
    }

    //    @Test (groups = {"negative","smoke"})
    public void negativeEmptyEmail() throws IOException, InterruptedException {
            changePassPage
                    .fillCurrentPassword(password)
                    .fillNewPassword(passwordResult)
                    .fillConfirmNewPassword(passwordResult)
                    .clickOnChangePassButton();
            changePassPage
                    .waitUntilGoToNextPageLoaded()
                    .clickOnGotoFillProfile();
            changePassPage
                    .waitUntilFillProfilePageIsLoaded()
                    .clickOnSubmitButton();

            Assert.assertTrue(changePassPage.isErEmptyEmail(), "Not found alert: Empty Last Email");
    }

    //    @Test (groups = {"negative","smoke"})
    public void negativeEmailInvalid() throws IOException, InterruptedException {
            changePassPage
                    .fillCurrentPassword(password)
                    .fillNewPassword(passwordResult)
                    .fillConfirmNewPassword(passwordResult)
                    .clickOnChangePassButton();
            changePassPage
                    .waitUntilGoToNextPageLoaded()
                    .clickOnGotoFillProfile();
            changePassPage
                    .waitUntilFillProfilePageIsLoaded()
                    .fillEmail("sdsdsdfsdf")
                    .clickOnSubmitButton();

            Assert.assertTrue(changePassPage.isErInvalidEmail(), "Not found alert: Empty Invalid Email");
    }

    //    @Test (groups = {"negative","smoke"})
    public void negativeEmptyTZ() throws IOException, InterruptedException {
            changePassPage
                    .fillCurrentPassword(password)
                    .fillNewPassword(passwordResult)
                    .fillConfirmNewPassword(passwordResult)
                    .clickOnChangePassButton();
            changePassPage
                    .waitUntilGoToNextPageLoaded()
                    .clickOnGotoFillProfile();
            changePassPage
                    .waitUntilFillProfilePageIsLoaded()
                    .clickOnSubmitButton();

            Assert.assertTrue(changePassPage.isErEmptyTZ(), "Not found alert: Empty TZ");
    }

    //    @Test
    public void negativeTZInvalid() throws IOException, InterruptedException {
            changePassPage
                    .fillCurrentPassword(password)
                    .fillNewPassword(passwordResult)
                    .fillConfirmNewPassword(passwordResult)
                    .clickOnChangePassButton();
            changePassPage
                    .waitUntilGoToNextPageLoaded()
                    .clickOnGotoFillProfile();
            changePassPage
                    .waitUntilFillProfilePageIsLoaded()
                    .fillEmail("sdsdsdfsdf")
                    .clickOnSubmitButton();

            Assert.assertTrue(changePassPage.isErTZInvalid(), "Not found alert: Empty TZ Invalid");
    }

    //    @Test
    public void negativeEmptyTelephone() throws IOException, InterruptedException {
            changePassPage
                    .fillCurrentPassword(password)
                    .fillNewPassword(passwordResult)
                    .fillConfirmNewPassword(passwordResult)
                    .clickOnChangePassButton();
            changePassPage
                    .waitUntilGoToNextPageLoaded()
                    .clickOnGotoFillProfile();
            changePassPage
                    .waitUntilFillProfilePageIsLoaded()
                    .clickOnSubmitButton();

            Assert.assertTrue(changePassPage.isErEmptyTelephone(), "Not found alert: Empty Telephone");
    }

    //    @Test
    public void negativeEmptyHomeNumber() throws IOException, InterruptedException {
            changePassPage
                    .fillCurrentPassword(password)
                    .fillNewPassword(passwordResult)
                    .fillConfirmNewPassword(passwordResult)
                    .clickOnChangePassButton();
            changePassPage
                    .waitUntilGoToNextPageLoaded()
                    .clickOnGotoFillProfile();
            changePassPage
                    .waitUntilFillProfilePageIsLoaded()
                    .clickOnSubmitButton();
            Assert.assertTrue(changePassPage.isErEmptyHomeNumber(), "Not found alert: Empty Home Number");
    }

    //    @Test
    public void negativeEmptyHomeStreet() throws IOException, InterruptedException {
            changePassPage
                    .fillCurrentPassword(password)
                    .fillNewPassword(passwordResult)
                    .fillConfirmNewPassword(passwordResult)
                    .clickOnChangePassButton();
            changePassPage
                    .waitUntilGoToNextPageLoaded()
                    .clickOnGotoFillProfile();
            changePassPage
                    .waitUntilFillProfilePageIsLoaded()
                    .clickOnSubmitButton();
            Assert.assertTrue(changePassPage.isErEmptyStreet(), "Not found alert: Empty Street");
    }

    //    @Test
    public void negativeEmptyTown() throws IOException, InterruptedException {
            changePassPage
                    .fillCurrentPassword(password)
                    .fillNewPassword(passwordResult)
                    .fillConfirmNewPassword(passwordResult)
                    .clickOnChangePassButton();
            changePassPage
                    .waitUntilGoToNextPageLoaded()
                    .clickOnGotoFillProfile();
            changePassPage
                    .waitUntilFillProfilePageIsLoaded()
                    .clickOnSubmitButton();
            Assert.assertTrue(changePassPage.isErEmptyTown(), "Not found alert: Empty Town");
    }

    @AfterClass(alwaysRun = true)
    public void tearDown(){
        this.driver.quit();
    }
}
