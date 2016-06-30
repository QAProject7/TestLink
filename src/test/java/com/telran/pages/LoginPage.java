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
public class LoginPage extends Page {
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

    @FindBy(id = "MainContent_LoginUser_LoginButton")
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

    @FindBy(xpath = "//span[@class='failureNotification']")
    WebElement unregisteredUserAlert;

    @FindBy(xpath = "//div[@id='MainContent_LoginUser_LoginUserValidationSummary']//li[contains(text(), 'שם משתמש חובה')]")
    WebElement wrongUserNameAlert;

    @FindBy(xpath = "//div[@id='MainContent_LoginUser_LoginUserValidationSummary']//li[contains(text(), 'סיסמא חובה.')]")
    WebElement wrongPasswordAlert;

    @FindBy(xpath = "//*[contains(text(), 'ניסיון ההתחברות שלך לא הצליח. אנא נסה שוב')]")
    WebElement loginUnsuccessfulAlert;

    public LoginPage(WebDriver driver) {
        super(driver);
        this.PAGE_URL = baseUrl;
        PageFactory.initElements(driver, this);
    }

    public LoginPage openLoginPage() {
        Log.info("Opening Login page");
        driver.get(PAGE_URL);
        return this;
    }

    //Fill the fields
    public LoginPage fillUsernameField(String username) {
        Log.info("Filling username field");
        setElementText(usernameField, username);
        return this;
    }

    public LoginPage fillPasswordField(String password) {
        Log.info("Filling password field");
        setElementText(passwordField, password);
        // Log.info("entering password from the list: " + password + " ");
        return this;
    }

    public LoginPage clickOnTermsCheckbox() {
        Log.info("Clicking on terms ofCheckBox");
        clickElement(termsCheckBox);
        return this;
    }


    public LoginPage waitUntilRegPageIsLoaded() throws IOException, InterruptedException {
            Log.info("Waiting for the Reg page is loaded");
            waitUntilElementIsLoaded(loginButton);
        return this;
    }

    public LoginPage waitUntilNextPageIsLoaded() throws IOException, InterruptedException {
            waitUntilElementIsLoaded(nextButton);
        return this;
    }

    public LoginPage waitUntinLogOutButtomIsLoaded() throws IOException, InterruptedException {
            waitUntilElementIsLoaded(logOutButton);
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

    public void openRegistrationPage() throws IOException, InterruptedException {
        waitUntilLoginPageIsLoaded();
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

    public void login(String username, String password) throws IOException, InterruptedException {
        waitUntilLoginPageIsLoaded();
        fillUsernameField(username);
        fillPasswordField(password);
        clickOnLoginButton();
    }

    //check alert presence




    public void clickOnNextButton() {
        clickElement(nextButton);
    }

    public LoginPage waitUntilLoginPageIsLoaded() throws IOException, InterruptedException {
            Thread.sleep(2000);
            waitUntilElementIsLoaded(loginButton);
        return this;
    }
    public boolean alertMessageUnregisteredUser() {
        return exists(unregisteredUserAlert);
    }

    public boolean alertMessageNotValidUserName() {
        return exists(wrongUserNameAlert);
    }

    public boolean isLoginUnsuccessfulAlertMessageDisplayed() {
        return exists(loginUnsuccessfulAlert);
    }

    public boolean alertMessageNotValidPassword() {
        return exists(wrongPasswordAlert);
    }

    public boolean isPageOpened() {
        return exists(loginButton);
    }

    public void clickLogOut() throws IOException, InterruptedException {
        waitUntilElementIsLoaded(logOutButton);
        logOutButton.click();
        Log.info("Clicking on 'Log Out' button");

    }
}