package com.telran;

import com.telran.MobileWebPages.LoginMobilePage;
import com.telran.MobileWebPages.QuestionVanderbiltForParentsPetrunin;
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
    public static String registered_username = "hore3216@yopmail.com"; //Данные входа клеента
    public static String registered_password = "LinkCare!!11";//Данные входа доктора
    public QuestionVanderbiltForParentsPetrunin questionVanderbiltForParentsPetrunin; //Ссылка на вход на страницу (берет из класса LoginMaksimPage)
    public LoginMobilePage loginMobilePage;
    private WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void setup() {
        driver = new FirefoxDriver(); //Запускаем Firefox
        //registrationPage = PageFactory.initElements(driver, RegistrationPage.class);
        //  mainPage = PageFactory.initElements(driver, DoctorMainPage.class);
        loginMobilePage = PageFactory.initElements(driver, LoginMobilePage.class); //Обращаемся к классу LoginMobilePage и берем оттуда ссылку на страницу
        questionVanderbiltForParentsPetrunin = PageFactory.initElements(driver, QuestionVanderbiltForParentsPetrunin.class);
       // doctorsPage = PageFactory.initElements(driver, DoctorsPage.class);
       // drugRecommendationPage = PageFactory.initElements(driver, DrugRecommendationPage.class);

    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethodSetUp() { //Входим на страницу и ждем пока она загрузится
        loginMobilePage.openLoginPage(driver); //Логи к данному методу добавлены на странице LoginMobilePage
        loginMobilePage.waitUntilLoginPageIsLoaded();
        loginMobilePage
                .fillUsernameField(registered_username)
                .fillPasswordField(registered_password)
                .checkAgreeChebox();

        loginMobilePage.clickOnLoginButton();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
        }
        questionVanderbiltForParentsPetrunin.clickSubmitButton();

    }




    @Test(groups = {"positive", "smoke"}) //Зашли через DoctorsPage в конкретного юзера по теудату и проверили зашел или нет
    public void testOpenPatientPage() {


        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
        }
        questionVanderbiltForParentsPetrunin.fillElements();
       /* Assert.assertTrue(drugRecommendationPage.isTableSelected(), "User not filled the questionnaire"); //Добавили проверку появилась ли заполненная таблица вопросника
    drugRecommendationPage.clickTimeLineQst();
        try {
            Thread.sleep(4000); //ждем 4 сек
        } catch (InterruptedException e) {}
       Assert.assertTrue(drugRecommendationPage.isOnframe(), "We are not on frame page"); //Проверяем находимся ли во фрейме(ссылка на DragRecommendationPage)
*/
        //driver.switchTo().frame(driver.findElement(By.tagName("iframe"))); //Переходим на внутренний фрейм
    }





    // test of clicking on Registration link are written in another class

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        this.driver.quit();
    }
}