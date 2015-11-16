package com.telran;

import com.telran.pages.ChronicQuestionnaire1VladimirPage;
import com.telran.pages.ChronicQuestionnaire2VladimirPage;
import com.telran.pages.ChronicQuestionnaire3VladimirPage;
import com.telran.pages.LoginVladimirPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Naryck
 */
public class QuestionnaireVladimirTest {
    public static String username = "metupelet12@yopmail.com";
    public static String password = "LinkCare!1";

    public WebDriver driver;

    public ChronicQuestionnaire1VladimirPage questionnaireFirstPage;
    public ChronicQuestionnaire2VladimirPage questionnaireSecondPage;
    public ChronicQuestionnaire3VladimirPage questionnaireThirdPage;
    public LoginVladimirPage loginPage;

    @BeforeClass(alwaysRun = true)
    public void setUp() {
        driver = new FirefoxDriver();
        //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        loginPage = PageFactory.initElements(driver, LoginVladimirPage.class);
        questionnaireFirstPage = PageFactory.initElements(driver, ChronicQuestionnaire1VladimirPage.class);
        questionnaireSecondPage = PageFactory.initElements(driver, ChronicQuestionnaire2VladimirPage.class);
        questionnaireThirdPage = PageFactory.initElements(driver, ChronicQuestionnaire3VladimirPage.class);
    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethodSetUp() {
        try {
            loginPage
                    .openLoginPage(driver)
                    .waitUntilRegPageIsLoaded()
                    .fillUsernameField(username)
                    .fillPasswordField(password)
                    .clickOnLoginButton();
            //loginPage.waitUntilNextPageIsLoaded();
            //.clickOnNextButton();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(groups = {"smoke", "positive"})
    public void FillElements() {
        if (questionnaireFirstPage.isChronicIllnessAvailable()) {
            questionnaireFirstPage.pressTestButton();
            questionnaireFirstPage.waitUntilTestPageIsLoaded();
            questionnaireFirstPage.fillElements();
            loginPage.openLoginPage(driver);
            if (loginPage.isOnLoginPage()) {
                loginPage.fillUsernameField(username).fillPasswordField(password).clickOnLoginButton();
            }
            questionnaireSecondPage.waitUntilTestPageIsLoaded();
            questionnaireSecondPage.fillElements();
            loginPage.openLoginPage(driver);
            if (loginPage.isOnLoginPage()) {
                loginPage.fillUsernameField(username).fillPasswordField(password).clickOnLoginButton();
            }
            questionnaireThirdPage.waitUntilTestPageIsLoaded();
            questionnaireThirdPage.fillElements();
        } else if (questionnaireSecondPage.isFollowUpAvailable()) {
            questionnaireSecondPage.pressTestButton();
            questionnaireSecondPage.waitUntilTestPageIsLoaded();
            questionnaireSecondPage.fillElements();
            loginPage.openLoginPage(driver);
            if (loginPage.isOnLoginPage()) {
                loginPage.fillUsernameField(username).fillPasswordField(password).clickOnLoginButton();
            }
            questionnaireThirdPage.waitUntilTestPageIsLoaded();
            questionnaireThirdPage.fillElements();
        } else if (questionnaireThirdPage.isAvailable()) {
            questionnaireThirdPage.pressTestButton();
            questionnaireThirdPage.waitUntilTestPageIsLoaded();
            questionnaireThirdPage.fillElements();
        }

        //questionnaireSecondPage.waitUntilTestPageIsLoaded();
        //questionnaireSecondPage.fillElements();

    }

    /*@Test(groups = {"smoke", "negative"})
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
        }

    }*/


   /* @AfterTest(alwaysRun = true)
    public void tearDown() {
        this.driver.quit();
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


}