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

    @FindBy(xpath = "//*[@id='MainContent_PasswordRecovery']//[contains(text(), 'הסיסמא שלך נשלחה אליך.')]")
    WebElement messageStatus;

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
        assertEquals("הסיסמא שלך נשלחה אליך.\nחזור", messageStatus.getText());
        return this;
    }

    public ForgotPasswordSuccessLeonidPage waitUntilForgotSuccessPageIsLoaded() {
        Log.info("wait until forgot success page is loaded");
        try {
            waitUntilElementIsLoaded(backButton);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }

    public void clickOnBackButton() {
        Log.info("clicking on \"back\" button");
        clickElement(backButton);
    }
    public void isRestoreMessageExists(){
        exists(messageStatus);
    }

}
