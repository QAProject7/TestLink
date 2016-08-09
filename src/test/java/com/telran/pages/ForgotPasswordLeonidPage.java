package com.telran.pages;

import com.telran.LogLog4j;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

/**
 * Created by Iakov Volf
 */
public class ForgotPasswordLeonidPage extends Page {
    private static Logger Log = Logger.getLogger(LogLog4j.class.getName());

    @FindBy(id = "MainContent_LoginUser_LoginButton")
    WebElement submitButton;

    @FindBy(id = "MainContent_PasswordRecovery_UserNameContainerID_SubmitButton")
    WebElement restoreButton;

    @FindBy(xpath = "//*[@id='MainContent_PasswordRecovery_UserNameContainerID_LinkButton1']")
    WebElement backButton;

    @FindBy(id = "MainContent_PasswordRecovery_UserNameContainerID_UserName")
    WebElement restoreUserNameField;


    public ForgotPasswordLeonidPage(WebDriver driver) {
        super(driver);
        this.PAGE_URL = baseUrl + "/Login.aspx";
        PageFactory.initElements(driver, this);
    }


    public ForgotPasswordLeonidPage openLoginPage(WebDriver driver) {
        driver.get(PAGE_URL);
        return this;
    }

//Fill the fileds

    public ForgotPasswordLeonidPage fillRestoreField(String login) {
        Log.info("fill restore field");
        setElementText(restoreUserNameField, login);
        return this;
    }

    public ForgotPasswordLeonidPage waitUntilLoginPageIsLoaded() throws IOException, InterruptedException {
        Log.info("waiting until login page is loaded");
            waitUntilElementIsLoaded(submitButton);
        return this;
    }

    public ForgotPasswordLeonidPage waitUntilForgotPageIsLoaded() throws IOException, InterruptedException {
        Log.info("waiting until forgot page is loaded");
            waitUntilElementIsLoaded(restoreButton);
            waitUntilIsLoadedCustomTime(restoreButton, 120);
        return this;
    }

    public ForgotPasswordLeonidPage clickOnRestoreButton() {
        Log.info("click on restore button");
        clickElement(restoreButton);
        return this;
    }

    public boolean isOnForgotPage() {
        return exists(restoreButton);
    }


}
