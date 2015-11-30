package com.telran;

import com.telran.pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Random;

import static org.testng.Assert.*;

/**
 * Created by Naryck, Maksim
 */
public class QuestionnaireVladimirTest extends TestNgTestBase {
    public static String email;// = "metupelet06@yopmail.com";
    public static String zeut;
    public static String password = "LinkCare!!11";
    public static String defaultPassword = "LinkCare!!11";
    public static String doctorEmail = "";
    public static String doctorPassword = "";
    public static String docName = "3339Doctor";
    public static String docPass = "LinkCare!!11";
    public static String username;
    static Random rnd = new Random();
    //public WebDriver driver;

    public ChronicQuestionnaire1VladimirPage questionnaireFirstPage;
    public LoginVladimirPage loginPage;
    public CreateNewPatientPage createNewPatientPage;
    public DoctorsPage doctorsPage;
    public RegistrationPage registrationPage;

    @BeforeClass(alwaysRun = true)
    public void setUp() throws InterruptedException, IOException {
        //driver = new FirefoxDriver();
        driver.manage().window().maximize();
        loginPage = PageFactory.initElements(driver, LoginVladimirPage.class);
        questionnaireFirstPage = PageFactory.initElements(driver, ChronicQuestionnaire1VladimirPage.class);
        createNewPatientPage = PageFactory.initElements(driver, CreateNewPatientPage.class);
        doctorsPage = PageFactory.initElements(driver, DoctorsPage.class);
        zeut = createNewPatientPage.generateZeut();
        email = createNewPatientPage.generateParentEmail();
        //createNewPatientPage.createPatientOneParent(zeut, email);
        username = email;

        loginPage
                .openLoginPage(driver)
                .fillUsernameField(docName)
                .fillPasswordField(docPass)
                .clickOnLoginButton();

        doctorsPage.waitUntilMainPageIsLoaded();
        doctorsPage.clickOnAddPatient();
        System.out.println("zeut: " + zeut + ", mail: " + email + " and the doctor is: " + docName);
        createNewPatientPage.createPatientOneParent(zeut, email);
        loginPage.clickLogOut();

        loginPage
                .openLoginPage(driver)
                .waitUntilRegPageIsLoaded()
                .fillUsernameField(username)
                .fillPasswordField(defaultPassword)
                .clickOnLoginButton();
        loginPage.clickOnCancelChangePassword();

        registrationPage
                .fillUsernameField(email)
                .fillFirstNameField("name" + generateRandomString(3))
                //.fillPasswordField(password)
                .fillEmailField(email)
                .fillLastNameField("last" + generateRandomString(4))
                .fillConfPasswordField(password)
                .fillIdField(zeut)
                .fillMobile("0531234567")
                .fillStreetField("street" + generateRandomString(3))
                .fillHouseField("123")
                .fillCityField("city" + generateRandomString(3))
                .clickOnSubmitButton();
        loginPage.clickLogOut();
    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethodSetUp() {
        loginPage
                .openLoginPage(driver)
                .waitUntilRegPageIsLoaded()
                .fillUsernameField(email)
                .fillPasswordField(password)
                .clickOnLoginButton();
    }

    @Test(groups = {"positive"})
    public void FillElements() {
        assertTrue(questionnaireFirstPage.isChronicIllnessAvailable());
        questionnaireFirstPage.clickTestButton();
        questionnaireFirstPage.waitUntilTestPageIsLoaded();
        questionnaireFirstPage.fillElements();

        loginPage.waitUntilRegPageIsLoaded()
                .fillUsernameField(email)
                .fillPasswordField(password)
                .clickOnLoginButton();
        assertFalse(questionnaireFirstPage.isChronicIllnessAvailable());

        loginPage.clickLogOut();
        loginPage.waitUntilRegPageIsLoaded()
                .fillUsernameField(doctorEmail)
                .fillPasswordField(doctorPassword)
                .clickOnLoginButton();
    }

    public String generateRandomString(int length) {
        String chars = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder buf = new StringBuilder();
        for (int i=0; i<length; i++) {
            buf.append(chars.charAt(rnd.nextInt(chars.length())));
        }
        return buf.toString();
    }

}