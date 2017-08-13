package com.telran;

import com.telran.Training.LoginIrinaPage;
import com.telran.pages.DoctorQuestionnaireChronicDiseasesPage;
import com.telran.pages.QuestionnaireChronicDiseasesPatientPetruninPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Created by PetruninLeonid
 */
public class DoctorQuestionnaireChronicDiseasesPetruninTest extends TestNgTestBase { //ГОТОВЫЙ ТЕСТ
    public static String username = "1003Doctor"; //Данные входа клеента
    public static String password = "LinkCare!!11";//Данные входа доктора
    private static Logger Log = Logger.getLogger(LogLog4j.class.getName());
    public LoginIrinaPage loginIrinaPage;
    public DoctorQuestionnaireChronicDiseasesPage doctorQuestionnaireChronicDiseasesPage;
    public QuestionnaireChronicDiseasesPatientPetruninPage questionnaireChronicDiseasesPatientPetruninPage;
    //private WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void setup() {
        //driver = new FirefoxDriver(); //Запускаем Firefox
        driver.manage().window().maximize(); //Развертывание окна
        loginIrinaPage = PageFactory.initElements(driver, LoginIrinaPage.class); //Обращаемся к классу LoginMobilePage и берем оттуда ссылку на страницу
        doctorQuestionnaireChronicDiseasesPage = PageFactory.initElements(driver, DoctorQuestionnaireChronicDiseasesPage.class); //Последующие методы
        questionnaireChronicDiseasesPatientPetruninPage=PageFactory.initElements(driver, QuestionnaireChronicDiseasesPatientPetruninPage.class); //Последующие методы

    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethodSetUp() { //Входим на страницу и ждем пока она загрузится
        loginIrinaPage.openLoginPage(driver); //Логи к данному методу добавлены на странице LoginMobilePage

        loginIrinaPage.waitUntilLoginPageIsLoaded();
        loginIrinaPage
                .fillUsernameField(username)
                .fillPasswordField(password);
        questionnaireChronicDiseasesPatientPetruninPage.clickAddAcceptField();
        loginIrinaPage.clickOnLoginButton();
    }

    @Test(groups = {"positive", "smoke"})
    public void testOpenPatientPage() throws InterruptedException, IOException {
        Thread.sleep(5000);
        doctorQuestionnaireChronicDiseasesPage.clickChoosePatient();
        Thread.sleep(15000);
        driver.switchTo().frame("MainContent_iframe1");
        Assert.assertTrue(doctorQuestionnaireChronicDiseasesPage.inTableFrame(), "Table has not been completed");
        doctorQuestionnaireChronicDiseasesPage.clickTableFrame();
        Thread.sleep(5000);
        Log.info("Registration is validate!");
        Reporter.log("Registration is validate!");

    }

   @AfterClass(alwaysRun = true)
    public void tearDown() {
        this.driver.quit();
    }
}