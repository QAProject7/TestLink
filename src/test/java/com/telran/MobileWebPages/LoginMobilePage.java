package com.telran.MobileWebPages;

import com.telran.pages.Page;
import com.telran.util.LogLog4j;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

/**
 * Created by Iakov Volf
 */
public class LoginMobilePage extends Page {

    private static Logger Log = Logger.getLogger(LogLog4j.class.getName());
    //fields
    @FindBy(id = "name")
    WebElement usernameField;

    @FindBy(id = "password")
    WebElement passwordField;

    @FindBy(id = "loginBtn")
    WebElement loginButton;

    @FindBy(id = "AgreeToTerms")
    WebElement agreeCheckbox;

    //Alerts
    @FindBy(xpath = "//*[@id='MainContent_LoginUser_LoginUserValidationSummary']/ul/li[contains(text(),('שם משתמש חובה'))]")
    WebElement wrongUserNameAlert;

    @FindBy(xpath = "//*[@id='MainContent_LoginUser_LoginUserValidationSummary']/ul/li[contains(text(),('סיסמא חובה.'))]")
    WebElement wrongPasswordAlert;


    //public ProfilePage profilePage;

    public LoginMobilePage(WebDriver driver) {
        super(driver);
        this.PAGE_URL = "http://dhclinicamobileppstg.item-soft.co.il/index.htm";
        PageFactory.initElements(driver, this);
    }


    public LoginMobilePage openLoginPage(WebDriver driver) {
        driver.get(PAGE_URL);
        return this;
    }

//Fill the fileds

    public LoginMobilePage fillUsernameField(String username) {
        setElementText(usernameField, username);
        return this;
    }


    public LoginMobilePage fillPasswordField(String password) {
        setElementText(passwordField, password);
        // Log.info("entering password from the list: " + password + " ");
        return this;
    }


    public LoginMobilePage waitUntilLoginPageIsLoaded() {
        try {
            waitUntilElementIsLoaded(loginButton);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }

    public LoginMobilePage clickOnLoginButton() {
        clickElement(loginButton);
        return this;
    }

    public LoginMobilePage checkAgreeChebox() {
        clickElement(agreeCheckbox);
        return this;
    }

    public void loginOnMobilePage(String username, String pass) {
        openLoginPage(driver);
        waitUntilLoginPageIsLoaded();
        fillUsernameField(username);
        fillPasswordField(pass);
        checkAgreeChebox();
        clickOnLoginButton();
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
