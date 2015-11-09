package com.telran.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

/**
 * Created by Iakov Volf
 */
public class TeacherTestPage extends Page {

    //private static Logger Log = Logger.getLogger(LogLog4j.class.getName());
    //fields
    @FindBy(id = "MainContent_LoginUser_UserName")
    WebElement usernameField;

    @FindBy(id = "MainContent_LoginUser_Password")
    WebElement passwordField;

    @FindBy(id = "MainContent_LoginUser_RegisterHyperLink")
    WebElement goToRegLink;

    @FindBy(id = "MainContent_LoginUser_LoginButton")
    WebElement loginButton;

    @FindBy(xpath = "//a[@class='forgot']")
    WebElement forgotPassLink;

    //Alerts
    @FindBy(xpath = "//*[@id='MainContent_LoginUser_LoginUserValidationSummary']/ul/li[contains(text(),('שם משתמש חובה'))]")
    WebElement wrongUserNameAlert;

    @FindBy(xpath = "//*[@id='MainContent_LoginUser_LoginUserValidationSummary']/ul/li[contains(text(),('סיסמא חובה.'))]")
    WebElement wrongPasswordAlert;


    //public ProfilePage profilePage;

    public TeacherTestPage(WebDriver driver) {
        super(driver);
        this.PAGE_URL = "http://dhclinicappv2stg.item-soft.co.il/Login.aspx";
        PageFactory.initElements(driver, this);
    }


    public TeacherTestPage openLoginPage(WebDriver driver) {
        driver.get(PAGE_URL);
        return this;
    }

//Fill the fileds

    public TeacherTestPage fillUsernameField(String username) {
        setElementText(usernameField, username);
        return this;
    }


    public TeacherTestPage fillPasswordField(String password) {
        setElementText(passwordField, password);
        // Log.info("entering password from the list: " + password + " ");
        return this;
    }


    public TeacherTestPage waitUntilLoginPageIsLoaded() {
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

    public void openRegistrationPage() {
        clickElement(goToRegLink);

    }


    public void openForgotPassPage() {
        clickElement(forgotPassLink);

    }

    public boolean isOnLoginPage() {
        return exists(loginButton);
    }


    //check alert presence

    public boolean alertMessageNotValidUserName() {
        return exists(wrongUserNameAlert);
    }

    public boolean alertMessageNotValidFirsrName() {
        return exists(wrongPasswordAlert);
    }

}
