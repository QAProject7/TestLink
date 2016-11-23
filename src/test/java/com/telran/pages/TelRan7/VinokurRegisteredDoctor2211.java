package com.telran.pages.TelRan7;


import com.telran.pages.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by user on 22.11.2016.
 */
public class VinokurRegisteredDoctor2211 extends Page {

    @FindBy(id="MainContent_LoginUser_RegisterHyperLink")
    WebElement buttonDoctorRegistration;

    @FindBy(id="MainContent_RegisterUser_CreateUserStepContainer_UserName")
    WebElement userName;
    @FindBy (id="MainContent_RegisterUser_CreateUserStepContainer_firstNameTxt")
    WebElement firstNameTxt;
    @FindBy (id="MainContent_RegisterUser_CreateUserStepContainer_lastNameTxt")
    WebElement lastNameTxt;
    @FindBy (id="MainContent_RegisterUser_CreateUserStepContainer_Email")
    WebElement email;
    @FindBy (id="MainContent_RegisterUser_CreateUserStepContainer_Password")
    WebElement password;
    @FindBy (id="MainContent_RegisterUser_CreateUserStepContainer_ConfirmPassword")
    WebElement confirmPassword;
    @FindBy (id="MainContent_RegisterUser_CreateUserStepContainer_PersonalIdTxt")
    WebElement PersonalIdTxt;
    @FindBy (id="MainContent_RegisterUser_CreateUserStepContainer_clinicNameTxt")
    WebElement clinicNameTxt;
    @FindBy (id="ctl00_MainContent_RegisterUser_CreateUserStepContainer_birthdayTxt_dateInput")
    WebElement birthdayTxt;
    @FindBy (id="ctl00_MainContent_RegisterUser_CreateUserStepContainer_ContactCellTxt")
    WebElement contactCellTxt;
    @FindBy (id="MainContent_RegisterUser_CreateUserStepContainer_AddressTxt")
    WebElement addressTxt;
    @FindBy (id="MainContent_RegisterUser_CreateUserStepContainer_HouseNumberTxt")
    WebElement houseNumberTxt;
    @FindBy (id="MainContent_RegisterUser_CreateUserStepContainer_CityTxt")
    WebElement cityTxt;

    @FindBy (id="MainContent_AddNewUser")
    WebElement addNewUser;

//  methods

    public void UserNameinput (){
        setElementText (userName, "Doctor1");}
    public void firstNameTxtinput (){
        setElementText (firstNameTxt, "Doctor1Name");}
    public void lastNameTxtinput (){
        setElementText (lastNameTxt, "Doctor1Family");}
    public void emailinput (){
        setElementText (email, "Doctor1@mail.ru");}
    public void lastNameTxtinput (){
        setElementText (userName, "Doctor1");}
    public void passwordinput (){
        setElementText (password, "Linkcare!!11");}
    public void confirmPasswordinput (){
        setElementText (confirmPassword, "Linkcare");}
    public void PersonalIdTxtinput (){
        setElementText (PersonalIdTxt, "085848356");}
    public void clinicNameTxtinput (){
        setElementText (clinicNameTxt, "Marshak");}
    public void birthdayTxtinput (){
        setDate  (birthdayTxt, "2001-11-11");
    }
    public void contactCellTxtinput (){
        setElementText (contactCellTxt, "0587909999");}
    public void addressTxtinput (){
        setElementText (addressTxt, "Rehov 1");}
    public void houseNumberTxtinput (){
        setElementText (houseNumberTxt, "33");}
    public void cityTxtinput (){
        setElementText (cityTxt, "City1");}

    public void RegisteredDocButton(){
        clickElement(addNewUser);
    }

    public VinokurRegisteredDoctor2211(WebDriver driver) {
        super(driver);
        this.PAGE_URL = "http://dhclinicappv2stg.item-soft.co.il/Login.aspx";
        PageFactory.initElements(driver, this);
    }




    // methods

    public void setElementText(WebElement element, String text) {
        element.click();
        element.clear();
        //Log.info("entering text '" + text + "' into element " + element);
        element.sendKeys(text);
        // Assert.assertEquals(element.getAttribute("value"), text);
    }

    public void clickElement(WebElement element) {
        // Log.info("clicking on element " + element + "");
        element.click();
    }

}
