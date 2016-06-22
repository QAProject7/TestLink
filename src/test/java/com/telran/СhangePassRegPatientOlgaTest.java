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
    private String emailTeacher;

    public WebDriver driver;
    private String driverPath = "C:\\Telran\\browserDriver\\";

    public CreateNewPatientTest createNewPatientPage1;
    public CreateNewPatientPage createNewPatientPage;
    public ChangePassRegistrationPatientOlgaPage changePassPage;

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
    public void beforeMethodSetUp() {
        try {
            personalId = createNewPatientPage.createId();
            email = createNewPatientPage.generateParentEmail();
            emailTeacher = createNewPatientPage.generateTeacherEmail();
            loginPage.openLoginPage()
                     .login("2907Doctor","LinkCare!!11");
            doctorsPage.waitUntilMainPageIsLoaded();
            driver.manage().window().maximize();
            doctorsPage.clickOnAddPatient();
            createNewPatientPage.createPatientOneParent(personalId, email);
            loginPage.clickLogOut();
            loginPage.openLoginPage()
                    .fillUsernameField(email)
                     .fillPasswordField(password)
                     .clickOnTermsCheckbox()
                     .clickOnLoginButton();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test (groups = {"positive","smoke"})
    public void loginFirstPatient() {
        try {
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
            Assert.assertTrue(paitientPage.isAvailable(),"Patients page isn't opening");
            Reporter.log("Profile created successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    @Test (groups = {"negative","smoke"})
    public void negativeEmptyPass(){
        try {
            changePassPage.clickOnChangePassButton();

            Assert.assertTrue(changePassPage.isErrorEmptyPass(), "Not found alert: Empty Pass ");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void negativeEmptyPassNew(){
        try {
            changePassPage.clickOnChangePassButton();
            Assert.assertTrue(changePassPage.isErrorEmptyPassNew(), "Not found alert: Empty Pass New");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void negativeEmptyPassRepeat(){
        try {
            changePassPage.clickOnChangePassButton();
            Assert.assertTrue(changePassPage.isErrorEmptyPassRepeat(), "Not found alert: Empty Pass Repeat  ");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test (groups = {"negative","smoke"})
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
    @Test (groups = {"negative","smoke"})
    public void negativeNoIntermediatePage(){
        try {
            changePassPage
                    .fillCurrentPassword(password)
                    .fillNewPassword(passwordResult)
                    .fillConfirmNewPassword(passwordResult)
                    .clickOnChangePassButton();

            Assert.assertTrue(changePassPage.isNoIntermediatePage(), "Not found alert: No Intermediate Page");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void negativeEmptyFirstName(){
        try {
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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void negativeEmptyLastName(){
        try {
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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test (groups = {"negative","smoke"})
    public void negativeEmptyEmail(){
        try {
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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test (groups = {"negative","smoke"})
    public void negativeEmailInvalid(){
        try {
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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test (groups = {"negative","smoke"})
    public void negativeEmptyTZ(){
        try {
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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void negativeTZInvalid(){
        try {
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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void negativeEmptyTelephone(){
        try {
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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void negativeEmptyHomeNumber(){
        try {
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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void negativeEmptyHomeStreet(){
        try {
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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void negativeEmptyTown(){
        try {
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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @AfterClass(alwaysRun = true)
    public void tearDown(){
        this.driver.quit();
    }


}
