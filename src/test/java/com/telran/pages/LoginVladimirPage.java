package com.telran.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

/**
 * Created by Vladimir, Iakov Volf
 */
public class LoginVladimirPage extends Page {

    //private static Logger Log = Logger.getLogger(LogLog4j.class.getName());
    //fields
    @FindBy(id = "MainContent_LoginUser_UserName")
    WebElement usernameField;

    @FindBy(id = "MainContent_LoginUser_Password")
    WebElement passwordField;

    //buttons
    @FindBy(id = "MainContent_LoginUser_LoginButton")
    WebElement loginButton;

    @FindBy(id = "MainContent_LoginUser_RegisterHyperLink")
    WebElement goToRegLink;

    @FindBy(xpath = "//a[@class='forgot']")
    WebElement forgotPassLink;

    @FindBy(id = "MainContent_RptNotification_NowBtn1_1")
    WebElement nextButton;

    @FindBy(id = "submit")
    WebElement submitButton;

    //checkboxs
    //Select
    //Alerts
    @FindBy(xpath = "//*[@id='MainContent_LoginUser_LoginUserValidationSummary']//li[contains(text(),'שם משתמש חובה')]")
    WebElement nameAlert;

    @FindBy(xpath = "//*[@id='MainContent_LoginUser_LoginUserValidationSummary']//li[contains(text(),'סיסמא חובה.')]")
    WebElement lastNameAlert;

    //public ProfilePage profilePage;

    public LoginVladimirPage(WebDriver driver) {
        super(driver);
        this.PAGE_URL = "http://dhclinicappv2stg.item-soft.co.il/SitePages/createUser.aspx?ReturnUrl=HomePage";
        PageFactory.initElements(driver, this);
    }

    public LoginVladimirPage openLoginPage(WebDriver driver) {
        driver.get(PAGE_URL);
        return this;
    }

    //Fill the fileds
    public LoginVladimirPage fillUsernameField(String username) {
        setElementText(usernameField, username);
        return this;
    }

    public LoginVladimirPage fillPasswordField(String password) {
        setElementText(passwordField, password);
        // Log.info("entering password from the list: " + password + " ");
        return this;
    }

    public LoginVladimirPage waitUntilRegPageIsLoaded() {
        try {
            waitUntilElementIsLoaded(loginButton);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }

    public LoginVladimirPage waitUntilNextPageIsLoaded() {
        try {
            waitUntilElementIsLoaded(nextButton);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }
    public void clickOnForgotPassLink() {
        clickElement(forgotPassLink);
    }

    public void clickOnLoginButton() {
        clickElement(loginButton);
    }

    public void openRegistrationPage() {
        clickElement(goToRegLink);
    }

    public boolean isOnLoginPage() {
        return exists(loginButton);
    }

    public void openForgotPasswordPage() {
        clickElement(forgotPassLink);
    }

    //check alert presence

    public boolean alertMessageNotValidUserName() {
        return exists(nameAlert);
    }

    public boolean alertMessageNotValidPassword() {
        return exists(lastNameAlert);
    }

    public void clickOnNextButton() {
        clickElement(nextButton);
    }

    public LoginVladimirPage waitUntilTestPageIsLoaded() {
        try {
            waitUntilElementIsLoaded(submitButton);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }
}