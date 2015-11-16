package com.telran;

import com.telran.pages.DrugRecomendationPage;
import com.telran.pages.LoginIrinaPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by Alex on 12.11.2015.
 */
public class DrugRecommendationFainbergObjTest {

    public static String username = "4337Doctor";
    public static String password = "LinkCare!!11";

    public WebDriver driver;

    public DrugRecomendationPage mainPage;
    public LoginIrinaPage loginPage;

    @BeforeClass(alwaysRun = true)
    public void setUp() {
        driver = new FirefoxDriver();
        //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        loginPage = PageFactory.initElements(driver, LoginIrinaPage.class);
        mainPage = PageFactory.initElements(driver, DrugRecomendationPage.class);
    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethodSetUp() {
        try {
            loginPage
                    .openLoginPage(driver)
                    .waitUntilLoginPageIsLoaded()
                    .fillUsernameField(username)
                    .fillPasswordField(password)
                    .clickOnLoginButton();
            mainPage
                    .waitUntilTestPageIsLoaded();


            //loginPage.waitUntilTestPageIsLoaded();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(groups = {"smoke", "positive"})
    public void FillElements() {
        mainPage.waitUntilTestPageIsLoaded();

        try {
            //mainPage.fillElements();
            mainPage.pressExpandElement()
                    .pressAddLink()
                    .fillTextField()
                    .pressCommitAddLink();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
