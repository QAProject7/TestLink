package com.telran;


import com.telran.Training.LoginIrinaPage;
import com.telran.pages.DoctorsPage;
import com.telran.pages.DrugRecommendationPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Irina
 */
public class DrugRecommendationPageTest {
    public static String username = "4337Doctor";
    public static String password = "LinkCare!!11";

    public WebDriver driver;

    public LoginIrinaPage loginPage;
    public DoctorsPage mainPage;
    public DrugRecommendationPage drugPage;
    //public DoctorMainPage mainPage;
    // public LoginPage loginPage;

    @BeforeClass(alwaysRun = true)
    public void setup() {
        driver = new FirefoxDriver();
        loginPage = PageFactory.initElements(driver, LoginIrinaPage.class);
        mainPage = PageFactory.initElements(driver, DoctorsPage.class);
        drugPage = PageFactory.initElements(driver, DrugRecommendationPage.class);
    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethodSetUp() {
        try {
            loginPage.openLoginPage(driver)
                    .waitUntilLoginPageIsLoaded()
                    .fillUsernameField(username)
                    .fillPasswordField(password)
                    .clickOnLoginButton();
            mainPage.isOnMainPage();
            mainPage.clickOnGoToPatientButton();
            drugPage.waitUntilDrugPageIsLoaded();


            //            .clickOnRegLink();
//            registrationPage.openRegistrationPage(driver)
            //loginPage.waitUntilLoginPageIsLoaded();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(groups = {"smoke", "positive"})
    public void AddDrugSuccess() {
        System.out.println("AddDrugSuccess");
        try {
            drugPage.clickOnExpandCollapseButton()
                    .waitUntilElementIsLoaded(drugPage.valueButton);
            String drugValue = "group111";
            drugPage.addDrug(drugValue);
            //.waitUntilElementIsLoaded(drugPage.valueButton);
            driver.switchTo().alert().accept();
            beforeMethodSetUp();

            Assert.assertTrue(drugPage.isDrugAdded(drugValue), "The drug wasn't added");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(groups = {"smoke", "positive"})
    public void RemoveDrugSuccess() {
        System.out.println("RemoveDrugSuccess");
        try {
            drugPage.clickOnExpandCollapseButton()
                    .waitUntilElementIsLoaded(drugPage.valueButton);
            String drugToRemove = drugPage.selectFirstDrug();
            drugPage.removeDrug(drugToRemove)
                    .waitUntilElementIsLoaded(drugPage.valueButton);
            Assert.assertTrue(drugPage.isDrugRemoved(drugToRemove), "The drug wasn't removed");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


   /* @Test(groups = {"smoke", "negative"})
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

    }*/


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
