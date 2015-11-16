package com.telran;

import com.telran.pages.DoctorsPage;
import com.telran.pages.DrugRecommendationPage;
import com.telran.pages.LoginMaksimPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class QuestionVanderbiltForParentsPetruninTest {
    public static String registered_username = "493Doctor"; //Данные входа доктора
    public static String registered_password = "LinkCare!!11";//Данные входа доктора
    public static String teudat = "140088204";//Данные входа доктора
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
        loginPage.openLoginPage(driver);
        loginPage
                .fillUsernameField(registered_username)
                .fillPasswordField(registered_password)
                .clickOnLoginButton();
       doctorsPage.waitUntilMainPageIsLoaded();
    }


    @Test(groups = {"positive", "smoke"}) //Зашли через DoctorsPage в конкретного юзера по теудату и проверили зашел или нет
    public void testOpenPatientPage() {
    doctorsPage.openPatientPage(teudat); // Открыли клиента по теудату
    drugRecommendationPage.waitUntilDrugPageIsLoaded(); //Дождались чтоб открылась клиентская страница через класс DrugRecommendationPage
    drugRecommendationPage.clickTimeLineQst();
        try {
            Thread.sleep(3000); //ждем 10 сек
        } catch (InterruptedException e) {}
        Assert.assertTrue(drugRecommendationPage.isOnframe(), "We are not on frame page"); //Проверяем находимся ли во фрейме(ссылка на DragRecommendationPage)
        try {
            Thread.sleep(10000); //ждем 10 сек
        } catch (InterruptedException e) {}
        //driver.switchTo().frame(driver.findElement(By.tagName("iframe"))); //Переходим на внутренний фрейм
    }





    // test of clicking on Registration link are written in another class

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        this.driver.quit();
    }
}