package com.telran;
/*
// Created by Tatiana Pereminski
*/
import com.telran.Training.LoginIrinaPage;
import com.telran.pages.DataProviders;
import com.telran.pages.Page;
import com.telran.pages.RegistrationPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;


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
    public Page page;


    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {
        // driver.get("http://dhclinicappv2stg.item-soft.co.il/Login.aspx");
        registrationPage = PageFactory.initElements(driver, RegistrationPage.class);
        loginIrinaPage = PageFactory.initElements(driver, LoginIrinaPage.class);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethodSetUp() {
        try {
            loginIrinaPage
                    .openLoginPage(driver)
                    .openRegistrationPage();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    @Test(groups={"smock","positive"},dataProviderClass = DataProviders.class, dataProvider = "loadPositiveRegDoctor")
    public void doctorPositiveRegTest(String username,String firstname,String lastname,String password,String house,String mobile,String street,String city,String phoneNumber)throws IOException, InterruptedException
            {
        Log.info("Test Registration of a new doctor was started...");
        try {
            registrationPage
                .waitUntilRegPageIsLoaded()
                .fillUsernameField(username)
                .fillFirstNameField(firstname)
                .fillLastNameField(lastname);
            String email = registrationPage.generateDoctorEmail(username);
            registrationPage.fillEmailField(email)
                .fillPasswordField(password)
                .fillConfPasswordField(password);
            String number = registrationPage.generateZeut();
            registrationPage.fillIdField(number)
                 .fillHousePhoneField(phoneNumber)
                 .fillMobile(mobile)
                 .fillStreetField(street)
                .fillHouseField(house)
                .fillCityField(city)
                .fillClinicName("Asuta");
                String name = "טסט מינדי";
           registrationPage.chooseClinic(name);
                //    .choosePrivateDoctor();
          //  page
           //         .selectValueInDropdownbyText(selectclinicType,"hhh");
            Log.info("write capcha mannualy");
            Thread.sleep(20000);

            registrationPage
                 .clickOnSubmitButton();
            Thread.sleep(10000);

        } catch (Exception e) {
            e.printStackTrace();
        }

        Log.info("Creating new doctor by  saving the data in database");
        Assert.assertTrue((loginIrinaPage.isOnLoginPage()), "You are not on Login Page now!!!");
        Assert.assertFalse(registrationPage.isOnRegistrationPage(),"You are still on Registration Page now!!!");

    }

    @Test(groups={"negative"})
    public void negativeEmptyUserName(){
        try {
            registrationPage
                    .waitUntilRegPageIsLoaded()
                    .fillUsernameField("")
                    .fillFirstNameField("firstname")
                    .fillLastNameField("lastname");

            registrationPage
                    .clickOnSubmitButton();
                     Thread.sleep(1000);

        } catch (Exception e) {
            e.printStackTrace();
        }
        Assert.assertTrue(registrationPage.alertMessageNotValidUserName(), "Not found alert: Empty User Name");
    }


    @Test(groups={"negative"})
    public void negativeEmptyFirstName(){
        try {
            registrationPage
                    .waitUntilRegPageIsLoaded()
                    .fillUsernameField("Doc233")
                    .fillFirstNameField("")
                    .fillLastNameField("lastname");

            registrationPage
                    .clickOnSubmitButton();
            Thread.sleep(1000);

        } catch (Exception e) {
            e.printStackTrace();
        }
        Assert.assertTrue(registrationPage.alertMessageNotValidFirstName(), "Not found alert: Empty First Name");
    }

    @Test(groups={"negative"})
    public void negativeEmptyLastName(){
        try {
            registrationPage
                    .waitUntilRegPageIsLoaded()
                    .fillUsernameField("Doc234")
                    .fillFirstNameField("Anatolii")
                    .fillLastNameField("");

            registrationPage
                    .clickOnSubmitButton();
            Thread.sleep(1000);

        } catch (Exception e) {
            e.printStackTrace();
        }
        Assert.assertTrue(registrationPage.alertMessageNotValidLastName(), "Not found alert: Empty Last Name");
    }

    @Test(groups={"negative"})
    public void negativeEmail(){
        try {
            registrationPage
                    .waitUntilRegPageIsLoaded()
                    .fillUsernameField("Doc235")
                    .fillFirstNameField("Anton")
                    .fillLastNameField("Pol")
                    .fillEmailField("")
                    .clickOnSubmitButton();
            Thread.sleep(1000);

        } catch (Exception e) {
            e.printStackTrace();
        }
        Assert.assertTrue(registrationPage.alertMessageRequiredEmail(), "Not found alert: Empty Email");
    }
    @Test(groups={"negative"})
    public void negativeNotValidEmail(){
        try {
            registrationPage
                    .waitUntilRegPageIsLoaded()
                    .fillUsernameField("Doc235")
                    .fillFirstNameField("Dan")
                    .fillLastNameField("Markov")
                    .fillEmailField("asdssa@hjhj")
                    .clickOnSubmitButton();
            Thread.sleep(1000);

        } catch (Exception e) {
            e.printStackTrace();
        }
        Assert.assertTrue(registrationPage.alertMessageNotValiddEmail(), "Not found alert: Not valid Email");
    }
    @Test(groups={"negative"})
    public void negativeNotValidPassword(){
        try {
            registrationPage
                    .waitUntilRegPageIsLoaded()
                    .fillUsernameField("Doc235")
                    .fillFirstNameField("Dan")
                    .fillLastNameField("Markov")
                    .fillEmailField("asdssa@hj.com")
                    .fillPasswordField("vb123")
                    .clickOnSubmitButton();
            Thread.sleep(1000);

        } catch (Exception e) {
            e.printStackTrace();
        }
        Assert.assertTrue(registrationPage.alertMessageNotValidPassword(), "Not found alert: Not valid Password");
    }
    @Test(groups={"negative"})
    public void negativeRequiredPassword(){
        try {
            registrationPage
                    .waitUntilRegPageIsLoaded()
                    .fillUsernameField("Doc235")
                    .fillFirstNameField("Dan")
                    .fillLastNameField("Markov")
                    .fillEmailField("asdssa@hj.com")
                    .fillPasswordField("")
                    .clickOnSubmitButton();
            Thread.sleep(1000);

        } catch (Exception e) {
            e.printStackTrace();
        }
        Assert.assertTrue(registrationPage.alertMessageRequiredPassword(), "Not found alert: Required Password");
    }
    @Test(groups={"negative"})
    public void negativeRequiredConfirmPassword(){
        try {
            registrationPage
                    .waitUntilRegPageIsLoaded()
                    .fillUsernameField("Doc235")
                    .fillFirstNameField("Dan")
                    .fillLastNameField("Markov")
                    .fillEmailField("asdssa@hj.com")
                    .fillPasswordField("LinkCare!!11")
                    .fillConfPasswordField("")
                    .clickOnSubmitButton();
            Thread.sleep(1000);

        } catch (Exception e) {
            e.printStackTrace();
        }
        Assert.assertTrue(registrationPage.alertMessageRequiredConfirmPassword(), "Not found alert: Required Confirm Password");
    }
    @Test(groups={"negative"})
    public void negativeNotValidConfirmPassword(){
        try {
            registrationPage
                    .waitUntilRegPageIsLoaded()
                    .fillUsernameField("Doc235")
                    .fillFirstNameField("Dan")
                    .fillLastNameField("Markov")
                    .fillEmailField("asdssa@hj.com")
                    .fillPasswordField("LinkCare!!11")
                    .fillConfPasswordField("LinkCare!11")
                    .clickOnSubmitButton();
            Thread.sleep(1000);

        } catch (Exception e) {
            e.printStackTrace();
        }
        Assert.assertTrue(registrationPage.alertMessageNotValidConfirmPassword(), "Not found alert:  Not Valid Confirm Password");
    }

    @Test(groups={"negative"})
    public void negativeNotValidZeut(){
        try {
            registrationPage
                    .waitUntilRegPageIsLoaded()
                    .fillUsernameField("Doc235")
                    .fillFirstNameField("Dan")
                    .fillLastNameField("Markov")
                    .fillEmailField("asdssa@hj.com")
                    .fillPasswordField("LinkCare!!11")
                    .fillConfPasswordField("LinkCare!!11")
                    .fillIdField("123ghj")
                    .clickOnSubmitButton();
            Thread.sleep(1000);

        } catch (Exception e) {
            e.printStackTrace();
        }
        Assert.assertTrue(registrationPage.alertMessageNotValidZeut(), "Not found alert:  Not Valid Zeut");

    }
    @Test(groups={"negative"})
    public void negativeRequiredZeut(){
        try {
            registrationPage
                    .waitUntilRegPageIsLoaded()
                    .fillUsernameField("Doc235")
                    .fillFirstNameField("Dan")
                    .fillLastNameField("Markov")
                    .fillEmailField("asdssa@hj.com")
                    .fillPasswordField("LinkCare!!11")
                    .fillConfPasswordField("LinkCare!!11")
           // String number = registrationPage.generateZeut();
         //   registrationPage.fillIdField(number)
                    .fillIdField("")
                    .clickOnSubmitButton();
            Thread.sleep(1000);

        } catch (Exception e) {
            e.printStackTrace();
        }
        Assert.assertTrue(registrationPage.alertMessageRequiredZeut(), "Not found alert:  Required Zeut");

    }
    @Test(groups={"negative"})
    public void negativeRequiredHouse(){
        try {
            registrationPage
                    .waitUntilRegPageIsLoaded()
                    .fillUsernameField("Doc235")
                    .fillFirstNameField("Dan")
                    .fillLastNameField("Markov")
                    .fillEmailField("asdssa@hj.com")
                    .fillPasswordField("LinkCare!!11")
                    .fillConfPasswordField("LinkCare!!11");
                     String number = registrationPage.generateZeut();
                     registrationPage.fillIdField(number)
                     .fillMobile("0509454665")
                    .fillHouseField("")
                    .clickOnSubmitButton();
            Thread.sleep(1000);

        } catch (Exception e) {
            e.printStackTrace();
        }
        Assert.assertTrue(registrationPage.alertMessageRequiredHouse(), "Not found alert:  Required number of  House");

    }
    @Test(groups={"negative"})
    public void negativeRequiredMobile() {
        try {
            registrationPage
                    .waitUntilRegPageIsLoaded()
                    .fillUsernameField("Doc235")
                    .fillFirstNameField("Dan")
                    .fillLastNameField("Markov")
                    .fillEmailField("asdssa@hj.com")
                    .fillPasswordField("LinkCare!!11")
                    .fillConfPasswordField("LinkCare!!11");
            String number = registrationPage.generateZeut();
            registrationPage.fillIdField(number)
                    .fillHouseField("11")
                    .fillMobile("")
                    .clickOnSubmitButton();
            Thread.sleep(1000);

        } catch (Exception e) {
            e.printStackTrace();
        }
        Assert.assertTrue(registrationPage.alertMessageNotReqMobile(), "Not found alert:  Not required mobile ");

    }
    @Test(groups={"negative"})
    public void negativeNotValidStreet() {
        try {
            registrationPage
                    .waitUntilRegPageIsLoaded()
                    .fillUsernameField("Doc235")
                    .fillFirstNameField("Dan")
                    .fillLastNameField("Markov")
                    .fillEmailField("asdssa@hj.com")
                    .fillPasswordField("LinkCare!!11")
                    .fillConfPasswordField("LinkCare!!11");
            String number = registrationPage.generateZeut();
            registrationPage.fillIdField(number)
                    .fillHouseField("11")
                    .fillMobile("0506506506")
                    .fillStreetField("")
                    .clickOnSubmitButton();
            Thread.sleep(1000);

        } catch (Exception e) {
            e.printStackTrace();
        }
        Assert.assertTrue(registrationPage.alertMessageNotValidStreet(), "Not found alert:  Not valid street ");

    }
    @Test(groups={"negative"})
    public void negativeNotValidCity() {
        try {
            registrationPage
                    .waitUntilRegPageIsLoaded()
                    .fillUsernameField("Doc235")
                    .fillFirstNameField("Dan")
                    .fillLastNameField("Markov")
                    .fillEmailField("asdssa@hj.com")
                    .fillPasswordField("LinkCare!!11")
                    .fillConfPasswordField("LinkCare!!11");
            String number = registrationPage.generateZeut();
            registrationPage.fillIdField(number)
                    .fillHouseField("11")
                    .fillMobile("0506506506")
                    .fillStreetField("Histadrut")
                    .fillCityField("")
                    .clickOnSubmitButton();
            Thread.sleep(1000);

        } catch (Exception e) {
            e.printStackTrace();
        }
        Assert.assertTrue(registrationPage.alertMessageNotValidCity(), "Not found alert:  Not valid city ");

    }



       /* @Test(groups = {"smock", "positive"})
        public void doctorPositiveAutoRegTest ()throws Exception {
            Log.info("Registration of a new doctor");
            try {

                registrationPage
                        .waitUntilRegPageIsLoaded()
                        .registerDoctorAuto("doctrr");
                Log.info("write capcha mannualy");
                Thread.sleep(8000);

                registrationPage
                        .clickOnSubmitButton();
                Thread.sleep(3000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            Assert.assertTrue((loginIrinaPage.isOnLoginPage()), "You are not on Login Page now!!!");
            Assert.assertTrue((registrationPage.isOnRegistrationPage()), "You are not on Registration Page now!!!");
            Assert.assertTrue((registrationPage.alertMessageNotValidFirstName()), "First name is not valid");
            Assert.assertTrue((registrationPage.alertMessageNotValidLastName()), "Last name is not valid");
            Assert.assertTrue((registrationPage.alertMessageNotValidUserName()), "User name s not valid");
        }*/

    }

