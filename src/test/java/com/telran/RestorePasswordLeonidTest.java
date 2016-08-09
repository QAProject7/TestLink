package com.telran;

import com.telran.pages.ForgotPasswordPage;
import com.telran.pages.ForgotPasswordSuccessLeonidPage;
import com.telran.pages.LoginPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by Leonid Gengrinovich
 * updated 25.01.2016
 */
public class RestorePasswordLeonidTest  {
    private static Logger Log = Logger.getLogger(LogLog4j.class.getName());
    private static String login = "3339Doctor";
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();
    private LoginPage loginPage;
    private ForgotPasswordPage forgotPasswordPage;
    private ForgotPasswordSuccessLeonidPage forgotPasswordPageSuccess;
    private WebDriver driver;
    private String driverPath = "C:\\Telran\\browserDriver\\";

    @BeforeClass(alwaysRun = true)
    public void setup() {
        System.setProperty("webdriver.chrome.driver", driverPath + "chromedriver.exe");
        driver = new ChromeDriver();

        Log.info("initialize loginPage");
        loginPage = PageFactory.initElements(driver, LoginPage.class);
        Log.info("initialize forgotPasswordPage");
        forgotPasswordPage = PageFactory.initElements(driver, ForgotPasswordPage.class);
        Log.info("initialize forgotPasswordPageSuccess");
        forgotPasswordPageSuccess = PageFactory.initElements(driver, ForgotPasswordSuccessLeonidPage.class);
    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethodSetUp() {
            Log.info("@BeforeMethod: open login page and openForgotPasswordPage");
            loginPage.openLoginPage()
                    .isOnLoginPage();
            loginPage.openForgotPasswordPage();
    }

    @Test(groups = {"positive", "smoke"})
    public void restorePasswordTest() {
        Log.info("restore Password");
        forgotPasswordPage.waitUntilForgotPageIsLoaded()
                        .fillRestoreField(login)
                        .clickOnRestoreButton();
        forgotPasswordPageSuccess.isRestoreMessageExists();
    }
    @AfterClass(alwaysRun = true)
    public void tearDown(){
        this.driver.quit();
    }
}