package com.telran.Training;

import com.telran.LogLog4j;
import com.telran.pages.Page;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

/**
 * Created by Iakov Volf,Oleg
 */
public class LoginIrinaPage extends Page {
    private static Logger Log = Logger.getLogger(LogLog4j.class.getName());
    @FindBy(id = "MainContent_LoginUser_Password")
    WebElement passwordField;
    @FindBy(id = "MainContent_LoginUser_RegisterHyperLink")  //zor meshtamesh
    WebElement goToRegLink;
    @FindBy(id = "MainContent_LoginUser_LoginButton")
    WebElement loginButton;
    @FindBy(id = "MainContent_LoginUser_UserName")
    private WebElement usernameField;
    //buttons
    @FindBy(xpath = "//a[@class='forgot']")
    private WebElement forgotPassLink;
    //alerts    //System messages

    @FindBy (xpath = "//div[@id='MainContent_LoginUser_LoginUserValidationSummary']/ul/li[contains(text(),'שם משתמש חובה')]")
    private WebElement wrongUsernameAlert;

    @FindBy(xpath = "//div[@id='MainContent_LoginUser_LoginUserValidationSummary']/ul/li[contains(text(),'סיסמא חובה.')]")
    private WebElement wrongPasswordAlert;


    //todo use URL from propretyloader instead of hardcpded address
    public LoginIrinaPage(WebDriver driver) {
        super(driver);
        //  this.PAGE_URL = "http://dhclinicappv2stgclalitinternal.item-soft.co.il/";
        PageFactory.initElements(driver, this);
    }

    public LoginIrinaPage openLoginPage(WebDriver driver) {
        driver.get(PAGE_URL);
        return this;
    }

    public LoginIrinaPage login(String username, String password) {
        openLoginPage(driver);
        waitUntilLoginPageIsLoaded();
        fillUsernameField(username);
        fillPasswordField(password);
        clickOnLoginButton();
        return this;
    }
//Fill the fileds

    public LoginIrinaPage fillUsernameField(String username) {
        setElementText(usernameField, username);
        Log.info("UserName was incerted");
        return this;
    }

    public LoginIrinaPage fillPasswordField(String password) {
        setElementText(passwordField, password);
        Log.info("entering password from the list: " + password + " ");
        return this;
    }


    public LoginIrinaPage waitUntilLoginPageIsLoaded() {
        try {
            waitUntilElementIsLoaded(loginButton);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Log.info("LoginPage was Loaded");
        return this;
    }

    public void clickOnLoginButton() {
        clickElement(loginButton);
        Log.info("Login button was pushed");
    }

    public void openRegistrationPage() {
        clickElement(goToRegLink);
        Log.info("RegistrationPage was opened");
    }

    public void openForgotPassPage() {
        clickElement(forgotPassLink);

    }

    public boolean isOnLoginPage() {

        return exists(loginButton);
    }

    //check alert presence

    public boolean alertMessageNotValidUsername() {

        return exists(wrongUsernameAlert);
    }
    //div[@id='MainContent_LoginUser_LoginUserValidationSummary']/ul/li[1]

    public boolean alertMessageNotValidPassword() {
        return exists(wrongPasswordAlert);
    }

}
