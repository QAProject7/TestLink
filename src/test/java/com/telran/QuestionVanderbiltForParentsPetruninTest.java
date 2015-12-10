package com.telran;

import com.telran.MobileWebPages.LoginMobilePage;
import com.telran.MobileWebPages.QuestionVanderbiltForParentsPetruninPage;
import com.telran.pages.CreateNewPatientPage;
import com.telran.pages.DoctorsPage;
import com.telran.pages.LoginPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.io.IOException;


/**
 * Created by PetruninLeonid
 */
public class QuestionVanderbiltForParentsPetruninTest extends TestNgTestBase{ //ГОТОВ. ИСПРАВЕН
    private static Logger Log = Logger.getLogger(LogLog4j.class.getName());

    public static String email;
    public static String zeut;
    public static String password = "LinkCare!!11";
    public static String docName = "1003Doctor";
    public static String docPass = "LinkCare!!11";
    public static String username;


    public QuestionVanderbiltForParentsPetruninPage questionVanderbiltForParentsPetrunin; //Ссылка на вход на страницу (берет из класса LoginMaksimPage)
    public LoginPage loginPage;
    public LoginMobilePage loginMobilePage;
    public DoctorsPage doctorsPage;
    public CreateNewPatientPage createNewPatientPage;



    @BeforeClass(alwaysRun = true)
    public void setup() throws InterruptedException, IOException {
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
        createNewPatient();
        loginPage.clickLogOut();
        Log.info("Exit from web page");
        loginMobilePage = PageFactory.initElements(driver, LoginMobilePage.class); //Обращаемся к классу LoginMobilePage и берем оттуда ссылку на страницу
        questionVanderbiltForParentsPetrunin = PageFactory.initElements(driver, QuestionVanderbiltForParentsPetruninPage.class);
        createNewPatientPage = PageFactory.initElements(driver, CreateNewPatientPage.class);


    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethodSetUp() throws InterruptedException {
        Thread.sleep(5000);
        createNewPatientPage.profileFilling(email, createNewPatientPage.generateZeut());
        Log.info("Password was changed");
        Thread.sleep(5000);
        loginPage.clickLogOut();
        Log.info("Exit from loginPage");
        Log.info("TestButton was pushed");

       Thread.sleep(5000);
        System.out.println("driver: " + driver);
        driver.get("http://dhclinicamobileppstg.item-soft.co.il/index.htm");
        Thread.sleep(10000);
        //loginMobilePage.waitUntilLoginPageIsLoaded();
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
            createNewPatientPage.waitUntilPageIsLoaded();
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


    @AfterClass(alwaysRun = true)
    public void tearDown() {
        this.driver.quit();
    }
}


