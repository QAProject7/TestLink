package com.telran.pages.TelRan7;

import com.telran.pages.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


/**
 * Created by
 */
public class IakovLoginPage extends Page {
    // private static Logger Log = Logger.getLogger(LogLog4j.class.getName());


    //fields
    @FindBy(id = "MainContent_LoginUser_UserName")
    WebElement usernameField;

    @FindBy(id = "MainContent_LoginUser_Password")
    WebElement passwordField;

    @FindBy(id = "MainContent_LoginUser_LoginButton")
    WebElement LoginButton;


    public IakovLoginPage(WebDriver driver) {
        super(driver);
        this.PAGE_URL = "http://dhclinicappv2stg.item-soft.co.il/Login.aspx";
        PageFactory.initElements(driver, this);
    }


    //check alert presence
//methods
    public void FillUsername(String username) {
        setElementText(usernameField, username);
    }

    public void FillPassword(String password) {
        setElementText(passwordField, password);
    }

    public void ClickOnLogin() {
        clickElement(LoginButton);
    }

    public void WaitUntilLoginPageIsLoaded() {
        waitUntilIsLoadedCustomTime(LoginButton, 10);
    }

    public void Login(String username, String password) {
        WaitUntilLoginPageIsLoaded();
        FillUsername(username);
        FillPassword(password);
        ClickOnLogin();
    }

}