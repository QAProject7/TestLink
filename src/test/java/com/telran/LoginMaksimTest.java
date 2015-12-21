package com.telran;

import com.github.yev.FailTestScreenshotListener;
import com.telran.pages.DataProviders;
import com.telran.pages.LoginPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Date;

@org.testng.annotations.Listeners(FailTestScreenshotListener.class)
public class LoginMaksimTest extends TestNgTestBase {
    public static String registered_username = "3339Doctor";
    public static String registered_password = "LinkCare!!11";
    public LoginPage loginPage;

    @BeforeClass(alwaysRun = true)
    public void setup() {
        loginPage = PageFactory.initElements(driver, LoginPage.class);
    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethodSetUp() {
        loginPage.openLoginPage();
    }

    @Test(groups = {"smoke", "negative"}, dataProviderClass = DataProviders.class, dataProvider = "loadInvalidLoginFromFile")
    public void testLoginWithExtData(String login, String pass) {
        loginPage
                .fillUsernameField(login)
                .fillPasswordField(pass)
                .clickOnTermsCheckbox()
                .clickOnLoginButton();
        Assert.assertTrue(loginPage.isLoginUnsuccessfulAlertMessageDisplayed());
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
    public void testLoginByRegisteredUser() throws IOException, InterruptedException {
        loginPage
                .fillUsernameField(registered_username)
                .fillPasswordField(registered_password)
                .clickOnTermsCheckbox()
                .clickOnLoginButton();
        Assert.assertFalse(loginPage.isPageOpened());
        loginPage.clickLogOut();
        loginPage.waitUntilLoginPageIsLoaded();
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