package com.telran.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by BARUR on 09/11/2015.
 */
public class DoctorsDrugPlan extends Page {
    //private static Logger Log = Logger.getLogger(LogLog4j.class.getName());
    //fields
    @FindBy(id = "ctl00_MainContent_Drugs_Relevance1_RadGrid1_ctl00_ctl05_RCBDrug_Input")
    WebElement drugsName;
    @FindBy(id = "ctl0MainContent_Drugs_Relevance1_RadGrid1_ctl00_ctl05_RcbForms_Input")
    WebElement formsInput;
    @FindBy(id = "ctl00_MainContent_Drugs_Relevance1_RadGrid1_ctl00_ctl05_RcMinun_Input")
    WebElement concentration;
    @FindBy(id = "ctl00_MainContent_Drugs_Relevance1_RadGrid1_ctl00_ctl05_TxtUnit")
    WebElement amountOfDrugs;
    @FindBy(id = "ctl00_MainContent_Drugs_Relevance1_RadGrid1_ctl00_ctl05_RCBTimesAday_Input")
    WebElement nTimesPerDay;
    @FindBy(id = "ctl00_MainContent_Drugs_Relevance1_RadGrid1_ctl00_ctl05_CblTimes_0")
    WebElement morning;
    @FindBy(id = "ctl00_MainContent_Drugs_Relevance1_RadGrid1_ctl00_ctl05_CblTimes_1")
    WebElement day;
    @FindBy(id = "ctl00_MainContent_Drugs_Relevance1_RadGrid1_ctl00_ctl05_CblTimes_2")
    WebElement evening;
    @FindBy(id = "ctl00_MainContent_Drugs_Relevance1_RadGrid1_ctl00_ctl05_RTBDuration")
    WebElement duration;
    @FindBy(id = "ctl00_MainContent_Drugs_Relevance1_RadGrid1_ctl00_ctl05_RTBDuration_Input")
    WebElement durationInput;
    @FindBy(id = "ctl00_MainContent_Drugs_Relevance1_RadGrid1_ctl00_ctl05_RTBComments")
    WebElement coments;
    @FindBy(id = "ctl00_MainContent_Drugs_Relevance1_RadGrid1_ctl00_ctl05_btnUpdate")
    WebElement update;
    @FindBy(id = "ctl00_MainContent_Drugs_Relevance1_RadGrid1_ctl00_ctl05_btnCancel")
    WebElement cancel;

    public DoctorsDrugPlan(WebDriver driver) {
        super(driver);
    }

    public void clickOnConcentration(String name) {
        selectValueInDropdownbyText(concentration, name);
    }

    public void clickOnNTimesPerDay(String name) {
        selectValueInDropdown(nTimesPerDay, name);
    }

    public void clickOnDuration(String name) {
        selectValueInDropdown(duration, name);
    }

    public void clickOnUpdateButton() {
        clickElement(update);
    }

    public void clickOnCancelButton() {
        clickElement(cancel);
    }
}
