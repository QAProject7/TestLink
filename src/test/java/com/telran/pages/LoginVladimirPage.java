package com.telran.pages;

import com.telran.LogLog4j;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

/**
 * Created by Vladimir, Iakov Volf
 */
public class LoginVladimirPage extends Page {
    private static Logger Log = Logger.getLogger(LogLog4j.class.getName());


    //fields
    @FindBy(id = "MainContent_LoginUser_UserName")
    WebElement usernameField;

    @FindBy(id = "MainContent_ChangeUserPassword_ChangePasswordContainerID_CancelPushButton")
    WebElement cancelChangePasswordButton;

    @FindBy(id = "MainContent_LoginUser_Password")
    WebElement passwordField;

    //buttons
    @FindBy(id = "MainContent_LoginUser_LoginButton")
    WebElement loginButton;

    @FindBy(id = "MainContent_LoginUser_RegisterHyperLink")
    WebElement goToRegLink;

    @FindBy(xpath = "//a[@class='forgot']")
    WebElement forgotPassLink;

    @FindBy(id = "MainContent_RptNotification_NowBtn1_2")
    WebElement nextButton;

    @FindBy(id = "submit")
    WebElement submitButton;

    @FindBy(id = "Top1_HeadLoginStatus")
    WebElement logOutButton;

    @FindBy(id = "MainContent_LoginUser_CBAgreeToTerms")
    WebElement termsCheckBox;

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
        this.PAGE_URL = baseUrl;
        PageFactory.initElements(driver, this);
    }

    public LoginVladimirPage openLoginPage(WebDriver driver) {
        Log.info("Opening Login page");
        driver.get(PAGE_URL);
        return this;
    }

    //Fill the fields
    public LoginVladimirPage fillUsernameField(String username) {
        Log.info("Filling username field");
        setElementText(usernameField, username);
        return this;
    }

    public LoginVladimirPage fillPasswordField(String password) {
        Log.info("Filling password field");
        setElementText(passwordField, password);
        // Log.info("entering password from the list: " + password + " ");
        return this;
    }

    public LoginVladimirPage clickOnTermsCheckbox() {
        clickElement(termsCheckBox);
        return this;
    }
    public LoginVladimirPage waitUntilRegPageIsLoaded() {
        try {
            Log.info("Waiting for the Reg page is loaded");
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
        Log.info("Clicking on Login button");
        clickElement(loginButton);
    }

    public void clickOnCancelChangePassword() {
        Log.info("Clicking on 'Cancel change password' button");
        clickElement(cancelChangePasswordButton);
    }

    public void openRegistrationPage() {
        Log.info("CLicking the 'Register' button");
        clickElement(goToRegLink);
    }

    public boolean isOnLoginPage() {
        Log.info("Checking if we are on Login page");
        return exists(loginButton);
    }

    public void openForgotPasswordPage() {
        clickElement(forgotPassLink);
    }

    public void login(String username, String password) {
        waitUntilLoginPageIsLoaded();
        fillUsernameField(username);
        fillPasswordField(password);
        clickOnTermsCheckbox();
        clickOnLoginButton();
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

    public LoginVladimirPage waitUntilLoginPageIsLoaded() {
        try {
            waitUntilElementIsLoaded(submitButton);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }

    public void clickLogOut() {
        Log.info("Clicking on 'Log Out' button");
        logOutButton.click();
    }
}