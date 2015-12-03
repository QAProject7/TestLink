package com.telran.MobileWebPages;

import com.telran.pages.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

/**
 * Created by Leonid Gengrinovich
 */
public class MobileLoginPageLeonid extends Page {

    //private static Logger Log = Logger.getLogger(LogLog4j.class.getName());
    //fields
    @FindBy(id = "name")
    WebElement usernameField;

    @FindBy(id = "password")
    WebElement passwordField;

    @FindBy(id = "loginBtn")
    WebElement loginButton;

    @FindBy(id = "AgreeToTerms")
    WebElement agreeCheckBox;

    public MobileLoginPageLeonid(WebDriver driver) {
        super(driver);
        this.PAGE_URL = "http://dhclinicamobileppstg.item-soft.co.il/index.htm";
        PageFactory.initElements(driver, this);
    }


    public MobileLoginPageLeonid openLoginPage(WebDriver driver) {
        driver.get(PAGE_URL);
        return this;
    }

//Fill the fileds

    public MobileLoginPageLeonid fillUsernameField(String username) {
        setElementText(usernameField, username);
        return this;
    }


    public MobileLoginPageLeonid fillPasswordField(String password) {
        setElementText(passwordField, password);
        // Log.info("entering password from the list: " + password + " ");
        return this;
    }

// wait
    public MobileLoginPageLeonid waitUntilLoginPageIsLoaded() {
        try {
            waitUntilElementIsLoaded(loginButton);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }

// clicks
    public MobileLoginPageLeonid clickOnLoginButton() {
        clickElement(loginButton);
        return this;
    }

    public MobileLoginPageLeonid clickOnAgreeCheckBox() {
        clickElement(agreeCheckBox);
        return this;
    }

    public boolean isOnLoginPage() {
        return exists(loginButton);
    }
}
