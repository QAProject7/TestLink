package com.telran.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Iakov Volf,Oleg
 */
public class DrugRecommendationPage extends Page {

    //group 1
    @FindBy(xpath = "//div[@id='ctl00_MainContent_ctl10_RadTreeList1_ctl02_RLB_Answers']//input")
    private WebElement group1_checkAll;
    @FindBy(xpath = "//li[@id='ctl00_MainContent_ctl10_RadTreeList1_ctl02_RLB_Answers_i0']//input")
    private WebElement group1_check0;
    @FindBy(xpath = "//li[@id='ctl00_MainContent_ctl10_RadTreeList1_ctl02_RLB_Answers_i1']//input")
    private WebElement group1_check1;
    @FindBy(xpath = "//li[@id='ctl00_MainContent_ctl10_RadTreeList1_ctl02_RLB_Answers_i2']//input")
    private WebElement group1_check2;
    @FindBy(xpath = "//li[@id='ctl00_MainContent_ctl10_RadTreeList1_ctl02_RLB_Answers_i3']//input")
    private WebElement group1_check3;
    @FindBy(xpath = "//li[@id='ctl00_MainContent_ctl10_RadTreeList1_ctl02_RLB_Answers_i4']//input")
    private WebElement group1_check4;
    @FindBy(xpath = "//li[@id='ctl00_MainContent_ctl10_RadTreeList1_ctl02_RLB_Answers_i5']//input")
    private WebElement group1_check5;
    @FindBy(xpath = "//li[@id='ctl00_MainContent_ctl10_RadTreeList1_ctl02_RLB_Answers_i6']//input")
    private WebElement group1_check6;
    @FindBy(xpath = "//li[@id='ctl00_MainContent_ctl10_RadTreeList1_ctl02_RLB_Answers_i7']//input")
    private WebElement group1_check7;
    @FindBy(xpath = "//li[@id='ctl00_MainContent_ctl10_RadTreeList1_ctl02_RLB_Answers_i8']//input")
    private WebElement group1_check8;
    @FindBy(xpath = "//li[@id='ctl00_MainContent_ctl10_RadTreeList1_ctl02_RLB_Answers_i9']//input")
    private WebElement group1_check9;
    @FindBy(xpath = "//textarea[@id='ctl00_MainContent_ctl10_RadTreeList1_ctl02_TxtPlan']")
    private WebElement group1_textarea;
    @FindBy(xpath = "//a[@id='ctl00_MainContent_ctl10_RadTreeList1_ctl02_Add']")
    private WebElement group1_linkAdd;

    //group 2
    @FindBy(xpath = "//textarea[@id='ctl00_MainContent_ctl10_RadTreeList1_ctl03_TxtPlan']")
    private WebElement group2_textarea;
    @FindBy(xpath = "//a[@id='ctl00_MainContent_ctl10_RadTreeList1_ctl03_Add']")
    private WebElement group2_linkAdd;

    //group 3
    @FindBy(xpath = "//textarea[@id='ctl00_MainContent_ctl10_RadTreeList1_ctl04_TxtPlan']")
    private WebElement group3_textarea;
    @FindBy(xpath = "//a[@id='ctl00_MainContent_ctl10_RadTreeList1_ctl04_Add']")
    private WebElement group3_linkAdd;

    //group 4
    @FindBy(xpath = "//div[@id='ctl00_MainContent_ctl10_RadTreeList1_ctl04_RLB_Answers']//input[@class='rlbCheckAllItemsCheckBox']")
    private WebElement group4_checkAll;
    @FindBy(xpath = "//li[@id='ctl00_MainContent_ctl10_RadTreeList1_ctl04_RLB_Answers_i0']//input")
    private WebElement group4_check0;
    @FindBy(xpath = "//li[@id='ctl00_MainContent_ctl10_RadTreeList1_ctl04_RLB_Answers_i1']//input")
    private WebElement group4_check1;
    @FindBy(xpath = "//li[@id='ctl00_MainContent_ctl10_RadTreeList1_ctl04_RLB_Answers_i2']//input")
    private WebElement group4_check2;
    @FindBy(xpath = "//li[@id='ctl00_MainContent_ctl10_RadTreeList1_ctl04_RLB_Answers_i3']//input")
    private WebElement group4_check3;
    @FindBy(xpath = "//textarea[@id='ctl00_MainContent_ctl10_RadTreeList1_ctl04_TxtPlan']")
    private WebElement group4_textarea;
    @FindBy(xpath = "//a[@id='ctl00_MainContent_ctl10_RadTreeList1_ctl04_Add']")
    private WebElement group4_linkAdd;

    //group 5
    @FindBy(xpath = "//div[@id='ctl00_MainContent_ctl10_RadTreeList1_ctl05_RLB_Answers']//input[@class='rlbCheckAllItemsCheckBox']")
    private WebElement group5_checkAll;
    @FindBy(xpath = "//li[@id='ctl00_MainContent_ctl10_RadTreeList1_ctl05_RLB_Answers_i0']//input")
    private WebElement group5_check0;
    @FindBy(xpath = "//li[@id='ctl00_MainContent_ctl10_RadTreeList1_ctl05_RLB_Answers_i1']//input")
    private WebElement group5_check1;
    @FindBy(xpath = "//li[@id='ctl00_MainContent_ctl10_RadTreeList1_ctl05_RLB_Answers_i2']//input")
    private WebElement group5_check2;
    @FindBy(xpath = "//li[@id='ctl00_MainContent_ctl10_RadTreeList1_ctl05_RLB_Answers_i3']//input")
    private WebElement group5_check3;
    @FindBy(xpath = "//li[@id='ctl00_MainContent_ctl10_RadTreeList1_ctl05_RLB_Answers_i4']//input")
    private WebElement group5_check4;
    @FindBy(xpath = "//li[@id='ctl00_MainContent_ctl10_RadTreeList1_ctl05_RLB_Answers_i5']//input")
    private WebElement group5_check5;
    @FindBy(xpath = "//li[@id='ctl00_MainContent_ctl10_RadTreeList1_ctl05_RLB_Answers_i6']//input")
    private WebElement group5_check6;
    @FindBy(xpath = "//li[@id='ctl00_MainContent_ctl10_RadTreeList1_ctl05_RLB_Answers_i7']//input")
    private WebElement group5_check7;
    @FindBy(xpath = "//li[@id='ctl00_MainContent_ctl10_RadTreeList1_ctl05_RLB_Answers_i8']//input")
    private WebElement group5_check8;
    @FindBy(xpath = "//textarea[@id='ctl00_MainContent_ctl10_RadTreeList1_ctl05_TxtPlan']")
    private WebElement group5_textarea;
    @FindBy(xpath = "//a[@id='ctl00_MainContent_ctl10_RadTreeList1_ctl05_Add']")
    private WebElement group5_linkAdd;


    //group 6
    @FindBy(xpath = "//div[@id='ctl00_MainContent_ctl10_RadTreeList1_ctl06_RLB_Answers']//input[@class='rlbCheckAllItemsCheckBox']")
    private WebElement group6_checkAll;
    @FindBy(xpath = "//li[@id='ctl00_MainContent_ctl10_RadTreeList1_ctl06_RLB_Answers_i0']//input")
    private WebElement group6_check0;
    @FindBy(xpath = "//li[@id='ctl00_MainContent_ctl10_RadTreeList1_ctl06_RLB_Answers_i1']//input")
    private WebElement group6_check1;
    @FindBy(xpath = "//li[@id='ctl00_MainContent_ctl10_RadTreeList1_ctl06_RLB_Answers_i2']//input")
    private WebElement group6_check2;
    @FindBy(xpath = "//li[@id='ctl00_MainContent_ctl10_RadTreeList1_ctl06_RLB_Answers_i3']//input")
    private WebElement group6_check3;
    @FindBy(xpath = "//li[@id='ctl00_MainContent_ctl10_RadTreeList1_ctl06_RLB_Answers_i4']//input")
    private WebElement group6_check4;
    @FindBy(xpath = "//li[@id='ctl00_MainContent_ctl10_RadTreeList1_ctl06_RLB_Answers_i5']//input")
    private WebElement group6_check5;
    @FindBy(xpath = "//li[@id='ctl00_MainContent_ctl10_RadTreeList1_ctl06_RLB_Answers_i6']//input")
    private WebElement group6_check6;
    @FindBy(xpath = "//li[@id='ctl00_MainContent_ctl10_RadTreeList1_ctl06_RLB_Answers_i7']//input")
    private WebElement group6_check7;
    @FindBy(xpath = "//li[@id='ctl00_MainContent_ctl10_RadTreeList1_ctl06_RLB_Answers_i8']//input")
    private WebElement group6_check8;
    @FindBy(xpath = "//li[@id='ctl00_MainContent_ctl10_RadTreeList1_ctl06_RLB_Answers_i9']//input")
    private WebElement group6_check9;
    @FindBy(xpath = "//li[@id='ctl00_MainContent_ctl10_RadTreeList1_ctl06_RLB_Answers_i10']//input")
    private WebElement group6_check10;
    @FindBy(xpath = "//li[@id='ctl00_MainContent_ctl10_RadTreeList1_ctl06_RLB_Answers_i11']//input")
    private WebElement group6_check11;
    @FindBy(xpath = "//textarea[@id='ctl00_MainContent_ctl10_RadTreeList1_ctl06_TxtPlan']")
    private WebElement group6_textarea;
    @FindBy(xpath = "//a[@id='ctl00_MainContent_ctl10_RadTreeList1_ctl06_Add']")
    private WebElement group6_linkAdd;

    //group 7
    @FindBy(xpath = "//div[@id='ctl00_MainContent_ctl10_RadTreeList1_ctl07_RLB_Answers']//input[@class='rlbCheckAllItemsCheckBox']")
    private WebElement group7_checkAll;
    @FindBy(xpath = "//li[@id='ctl00_MainContent_ctl10_RadTreeList1_ctl07_RLB_Answers_i0']//input")
    private WebElement group7_check0;
    @FindBy(xpath = "//li[@id='ctl00_MainContent_ctl10_RadTreeList1_ctl07_RLB_Answers_i1']//input")
    private WebElement group7_check1;
    @FindBy(xpath = "//li[@id='ctl00_MainContent_ctl10_RadTreeList1_ctl07_RLB_Answers_i2']//input")
    private WebElement group7_check2;
    @FindBy(xpath = "//li[@id='ctl00_MainContent_ctl10_RadTreeList1_ctl07_RLB_Answers_i3']//input")
    private WebElement group7_check3;
    @FindBy(xpath = "//li[@id='ctl00_MainContent_ctl10_RadTreeList1_ctl07_RLB_Answers_i4']//input")
    private WebElement group7_check4;
    @FindBy(xpath = "//textarea[@id='ctl00_MainContent_ctl10_RadTreeList1_ctl07_TxtPlan']")
    private WebElement group7_textarea;
    @FindBy(xpath = "//a[@id='ctl00_MainContent_ctl10_RadTreeList1_ctl07_Add']")
    private WebElement group7_linkAdd;


    /*   @FindBy(id = "MainContent_LoginUser_RegisterHyperLink")
    WebElement goToRegLink;

    @FindBy(id = "MainContent_LoginUser_LoginButton")
    WebElement loginButton;*/

    //alerts
    @FindBy(xpath = "//div[@id='MainContent_LoginUser_LoginUserValidationSummary']/ul/li[contains(text(),'שם משתמש חובה')]")
    private WebElement wrongUsernameAlert;

    @FindBy(xpath = "//div[@id='MainContent_LoginUser_LoginUserValidationSummary']/ul/li[contains(text(),'סיסמא חובה.')]")
    private WebElement wrongPasswordAlert;

    public DrugRecommendationPage(WebDriver driver) {
        super(driver);
        this.PAGE_URL = "http://dhclinicappv2stg.item-soft.co.il/Login.aspx";
        PageFactory.initElements(driver, this);
    }

    public DrugRecommendationPage openLoginPage(WebDriver driver) {
        driver.get(PAGE_URL);
        return this;
    }

    /*public DrugRecommendationPage waitUntilDrugPageIsLoaded() {
        try {
            waitUntilElementIsLoaded(loginButton);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }

    public void clickOnLoginButton() {
        clickElement(loginButton);

    }

    public boolean isOnLoginPage() {

        return exists(loginButton);
    }*/

    //check alert presence

    public boolean alertMessageNotValidUsername() {

        return exists(wrongUsernameAlert);
    }
    //div[@id='MainContent_LoginUser_LoginUserValidationSummary']/ul/li[1]

    public boolean alertMessageNotValidPassword() {
        return exists(wrongPasswordAlert);
    }

}
