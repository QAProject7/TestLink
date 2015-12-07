package com.telran.Training;

import com.telran.pages.PageTraining.LoginVadymPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class RegVadymTest {
    public static String username = "User1";
    public static String firstName = "Moshe";
    public static String lastName = "Levi";
    public static String email = "hore665@yopmail.com";
    public static String password = "!wTnrqiai$";
    public static String teudat = "049919889";
    public static String telephone = "0521234567";
    public static String street = "Herzl";
    public static String city = "Ashdod";
    public static String housenumber = "33";

    public WebDriver driver;
    public LoginVadymPage loginVadymPage;

    @BeforeClass(alwaysRun = true)
    public void setup() {
        driver = new FirefoxDriver();
        loginVadymPage = PageFactory.initElements(driver, LoginVadymPage.class);
    }
    @BeforeMethod(alwaysRun = true)
    public void beforeMethodSetUp() {
        try {
            // loginPage.openLoginPage(driver)
            //       .waitUntilLoginPageIsLoaded()
            //        .clickOnRegLink();
            loginVadymPage.openLoginPage(driver);
            loginVadymPage.waitUntilLoginPageIsLoaded();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test(groups = {"smoke", "positive"})
    public void ForgotPassword() {
        Reporter.log("Checking ability recreate password");
        try {

            loginVadymPage.isOnLoginPage();
            loginVadymPage.openForgotPage();
            loginVadymPage.isOnForgotPasswordPage();
            loginVadymPage.fillUsernameFieldByForgotPage(email)
                    .clickOnRecoveryPasswordButton();
            loginVadymPage.assertText("הסיסמא שלך נשלחה אליך.\nחזור");

        } catch (Exception e) {
            e.printStackTrace();
        }
        Reporter.log("Password recreated successful");
    }
    @Test(groups = {"smoke", "negative"})
    public void RecoveryPasswordWithoutUsername() {
        try {

            loginVadymPage.isOnLoginPage();
            loginVadymPage.openForgotPage();
            loginVadymPage.isOnForgotPasswordPage();
            loginVadymPage.clickOnRecoveryPasswordButton();
            loginVadymPage.assertRequiredText("*");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
