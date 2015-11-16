package com.telran;

import com.telran.MobileWebPages.QuestionVanderbiltForParentsPetrunin;
import com.telran.pages.DoctorsPage;
import com.telran.pages.LoginMaksimPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Date;

public class QuestionVanderbiltForParentsPetruninTest {
    public static String registered_username = "493Doctor"; //Данные входа доктора
    public static String registered_password = "LinkCare!!11";//Данные входа доктора
    public static String teudat = "140088204";//Данные входа доктора
    private WebDriver driver;
    public LoginMaksimPage loginPage; //Ссылка на вход на страницу (берет из класса LoginMaksimPage)
    public DoctorsPage doctorsPage;


    @BeforeClass(alwaysRun = true)
    public void setup() {
        driver = new FirefoxDriver(); //Запускаем Firefox
        //registrationPage = PageFactory.initElements(driver, RegistrationPage.class);
        //  mainPage = PageFactory.initElements(driver, DoctorMainPage.class);
        loginPage = PageFactory.initElements(driver, LoginMaksimPage.class); //Обращаемся к классу LoginMaksimPage
         doctorsPage = PageFactory.initElements(driver, DoctorsPage.class);                                                                  // и берем оттуда ссылку на страницу
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
    doctorsPage.openPatientPage(teudat);

    }



    // test of clicking on Registration link are written in another class

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        this.driver.quit();
    }
}