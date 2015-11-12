package com.telran.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

/**
 * Created by Iakov Volf
 */
public class ForgotPasswordPageSuccessLeonid extends Page {

    //private static Logger Log = Logger.getLogger(LogLog4j.class.getName());
    //fields
    @FindBy(id = "MainContent_PasswordRecovery_SuccessContainerID_LinkButton1")
    WebElement backButton;

    @FindBy(xpath = "//*[@id='MainContent_PasswordRecovery']//div[contains(text(), 'הסיסמא שלך נשלחה אליך.')]")
    WebElement textStatus;

     public ForgotPasswordPageSuccessLeonid(WebDriver driver) {
        super(driver);
        this.PAGE_URL = "http://dhclinicappv2stg.item-soft.co.il/Login.aspx";
        PageFactory.initElements(driver, this);
    }


    public ForgotPasswordPageSuccessLeonid openLoginPage(WebDriver driver) {
        driver.get(PAGE_URL);
        return this;
    }

//Fill the fileds

    public ForgotPasswordPageSuccessLeonid assertText(){
        System.out.println(textStatus.getText());
        assertEquals("הסיסמא שלך נשלחה אליך.\nחזור", textStatus.getText());
        return this;
    }

    public ForgotPasswordPageSuccessLeonid fillRestoreField(String login) {
        setElementText(backButton, login);
        return this;
    }

    public ForgotPasswordPageSuccessLeonid waitUntilForgotSuccessPageIsLoaded() {
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
        clickElement(backButton);

    }

    public boolean isOnForgotPage() {
        return exists(backButton);
    }


}
