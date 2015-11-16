package com.telran;

import com.telran.pages.CreateNewPatientPage;
import com.telran.pages.LoginMaksimPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class CreateNewPatientTest {
    public static String username = "527Doctor";
    public static String password = "LinkCare!!11";
    public static String zeut;
    public static String email;
    public LoginMaksimPage loginPage;
    public CreateNewPatientPage createNewPatientpage;
    private WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void setup() {
        driver = new FirefoxDriver();
        //registrationPage = PageFactory.initElements(driver, RegistrationPage.class);
        //  mainPage = PageFactory.initElements(driver, DoctorMainPage.class);
        loginPage = PageFactory.initElements(driver, LoginMaksimPage.class);
        createNewPatientpage = PageFactory.initElements(driver, CreateNewPatientPage.class);
        zeut = createNewPatientpage.generateZeut();
        email = createNewPatientpage.generateParentEmail();
        loginPage.
                openLoginPage(driver)
                .fillUsernameField(username)
                .fillPasswordField(password)
                .clickOnLoginButton();

    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethodSetUp() {

    }

    @Test(groups = {"positive"})
    public void createNewPatient() {
        try {
            createNewPatientpage.createPatientOneParent(zeut, email);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
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

    // test of clicking on Registration link are written in another class

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        this.driver.quit();
    }
}