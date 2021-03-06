package com.telran.Training;

import com.telran.pages.ForgotPasswordPage;
import com.telran.pages.ForgotPasswordSuccessLeonidPage;
import com.telran.pages.LoginPage;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.fail;

public class RegistrationLeonidTest {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    private LoginPage loginPage;
    private ForgotPasswordPage forgotPasswordPage;
    private ForgotPasswordSuccessLeonidPage forgotPasswordSuccessPage;

    @BeforeClass(alwaysRun = true)
    public void setup() {
        driver = new FirefoxDriver();
        loginPage = PageFactory.initElements(driver,LoginPage.class);
        forgotPasswordPage = PageFactory.initElements(driver, ForgotPasswordPage.class);
        forgotPasswordSuccessPage = PageFactory.initElements(driver, ForgotPasswordSuccessLeonidPage.class);
    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethodSetUp() {
        try {
//             loginPage.openLoginPage(driver)
//                      .waitUntilMenuPageIsLoaded();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testMercuryRegister() throws Exception {

        loginPage
                .openLoginPage()
                .waitUntilLoginPageIsLoaded()
                .openForgotPasswordPage();
        forgotPasswordPage
                .waitUntilForgotPageIsLoaded()
                .fillRestoreField("hore548@yopmail.com")
                .clickOnRestoreButton();
        forgotPasswordSuccessPage
                .waitUntilForgotSuccessPageIsLoaded()
                .assertText()
                .clickOnBackButton();
    }

    @AfterTest
    public void tearDown() throws Exception {
        Thread.sleep(5000);
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
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