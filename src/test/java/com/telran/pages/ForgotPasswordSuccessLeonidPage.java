package com.telran.pages;

import com.telran.LogLog4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.logging.Logger;

import static org.testng.AssertJUnit.assertEquals;


/**
 * Created by Leonid Gengrinovich
 */
public class ForgotPasswordSuccessLeonidPage extends Page {

    private static Logger Log = Logger.getLogger(LogLog4j.class.getName());
    //fields
    @FindBy(id = "MainContent_PasswordRecovery_SuccessContainerID_LinkButton1")
    WebElement backButton;

    @FindBy(xpath = "//*[@id='MainContent_PasswordRecovery']//div[contains(text(), 'הסיסמא שלך נשלחה אליך.')]")
    WebElement textStatus;

    @FindBy(xpath = "//*[@id='MainContent_PasswordRecovery']//[contains(text(), 'הסיסמא שלך נשלחה אליך.')]")
    WebElement messageStatus;

    @FindBy(xpath = "//*[contains (text(), 'לא הצלחנו לגשת למידע שלך. אנא נסה שוב')]")
    WebElement messageStatusNotValid;

     public ForgotPasswordSuccessLeonidPage(WebDriver driver) {
        super(driver);
        this.PAGE_URL = "http://dhclinicappv2stg.item-soft.co.il/Login.aspx";
        PageFactory.initElements(driver, this);
    }

    public ForgotPasswordSuccessLeonidPage openLoginPage(WebDriver driver) {
        Log.info("Open login page");
        driver.get(PAGE_URL);
        return this;
    }

    public ForgotPasswordSuccessLeonidPage assertText(){
        Log.info("assert text on forgotPassword page");
        assertEquals("הסיסמא שלך נשלחה אליך.\nחזור", textStatus.getText());
        return this;
    }

    public ForgotPasswordSuccessLeonidPage waitUntilForgotSuccessPageIsLoaded() throws IOException, InterruptedException {
        Log.info("wait until forgot success page is loaded");
            waitUntilElementIsLoaded(backButton);
        return this;
    }

    public void clickOnBackButton() {
        Log.info("clicking on \"back\" button");
        clickElement(backButton);
    }
    public void isRestoreMessageExists() {
        Log.info("Wait for Restore message");
        exists(messageStatus);
    }
    public void isRestoreMessageNotValidExists() {
        Log.info("Wait for Restore message not valid");
        exists(messageStatusNotValid);
    }
}
