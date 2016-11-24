package com.telran.pages.TelRan7.vitaliy;

import com.telran.pages.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


/**
 * Created by Vitaliy
 */
public class LoginPage extends Page {
    // private static Logger Log = Logger.getLogger(LogLog4j.class.getName());


    //fields
    @FindBy(id = "MainContent_LoginUser_UserName")
    WebElement usernameField;

    @FindBy(id = "MainContent_LoginUser_Password")
    WebElement passwordField;

    @FindBy(id = "MainContent_LoginUser_LoginButton")
    WebElement LoginButton;





    //check alert presence

    //methods
    public LoginPage(WebDriver driver) {
        super(driver);
        this.PAGE_URL = "http://dhclinicappv2stg.item-soft.co.il/Login.aspx";
        PageFactory.initElements(driver, this);
    }
    public void FillUserName() {
        setElementText(usernameField, "Login");
    }

    public void FillPassword() {
        setElementText(passwordField, "password");
    }

    public void ClickLogIn() {
        clickElement(LoginButton);
    }

    public void WaitUntilLoginPageIsLoaded() {
        waitUntilIsLoadedCustomTime(LoginButton, 10);
    }

    public void Login() {
        WaitUntilLoginPageIsLoaded();
        FillUserName();
        FillPassword();
        ClickLogIn();
    }
}