package com.telran;

import com.telran.MobileWebPages.MobileLoginPageLeonid;
import com.telran.MobileWebPages.MobileQuestionnareForTeacher8qLeonid;
import com.telran.MobileWebPages.MobileUserMainMenuAccountLeonid;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

/**
 *  Created by Leonid Gengrinovich
 */
public class QuestionnaireForTeachersTestLeonid {

    String username = "more3373@yopmail.com";
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
    public void FillElements() throws InterruptedException {
        mobileQuestionnareForTeacher8q
                .waitUntilQuestionsIsLoaded();
        fillQuestionnaire();
        mobileQuestionnareForTeacher8q.clickOnSendResultbutton();
        boolean flag = mobileQuestionnareForTeacher8q.isHelpButtonExist();
        assertTrue(flag);
    }

    @AfterTest
    public void tearDown() throws Exception {
        Thread.sleep(5000);
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    public void fillQuestionnaire() throws InterruptedException {
        List<WebElement> divs = mobileQuestionnareForTeacher8q.getAllQuestions();

        List<WebElement> spanWithInput, radioButtons;
        int divAnswered = 0;
        int divNotAnswered = divs.size();

        for (WebElement div: divs) {
            mobileQuestionnareForTeacher8q.clickOnSendResultbutton();
            int divCounter = 1;
            for(WebElement question: divs) {
                if(divCounter > divAnswered) {
                    assertTrue(question.getAttribute("class").equals("sectionq  Required"));
                }
                divCounter++;
            }
            spanWithInput = div.findElements(By.className("answerInput"));
            int rndValue = (int) (Math.random() * 3);
            WebElement currentSpan = spanWithInput.get(rndValue);
            WebElement radioButton = currentSpan.findElement(By.tagName("input"));
            radioButton.click();
            divAnswered++;
        }
    }
}