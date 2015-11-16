package com.telran;


import com.telran.pages.ChangePassRegistrationPatientOlga;
import com.telran.pages.CreateNewPatient;
import com.telran.pages.LoginPage;
import com.telran.pages.RegistrationPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class GhengePassRegPatientOlgaTest {
    public static String firstName = "Moshe";
    public static String lastName = "Levi";
    public static String email = "mosheLevi@yopmail.com";
    public static String password = "LinkCare!!1";
    public static String personalId = "049919889";
    public static String address = "Herzl";
    public static String city = "Ashdod";
    public static String houseNumber = "33";
    public static String date = "1990-11-05";

    public WebDriver driver;

    public CreateNewPatient patient;
    public ChangePassRegistrationPatientOlga loginPatient;
    private LoginPage loginPage;

    @BeforeClass(alwaysRun = true)
    public void setup() {
        driver = new FirefoxDriver();
        loginPage = PageFactory.initElements(driver,LoginPage.class);
        loginPatient = PageFactory.initElements(driver, ChangePassRegistrationPatientOlga.class);
        patient = PageFactory.initElements(driver, CreateNewPatient.class);
    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethodSetUp() {
        try {
//            patient.
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
                    .fillNewPassword(password+'1')
                    .fillConfirmNewPassword(password+'1')
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




}
