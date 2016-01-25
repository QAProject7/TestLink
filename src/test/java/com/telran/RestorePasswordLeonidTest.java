package com.telran;

import com.telran.pages.DataProviders;
import com.telran.pages.ForgotPasswordPageLeonid;
import com.telran.pages.ForgotPasswordPageSuccessLeonid;
import com.telran.pages.LoginPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by Leonid Gengrinovich
 * updated 25.01.2016
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

    @Test(groups = {"positive", "smoke"},dataProviderClass = DataProviders.class, dataProvider = "loadLogins")
    public void restorePasswordTest1(String login, String comment) throws Exception {
        Log.info("test with " + comment);
        forgotPasswordPage.waitUntilForgotPageIsLoaded()
                        .fillRestoreField(login)
                        .clickOnRestoreButton();
        forgotPasswordPageSuccess.waitUntilForgotSuccessPageIsLoaded()
                                .assertText();
    }

}