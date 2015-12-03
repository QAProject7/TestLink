package com.telran.pages;

import com.telran.TestNgTestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

/**
 * Created by Maksim
 */
public class LoginMaksimPage extends Page {

    @FindBy(id = "MainContent_LoginUser_UserName")
    WebElement usernameField;

    @FindBy(id = "MainContent_LoginUser_Password")
    WebElement passwordField;

    @FindBy(xpath = "//a[@class='forgot']")
    WebElement forgotPassLink;

    @FindBy(id = "MainContent_LoginUser_RegisterHyperLink")
    WebElement goToRegLink;

    @FindBy(id = "MainContent_LoginUser_LoginButton")
    WebElement loginBtn;

    @FindBy(xpath = "//span[@class='failureNotification']")
    WebElement unregisteredUserAlert;

    @FindBy(xpath = "//div[@id='MainContent_LoginUser_LoginUserValidationSummary']//li[contains(text(), 'שם משתמש חובה')]")
    WebElement wrongUserNameAlert;

    @FindBy(xpath = "//div[@id='MainContent_LoginUser_LoginUserValidationSummary']//li[contains(text(), 'סיסמא חובה.')]")
    WebElement wrongPasswordAlert;

    public LoginMaksimPage(WebDriver driver) {
        super(driver);
        this.PAGE_URL = TestNgTestBase.baseUrl + "/Login.aspx";
        this.PAGE_TITLE = "Log In";
        PageFactory.initElements(driver, this);
    }

    public LoginMaksimPage openLoginPage(WebDriver driver) {
        driver.get(PAGE_URL);
        return this;
    }

    //Fill the fileds
    public LoginMaksimPage fillUsernameField(String username) {
        setElementText(usernameField, username);
        // Log.info("entering username: " + username + " ");
        return this;
    }

    public LoginMaksimPage fillPasswordField(String password) {
        setElementText(passwordField, password);
        // Log.info("entering password: " + password + " ");
        return this;
    }

    public LoginMaksimPage waitUntilLoginPageIsLoaded() {
        try {
            waitUntilElementIsLoaded(loginBtn);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }

    public void openForgotPasswordPage() {
        clickElement(forgotPassLink);
    }

    public void openRegistrationPage() {
        clickElement(goToRegLink);
    }

    public void clickOnLoginButton() {
        clickElement(loginBtn);
    }

    public boolean alertMessageUnregisteredUser() {
        return exists(unregisteredUserAlert);
    }

    public boolean alertMessageNotValidUserName() {
        return exists(wrongUserNameAlert);
    }

    public boolean alertMessageNotValidPassword() {
        return exists(wrongPasswordAlert);
    }

    public boolean isPageOpened() {
        return exists(loginBtn);
    }
}
