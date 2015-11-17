package com.telran;

import com.telran.pages.CreateNewPatientPage;
import com.telran.pages.TeacherTestPage;
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
public class RegistrationPageTeacherTest {
    public static String registered_username;
    public static String registered_password = "LinkCare!!11";
    public TeacherTestPage loginPage;
    public CreateNewPatientPage createPatientPage;
    private WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void setup() {
        driver = new FirefoxDriver();
        //registrationPage = PageFactory.initElements(driver, RegistrationPage.class);
        //  mainPage = PageFactory.initElements(driver, DoctorMainPage.class);
        loginPage = PageFactory.initElements(driver, TeacherTestPage.class);
    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethodSetUp() {
        loginPage.openLoginPage(driver);
    }

    @AfterTest(alwaysRun = true)
    public void tearDown() {
        this.driver.quit();
    }

    @Test(groups = {"positive", "smoke"})
    public void testLoginByRegisteredUser() {
        registered_username = createPatientPage.generateTeacherEmail();
        loginPage
                .fillUsernameField(registered_username)
                .fillPasswordField(registered_password)
                .clickOnLoginButton();
        Assert.assertFalse(loginPage.isPageOpened());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(loginPage.isButtonStartTest(),"Button start test not present");
        loginPage
                .clickOnButtonStartTest();
        loginPage
                .clickOnAnyStar();
        loginPage
                .clickOnSendButton();
        Assert.assertFalse(loginPage.isButtonStartTest(), "Test not passed");

    }





}


        //  @Test(groups = {"smoke", "positive"})
   /* public void LoginSuccess() {
        try {
            teacherTestPage
                    //.fillUsernameField(username)
                    //.fillFirstNameField(firstName)
                    .fillPasswordField(password)
                    .fillEmailField()
                    .fillLastNameField(lastName)
                    .fillConfPasswordField(password)
                    .fillIdField()
                    .fillMobile(telephone)
                    .fillStreetField(street)
                    .fillHouseField(housenumber)
                    .fillCityField(city)
                    .clickOnSubmitButton();

            //    mainPage.waitUntilMainPageIsLoaded();
            //    Assert.assertTrue(mainPage.isOnMainPage(), "The Main Page doesn't open");

        } catch (Exception e) {
            e.printStackTrace();
        }*/



   /* @Test(groups = {"smoke", "negative"})
    public void LoginWithoutFirstName() {
        try {
            registrationPage
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

            Assert.assertTrue(registrationPage.isOnRegistrationPage(), "The Main Page is opened");
            Assert.assertTrue(registrationPage.alertMessageNotValidFirsrName(), "Alert message 'שם פרטי חובה' is not presented");

        } catch (Exception e) {
            e.printStackTrace();
        }*/





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
