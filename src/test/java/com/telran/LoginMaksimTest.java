package com.telran;

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

public class LoginMaksimTest {
    public static String registered_username = "loginName";
    public static String registered_password = "Passw0rd!";
    public LoginMaksimPage loginPage;
    private WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void setup() {
        driver = new FirefoxDriver();
        //registrationPage = PageFactory.initElements(driver, RegistrationPage.class);
        //  mainPage = PageFactory.initElements(driver, DoctorMainPage.class);
        loginPage = PageFactory.initElements(driver, LoginMaksimPage.class);
    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethodSetUp() {
        loginPage.openLoginPage(driver);
    }

    @Test(groups = {"negative"})
    public void testLoginWithoutNameAndPassword() {
        loginPage
                .fillUsernameField("")
                .fillPasswordField("")
                .clickOnLoginButton();
        Assert.assertTrue(loginPage.alertMessageNotValidUserName() && loginPage.alertMessageNotValidPassword());
    }

    @Test(groups = {"negative"})
    public void testLoginWithoutName() {
        loginPage
                .fillUsernameField("")
                .fillPasswordField("anypassword")
                .clickOnLoginButton();
        Assert.assertTrue(loginPage.alertMessageNotValidUserName() && !loginPage.alertMessageNotValidPassword());
    }

    @Test(groups = {"negative"})
    public void testLoginWithoutPassword() {
        loginPage
                .fillUsernameField("anyusername")
                .fillPasswordField("")
                .clickOnLoginButton();
        Assert.assertTrue(!loginPage.alertMessageNotValidUserName() && loginPage.alertMessageNotValidPassword());
    }

    @Test(groups = {"negative"})
    public void testLoginByUnregisteredUser() {
        long suffix = new Date().getTime();
        loginPage
                .fillUsernameField("user" + suffix)
                .fillPasswordField("password" + suffix)
                .clickOnLoginButton();
        Assert.assertTrue(loginPage.alertMessageUnregisteredUser());
    }

    @Test(groups = {"positive", "smoke"})
    public void testLoginByRegisteredUser() {
        loginPage
                .fillUsernameField(registered_username)
                .fillPasswordField(registered_password)
                .clickOnLoginButton();
        Assert.assertFalse(loginPage.isPageOpened());
    }

    @Test(groups = {"positive"})
    public void testOpenForgotPasswordPage() {
        loginPage.openForgotPasswordPage();
        Assert.assertFalse(loginPage.isPageOpened());
    }

    // test of clicking on Registration link are written in another class

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        this.driver.quit();
    }
}