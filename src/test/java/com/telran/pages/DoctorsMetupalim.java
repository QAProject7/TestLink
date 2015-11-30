package com.telran.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * 
 */
public class DoctorsMetupalim extends Page {

    @FindBy(id = "Div1")
    WebElement goNext;

    @FindBy(id = "BtnPrevPage")
    WebElement goLast;

    @FindBy(xpath = "//*[@id='ctl00_MainContent_RadTabStrip1']//span[contains(text(), 'מטופלים פעילים')]")
    WebElement tab1;

    @FindBy(xpath = "//*[@id='ctl00_MainContent_RadTabStrip1']//span[contains(text(), 'מטופלים להיום')]")
    WebElement tab2;

    @FindBy(xpath = "//*[@id='ctl00_MainContent_RadTabStrip1']//span[contains(text(), 'חיפוש מטופלים')]")
    WebElement tab3;

    @FindBy(id = "MainContent_ItemLinkButton3")
    WebElement addPatientUpper;

    @FindBy(id = "MainContent_AddNewItem")
    WebElement addPatientBottom;

    @FindBy(id = "MainContent_BtnDeleteMeeting")
    WebElement deleteMeeting;

    @FindBy(id = "ctl00_MainContent_RDP_AccountMeeting_dateInput")
    WebElement inputDate;

    @FindBy(id = "ctl00_MainContent_RadGrid1_ctl00_ctl02_ctl02_FilterTextBox_PersonalId")
    WebElement teudatInput;

    @FindBy(id = "ctl00_MainContent_RadGrid1_ctl00_ctl02_ctl02_FilterTextBox_LastName")
    WebElement nameInput;

    @FindBy(id = "ctl00_MainContent_RadGrid1_ctl00_ctl02_ctl02_FilterTextBox_FirstName")
    WebElement lastNameInput;

    //public ProfilePage profilePage;

    public DoctorsMetupalim(WebDriver driver) {
        super(driver);
        this.PAGE_URL = "http://dhclinicappv2stg.item-soft.co.il/SitePages/createUser.aspx?ReturnUrl=HomePage";
        PageFactory.initElements(driver, this);
    }

    public DoctorsMetupalim addingPatient(WebDriver driver) {
        driver.get(PAGE_URL);
        return this;
    }

//Fill the fileds

    public void clickGoNext() {
        clickElement(goNext);
    }

    public void clickGoLast() {
        clickElement(goLast);
    }

    public void clickTab1() {
        clickElement(tab1);
    }

    public void clickTab2() {
        clickElement(tab2);
    }

    public void clickAddPatientUpper() {
        clickElement(addPatientUpper);
    }

    public void clickAddPatientBottom() {
        clickElement(addPatientBottom);
    }

    public DoctorsMetupalim inputDate(String date) {
        setElementText(inputDate, date);
        return this;
    }

    public DoctorsMetupalim inputTeudat(String teudat) {
        setElementText(teudatInput, teudat);
        return this;
    }

    public DoctorsMetupalim inputName(String name) {
        setElementText(nameInput, name);
        return this;
    }

    public DoctorsMetupalim inputLastName(String lastName) {
        setElementText(lastNameInput, lastName);
        return this;
    }


    public boolean isOnCreateNewPatientPage() {
        return exists(addPatientBottom);
    }

}
