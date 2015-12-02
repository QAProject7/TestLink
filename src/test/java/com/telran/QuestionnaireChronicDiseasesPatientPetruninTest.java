package com.telran;

import com.telran.MobileWebPages.LoginMobilePage;
import com.telran.MobileWebPages.QuestionVanderbiltForParentsPetruninPage;
import com.telran.pages.LoginIrinaPage;
import com.telran.pages.QuestionnaireChronicDiseasesPatientPetruninPage;
import org.apache.log4j.Priority;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by Petrunin on 01.12.2015.
 */
public class QuestionnaireChronicDiseasesPatientPetruninTest {

    public static String username = "hore4743@yopmail.com"; //Данные входа клеента (hore2966@yopmail.com был заполнен)
    public static String password = "LinkCare!!11";//Данные входа доктора
    public LoginIrinaPage loginIrinaPage;
    public QuestionnaireChronicDiseasesPatientPetruninPage questionnaireChronicDiseasesPatientPetruninPage;
    private WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void setup() {
        driver = new FirefoxDriver(); //Запускаем Firefox
        loginIrinaPage = PageFactory.initElements(driver, LoginIrinaPage.class); //Обращаемся к классу LoginMobilePage и берем оттуда ссылку на страницу
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
        questionnaireChronicDiseasesPatientPetruninPage.clickTableButtom();
        Thread.sleep(5000);
        driver.switchTo().frame(driver.findElement(By.tagName("iframe")));
        Assert.assertTrue(questionnaireChronicDiseasesPatientPetruninPage.isOnframe(), "We are not on frame page");
        questionnaireChronicDiseasesPatientPetruninPage.fillElements();
        Thread.sleep(3000);
        questionnaireChronicDiseasesPatientPetruninPage.clickSubmitButtom();
        Reporter.log("Registration is validate!");

    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        this.driver.quit();
    }
}

