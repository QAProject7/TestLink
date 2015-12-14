package com.telran;

import com.telran.pages.ForgotPasswordPageLeonid;
import com.telran.pages.ForgotPasswordPageSuccessLeonid;
import com.telran.pages.LoginPage;
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
    //private WebDriver driver;  we have driver from TestNgTestBase
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    private LoginPage loginPage;
    private ForgotPasswordPageLeonid forgotPasswordPage;
    private ForgotPasswordPageSuccessLeonid forgotPasswordPageSuccess;

    @BeforeClass(alwaysRun = true)
    public void setup() {
        // driver = new FirefoxDriver();
        loginPage = PageFactory.initElements(driver, LoginPage.class);
        forgotPasswordPage = PageFactory.initElements(driver, ForgotPasswordPageLeonid.class);
        forgotPasswordPageSuccess = PageFactory.initElements(driver, ForgotPasswordPageSuccessLeonid.class);
    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethodSetUp() {
        try {
            loginPage.openLoginPage()
                    .waitUntilLoginPageIsLoaded()
                    .openForgotPasswordPage();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(groups = {"positive", "smoke"})
    public void restorePasswordTest1() throws Exception {
        forgotPasswordPage.waitUntilForgotPageIsLoaded()
                .fillRestoreField("ק")
                .clickOnRestoreButton();
        forgotPasswordPageSuccess.waitUntilForgotSuccessPageIsLoaded()
                .assertText();
    }

    @Test(groups = {"positive", "smoke"})
    public void restorePasswordTest2() throws Exception {
        forgotPasswordPage.waitUntilForgotPageIsLoaded()
                .fillRestoreField("קראטוןםפשדגכעיח")
                .clickOnRestoreButton();
        forgotPasswordPageSuccess.waitUntilForgotSuccessPageIsLoaded()
                .assertText();
    }

    @Test(groups = {"positive", "smoke"})
    public void restorePasswordTest3() throws Exception {
        forgotPasswordPage.waitUntilForgotPageIsLoaded()
                .fillRestoreField("j")
                .clickOnRestoreButton();
        forgotPasswordPageSuccess.waitUntilForgotSuccessPageIsLoaded()
                .assertText();
    }

    @Test(groups = {"positive", "smoke"})
    public void restorePasswordTest4() throws Exception {
        forgotPasswordPage.waitUntilForgotPageIsLoaded()
                .fillRestoreField("qwertyuiopasdfg")
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