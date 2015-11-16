package com.telran.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class MobileForLoginPageVadym extends Page {
    @FindBy(id = "name")
    WebElement userNameField;

    @FindBy(id = "password")
    WebElement passwordField;

    @FindBy(id = "loginBtn")
    WebElement loginButton;

    @FindBy(id = "AgreeToTerms")
    WebElement agreeCheckBox;

    public MobileForLoginPageVadym(WebDriver driver) {
        super(driver);
        this.PAGE_URL = "http://dhclinicamobileppstg.item-soft.co.il/index.htm";
        PageFactory.initElements(driver, this);
    }

    public MobileForLoginPageVadym openLoginPage(WebDriver driver) {
        driver.get(PAGE_URL);
        return this;
    }
    public MobileForLoginPageVadym fillUsernameField(String username) {
        setElementText(userNameField, username);
        return this;
    }

    public MobileForLoginPageVadym fillPasswordField(String password) {
        setElementText(passwordField, password);
        return this;
    }
    public MobileForLoginPageVadym waitUntilLoginPageIsLoaded() {
        try {
            waitUntilElementIsLoaded(loginButton);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }
    public MobileForLoginPageVadym clickOnAgreeToTerms (){
        clickElement(agreeCheckBox);
        return this;
    }
    public MobileForLoginPageVadym clickOnLogin (){
        clickElement(loginButton);
        return this;
    }
    public boolean isOnLoginPage(){
        return exists(loginButton);
    }

}
