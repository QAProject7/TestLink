package com.telran;

import com.telran.MobileWebPages.LoginMobilePage;
import com.telran.MobileWebPages.MobileQuestionnareForTeacher8qLeonid;
import com.telran.MobileWebPages.MobileUserMainMenuAccountLeonid;
import com.telran.MobileWebPages.QuestionVanderbiltForParentsPetrunin;
import com.telran.pages.DoctorsPage;
import com.telran.pages.DrugRecommendationPage;
import com.telran.pages.LoginMaksimPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertTrue;

public class QuestionVanderbiltForParentsPetruninTest {
    public static String registered_username = "hore3216@yopmail.com"; //Данные входа клеента
    public static String registered_password = "LinkCare!!11";//Данные входа доктора
    public QuestionVanderbiltForParentsPetrunin questionVanderbiltForParentsPetrunin; //Ссылка на вход на страницу (берет из класса LoginMaksimPage)
    public LoginMobilePage loginMobilePage;
    private WebDriver driver;


    @BeforeClass(alwaysRun = true)
    public void setup() {
        driver = new FirefoxDriver(); //Запускаем Firefox
        loginMobilePage = PageFactory.initElements(driver, LoginMobilePage.class); //Обращаемся к классу LoginMobilePage и берем оттуда ссылку на страницу
        questionVanderbiltForParentsPetrunin = PageFactory.initElements(driver, QuestionVanderbiltForParentsPetrunin.class);

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

    @Test(groups = {"positive", "smoke"})
    public void testOpenPatientPage() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
        }
        questionVanderbiltForParentsPetrunin.checkNextImgButton();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
        }

            questionVanderbiltForParentsPetrunin.fillElements();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
        }
        questionVanderbiltForParentsPetrunin.checkLeftBtnHeader();
    }


    @AfterClass(alwaysRun = true)
    public void tearDown() {
        this.driver.quit();
    }
}