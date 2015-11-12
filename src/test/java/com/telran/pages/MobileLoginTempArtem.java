package com.telran.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

/**
 * Created by Artem
 */
public class MobileLoginTempArtem extends Page {

    //private static Logger Log = Logger.getLogger(LogLog4j.class.getName());
    //fields

    @FindBy(xpath = "//*[contains(text(),'ההתחברות נכשלה נא נסה שנית')]")
    WebElement loginFailedAlert;

    @FindBy(xpath = "//*[contains(text(),'נא להזין את כל השדות')]")
    WebElement enterAllFieldsAlert;

    @FindBy(xpath = "//*[contains(text(),'נא אשר את תנאי השימוש')]")
    WebElement confirmTermOfUseAlert;

    @FindBy(id = "name")
    WebElement nameField;

    @FindBy(id = "password")
    WebElement passwordField;

    @FindBy(id = "AgreeToTerms")
    WebElement agreeToTermsChecker;

    @FindBy(id = "loginBtn")
    WebElement loginButton;


    //public ProfilePage profilePage;

    public MobileLoginTempArtem(WebDriver driver) {
        super(driver);
        this.PAGE_URL = "http://dhclinicamobileppstg.item-soft.co.il/index.htm";
        PageFactory.initElements(driver, this);
    }


    public MobileLoginTempArtem openMobileLoginTempArtemPage(WebDriver driver) {
        driver.get(PAGE_URL);
        return this;
    }

//Fill the fileds



    public MobileLoginTempArtem fillNameField(String name) {
        setElementText(nameField, name);
        // Log.info("entering password from the list: " + password + " ");
        return this;
    }


    public MobileLoginTempArtem fillPasswordField(String password) {
        setElementText(passwordField, password);
        return this;
    }




    public MobileLoginTempArtem waitUntilLoginPageIsLoaded() {
        try {
            waitUntilElementIsLoaded(loginButton);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }

    public void clickOnAgreeToTermsChecker() {
        clickElement(agreeToTermsChecker);

    }

    public void clickOnLoginButton() {
        clickElement(loginButton);

    }




    public boolean isOnRegistrationPage() {
        return exists(loginButton);
    }

    //check alert presence

    public boolean alertMessageFailedLogin() {
        return exists(loginFailedAlert);
    }


    public boolean alertMessageEnterAllFields() {
        return exists(enterAllFieldsAlert);
    }

    public boolean alertMessageConfirmTermOfUse() {
        return exists(confirmTermOfUseAlert);
    }


}
