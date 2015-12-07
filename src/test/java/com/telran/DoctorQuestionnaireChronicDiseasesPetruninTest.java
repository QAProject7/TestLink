package com.telran;

import com.telran.Training.LoginIrinaPage;
import com.telran.pages.DoctorQuestionnaireChronicDiseasesPetruninPage;
import com.telran.pages.QuestionnaireChronicDiseasesPatientPetruninPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by leoni on 02.12.2015.
 */
public class DoctorQuestionnaireChronicDiseasesPetruninTest extends TestNgTestBase {
    public static String username = "1003Doctor"; //Данные входа клеента
    public static String password = "LinkCare!!11";//Данные входа доктора
    public LoginIrinaPage loginIrinaPage;
    public DoctorQuestionnaireChronicDiseasesPetruninPage doctorQuestionnaireChronicDiseasesPetruninPage;
    public QuestionnaireChronicDiseasesPatientPetruninPage questionnaireChronicDiseasesPatientPetruninPage;
    private WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void setup() {
        driver = new FirefoxDriver(); //Запускаем Firefox
        loginIrinaPage = PageFactory.initElements(driver, LoginIrinaPage.class); //Обращаемся к классу LoginMobilePage и берем оттуда ссылку на страницу
        doctorQuestionnaireChronicDiseasesPetruninPage=PageFactory.initElements(driver, DoctorQuestionnaireChronicDiseasesPetruninPage.class); //Последующие методы
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
    public void testOpenPatientPage() throws InterruptedException {
        Thread.sleep(5000);
        doctorQuestionnaireChronicDiseasesPetruninPage.clickChoosePatient();
        Thread.sleep(10000);
        //Assert.assertTrue(doctorQuestionnaireChronicDiseasesPetruninPage.inTableFrame(), "Table has not been completed");
        doctorQuestionnaireChronicDiseasesPetruninPage.clickTableFrame();
        Thread.sleep(5000);

        Reporter.log("Registration is validate!");

    }

   @AfterClass(alwaysRun = true)
    public void tearDown() {
        this.driver.quit();
    }
}