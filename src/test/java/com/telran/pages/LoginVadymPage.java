package com.telran.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

/**
 * Created by Iakov Volf,Oleg
 */
public class LoginVadymPage extends Page {
    @FindBy(id = "MainContent_LoginUser_UserName")
    WebElement  userNameField;

    @FindBy(id = "MainContent_PasswordRecovery_UserNameContainerID_UserNameLabell")
    WebElement userNameFieldByForgotPage;

    @FindBy(id = "MainContent_PasswordRecovery_UserNameContainerID_lbl")
    WebElement  forgotPasswordPage;

    @FindBy(id = "MainContent_LoginUser_Password")
    WebElement passwordField;

    //buttons
    @FindBy(id = "MainContent_LoginUser_RegisterHyperLink")
    WebElement goToRegistration;

    @FindBy(id = "MainContent_PasswordRecovery_UserNameContainerID_SubmitButton")
    WebElement recoveryPasswordButton;

    @FindBy(id = "MainContent_LoginUser_LoginButton")
    WebElement loginButton;

    //*[@class='forgot']
    @FindBy(xpath = "//*[@class='forgot']")
    WebElement forgoPassLink;

    //alert
    @FindBy(xpath = "//*[@id='MainContent_LoginUser_LoginUserValidationSummary']/ul/li[1][contains(text(),'שם משתמש חובה')]")
    WebElement wrongUserName;

    @FindBy(xpath = "//*[@id='MainContent_LoginUser_LoginUserValidationSummary']/ul/li[2][contains(text(),'סיסמא חובה')]")
    WebElement wrongPassword;

    //public ProfilePage profilePage;

    public LoginVadymPage(WebDriver driver) {
        super(driver);
        this.PAGE_URL = "http://dhclinicappv2stg.item-soft.co.il/Login.aspx";
        PageFactory.initElements(driver, this);
    }

    public LoginVadymPage openLoginPage(WebDriver driver) {
        driver.get(PAGE_URL);
        return this;
    }

//Fill the fileds

    public LoginVadymPage fillUsernameField(String username) {
        setElementText(userNameField, username);
        return this;
    }

    public LoginVadymPage fillUsernameFieldByForgotPage (String username) {
        setElementText(userNameFieldByForgotPage, username);
        return this;
    }

    public LoginVadymPage fillPasswordField(String password) {
        setElementText(passwordField, password);
        // Log.info("entering password from the list: " + password + " ");
        return this;
    }

    public LoginVadymPage login (String username, String password) {
        openLoginPage(driver);
        waitUntilLoginPageIsLoaded();
        fillUsernameField(username);
        fillPasswordField(password);
        clickOnLoginButton();
        return  this;
    }

    public LoginVadymPage waitUntilLoginPageIsLoaded() {
        try {
            waitUntilElementIsLoaded(loginButton);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }

    public void clickOnLoginButton() {
        clickElement(loginButton);

    }

    public void clickOnRecoveryPasswordButton() {
        clickElement(recoveryPasswordButton);

    }

    public void openRegistrationPage() {
        clickElement(goToRegistration);
    }

    public void openForgotPage() {
        clickElement(forgoPassLink);
    }

    public boolean isOnLoginPage() {
        return exists(loginButton);
    }

    public boolean isOnForgotPasswordPage() {
        return exists(forgotPasswordPage);
    }

    //check alert presence

    public boolean alertMessageNotValidUserName() {
        return exists(wrongUserName);
    }

    public boolean alertMessageNotValidFirsrName() {
        return exists(wrongPassword);
    }



}
