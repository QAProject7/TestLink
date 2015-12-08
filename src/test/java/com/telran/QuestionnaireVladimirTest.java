package com.telran;

import com.telran.pages.*;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.seleniumhq.jetty7.util.log.Log;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Random;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

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
    public LoginPage loginPage;
    public CreateNewPatientPage createNewPatientPage;
    public DoctorsPage doctorsPage;
    public RegistrationPage registrationPage;
    public CreateNewPatientPage createNewPatientpage;

    @BeforeClass(alwaysRun = true)
    public void setUp() throws InterruptedException, IOException {
        //driver = new FirefoxDriver();
        driver.manage().window().maximize();
        loginPage = PageFactory.initElements(driver, LoginPage.class);
        questionnaireFirstPage = PageFactory.initElements(driver, ChronicQuestionnaire1VladimirPage.class);
        createNewPatientPage = PageFactory.initElements(driver, CreateNewPatientPage.class);
        doctorsPage = PageFactory.initElements(driver, DoctorsPage.class);
        zeut = createNewPatientPage.generateZeut();
        email = createNewPatientPage.generateParentEmail();
        //createNewPatientPage.createPatientOneParent(zeut, email);
        username = email;

        loginPage
                .openLoginPage()
                .fillUsernameField(docName)
                .fillPasswordField(docPass)
                .clickOnTermsCheckbox()
                .clickOnLoginButton();

        doctorsPage.waitUntilMainPageIsLoaded();
        doctorsPage.clickOnAddPatient();
        System.out.println("zeut: " + zeut + ", mail: " + email + " and the doctor is: " + docName);
        //createNewPatientPage.createPatientOneParent(zeut, email);
        createNewPatient();
        questionnaireFirstPage.waitUntilElementIsDisappeared("popup");

        loginPage.clickLogOut();

        createNewPatientPage.profileFilling(email, createNewPatientPage.generateZeut());

        /*loginPage
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
        loginPage.clickLogOut();*/
    }

    /*@BeforeMethod(alwaysRun = true)
    public void beforeMethodSetUp() {
        loginPage
                .openLoginPage()
                .waitUntilRegPageIsLoaded()
                .fillUsernameField(email)
                .fillPasswordField(password)
                .clickOnTermsCheckbox()
                .clickOnLoginButton();
    }*/

    @Test(groups = {"positive", "smoke"})
    public void FillElements() {
        assertTrue(questionnaireFirstPage.isChronicIllnessAvailable());
        questionnaireFirstPage.clickTestButton();
        questionnaireFirstPage.waitUntilTestPageIsLoaded();
        questionnaireFirstPage.fillElements(zeut);

        loginPage.waitUntilRegPageIsLoaded()
                .fillUsernameField(email)
                .fillPasswordField(password)
                .clickOnTermsCheckbox()
                .clickOnLoginButton();
        assertFalse(questionnaireFirstPage.isChronicIllnessAvailable());

        loginPage.clickLogOut();
        loginPage.waitUntilRegPageIsLoaded()
                .fillUsernameField(doctorEmail)
                .fillPasswordField(doctorPassword)
                .clickOnTermsCheckbox()
                .clickOnLoginButton();
        loginPage.clickElement(driver.findElement(By.xpath("//tr[contains(text(),'GridItem')]//*[contains(text(),'" + zeut + "')]/..//a[@class='LinkBtnPatients GreenBtn']")));

        //questionnaireFirstPage.checkAnswers();

    }

    public String generateRandomString(int length) {
        String chars = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder buf = new StringBuilder();
        for (int i=0; i<length; i++) {
            buf.append(chars.charAt(rnd.nextInt(chars.length())));
        }
        return buf.toString();
    }
    public void createNewPatient() {
        try {
            Log.info("Create new patient started");
            // createNewPatientpage.createPatientOneParent(zeut, email);
            createNewPatientPage.waitUntilPageIsLoaded();
            createNewPatientPage.fillFirstNameField("PatientChildFirst")
                    .fillLastNamefield("PatientChildLast")
                    .fillZeutfield(zeut)
                    .fillWeightfield("2")
                    .filltEmailField(email)
                    .sendAdultEmail();
                    //.addTeacher()
                    //.filltEmailField(createNewPatientPage.emailTeacher)
                    //.sendAdultEmail();
            Thread.sleep(4000);
            createNewPatientPage.fillMeetingDateAndTime(createNewPatientPage.createMeetingDate())
                    .fillBirthDayfield(createNewPatientPage.generateBirthDate())
                    .clickSaveAccount();
            Thread.sleep(4000);
            // doctorsPage.waitUntilMainPageIsLoaded();
            //  doctorsPage.isPatientExists(zeut);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}