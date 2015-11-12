package com.telran;

import com.telran.pages.MobileLoginPageLeonid;
import com.telran.pages.MobileQuestionnareForTeacher8qLeonid;
import com.telran.pages.MobileUserMainMenuAccountLeonid;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.fail;

/**
 * Naryck
 */
public class QuestionnaireForTeachersTestLeonid {

    String username = "more8262@yopmail.com";
    String password = "LinkCare!!11";

    public WebDriver driver;
    private StringBuffer verificationErrors = new StringBuffer();
    MobileLoginPageLeonid mobileLoginPage;
    MobileUserMainMenuAccountLeonid mobileUserMainMenuAccount;
    MobileQuestionnareForTeacher8qLeonid mobileQuestionnareForTeacher8q;


    @BeforeClass(alwaysRun = true)
    public void setUp() {
        driver = new FirefoxDriver();
        //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        mobileLoginPage = PageFactory.initElements(driver, MobileLoginPageLeonid.class);
        mobileUserMainMenuAccount = PageFactory.initElements(driver, MobileUserMainMenuAccountLeonid.class);
        mobileQuestionnareForTeacher8q = PageFactory.initElements(driver, MobileQuestionnareForTeacher8qLeonid.class);
    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethodSetUp() {
        try {
            mobileLoginPage
                    .openLoginPage(driver)
                    .waitUntilLoginPageIsLoaded()
                    .fillUsernameField(username)
                    .fillPasswordField(password)
                    .clickOnAgreeCheckBox()
                    .clickOnLoginButton();
            mobileUserMainMenuAccount
                    .waitUntilMenuPageIsLoaded()
                    .clickOnSubmitButton()
                    .waitUntilStartTestButtonIsLoaded()
                    .clickOnStartTestButton();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(groups = {"smoke", "positive"})
    public void FillElements() {
        mobileQuestionnareForTeacher8q
                .waitUntilQuestionsIsLoaded()
                .fillQuestionnaire()
                .clickOnSendResultbutton();
    }


    @AfterTest
    public void tearDown() throws Exception {
        Thread.sleep(10000);
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

}