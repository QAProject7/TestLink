package com.telran.pages.TelRan7;

import com.telran.pages.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by user on 22.11.2016.
 */
public class VinokurLoginPage2211 extends Page {

    @Findby (id="MainContent_LoginUser_RegisterHyperLink")
    WebElement buttonDoctorRegistration;

    @Findby (id="MainContent_RegisterUser_CreateUserStepContainer_UserName")
    WebElement userName;

    @Findby (id="MainContent_RegisterUser_CreateUserStepContainer_firstNameTxt")
    WebElement firstNameTxt;

    @Findby (id="MainContent_RegisterUser_CreateUserStepContainer_lastNameTxt")
    WebElement lastNameTxt;

    @Findby (id="MainContent_RegisterUser_CreateUserStepContainer_Email")
    WebElement email;

    @Findby (id="MainContent_RegisterUser_CreateUserStepContainer_ConfirmPassword")
    WebElement confirmPassword;

//


    public VinokurLoginPage2211(WebDriver driver) {
        super(driver);
        this.PAGE_URL = "http://dhclinicappv2stg.item-soft.co.il/Login.aspx";
        PageFactory.initElements(driver, this);
    }

    // methods
    public void LoginRun(){
        clickElement(buttonDoctorRegistration);
    }



}
