package com.telran;

import com.telran.MobileWebPages.LoginMobilePage;
import com.telran.MobileWebPages.QuestionVanderbiltForParentsPetruninPage;
import com.telran.pages.ChronicQuestionnaire1VladimirPage;
import com.telran.pages.CreateNewPatientPage;
import com.telran.pages.DoctorsPage;
import com.telran.pages.LoginPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.seleniumhq.jetty7.util.log.Log;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Random;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

/**
 * Created by PetruninLeonid
 */
public class QuestionVanderbiltForParentsPetruninTest extends TestNgTestBase{ //ДОБАВИТЬ СОЗДАНИЕ НОВОГО ПАЦИЕНТА
    private static Logger Log = Logger.getLogger(LogLog4j.class.getName());

    public static String email;
    public static String zeut;
    public static String password = "LinkCare!!11";
    public static String doctorPassword = "";
    public static String docName = "1003Doctor";
    public static String docPass = "LinkCare!!11";
    public static String username;
    static Random rnd = new Random();

    public QuestionVanderbiltForParentsPetruninPage questionVanderbiltForParentsPetrunin; //Ссылка на вход на страницу (берет из класса LoginMaksimPage)
    public ChronicQuestionnaire1VladimirPage questionnaireFirstPage;
    public LoginPage loginPage;
    public LoginMobilePage loginMobilePage;
    public DoctorsPage doctorsPage;
    public CreateNewPatientPage createNewPatientPage;
   // private WebDriver driver;


    @BeforeClass(alwaysRun = true)
    public void setup() throws InterruptedException, IOException {
        //driver = new FirefoxDriver(); //Запускаем Firefox
        driver.manage().window().maximize();
        loginPage = PageFactory.initElements(driver, LoginPage.class);
        createNewPatientPage = PageFactory.initElements(driver, CreateNewPatientPage.class);
        doctorsPage = PageFactory.initElements(driver, DoctorsPage.class);
        zeut = createNewPatientPage.generateZeut();
        email = createNewPatientPage.generateParentEmail();
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
        //questionnaireFirstPage.waitUntilElementIsDisappeared("popup");
        loginPage.clickLogOut();
        createNewPatientPage.profileFilling(email, createNewPatientPage.generateZeut());
      // assertTrue(questionnaireFirstPage.isChronicIllnessAvailable());
        Log.info("Password was changed");
        loginPage.clickLogOut();
        Log.info("Exit from loginPage");
       // questionnaireFirstPage.clickTestButton();
        Log.info("TestButton was pushed");
        /*questionnaireFirstPage.waitUntilTestPageIsLoaded();
        questionnaireFirstPage.fillElements(zeut);
*/
       /* loginPage.waitUntilRegPageIsLoaded()
                .fillUsernameField(email)
                .fillPasswordField(password)
                .clickOnTermsCheckbox()
                .clickOnLoginButton();
        assertFalse(questionnaireFirstPage.isChronicIllnessAvailable());

        loginPage.clickLogOut();*/

        loginMobilePage = PageFactory.initElements(driver, LoginMobilePage.class); //Обращаемся к классу LoginMobilePage и берем оттуда ссылку на страницу
        questionVanderbiltForParentsPetrunin = PageFactory.initElements(driver, QuestionVanderbiltForParentsPetruninPage.class);
        createNewPatientPage = PageFactory.initElements(driver, CreateNewPatientPage.class);


    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethodSetUp() throws InterruptedException { //Входим на страницу и ждем пока она загрузится
        //loginMobilePage.openLoginPage(driver); //Логи к данному методу добавлены на странице LoginMobilePage
       Thread.sleep(50000);
        System.out.println("driver: " + driver);
        driver.get("http://dhclinicamobileppstg.item-soft.co.il/index.htm");
        Thread.sleep(50000);
        loginMobilePage.waitUntilLoginPageIsLoaded();
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

    public void createNewPatient() {
        try {
            org.seleniumhq.jetty7.util.log.Log.info("Create new patient started");
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


    @AfterClass(alwaysRun = true)
    public void tearDown() {
        this.driver.quit();
    }
}


