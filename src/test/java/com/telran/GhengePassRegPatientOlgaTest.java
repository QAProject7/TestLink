package com.telran;


import com.telran.pages.ChangePassRegistrationPatientOlgaPage;
import com.telran.pages.CreateNewPatientPage;
import com.telran.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class GhengePassRegPatientOlgaTest {
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

    public CreateNewPatientPage patient;
    public ChangePassRegistrationPatientOlgaPage loginPatient;
    private LoginPage loginPage;
    private String emailTeacher;

    @BeforeClass(alwaysRun = true)
    public void setup() {
        driver = new FirefoxDriver();
        loginPage = PageFactory.initElements(driver,LoginPage.class);
        loginPatient = PageFactory.initElements(driver, ChangePassRegistrationPatientOlgaPage.class);
        patient = PageFactory.initElements(driver, CreateNewPatientPage.class);

    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethodSetUp() {
        try {
            personalId = patient.createId();
            email = patient.generateParentEmail();
            emailTeacher = patient.generateTeacherEmail();
             patient.createPatientParentAndTeacher(personalId, email, emailTeacher);
             loginPage.openLoginPage(driver)
                     .fillUsernameField(email)
                     .fillPasswordField(password)
                     .clickOnLoginButton();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void loginFirstPatient() {
        try {
            loginPatient
                    .fillCurrentPassword(password)
                    .fillNewPassword(passwordResult)
                    .fillConfirmNewPassword(passwordResult)
                    .clickOnChangePassButton();
            loginPatient
                    .waitUntilGoToNextPageLoaded()
                    .clickOnGotoFillProfile();
            loginPatient
                    .waitUntilFillProfilePageIsLoaded()
                    .fillFirstNameTxt(firstName)
                    .fillLastNameTxt(lastName)
                    .fillDateBirthday(date)
                    .fillPersonalId(personalId)
                    .fillcontactPhone(personalId)
                    .fillAdress(address)
                    .fillHouseNumber(houseNumber)
                    .fillCity(city)
                    .clickOnSubmitButton();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    @Test
    public void negativeEmptyPass(){
        try {
            loginPatient.clickOnChangePassButton();

            Assert.assertTrue(loginPatient.isErrorEmptyPass(),"Not found alert: Empty Pass ");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void negativeEmptyPassNew(){
        try {
            loginPatient.clickOnChangePassButton();
            Assert.assertTrue(loginPatient.isErrorEmptyPassNew(),"Not found alert: Empty Pass New");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void negativeEmptyPassRepeat(){
        try {
            loginPatient.clickOnChangePassButton();
            Assert.assertTrue(loginPatient.isErrorEmptyPassRepeat(),"Not found alert: Empty Pass Repeat  ");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void negativePassNotSame(){
        try {
            loginPatient
                    .fillCurrentPassword(password)
                    .fillNewPassword("QWEqwe123")
                    .fillConfirmNewPassword("qwe")
                    .clickOnChangePassButton();
            Assert.assertTrue(loginPatient.isErrorPassNotSame(),"Not found alert: Pass Not Same  ");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void negativeNoIntermediatePage(){
        try {
            loginPatient
                    .fillCurrentPassword(password)
                    .fillNewPassword(passwordResult)
                    .fillConfirmNewPassword(passwordResult)
                    .clickOnChangePassButton();

            Assert.assertTrue(loginPatient.isNoIntermediatePage(),"Not found alert: No Intermediate Page");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void negativeEmptyFirstName(){
        try {
            loginPatient
                    .fillCurrentPassword(password)
                    .fillNewPassword(passwordResult)
                    .fillConfirmNewPassword(passwordResult)
                    .clickOnChangePassButton();
            loginPatient
                    .waitUntilGoToNextPageLoaded()
                    .clickOnGotoFillProfile();
            loginPatient
                    .waitUntilFillProfilePageIsLoaded()
                    .clickOnSubmitButton();

            Assert.assertTrue(loginPatient.isErEmptyFirstName(),"Not found alert: Empty First Name");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void negativeEmptyLastName(){
        try {
            loginPatient
                    .fillCurrentPassword(password)
                    .fillNewPassword(passwordResult)
                    .fillConfirmNewPassword(passwordResult)
                    .clickOnChangePassButton();
            loginPatient
                    .waitUntilGoToNextPageLoaded()
                    .clickOnGotoFillProfile();
            loginPatient
                    .waitUntilFillProfilePageIsLoaded()
                    .clickOnSubmitButton();

            Assert.assertTrue(loginPatient.isErEmptyLastName(),"Not found alert: Empty Last Name");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void negativeEmptyEmail(){
        try {
            loginPatient
                    .fillCurrentPassword(password)
                    .fillNewPassword(passwordResult)
                    .fillConfirmNewPassword(passwordResult)
                    .clickOnChangePassButton();
            loginPatient
                    .waitUntilGoToNextPageLoaded()
                    .clickOnGotoFillProfile();
            loginPatient
                    .waitUntilFillProfilePageIsLoaded()
                    .clickOnSubmitButton();

            Assert.assertTrue(loginPatient.isErEmptyEmail(),"Not found alert: Empty Last Email");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void negativeEmailInvalid(){
        try {
            loginPatient
                    .fillCurrentPassword(password)
                    .fillNewPassword(passwordResult)
                    .fillConfirmNewPassword(passwordResult)
                    .clickOnChangePassButton();
            loginPatient
                    .waitUntilGoToNextPageLoaded()
                    .clickOnGotoFillProfile();
            loginPatient
                    .waitUntilFillProfilePageIsLoaded()
                    .fillEmail("sdsdsdfsdf")
                    .clickOnSubmitButton();

            Assert.assertTrue(loginPatient.isErEmailInvalid(),"Not found alert: Empty Invalid Email");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void negativeEmptyTZ(){
        try {
            loginPatient
                    .fillCurrentPassword(password)
                    .fillNewPassword(passwordResult)
                    .fillConfirmNewPassword(passwordResult)
                    .clickOnChangePassButton();
            loginPatient
                    .waitUntilGoToNextPageLoaded()
                    .clickOnGotoFillProfile();
            loginPatient
                    .waitUntilFillProfilePageIsLoaded()
                    .clickOnSubmitButton();

            Assert.assertTrue(loginPatient.isErEmptyTZ(),"Not found alert: Empty TZ");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void negativeTZInvalid(){
        try {
            loginPatient
                    .fillCurrentPassword(password)
                    .fillNewPassword(passwordResult)
                    .fillConfirmNewPassword(passwordResult)
                    .clickOnChangePassButton();
            loginPatient
                    .waitUntilGoToNextPageLoaded()
                    .clickOnGotoFillProfile();
            loginPatient
                    .waitUntilFillProfilePageIsLoaded()
                    .fillEmail("sdsdsdfsdf")
                    .clickOnSubmitButton();

            Assert.assertTrue(loginPatient.isErTZInvalid(),"Not found alert: Empty TZ Invalid");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void negativeEmptyTelephone(){
        try {
            loginPatient
                    .fillCurrentPassword(password)
                    .fillNewPassword(passwordResult)
                    .fillConfirmNewPassword(passwordResult)
                    .clickOnChangePassButton();
            loginPatient
                    .waitUntilGoToNextPageLoaded()
                    .clickOnGotoFillProfile();
            loginPatient
                    .waitUntilFillProfilePageIsLoaded()
                    .clickOnSubmitButton();

            Assert.assertTrue(loginPatient.isErEmptyTelephone(),"Not found alert: Empty Telephone");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void negativeEmptyHomeNumber(){
        try {
            loginPatient
                    .fillCurrentPassword(password)
                    .fillNewPassword(passwordResult)
                    .fillConfirmNewPassword(passwordResult)
                    .clickOnChangePassButton();
            loginPatient
                    .waitUntilGoToNextPageLoaded()
                    .clickOnGotoFillProfile();
            loginPatient
                    .waitUntilFillProfilePageIsLoaded()
                    .clickOnSubmitButton();

            Assert.assertTrue(loginPatient.isErEmptyHomeNumber(),"Not found alert: Empty Home Number");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void negativeEmptyHomeStreet(){
        try {
            loginPatient
                    .fillCurrentPassword(password)
                    .fillNewPassword(passwordResult)
                    .fillConfirmNewPassword(passwordResult)
                    .clickOnChangePassButton();
            loginPatient
                    .waitUntilGoToNextPageLoaded()
                    .clickOnGotoFillProfile();
            loginPatient
                    .waitUntilFillProfilePageIsLoaded()
                    .clickOnSubmitButton();

            Assert.assertTrue(loginPatient.isErEmptyStreet(),"Not found alert: Empty Street");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void negativeEmptyTown(){
        try {
            loginPatient
                    .fillCurrentPassword(password)
                    .fillNewPassword(passwordResult)
                    .fillConfirmNewPassword(passwordResult)
                    .clickOnChangePassButton();
            loginPatient
                    .waitUntilGoToNextPageLoaded()
                    .clickOnGotoFillProfile();
            loginPatient
                    .waitUntilFillProfilePageIsLoaded()
                    .clickOnSubmitButton();

            Assert.assertTrue(loginPatient.isErEmptyTown(),"Not found alert: Empty Town");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
