package com.telran.pages.TelRan7;

import com.telran.pages.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Napris on 23.11.2016.
 */
public class NaprisLoginPage extends Page {
    //fields
    @FindBy(id = "MainContent_LoginUser_UserName")
    WebElement usernameField;

    @FindBy(id = "MainContent_LoginUser_Password")
    WebElement passwordField;

    //buttons
    @FindBy(id = "MainContent_LoginUser_LoginButton")
    WebElement loginButton;

    //constructor
    public NaprisLoginPage(WebDriver driver) {
        super(driver);
        this.PAGE_URL = "http://dhclinicappv2stg.item-soft.co.il/Login.aspx";
        PageFactory.initElements(driver, this);
    }

    //methods
    public void fillUserName(String username) {
        setElementText(usernameField, username);
    }

    public void fillPassword(String password) {
        setElementText(passwordField, password);
    }

    public void clickOnLogin() {
        clickElement(loginButton);
    }

    public void waitUntilLoginPageIsLoaded() {
        waitUntilIsLoadedCustomTime(loginButton, 10);
    }

    public void login(String username, String password) {
        waitUntilLoginPageIsLoaded();
        fillUserName(username);
        fillPassword(password);
        clickOnLogin();
    }
}
