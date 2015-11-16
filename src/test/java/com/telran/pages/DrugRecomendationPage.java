package com.telran.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

/**
 * Created by
 */
public class DrugRecomendationPage extends Page {

    //private static Logger Log = Logger.getLogger(LogLog4j.class.getName());
    //fields

    //input [@id="ctl00_MainContent_ctl10_RadTreeList1_ctl03_ExpandCollapseButton" ]
    @FindBy(id = "ctl00_MainContent_ctl10_RadTreeList1_ctl03_ExpandCollapseButton")
    WebElement expandCollapseButton;

    @FindBy(xpath = "//tr[@id='ctl00_MainContent_ctl10_RadTreeList1_ctl08__6']//*[contains(text(),('ערוך'))]")
    WebElement groupLastAddLink;

    @FindBy(id = "ctl00_MainContent_ctl10_RadTreeList1_ctl08_TxtPlan")
    WebElement groupLastTextInput;

    @FindBy(id = "ctl00_MainContent_ctl10_RadTreeList1_ctl08_Add")
    WebElement commitWebLink;



    /*@FindBy(xpath = "//div [id='ctl00_MainContent_ctl10_RadTreeList1_ctl02_RLB_Answers']//input")
    WebElement group1_checkAll;

    @FindBy(xpath = "//li[id='ctl00_MainContent_ctl10_RadTreeList1_ctl02_RLB_Answers_i0']//input")
    WebElement passwordField;


    @FindBy(id = "ctl00_MainContent_ctl10_RadTreeList1_ctl03_TxtPlan")
    WebElement group2_textArea;

    @FindBy(id = "ctl00_MainContent_ctl10_RadTreeList1_ctl03_Add")
    WebElement group2_link_add;

    @FindBy(id = "ctl00_MainContent_ctl10_RadTreeList1_ctl04_TxtPlan")
    WebElement group3_textArea;

    @FindBy(id = "ctl00_MainContent_ctl10_RadTreeList1_ctl04_Add")
    WebElement group3_link_add;


    //Alerts
    @FindBy(xpath = "/*//*[@id='MainContent_LoginUser_LoginUserValidationSummary']/ul/li[contains(text(),('שם משתמש חובה'))]")
    WebElement wrongUserNameAlert;

    @FindBy(xpath = "/*//*[@id='MainContent_LoginUser_LoginUserValidationSummary']/ul/li[contains(text(),('סיסמא חובה.'))]")
    WebElement wrongPasswordAlert;*/


    public DrugRecomendationPage(WebDriver driver) {
        super(driver);
        this.PAGE_URL = "http://dhclinicappv2stg.item-soft.co.il/Login.aspx";
        PageFactory.initElements(driver, this);
    }

    //public ProfilePage profilePage;
    public DrugRecomendationPage pressExpandElement() {
        expandCollapseButton.click();
        //System.out.println("test page loaded successfully");
        return this;
    }

    public DrugRecomendationPage pressAddLink() {
        groupLastAddLink.click();
        return this;
    }

    public DrugRecomendationPage fillTextField(String text) {
        setElementText(groupLastTextInput, text);
        return this;
    }

    public DrugRecomendationPage pressCommitAddLink() {
        commitWebLink.click();
        return this;
    }

    public DrugRecomendationPage waitUntilTestPageIsLoaded() {
        try {
            waitUntilElementIsLoaded(groupLastAddLink);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("test page IOException");
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("test page interrupted exception");
        }
        System.out.println("test page loaded successfully");
        return this;
    }

    public DrugRecomendationPage openLoginPage(WebDriver driver) {
        driver.get(PAGE_URL);
        return this;
    }


    //check alert presence

//    public boolean alertMessageNotValidUserName() {
//        return exists(wrongUserNameAlert);
//    }
//
//    public boolean alertMessageNotValidFirsrName() {
//        return exists(wrongPasswordAlert);
//    }

}
