package com.telran.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

/**
 * Created by Iakov Volf
 */
public class ForgotPasswordPageLeonid extends Page {

   @FindBy(id = "MainContent_PasswordRecovery_UserNameContainerID_SubmitButton")
    WebElement restoreButton;

    @FindBy(xpath = "//*[@id='MainContent_PasswordRecovery_UserNameContainerID_LinkButton1']")
    WebElement backButton;

    @FindBy(id = "MainContent_PasswordRecovery_UserNameContainerID_UserName")
    WebElement restoreField;


    public ForgotPasswordPageLeonid(WebDriver driver) {
        super(driver);
        this.PAGE_URL = baseUrl + "/Login.aspx";
        PageFactory.initElements(driver, this);
    }


    public ForgotPasswordPageLeonid openLoginPage(WebDriver driver) {
        driver.get(PAGE_URL);
        return this;
    }

//Fill the fileds

    public ForgotPasswordPageLeonid fillRestoreField(String login) {
        setElementText(restoreField, login);
        return this;
    }

    public ForgotPasswordPageLeonid waitUntilForgotPageIsLoaded() {
        try {
            waitUntilElementIsLoaded(restoreButton);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }

    public ForgotPasswordPageLeonid clickOnRestoreButton() {
        clickElement(restoreButton);
        return this;
    }

    public boolean isOnForgotPage() {
        return exists(restoreButton);
    }


}
