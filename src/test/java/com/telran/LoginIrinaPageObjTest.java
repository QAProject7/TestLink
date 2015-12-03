package com.telran;


import com.telran.pages.DoctorsPage;
import com.telran.pages.LoginIrinaPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Oleg
 */
public class LoginIrinaPageObjTest {
    public static String username = "4337Doctor";
    public static String password = "LinkCare!!11";

    public WebDriver driver;

    public LoginIrinaPage loginPage;
    public DoctorsPage mainPage;
    //public DoctorMainPage mainPage;
    // public LoginPage loginPage;

    @BeforeClass(alwaysRun = true)
    public void setup() {
        driver = new FirefoxDriver();
        loginPage = PageFactory.initElements(driver, LoginIrinaPage.class);
        mainPage = PageFactory.initElements(driver, DoctorsPage.class);
        //  loginPage = PageFactory.initElements(driver,LoginPage.class);
    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethodSetUp() {
        try {
            loginPage.openLoginPage(driver)
                    .waitUntilLoginPageIsLoaded();
            //            .clickOnRegLink();
//            registrationPage.openRegistrationPage(driver)
            //loginPage.waitUntilMenuPageIsLoaded();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(groups = {"smoke", "positive"})
    public void LoginSuccess() {
        try {
            loginPage
                    .fillUsernameField(username)
                    .fillPasswordField(password)
                    .clickOnLoginButton();

            //mainPage.waitUntilMainPageIsLoaded();
            Assert.assertTrue(mainPage.isOnMainPage(), "The Main Page is opened");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test(groups = {"smoke", "negative"})
    public void LoginWithoutUsername() {
        try {
            loginPage
                    .fillUsernameField("")
                    .fillPasswordField(password)
                    .clickOnLoginButton();

            Assert.assertTrue(loginPage.isOnLoginPage(), "The Login Page is opened");
            Assert.assertTrue(loginPage.alertMessageNotValidUsername(), "Alert message 'שם משתמש חובה' is presented");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    @AfterTest(alwaysRun = true)
    public void tearDown() {
        this.driver.quit();
    }

    /*@Test(groups = {"smoke", "negative"})
    public void LoginWithoutAtInUserNameField() {
      //  Log.info("Checking inability lodin without @ in email field");
        try {
            loginPage
                    .fillEmailField("")
                    .fillPasswordField(PASSWORD)
                    .waitUntilAllertEmailIsLogIsLoaded()
                    .clickOnLogin();
            assertTrue("The Email is valid", loginPage.alertMessageInvalidEmail());
            assertTrue("The current page is changed", loginPage.isOnLoginPage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        Reporter.log("Not logged in successful");
    }
    @Test(groups = {"smoke", "negative"})
    public void LoginWithPasswordContains1Symbol() {
        Log.info("Checking inability lodin with password contains 1 symbol");
        try {
            loginPage
                    .fillEmailField(USER)
                    .fillPasswordField("1")
                    .waitUntilAllertPasswordIsLogIsLoaded()
                    .clickOnLogin();
            assertTrue("The Password is valid", loginPage.alertMessageInvalidPassword());
            assertTrue("The current page is changed", loginPage.isOnLoginPage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        Reporter.log("Not logged in successful");
    }

    @Test(groups = {"smoke", "positive"})
    public void ForgotPassword() {
        Log.info("Checking ability recreate password");
        try {
            loginPage
                    .clickOnForgotPasswordLink();
            resetYourPasswordPage.waitUntilResetPageIsLoaded();
            assertTrue("The Reset Password Page doesn't open", resetYourPasswordPage.isOnResetPage());
            resetYourPasswordPage.fillEmailField(USER);
            resetYourPasswordPage.clickOnEmailMe();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Reporter.log("Password recreated successful");
    }

    @Test(groups = {"smoke", "negative"})
    public void LoginWithEmptyFields() {
        Log.info("Checking inability lodin with empty fields");
        try {
            loginPage
                    .fillEmailField("")
                    .fillPasswordField("")
                    .waitUntilAllertEmailIsLogIsLoaded()
                    .clickOnLogin();
            assertTrue("The Email is valid", loginPage.alertMessageInvalidEmail());
            assertTrue("The Password is valid", loginPage.alertMessageInvalidPassword());
            assertTrue("The current page is changed", loginPage.isOnLoginPage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        Reporter.log("Not logged in successful");
    }*/


}
