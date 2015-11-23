package com.telran;

import com.telran.pages.CreateNewPatientPage;
import com.telran.pages.DoctorsPage;
import com.telran.pages.LoginMaksimPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class CreateNewPatientTest extends TestNgTestBase {
    public static String username = "1298Doctor";
    public static String password = "LinkCare!!11";
    public static String zeut;
    public static String email;
    public static String emailTeacher;
    public static String birthDate = "21/10/2013";
    public static String meetingDate;
    private static Logger Log = Logger.getLogger(LogLog4j.class.getName());
    public LoginMaksimPage loginPage;
    public DoctorsPage doctorsPage;
    public CreateNewPatientPage createNewPatientpage;
    // private WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void setup() throws InterruptedException {
        // driver = new FirefoxDriver();
        //registrationPage = PageFactory.initElements(driver, RegistrationPage.class);
        //  mainPage = PageFactory.initElements(driver, DoctorMainPage.class);
        loginPage = PageFactory.initElements(driver, LoginMaksimPage.class);
        createNewPatientpage = PageFactory.initElements(driver, CreateNewPatientPage.class);
        doctorsPage = PageFactory.initElements(driver, DoctorsPage.class);
        zeut = createNewPatientpage.generateZeut();
        email = createNewPatientpage.generateParentEmail();
        emailTeacher = createNewPatientpage.generateTeacherEmail();
        meetingDate = createNewPatientpage.createMeetingDate();
        loginPage.
                openLoginPage(driver)
                .fillUsernameField(username)
                .fillPasswordField(password)
                .clickOnLoginButton();
        doctorsPage.waitUntilMainPageIsLoaded();
        driver.manage().window().maximize();
        doctorsPage.clickOnAddPatient();

    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethodSetUp() {

    }

    @Test(groups = {"positive"})
    public void createNewPatient() {
        try {
            Log.info("Create new patient started");
            createNewPatientpage.createPatientOneParent(zeut, email);
            createNewPatientpage.waitUntilPageIsLoaded();
            createNewPatientpage.fillFirstNameField("PatientChildFirst")
                    .fillLastNamefield("PatientChildLast")
                    .fillZeutfield(zeut)
                    .fillWeightfield("2")
                    .filltEmailField(email)
                    .sendFirstEmail()
                    .addTeacher()
                    .filltEmailField(emailTeacher)
                    .sendFirstEmail();
            Thread.sleep(4000);
            createNewPatientpage.fillMeetingDateAndTime(meetingDate)
                    .fillBirthDayfield(birthDate)
                    .clickSaveAccount();
            Thread.sleep(4000);
            doctorsPage.waitUntilMainPageIsLoaded();
            doctorsPage.isPatientExists(zeut);
            Reporter.log("new Patient added");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test(groups = {"positive"})
    public void createNewPatientWithParentAndTeacher() {
        try {
            createNewPatientpage.createPatientParentAndTeacher(zeut, email, emailTeacher);
            doctorsPage.waitUntilMainPageIsLoaded();
            doctorsPage.isPatientExists(zeut);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

  /* @AfterClass(alwaysRun = true)
    public void tearDown() {
        this.driver.quit();
    }*/
}