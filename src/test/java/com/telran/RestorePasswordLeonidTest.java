package com.telran;

import com.telran.pages.ForgotPasswordPageLeonid;
import com.telran.pages.ForgotPasswordPageSuccessLeonid;
import com.telran.pages.LoginPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
/**
 * Created by Leonid Gengrinovich
 */
public class RestorePasswordLeonidTest  extends TestNgTestBase{
    private static Logger Log = Logger.getLogger(LogLog4j.class.getName());

    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    private LoginPage loginPage;
    private ForgotPasswordPageLeonid forgotPasswordPage;
    private ForgotPasswordPageSuccessLeonid forgotPasswordPageSuccess;

    @BeforeClass(alwaysRun = true)
    public void setup() {
        // driver = new FirefoxDriver();
        Log.info("initialize loginPage");
        loginPage = PageFactory.initElements(driver, LoginPage.class);
        Log.info("initialize forgotPasswordPage");
        forgotPasswordPage = PageFactory.initElements(driver, ForgotPasswordPageLeonid.class);
        Log.info("initialize forgotPasswordPageSuccess");
        forgotPasswordPageSuccess = PageFactory.initElements(driver, ForgotPasswordPageSuccessLeonid.class);
    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethodSetUp() {
        try {
            Log.info("@BeforeMethod: open login page, waitUntilPageIsLoaded and openForgotPasswordPage");
            loginPage.openLoginPage()
                    .waitUntilLoginPageIsLoaded()
                    .openForgotPasswordPage();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(groups = {"positive", "smoke"})
    public void restorePasswordTest1() throws Exception {
        Log.info("test with 1 hebrew letter");
        forgotPasswordPage.waitUntilForgotPageIsLoaded()
                .fillRestoreField("ק")
                .clickOnRestoreButton();
        forgotPasswordPageSuccess.waitUntilForgotSuccessPageIsLoaded()
                .assertText();
    }

    @Test(groups = {"positive", "smoke"})
    public void restorePasswordTest2() throws Exception {
        Log.info("test with 15 hebrew letters");
        forgotPasswordPage.waitUntilForgotPageIsLoaded()
                .fillRestoreField("קראטוןםפשדגכעיח")
                .clickOnRestoreButton();
        forgotPasswordPageSuccess.waitUntilForgotSuccessPageIsLoaded()
                .assertText();
    }

    @Test(groups = {"positive", "smoke"})
    public void restorePasswordTest3() throws Exception {
        Log.info("test with 1 english letter");
        forgotPasswordPage.waitUntilForgotPageIsLoaded()
                .fillRestoreField("j")
                .clickOnRestoreButton();
        forgotPasswordPageSuccess.waitUntilForgotSuccessPageIsLoaded()
                .assertText();
    }

    @Test(groups = {"positive", "smoke"})
    public void restorePasswordTest4() throws Exception {
        Log.info("test with 15 english letters");
        forgotPasswordPage.waitUntilForgotPageIsLoaded()
                .fillRestoreField("qwertyuiopasdfg")
                .clickOnRestoreButton();
        forgotPasswordPageSuccess.waitUntilForgotSuccessPageIsLoaded()
                .assertText();
    }

    @Test(groups = {"positive", "smoke"})
    public void restorePasswordTest5() throws Exception {
        Log.info("test with 1 number");
        forgotPasswordPage.waitUntilForgotPageIsLoaded()
                .fillRestoreField("2")
                .clickOnRestoreButton();
        forgotPasswordPageSuccess.waitUntilForgotSuccessPageIsLoaded()
                .assertText();
    }

    @Test(groups = {"positive", "smoke"})
    public void restorePasswordTest6() throws Exception {
        Log.info("test with 15 numbers");
        forgotPasswordPage.waitUntilForgotPageIsLoaded()
                .fillRestoreField("555555555555555")
                .clickOnRestoreButton();
        forgotPasswordPageSuccess.waitUntilForgotSuccessPageIsLoaded()
                .assertText();
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }
}