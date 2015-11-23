package com.telran.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

/**
 * Created by BARUR on 09/11/2015.
 */
public class DoctorsDrugsPlanPage extends Page {


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
     // open drug plan pacient (GreenButton)
    @FindBy(id = "ctl00_MainContent_ctl10_RadTreeList1_ctl03_ExpandCollapseButton")
    private WebElement expandCollapseButton;

    //Elements for open dragPlan Forms
    //*[@id='MainContent_ctl02_btnAddEditMedication']
        //*[@id='MainContent_ctl03_btnAddEditMedication']
        //*[@id='MainContent_ctl04_btnAddEditMedication']

    @FindBy(id = "MainContent_ctl02_btnAddEditMedication")
    WebElement drugPlanWithoutInformationBefore;

    @FindBy(id = "MainContent_ctl03_btnAddEditMedication")
    WebElement drugPlanWithInformationBefore;

    @FindBy(id = "MainContent_ctl04_btnAddEditMedication")
    WebElement drugPlanAnother;

    @FindBy(id="MainContent_Drugs_Relevance1_AddDrug1")
    WebElement addDrugPlan;


    public DoctorsDrugsPlanPage(WebDriver driver) {
        super(driver);
        this.PAGE_URL = "http://dhclinicappv2stg.item-soft.co.il/SecurityInfrastructure/PatientPage.aspx?PersonalId=344457288";
        PageFactory.initElements(driver, this);
    }
                //open need drugsPlan

    public DoctorsDrugsPlanPage openDoctorsDoctorsDrugsPlan(WebDriver driver) {
        driver.get(PAGE_URL);
        return this;
    }

    public void openDrugPlanWithoutInformationBefore(WebDriver driver){
             clickElement(drugPlanWithoutInformationBefore);
    }

    public void openDrugPlanWithInformationBefore(WebDriver driver){
        clickElement(drugPlanWithInformationBefore);
    }

    public void openDrugPlanAnother(WebDriver driver){
        clickElement(drugPlanAnother);

    }
    public void  openFormAddDrugPlan(WebDriver driver)   {
        clickElement(addDrugPlan);
    }
          //filling form

    public void clickOnDrugsName(String name) {
        selectValueInDropdownbyText(drugsName, name);
    }
    public void clickOnFormsInput(String name) {
        selectValueInDropdownbyText(formsInput, name);
    }

    public void clickOnConcentration(String name) {
        selectValueInDropdownbyText(concentration, name);
    }

    public void  fillAmountOfDrugs(String name) {
        setElementText(amountOfDrugs, name);
    }
    public void clickOnNTimesPerDay(String name) {
    selectValueInDropdown(nTimesPerDay, name);
    }

    public void clickOnDay() {
        clickElement(day);
    }
     public void clickOnMorning(){
         clickElement(morning);
     }
     public void clickOnEvening() {
         clickElement(evening);
     }
    public void  fillDuration(String name) {
        setElementText(durationInput, name);
    }

    public void clickOnDuration(String name) {
        selectValueInDropdown(duration, name);
    }

    public void  fillComents(String name) {
        setElementText(coments, name);
    }
    public void clickOnUpdateButton() {
        clickElement(update);
    }

    public void clickOnCancelButton() {
        clickElement(cancel);
    }

    public DoctorsDrugsPlanPage waitUntilDrugPageIsLoaded() {
        try {
            Thread.sleep(10000);
            driver.switchTo().frame(0);
            waitUntilElementIsLoaded(expandCollapseButton);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }
    public DoctorsDrugsPlanPage clickOnExpandCollapseButton() {
        clickElement(expandCollapseButton);
        return this;
    }
    }

