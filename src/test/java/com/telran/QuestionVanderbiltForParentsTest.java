package com.telran;

import com.telran.MobileWebPages.LoginMobilePage;
import com.telran.MobileWebPages.QuestionVanderbiltForParentsPetruninPage;
import com.telran.pages.CreateNewPatientPage;
import com.telran.pages.DoctorsPage;
import com.telran.pages.LoginPage;
import com.telran.pages.RegistrationPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;


/**
 * Created by PetruninLeonid
 */
public class QuestionVanderbiltForParentsTest extends TestNgTestBase{ //ГОТОВ. ИСПРАВЕН (15.12.15)
    public static String email;
    public static String zeut;
    public static String password = "LinkCare!!11";
    public static String docName;
    public static String docPass = "LinkCare!!11";
    public static String username;
    public static String emailTeacher;
    public static String meetingDate;
    public static String birthDate = "21/10/2013";
    private static Logger Log = Logger.getLogger(LogLog4j.class.getName());
    public QuestionVanderbiltForParentsPetruninPage questionVanderbiltForParentsPetrunin; //Ссылка на вход на страницу (берет из класса LoginMaksimPage)
    public LoginPage loginPage;
    public LoginMobilePage loginMobilePage;
    public DoctorsPage doctorsPage;
    public CreateNewPatientPage createNewPatientPage;
    public RegistrationPage registrationPage;
    public CreateNewPatientTest createNewPatientTest;


    @BeforeClass(alwaysRun = true)
    public void setup() throws InterruptedException, IOException {
       // driver.manage().window().maximize();
        loginPage = PageFactory.initElements(driver, LoginPage.class);
        createNewPatientPage = PageFactory.initElements(driver, CreateNewPatientPage.class);
        doctorsPage = PageFactory.initElements(driver, DoctorsPage.class);
        registrationPage=PageFactory.initElements(driver, RegistrationPage.class);
        loginMobilePage = PageFactory.initElements(driver, LoginMobilePage.class); //Обращаемся к классу LoginMobilePage и берем оттуда ссылку на страницу
        questionVanderbiltForParentsPetrunin = PageFactory.initElements(driver, QuestionVanderbiltForParentsPetruninPage.class);
        createNewPatientPage = PageFactory.initElements(driver, CreateNewPatientPage.class);
        createNewPatientTest = PageFactory.initElements(driver, CreateNewPatientTest.class);

        Log.info("QuestionVanderbiltForParentsTest started.....");
        zeut = createNewPatientPage.generateZeut();
        email = createNewPatientPage.generateParentEmail();
        username = email;
        docName=registrationPage.generateDoctorUsername();
        emailTeacher = createNewPatientPage.generateTeacherEmail();
        meetingDate = createNewPatientPage.createMeetingDate();


        registrationPage.openRegistrationPage(driver);
        registrationPage.registerDoctor(docName, registrationPage.generateZeut());
        Thread.sleep(3000);
       // registrationPage.clickAddPatientButton();
        doctorsPage.isOnMainPage();
    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethodSetUp() throws InterruptedException, IOException {
        doctorsPage.clickOnAddPatient();
        System.out.println("zeut: " + zeut + ", mail: " + email + " and the doctor is: " + docName);
        Thread.sleep(5000);
       // driver.switchTo().frame(1);
        createNewPatientPage.fillFirstNameField("PatientChildFirst")
                .fillLastNamefield("PatientChildLast")
                .fillZeutfield(zeut)
                .fillWeightfield("2")
                .filltEmailField(email)
                .sendAdultEmail()
                .addTeacher()
                .filltEmailField(emailTeacher)
                .sendAdultEmail();
        Thread.sleep(4000);
        createNewPatientPage.fillMeetingDateAndTime(meetingDate)
                .fillBirthDayfield(birthDate)
                .clickSaveAccount();
        Thread.sleep(5000);
        doctorsPage.isOnMainPage();
        doctorsPage.isPatientExists(zeut);
       // Reporter.log("new Patient added");
        loginPage.clickLogOut();
        Log.info("Exit from web page");
        Thread.sleep(8000);
        createNewPatientPage.profileFilling(email, zeut);
        Log.info("Password was changed");
        loginPage.waitUntinLogOutButtomIsLoaded();
       // Thread.sleep(5000);
        loginPage.clickLogOut();
        Log.info("Exit from loginPage");
        Log.info("TestButton was pushed");

       //Thread.sleep(5000);
        System.out.println("driver: " + driver);
        driver.get("http://dhclinicamobileppstg.item-soft.co.il/index.htm");
        loginMobilePage.waitUntilLoginPageIsLoaded();
        Thread.sleep(10000);
        loginMobilePage
                .fillUsernameField(username)
                .fillPasswordField(password)
                .checkAgreeChebox();

        loginMobilePage.clickOnLoginButton();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
        }
        questionVanderbiltForParentsPetrunin.clickSubmitButton();
    }

    @Test(groups = {"positive", "smoke"})
    public void testOpenPatientPage() throws InterruptedException {
            Thread.sleep(3000);
        questionVanderbiltForParentsPetrunin.checkNextImgButton();
            Thread.sleep(5000);
        questionVanderbiltForParentsPetrunin.fillElements();
        Thread.sleep(3000);
        Log.info("All input elements is clicked");
            Thread.sleep(3000);
       questionVanderbiltForParentsPetrunin.checkLeftBtnHeader();
        Log.info("Access buttom was pushed. Test is finished!");
    }

    public void createNewPatient() { //Not in work
        try {
            Log.info("Create new patient started");
            Thread.sleep(5000);

            createNewPatientPage.fillFirstNameField("PatientChildFirst")
                    .fillLastNamefield("PatientChildLast")
                    .fillZeutfield(zeut)
                    .fillWeightfield("2")
                    .filltEmailField(email)
                    .sendAdultEmail();

            Thread.sleep(4000);
            createNewPatientPage.fillMeetingDateAndTime(createNewPatientPage.createMeetingDate())
                    .fillBirthDayfield(createNewPatientPage.generateBirthDate())
                    .clickSaveAccount();
            Thread.sleep(4000);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void createNewPatientTest() { //Not in work
        try {
            Log.info("Create new patient started");
            // createNewPatientpage.createPatientOneParent(zeut, email);
            createNewPatientPage.waitUntilPageIsLoaded();
            createNewPatientPage.fillFirstNameField("PatientChildFirst")
                    .fillLastNamefield("PatientChildLast")
                    .fillZeutfield(zeut)
                    .fillWeightfield("2")
                    .filltEmailField(email)
                    .sendAdultEmail()
                    .addTeacher()
                    .filltEmailField(emailTeacher)
                    .sendAdultEmail();
            Thread.sleep(4000);
            createNewPatientPage.fillMeetingDateAndTime(meetingDate)
                    .fillBirthDayfield(birthDate)
                    .clickSaveAccount();
            Thread.sleep(4000);
            // doctorsPage.isOnMainPage();
            //  doctorsPage.isPatientExists(zeut);
            Reporter.log("new Patient added");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
  /*  @AfterClass(alwaysRun = true)
    public void tearDown() {
        this.driver.quit();
    }*/
}


