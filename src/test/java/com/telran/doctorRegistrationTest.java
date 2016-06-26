package com.telran;
/*
// Modified by Tatiana Pereminski
*/
import com.telran.Training.LoginIrinaPage;
import com.telran.pages.DataProviders;
import com.telran.pages.RegistrationPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

public class doctorRegistrationTest extends TestNgTestBase {

    private StringBuffer verificationErrors = new StringBuffer();
    private String lFamily = "testfam";
    private String lName = "testname";
    private String loginName = "d";
    long millis = System.currentTimeMillis();
    private String DocLogin = loginName + millis;

    private static Logger Log = Logger.getLogger(LogLog4j.class.getName()); //Необходимо для написания логов
    public RegistrationPage registrationPage;
    public LoginIrinaPage loginIrinaPage;


    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {
        // driver.get("http://dhclinicappv2stg.item-soft.co.il/Login.aspx");
        registrationPage = PageFactory.initElements(driver, RegistrationPage.class);
        loginIrinaPage = PageFactory.initElements(driver, LoginIrinaPage.class);
        //   driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethodSetUp() {
        try {
            loginIrinaPage
                    .openLoginPage(driver)
                    .waitUntilLoginPageIsLoaded()
                    .openRegistrationPage();
            registrationPage
                    .waitUntilRegPageIsLoaded();

        } catch (Exception e) {
            e.printStackTrace();
        }
       // driver.manage().window().maximize();
    }



  /* @Test(groups = {"smoke", "negative"}, dataProviderClass = DataProviders.class, dataProvider = "loadInvalidLoginFromFile")
    public void testLoginWithExtData(String login, String pass) {
        Log.info("TestLoginWithExtData was started....");
        loginIrinaPage
                .fillUsernameField(login)
                .fillPasswordField(pass)
                // .clickOnTermsCheckbox()
                .clickOnLoginButton();
        Assert.assertTrue(loginIrinaPageisLoginUnsuccessfulAlertMessageDisplayed());
        Log.info("TestLoginWithExtData stoped....");
    }*/

    @Test(groups = {"negative"})
      public void testLoginWithoutNameAndPassword() {
          loginIrinaPage
                  .fillUsernameField("")
                  .fillPasswordField("")
                  .clickOnLoginButton();
          Assert.assertTrue(loginIrinaPage.alertMessageNotValidUsername(),"Not found alert: Empty First Name");// && loginIrinaPage.alertMessageNotValidPassword());

      }

    @Test(groups= {"smock","positive"})
    public void doctorPositiveRegTest() throws Exception {
        Log.info("Registration of a new doctor");
        try {

        registrationPage
                .waitUntilRegPageIsLoaded()
                .fillUsernameField("username")
                .fillFirstNameField("firstname")
                .fillLastNameField("lastname")
                .fillPasswordField("password")
                .fillConfPasswordField("password")
                .fillEmailField("sasdfg1111@yopmail.com")
                .fillIdField("083493015")
                .fillHouseField("14")
                .fillCityField("haifa")
                .fillMobile("975176421")
                .choosePrivateDoctor()
                .chooseClinic("טסט מינדי");


            Log.info("write capcha mannualy");
            Thread.sleep(10000);

            registrationPage
                 .clickOnSubmitButton();
            Thread.sleep(5000);

        } catch (Exception e) {
            e.printStackTrace();
        }

        Log.info("Creating new doctor by  saving the data in database");
        Assert.assertTrue((loginIrinaPage.isOnLoginPage()), "You are not on Login Page now!!!");
       // Assert.assertFalse(registrationPage.isOnRegistrationPage(),"You are still on Registration Page now!!!");

    }
    @Test(groups= {"smock","positive"})
    public void doctorPositiveAutoRegTest() throws Exception {
        Log.info("Registration of a new doctor");
        try {

            registrationPage
                    .waitUntilRegPageIsLoaded()
                    .registerDoctorAuto("doctr16");
        } catch (Exception e) {
            e.printStackTrace();
        }
        Assert.assertTrue((loginIrinaPage.isOnLoginPage()), "You are not on Login Page now!!!");
    }
  /*  @Test
    public void doctorRegTest1() throws Exception {
        driver.findElement(By.id("MainContent_LoginUser_RegisterHyperLink")).click();
        for (int second = 0; ; second++) {
            if (second >= 60) fail("timeout");
            try {
                if (isElementPresent(By.xpath
                        ("//input[@id='MainContent_RegisterUser_CreateUserStepContainer_UserName']")))
                    break;
            } catch (Exception e) {
            }
            Thread.sleep(1000);
        }

        driver.findElement(By.id("MainContent_RegisterUser_CreateUserStepContainer_UserName")).clear();
        driver.findElement(By.id("MainContent_RegisterUser_CreateUserStepContainer_UserName"))
                .sendKeys(DocLogin);
        try {
            assertEquals(DocLogin, driver
                    .findElement(By.xpath("//input[@id='MainContent_RegisterUser_CreateUserStepContainer_UserName']"))
                    .getAttribute("value"));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        driver.findElement(By.id("MainContent_RegisterUser_CreateUserStepContainer_firstNameTxt")).clear();
        driver.findElement(By.id("MainContent_RegisterUser_CreateUserStepContainer_firstNameTxt")).sendKeys(lName);
        driver.findElement(By.id("MainContent_RegisterUser_CreateUserStepContainer_lastNameTxt")).clear();
        driver.findElement(By.id("MainContent_RegisterUser_CreateUserStepContainer_lastNameTxt")).sendKeys(lFamily);
        driver.findElement(By.id("MainContent_RegisterUser_CreateUserStepContainer_Email")).clear();
        driver.findElement(By.id("MainContent_RegisterUser_CreateUserStepContainer_Email"))
                .sendKeys(DocLogin + "@mail.com");
        System.out.println("mail is: " + DocLogin + "@mail.com");
        try {
            assertEquals(DocLogin + "@mail.com", driver
                    .findElement(By.xpath("//*[@id='MainContent_RegisterUser_CreateUserStepContainer_Email']"))
                    .getAttribute("value"));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        driver.findElement(By.id("MainContent_RegisterUser_CreateUserStepContainer_Password")).clear();
        driver.findElement(By.id("MainContent_RegisterUser_CreateUserStepContainer_Password")).sendKeys("Qazxsw2!");
        driver.findElement(By.id("MainContent_RegisterUser_CreateUserStepContainer_ConfirmPassword")).clear();
        driver.findElement(By.id("MainContent_RegisterUser_CreateUserStepContainer_ConfirmPassword"))
                .sendKeys("Qazxsw2!");
        driver.findElement(By.id("MainContent_RegisterUser_CreateUserStepContainer_PersonalIdTxt")).clear();
        driver.findElement(By.id("MainContent_RegisterUser_CreateUserStepContainer_PersonalIdTxt"))
                .sendKeys("70357264");
        driver.findElement(By.id("MainContent_RegisterUser_CreateUserStepContainer_clinicNameTxt")).clear();
        driver.findElement(By.id("MainContent_RegisterUser_CreateUserStepContainer_clinicNameTxt")).sendKeys("Clinic");
        new Select(driver.findElement(By.id("MainContent_RegisterUser_CreateUserStepContainer_OrganizationDDL")))
                .selectByVisibleText("רופאים פרטיים");
        driver.findElement(By.id("ctl00_MainContent_RegisterUser_CreateUserStepContainer_birthdayTxt_dateInput"))
                .click();
        driver.findElement(By.id("ctl00_MainContent_RegisterUser_CreateUserStepContainer_birthdayTxt_dateInput"))
                .clear();
        driver.findElement(By.id("ctl00_MainContent_RegisterUser_CreateUserStepContainer_birthdayTxt_dateInput"))
                .sendKeys("07/11/1981");
        driver.findElement(By.id("ctl00_MainContent_RegisterUser_CreateUserStepContainer_ContactCellTxt")).clear();
        driver.findElement(By.id("ctl00_MainContent_RegisterUser_CreateUserStepContainer_ContactCellTxt"))
                .sendKeys("053-1234567");
        driver.findElement(By.id("ctl00_MainContent_RegisterUser_CreateUserStepContainer_ContactPhoneTxt")).clear();
        driver.findElement(By.id("ctl00_MainContent_RegisterUser_CreateUserStepContainer_ContactPhoneTxt"))
                .sendKeys("(053)-1234568");
        driver.findElement(By.id("MainContent_RegisterUser_CreateUserStepContainer_AddressTxt")).clear();
        driver.findElement(By.id("MainContent_RegisterUser_CreateUserStepContainer_AddressTxt")).sendKeys("Ye'elim");
        driver.findElement(By.id("MainContent_RegisterUser_CreateUserStepContainer_HouseNumberTxt")).clear();
        driver.findElement(By.id("MainContent_RegisterUser_CreateUserStepContainer_HouseNumberTxt")).sendKeys("3");
        driver.findElement(By.id("MainContent_RegisterUser_CreateUserStepContainer_CityTxt")).clear();
        driver.findElement(By.id("MainContent_RegisterUser_CreateUserStepContainer_CityTxt")).sendKeys("Jerusalem");
        driver.findElement(By.id("MainContent_RegisterUser_CreateUserStepContainer_ZipCodeTxt")).clear();
        driver.findElement(By.id("MainContent_RegisterUser_CreateUserStepContainer_ZipCodeTxt")).sendKeys("1234567");
        driver.findElement(By.id("MainContent_AddNewUser")).click();
        try {
            assertEquals("http://dhclinicappv2stg.item-soft.co.il/SecurityInfrastructure/Accounts.aspx"
                    , driver.getCurrentUrl());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            assertEquals(lName + " " + lFamily, driver
                    .findElement(By.xpath("//*[@id='Top1_HeadLoginView_DisplayName']")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
    }*/
/*
    @AfterTest
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }*/

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}