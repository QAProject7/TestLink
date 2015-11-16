package com.telran;


import com.telran.pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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
public class MobileChangePasswordTestArtem {
    public static String username = "hore582@yopmail.com";
    public static String password = "LinkCare!1";
    public static String wrongPass = "LinkCare!2";
    public static String oldPass = "LinkCare!1";
    public static String newPass = "Fuckoff1";


    public WebDriver driver;

    public MobileLoginTempArtem loginPage;
    public MobileChangePasswordArtem changePassPage;
    // public LoginPage loginPage;

    @BeforeClass(alwaysRun = true)
    public void setup() {
        driver = new FirefoxDriver();
        loginPage = PageFactory.initElements(driver, MobileLoginTempArtem.class);
        changePassPage = PageFactory.initElements(driver, MobileChangePasswordArtem.class);
        //  mainPage = PageFactory.initElements(driver, DoctorMainPage.class);
        //  loginPage = PageFactory.initElements(driver,LoginPage.class);
    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethodSetUp() {
        try {
            // loginPage.openLoginPage(driver)
            //       .waitUntilLoginPageIsLoaded()
            //        .clickOnRegLink();
 loginPage.openMobileLoginTempArtemPage(driver)
           .waitUntilLoginPageIsLoaded();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*@Test(groups = {"smoke", "positive"})
    public void LoginSuccess() {
        try {
            loginPage
                    .fillUsernameField(username)
                    .fillPasswordField(password)
                    .clickOnAgreeToTermsChecker()
                    .clickOnLoginButton();
            changePassPage.waitUntilLoginPageIsLoaded()
                    .fillOldPasswordField(oldPass)
                    .fillNewPasswordField(newPass)
                    .fillConfirmNewPasswordField(newPass)
                    .clickOnOkChangePasswordButton();
            //    mainPage.waitUntilMainPageIsLoaded();
            //    Assert.assertTrue(mainPage.isOnMainPage(), "The Main Page doesn't open");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }*/

    @Test(groups = {"smoke", "negative"})
    public void LoginWithoutUserName() {
        try {
            loginPage
                    .fillPasswordField(password)
                    .clickOnAgreeToTermsChecker()
                    .clickOnLoginButton();
            Assert.assertTrue(loginPage.alertMessageEnterAllFields(), "Alert message 'נא להזין את כל השדות' is not presented");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }




    @Test(groups = {"smoke", "negative"})
    public void LoginWithoutAnyInfo() {
        try {
            loginPage
                    .clickOnAgreeToTermsChecker()
                   .clickOnLoginButton();

            Assert.assertTrue(loginPage.isOnRegistrationPage(), "The Main Page is opened");
            Assert.assertTrue(loginPage.alertMessageEnterAllFields(), "Alert message 'נא להזין את כל השדות' is not presented");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }



    @Test(groups = {"smoke", "negative"})
    public void LoginWithWrongPass() {
        try {
            loginPage
                    .fillUsernameField(username)
                    .fillPasswordField(wrongPass)
                    .clickOnAgreeToTermsChecker()
                    .clickOnLoginButton();

            //Assert.assertTrue(loginPage.isOnRegistrationPage(), "The Main Page is opened");
            Assert.assertTrue(loginPage.alertMessageFailedLogin(), "Alert message 'ההתחברות נכשלה נא נסה שנית' is not presented");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
/*

    @Test(groups = {"smoke", "negative"})
    public void LoginWithWrongUserName() {
        try {
            loginPage
                    .fillUsernameField(username)
                    .fillFirstNameField("")
                    .fillPasswordField(password)
                    .fillEmailField()
                    .fillLastNameField(lastName)
                    .fillConfPasswordField(password)
                    .fillIdField()
                    .fillStreetField(street)
                    .fillHouseField(housenumber)
                    .fillCityField(city)
                    .clickOnSubmitButton();

            Assert.assertTrue(loginPage.isOnRegistrationPage(), "The Main Page is opened");
            Assert.assertTrue(loginPage.alertMessageNotValidFirsrName(), "Alert message 'שם פרטי חובה' is not presented");

        } catch (Exception e) {
            e.printStackTrace();
        }



    @Test(groups = {"smoke", "negative"})
    public void LoginWithoutPassword() {
        try {
            loginPage
                    .fillUsernameField(username)
                    .fillFirstNameField("")
                    .fillPasswordField(password)
                    .fillEmailField()
                    .fillLastNameField(lastName)
                    .fillConfPasswordField(password)
                    .fillIdField()
                    .fillStreetField(street)
                    .fillHouseField(housenumber)
                    .fillCityField(city)
                    .clickOnSubmitButton();

            Assert.assertTrue(loginPage.isOnRegistrationPage(), "The Main Page is opened");
            Assert.assertTrue(loginPage.alertMessageNotValidFirsrName(), "Alert message 'שם פרטי חובה' is not presented");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }



    @Test(groups = {"smoke", "negative"})
    public void LoginWithoutTerms() {
        try {
            loginPage
                    .fillUsernameField(username)
                    .fillFirstNameField("")
                    .fillPasswordField(password)
                    .fillEmailField()
                    .fillLastNameField(lastName)
                    .fillConfPasswordField(password)
                    .fillIdField()
                    .fillStreetField(street)
                    .fillHouseField(housenumber)
                    .fillCityField(city)
                    .clickOnSubmitButton();

            Assert.assertTrue(loginPage.isOnRegistrationPage(), "The Main Page is opened");
            Assert.assertTrue(loginPage.alertMessageNotValidFirsrName(), "Alert message 'שם פרטי חובה' is not presented");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
*/



    @AfterTest(alwaysRun = true)
    public void tearDown() {
        // this.driver.quit();
    }

    /*@Test(groups = {"smoke", "negative"})
    public void LoginWithoutAtInUserNameField() {
      //  Log.info("Checking inability lodin without @ in email field");
        try {
            loginPage
                    .fillEmailField("")
                    .fillOldPasswordField(PASSWORD)
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
                    .fillOldPasswordField("1")
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
                    .fillOldPasswordField("")
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
