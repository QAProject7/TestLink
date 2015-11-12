package com.telran.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

/**
 * Created by Artem
 */
public class MobileChangePasswordArtem extends Page {

    //private static Logger Log = Logger.getLogger(LogLog4j.class.getName());
    //fields

    @FindBy(xpath = "//*[@class='statusLogin'][contains(text(),'ההתחברות נכשלה נא נסה שנית')]")
    WebElement loginFailedAlert;

    @FindBy(id = "OldPassword")
    WebElement oldPasswordField;

    @FindBy(id = "NewPassword")
    WebElement newPasswordField;

    @FindBy(id = "ConfirmNewPassword")
    WebElement confirmNewPasswordField;

    @FindBy(id = "CancelChangePassword")
    WebElement CancelChangePasswordButton;

    @FindBy(id = "OkChangePassword")
    WebElement OkChangePasswordButton;



    //public ProfilePage profilePage;

    public MobileChangePasswordArtem(WebDriver driver) {
        super(driver);
        this.PAGE_URL = "http://dhclinicamobileppstg.item-soft.co.il/index.htm";
        PageFactory.initElements(driver, this);
    }


    public MobileChangePasswordArtem openChangePasswordPage(WebDriver driver) {
        driver.get(PAGE_URL);
        return this;
    }

//Fill the fileds



    public MobileChangePasswordArtem fillOldPasswordField(String oldPass) {
        setElementText(oldPasswordField, oldPass);
        // Log.info("entering password from the list: " + password + " ");
        return this;
    }


    public MobileChangePasswordArtem fillNewPasswordField(String newPass) {
        setElementText(newPasswordField, newPass);
        return this;
    }

    public MobileChangePasswordArtem fillConfirmNewPasswordField(String newPass) {
        setElementText(confirmNewPasswordField, newPass);
        return this;
    }



    public MobileChangePasswordArtem waitUntilLoginPageIsLoaded() {
        try {
            waitUntilElementIsLoaded(CancelChangePasswordButton);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }

    public void clickOnCancelChangePasswordButton() {
        clickElement(CancelChangePasswordButton);

    }

    public void clickOnOkChangePasswordButton() {
        clickElement(CancelChangePasswordButton);

    }


    public boolean isOnRegistrationPage() {
        return exists(CancelChangePasswordButton);
    }

    //check alert presence

    public boolean alertMessageNotValidUserName() {
        return exists(loginFailedAlert);
    }


}
