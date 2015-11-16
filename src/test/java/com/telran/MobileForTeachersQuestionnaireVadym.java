package com.telran;

import com.telran.pages.MobileForLoginPageVadym;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MobileForTeachersQuestionnaireVadym {
    String username = " ";
    String password = "LinkCare!!11";
    public WebDriver driver;
    private StringBuffer verificationErrors = new StringBuffer();
    MobileForLoginPageVadym forLoginPageVadym;
    MobileForTeachersQuestionnaireVadym teachersQuestionnaireVadym;
    @BeforeClass(alwaysRun = true)
    public void setup() {
        driver = new FirefoxDriver();
        forLoginPageVadym = PageFactory.initElements(driver, MobileForLoginPageVadym.class);
    }
    @BeforeMethod(alwaysRun = true)
    public void beforeMethodSetUp() {
        try {
            // loginPage.openLoginPage(driver)
            //       .waitUntilLoginPageIsLoaded()
            //        .clickOnRegLink();
            forLoginPageVadym.openLoginPage(driver);
            forLoginPageVadym.waitUntilLoginPageIsLoaded();
            forLoginPageVadym.isOnLoginPage();
            forLoginPageVadym.fillUsernameField(username)
                    .fillPasswordField(password)
                    .clickOnAgreeToTerms()
                    .clickOnLogin();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    @Test(groups = {"smoke", "positive"})
    public void fillQuestionnaire() {

        try {




        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
