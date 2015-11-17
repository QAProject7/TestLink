package com.telran.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.List;

/**
 * Created by Iakov Volf,Irina
 */
public class DrugRecommendationPage extends Page {

    @FindBy(xpath = "//a[contains(text(),'ערוך')]")
    public WebElement valueButton;

    @FindBy(xpath = "//tr[@id='ctl00_MainContent_ctl10_RadTreeList1_ctl02__0']")
    public WebElement group1;
    @FindBy(id = "ctl00_MainContent_AddEditAccount1_RDTmeetingdate_dateInput")
    public WebElement dateMeetingInput;
    @FindBy(xpath = "//input[@class='BtnCreateSummaryReport']")
    public WebElement redMainButton;
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
    @FindBy(id = "ctl00_MainContent_ctl10_RadTreeList1_ctl02_TxtPlan_ClientState")
    private WebElement group1_input;
    @FindBy(xpath = "//a[@id='ctl00_MainContent_ctl10_RadTreeList1_ctl02_Add']")
    private WebElement group1_linkAdd;
    //group 2
    @FindBy(xpath = "//textarea[@id='ctl00_MainContent_ctl10_RadTreeList1_ctl03_TxtPlan']")
    private WebElement group2_textarea;
    @FindBy(xpath = "//a[@id='ctl00_MainContent_ctl10_RadTreeList1_ctl03_Add']")
    private WebElement group2_linkAdd;
    //group 3
    @FindBy(xpath = "//td[contains(text(),'מידע נוסף')]/../td[3]//textarea")
    private WebElement group3_textarea;
    @FindBy(xpath = "//td[contains(text(),'מידע נוסף')]/../td[3]//a[contains(text(),'הוסף')]")
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
    @FindBy(id = "ctl00_MainContent_ctl10_RadTreeList1_ctl03_ExpandCollapseButton")
    private WebElement expandCollapseButton;
    @FindBy(xpath = "//*[@id='MainContent_ctl05_chartDiv']//*[contains(text(),'שאלון וונדרבילט להורה')]//img[@src=\"../images/showIcon1.png\"]")
    private WebElement timeLineQst;
    @FindBy(xpath = "//*[contains(text(),'שאלון וונדרבילט להורה')]//img[@src=\"../images/showIcon1.png\"]/../..[contains(text(), 'שאלון וונדרבילט להורה')]")
    private WebElement tebleSelect;
    @FindBy(xpath = "//*[@id='form1']//*[@type='button'][@value='export pdf']")
    private WebElement exportPdfframeButton;


    /*   @FindBy(id = "MainContent_LoginUser_RegisterHyperLink")
    WebElement goToRegLink;

    @FindBy(id = "MainContent_LoginUser_LoginButton")
    WebElement loginButton;*/

    public DrugRecommendationPage(WebDriver driver) {
        super(driver);
        this.PAGE_URL = "http://dhclinicappv2stg.item-soft.co.il/Login.aspx";
        PageFactory.initElements(driver, this);
    }

    /*public DrugRecommendationPage openDrugRecommendationPage(WebDriver driver) {
        driver.get(PAGE_URL);

        return this;
    }*/

    public DrugRecommendationPage waitUntilDrugPageIsLoaded() {
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

    public DrugRecommendationPage clickOnExpandCollapseButton() {
        clickElement(expandCollapseButton);
        return this;
    }

    public DrugRecommendationPage clickOnAddDrugButton() {
        clickElement(valueButton);
        return this;
    }

    public DrugRecommendationPage addDrug(String drug) {
        clickOnAddDrugButton();
        System.out.println(drug);
        setElementText(group1_textarea, drug);
        group1_linkAdd.click();
        setElementText(dateMeetingInput, "12.12.2015");
        redMainButton.click();
        return this;
    }

    private List<WebElement> findDrugs() {
        String locator = "//tr[@id='ctl00_MainContent_ctl10_RadTreeList1_ctl02__0']//tr[@class='planAnswers']";
        return group1.findElements(By.xpath(locator));
        //System.out.println("size=" + drugsList.size());
    }

    public boolean isDrugAdded(String drug) {
        List<WebElement> drugsList = findDrugs();
        System.out.println("found: " + drugsList.size());
        for (WebElement drugFromList : drugsList) {
            System.out.println(drugFromList.getText());
            if (drugFromList.getText().equals(drug))
                return true;
        }
        return false;
    }


    public boolean isOnDrugPage() {
        return exists(expandCollapseButton);
    }

    public String selectFirstDrug() {
        List<WebElement> drugsList = findDrugs();
        return drugsList.get(0).getText();
    }

       public void clickTimeLineQst() {
        clickElement(timeLineQst);

    }

    public void clickToExportOnFrame() throws InterruptedException {
        Thread.sleep(3000);
        WebElement iframeQ = driver.findElement(By.xpath("//iframe[@name='rwQuestion']"));
        driver.switchTo().frame(iframeQ);
        Thread.sleep(2000);
        clickElement(exportPdfframeButton);

    }

    public DrugRecommendationPage removeDrug(String drug) {
        clickOnAddDrugButton();
        String locator = "//li[@id='ctl00_MainContent_ctl10_RadTreeList1_ctl02_RLB_Answers_i0']/label/input";
        WebElement checkBox = driver.findElement(By.xpath(locator));
        checkBox.click();
        group1_linkAdd.click();
        return this;
    }

    public boolean isOnframe() {
        driver.switchTo().activeElement();

        return exists(exportPdfframeButton);
    }

    public boolean isTableSelected() {

        return exists(tebleSelect);
    }

    public boolean isDrugRemoved(String drug) {
        List<WebElement> drugsList = findDrugs();
        for (WebElement drugFromList : drugsList) {
            if (drugFromList.getText().equals(drug))
                return false;
        }
        return true;
    }

    //check alert presence

    /*public boolean alertMessageNotValidUsername() {

        return exists(wrongUsernameAlert);
    }*/
    //div[@id='MainContent_LoginUser_LoginUserValidationSummary']/ul/li[1]

    /*public boolean alertMessageNotValidPassword() {
        return exists(wrongPasswordAlert);
    }*/

}
