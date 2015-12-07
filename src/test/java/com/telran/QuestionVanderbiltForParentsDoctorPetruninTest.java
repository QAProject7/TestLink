package com.telran;

import com.telran.pages.DoctorsPage;
import com.telran.pages.DrugRecommendationPage;
import com.telran.pages.PageTraining.LoginMaksimPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class QuestionVanderbiltForParentsDoctorPetruninTest {
    public static String registered_username = "1003Doctor"; //Данные входа доктора
    public static String registered_password = "LinkCare!!11";//Данные входа доктора
    public static String teudat = "779294107";//Данные входа доктора
    private static Logger Log = Logger.getLogger(LogLog4j.class.getName()); //Необходимо для написания логов
    public LoginMaksimPage loginPage; //Ссылка на вход на страницу (берет из класса LoginMaksimPage)
    public DoctorsPage doctorsPage;
    public DrugRecommendationPage drugRecommendationPage;
    private WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void setup() {
        driver = new FirefoxDriver(); //Запускаем Firefox
        //registrationPage = PageFactory.initElements(driver, RegistrationPage.class);
        //  mainPage = PageFactory.initElements(driver, DoctorMainPage.class);
        loginPage = PageFactory.initElements(driver, LoginMaksimPage.class); //Обращаемся к классу LoginMaksimPage и берем оттуда ссылку на страницу
        doctorsPage = PageFactory.initElements(driver, DoctorsPage.class);
        drugRecommendationPage = PageFactory.initElements(driver, DrugRecommendationPage.class);

    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethodSetUp() { //Входим на страницу и ждем пока она загрузится
        loginPage.openLoginPage(driver); //Логи к данному методу добавлены на странице Максима LoginPage
        loginPage
                .fillUsernameField(registered_username)
                .fillPasswordField(registered_password)
                .clickOnLoginButton();
       doctorsPage.waitUntilMainPageIsLoaded();
    }


    @Test(groups = {"positive", "smoke"}) //Зашли через DoctorsPage в конкретного юзера по теудату и проверили зашел или нет
    public void testOpenPatientPage() {
    //Логи к методам добавлены на странице Иры DoctorsPage и DrugRecommendationPage
    doctorsPage.openPatientPage(teudat); // Открыли клиента по теудату
    drugRecommendationPage.waitUntilDrugPageIsLoaded(); //Дождались чтоб открылась клиентская страница через класс DrugRecommendationPage
      Assert.assertTrue(drugRecommendationPage.isTableSelected(), "User not filled the questionnaire"); //Добавили проверку появилась ли заполненная таблица вопросника
              drugRecommendationPage.clickTimeLineQst();
        try {
            Thread.sleep(4000); //ждем 4 сек
        } catch (InterruptedException e) {}
       Assert.assertTrue(drugRecommendationPage.isOnframe(), "We are not on frame page"); //Проверяем находимся ли во фрейме(ссылка на DragRecommendationPage)
        Log.info("We are on frame page");
        //driver.switchTo().frame(driver.findElement(By.tagName("iframe"))); //Переходим на внутренний фрейм
    }





    // test of clicking on Registration link are written in another class

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        this.driver.quit();
    }
}