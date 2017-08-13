package com.telran.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Iakov Volf,Oleg
 */
public class DoctorsFizicalExamPage extends Page {

    //private static Logger Log = Logger.getLogger(LogLog4j.class.getName());
    //fields
    @FindBy(id = "ctl00_MainContent_ctl07_RadTreeList1_ctl03_RCB_ValidAns_Input")
    WebElement inputField1;

    @FindBy(id = "ctl00_MainContent_ctl07_RadTreeList1_ctl03_RCB_NotValidAns_Input")
    WebElement inputField2;

    @FindBy(id = "ctl00_MainContent_ctl07_RadTreeList1_ctl04_RCB_ValidAns_Input")
    WebElement inputField3;

    @FindBy(id = "ctl00_MainContent_ctl07_RadTreeList1_ctl04_RCB_NotValidAns_Input")
    WebElement inputField4;

    @FindBy(id = "ctl00_MainContent_ctl07_RadTreeList1_ctl10_RCB_ValidAns_Input")
    WebElement inputField5;

    @FindBy(id = "ctl00_MainContent_ctl07_RadTreeList1_ctl10_RCB_NotValidAns_Input")
    WebElement inputField6;

    @FindBy(id = "ctl00_MainContent_ctl07_RadTreeList1_ctl11_RCB_ValidAns_Input")
    WebElement inputField7;

    @FindBy(id = "ctl00_MainContent_ctl07_RadTreeList1_ctl11_RCB_NotValidAns_Input")
    WebElement inputField8;

    @FindBy(id = "ctl00_MainContent_ctl07_RadTreeList1_ctl12_RCB_ValidAns_Input")
    WebElement inputField9;

    @FindBy(id = "ctl00_MainContent_ctl07_RadTreeList1_ctl12_RCB_NotValidAns_Input")
    WebElement inputField10;

    @FindBy(id = "ctl00_MainContent_ctl07_RadTreeList1_ctl13_RCB_ValidAns_Input")
    WebElement inputField11;

    @FindBy(id = "ctl00_MainContent_ctl07_RadTreeList1_ctl13_RCB_NotValidAns_Input")
    WebElement inputField12;

    @FindBy(id = "ctl00_MainContent_ctl07_RadTreeList1_ctl14_RCB_ValidAns_Input")
    WebElement inputField13;

    @FindBy(id = "ctl00_MainContent_ctl07_RadTreeList1_ctl14_RCB_NotValidAns_Input")
    WebElement inputField14;

    @FindBy(id = "ctl00_MainContent_ctl07_RadTreeList1_ctl15_RCB_ValidAns_Input")
    WebElement inputField15;

    @FindBy(id = "ctl00_MainContent_ctl07_RadTreeList1_ctl15_RCB_NotValidAns_Input")
    WebElement inputField16;


    //public ProfilePage profilePage;

    public DoctorsFizicalExamPage(WebDriver driver) {
        super(driver);
        this.PAGE_URL = "http://dhclinicappv2stg.item-soft.co.il/SecurityInfrastructure/PatientPage.aspx?PersonalId=876086950";
        PageFactory.initElements(driver, this);
    }


    public DoctorsFizicalExamPage openDoctorsFizicalExam(WebDriver driver) {
        driver.get(PAGE_URL);
        return this;
    }

//Fill the fileds

    public DoctorsFizicalExamPage fillInputField1(String text) {
       clickElement(inputField1);
        setElementText(inputField1, text);
        return this;
    }

    public DoctorsFizicalExamPage fillInputField2(String text) {
        clickElement(inputField2);
        setElementText(inputField2, text);
        return this;
    }

    public DoctorsFizicalExamPage fillInputField3(String text) {
        clickElement(inputField3);
        setElementText(inputField3, text);
        return this;
    }

    public DoctorsFizicalExamPage fillInputField4(String text) {
        clickElement(inputField4);
        setElementText(inputField4, text);
        return this;
    }

    public DoctorsFizicalExamPage fillInputField5(String text) {
        clickElement(inputField5);
        setElementText(inputField5, text);
        return this;
    }

    public DoctorsFizicalExamPage fillInputField6(String text) {
        clickElement(inputField6);
        setElementText(inputField6, text);
        return this;
    }

    public DoctorsFizicalExamPage fillInputField7(String text) {
        clickElement(inputField7);
        setElementText(inputField7, text);
        return this;
    }

    public DoctorsFizicalExamPage fillInputField8(String text) {
        clickElement(inputField8);
        setElementText(inputField8, text);
        return this;
    }

    public DoctorsFizicalExamPage fillInputField9(String text) {
        clickElement(inputField9);
        setElementText(inputField9, text);
        return this;
    }

    public DoctorsFizicalExamPage fillInputField10(String text) {
        clickElement(inputField10);
        setElementText(inputField10, text);
        return this;
    }

    public DoctorsFizicalExamPage fillInputField11(String text) {
        clickElement(inputField11);
        setElementText(inputField11, text);
        return this;
    }

    public DoctorsFizicalExamPage fillInputField12(String text) {
        clickElement(inputField12);
        setElementText(inputField12, text);
        return this;
    }

    public DoctorsFizicalExamPage fillInputField13(String text) {
        clickElement(inputField13);
        setElementText(inputField13, text);
        return this;
    }

    public DoctorsFizicalExamPage fillInputField14(String text) {
        clickElement(inputField14);
        setElementText(inputField14, text);
        return this;
    }

    public DoctorsFizicalExamPage fillInputField15(String text) {
        clickElement(inputField15);
        setElementText(inputField15, text);
        return this;
    }

    public DoctorsFizicalExamPage fillInputField16(String text) {
        clickElement(inputField16);
        setElementText(inputField16, text);
        return this;
    }



}
