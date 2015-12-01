package com.telran;

import com.telran.MobileWebPages.LoginMobilePage;
import com.telran.MobileWebPages.QuestionVanderbiltForParentsPetruninPage;
import com.telran.pages.LoginIrinaPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by Petrunin on 01.12.2015.
 */
public class QuestionnaireChronicDiseasesPatientPetruninTest {

    public static String username = "hore2966@yopmail.com"; //Данные входа клеента
    public static String password = "LinkCare!!11";//Данные входа доктора
    public LoginIrinaPage loginIrinaPage;
    private WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void setup() {
        driver = new FirefoxDriver(); //Запускаем Firefox
        loginIrinaPage = PageFactory.initElements(driver, LoginIrinaPage.class); //Обращаемся к классу LoginMobilePage и берем оттуда ссылку на страницу

    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethodSetUp() { //Входим на страницу и ждем пока она загрузится
        loginIrinaPage.openLoginPage(driver); //Логи к данному методу добавлены на странице LoginMobilePage
        loginIrinaPage.waitUntilLoginPageIsLoaded();
        loginIrinaPage
                .fillUsernameField(username)
                .fillPasswordField(password)
                .clickOnLoginButton();
    }

    @Test(groups = {"positive", "smoke"})
    public void testOpenPatientPage() {

    }

}
