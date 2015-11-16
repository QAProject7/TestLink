package com.telran;

import com.telran.MobileWebPages.MobileForLoginPageVadym;
import com.telran.MobileWebPages.MobileForTeachersQuestionnairePageVadym;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MobileForTeachersQuestionnaireVadymTest {
    String username = "more8262@yopmail.com";
    String password = "LinkCare!!11";
    public WebDriver driver;
   // private StringBuffer verificationErrors = new StringBuffer();
    MobileForLoginPageVadym forLoginPageVadym;
    MobileForTeachersQuestionnairePageVadym questionnairePageVadym;
    @BeforeClass(alwaysRun = true)
    public void setup() {
        driver = new FirefoxDriver();
        forLoginPageVadym = PageFactory.initElements(driver, MobileForLoginPageVadym.class);
        questionnairePageVadym = PageFactory.initElements(driver, MobileForTeachersQuestionnairePageVadym.class);
    }
    @BeforeMethod(alwaysRun = true)
    public void beforeMethodSetUp() {
        try {

            forLoginPageVadym.openLoginPage(driver);
            forLoginPageVadym.waitUntilLoginPageIsLoaded();
            forLoginPageVadym.isOnLoginPage();
            forLoginPageVadym.fillUsernameField(username)
                    .fillPasswordField(password)
                    .clickOnAgreeToTerms()
                    .clickOnLogin();
            questionnairePageVadym.waitUntilMenuPageIsLoaded()
                    .clickOnStartTestButton()
                    .waitUntilStartTestButtonIsLoaded()
                    .clickOnContinueButton();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    @Test(groups = {"smoke", "positive"})
    public void fillQuestionnaire() {

        try {
            questionnairePageVadym
                    .waitUntilQuestionsIsLoaded()
                    .fillQuestionnaire()
                    .clickOnSendbutton();



        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
