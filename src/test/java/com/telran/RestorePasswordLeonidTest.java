package com.telran;

import com.telran.pages.ForgotPasswordLeonidPage;
import com.telran.pages.ForgotPasswordSuccessLeonidPage;
import com.telran.pages.LoginPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Created by Leonid Gengrinovich
 * updated 25.01.2016
 */
public class RestorePasswordLeonidTest  extends TestNgTestBase{
    private static Logger Log = Logger.getLogger(LogLog4j.class.getName());

    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();
    private LoginPage loginPage;
    private ForgotPasswordLeonidPage forgotPasswordPage;
    private ForgotPasswordSuccessLeonidPage forgotPasswordSuccessPage;
    private static String login = "7070Doctor";
    private static String loginNotValid = "Doctor";

    @BeforeClass(alwaysRun = true)
    public void setup() {

        Log.info("initialize loginPage");
        loginPage = PageFactory.initElements(driver, LoginPage.class);
        Log.info("initialize forgotPasswordPage");
        forgotPasswordPage = PageFactory.initElements(driver, ForgotPasswordLeonidPage.class);
        Log.info("initialize forgotPasswordSuccessPage");
        forgotPasswordSuccessPage = PageFactory.initElements(driver, ForgotPasswordSuccessLeonidPage.class);
    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethodSetUp() {
        Log.info("@BeforeMethod: open login page and openForgotPasswordPage");
        loginPage.openLoginPage()
                .isOnLoginPage();
        loginPage.openForgotPasswordPage();
    }
    @Test(groups = {"positive", "smoke"})
    public void restorePasswordTest() throws IOException, InterruptedException {
        Log.info("restore Password");
        forgotPasswordPage.waitUntilForgotPageIsLoaded()
                .fillRestoreField(login)
                .clickOnRestoreButton();
        Thread.sleep(5000);
        forgotPasswordSuccessPage.isRestoreLoginMessageExists();
    }

    @Test(groups = {"negative", "smoke"})
    public void restorePasswordNotValidLoginTest() throws IOException, InterruptedException {
        Log.info("restore Password");
        forgotPasswordPage.waitUntilForgotPageIsLoaded()
                .fillRestoreField(loginNotValid)
                .clickOnRestoreButton();
        Thread.sleep(5000);
        forgotPasswordSuccessPage.isRestoreNotValidLoginMessageExists();
    }

    @Test(groups = {"negative", "smoke"})
    public void restorePasswordEmptyLoginTest() throws IOException, InterruptedException {
        Log.info("restore Password");
        forgotPasswordPage.waitUntilForgotPageIsLoaded()
                .fillRestoreField("")
                .clickOnRestoreButton();
        Thread.sleep(5000);
        forgotPasswordSuccessPage.isRestoreEmptyLoginMessageExists();
    }
//    @AfterClass(alwaysRun = true)
//    public void tearDown(){
//        this.driver.quit();
//    }
}