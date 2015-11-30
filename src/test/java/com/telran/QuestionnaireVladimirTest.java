package com.telran;

import com.telran.pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.*;

/**
 * Created by Naryck, Maksim
 */
public class QuestionnaireVladimirTest extends TestNgTestBase {
    public static String email;// = "metupelet06@yopmail.com";
    public static String zeut;
    public static String password = "LinkCare!!11";
    public static String doctorEmail = "";
    public static String doctorPassword = "";
    public static String docName = "3339Doctor";
    public static String docPass = "LinkCare!!11";
    public static String username;


    public static String firstName = "Scarlettt";
    public static String lastName = "Johanssson";


    public WebDriver driver;

    public ChronicQuestionnaire1VladimirPage questionnaireFirstPage;
    public LoginVladimirPage loginPage;
    public CreateNewPatientPage createNewPatientPage;
    public DoctorsPage doctorsPage;
    public RegistrationPage registrationPage;



    /*private String street = "Rehov";
    private String housenumber = "123";
    private String telephone = "0531234567";
    private String city = "Jerusalem";*/

    @BeforeClass(alwaysRun = true)
    public void setUp() throws InterruptedException, IOException {
        driver = new FirefoxDriver();
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

        /*loginPage
                .openLoginPage(driver)
                .waitUntilRegPageIsLoaded()
                .fillUsernameField(username)
                .fillPasswordField(password)
                .clickOnLoginButton();
        loginPage.clickOnCancelChangePassword();

        registrationPage
                .fillUsernameField(firstName)
                .fillFirstNameField(firstName)
                //.fillPasswordField(password)
                .fillEmailField(email)
                .fillLastNameField(lastName)
                .fillConfPasswordField(password)
                .fillIdField(zeut)
                .fillMobile(telephone)
                .fillStreetField(street)
                .fillHouseField(housenumber)
                .fillCityField(city)
                .clickOnSubmitButton();
        loginPage.clickLogOut();*/
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

}