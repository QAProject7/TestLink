package com.telran;

import com.telran.pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.assertTrue;

/**
 * Created by Naryck, Maksim
 */
public class QuestionnaireVladimirTest {
    public static String username;
    public static String password = "LinkCare!1";
    public static String firstName = "Scarlettt";
    public static String lastName = "Johanssson";
    public static String docName = "493Doctor";
    public static String docPass = "LinkCare!!11";

    public WebDriver driver;

    public ChronicQuestionnaire1VladimirPage questionnaireFirstPage;
    public LoginVladimirPage loginPage;
    public CreateNewPatientPage createNewPatientPage;
    public DoctorsPage doctorsPage;
    public RegistrationPage registrationPage;

    private String zeut;
    private String email;
    private String street = "Rehov";
    private String housenumber = "123";
    private String telephone = "0531234567";
    private String city = "Jerusalem";

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
        username = email;

        loginPage
                .openLoginPage(driver)
                .fillUsernameField(docName)
                .fillPasswordField(docPass)
                .clickOnLoginButton();
        doctorsPage.waitUntilMainPageIsLoaded();
        doctorsPage.clickOnAddPatient();
        createNewPatientPage.createPatientOneParent(zeut, email);
        System.out.println("zeut: " + zeut + ", mail: " + email + " and the doctor is: " + docName);
        loginPage.clickLogOut();

        loginPage
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
        loginPage.clickLogOut();
    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethodSetUp() {
        loginPage
                .openLoginPage(driver)
                .waitUntilRegPageIsLoaded()
                .fillUsernameField(username)
                .fillPasswordField(password)
                .clickOnLoginButton();
    }

    @Test(groups = {"positive"})
    public void FillElements() {
        assertTrue(questionnaireFirstPage.isChronicIllnessAvailable());
        questionnaireFirstPage.clickTestButton();
        questionnaireFirstPage.waitUntilTestPageIsLoaded();
        questionnaireFirstPage.fillElements();
    }

}