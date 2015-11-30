package com.telran.pages;


import com.telran.LogLog4j;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.List;

/**
 * Created by Alex
 */
public class DrugRecomendationPage extends Page {
    private static Logger Log = Logger.getLogger(LogLog4j.class.getName()); //Необходимо для написания логов
    //private static Logger Log = Logger.getLogger(LogLog4j.class.getName());
    //fields

    //input [@id="ctl00_MainContent_ctl10_RadTreeList1_ctl03_ExpandCollapseButton" ]
//a[@id='ctl00_MainContent_ctl10_RadTreeList1_ctl08_Add']
    @FindBy(xpath = "//tr [@id='ctl00_MainContent_ctl10_RadTreeList1_ctl08__6']//a[contains(text(),'ערוך')]")
    public WebElement groupLastAddLink;
    @FindBy(xpath = "//textarea [@id='ctl00_MainContent_ctl10_RadTreeList1_ctl08_TxtPlan']")
    WebElement groupLastTextInput;
    @FindBy(xpath = "//a [@id='ctl00_MainContent_ctl10_RadTreeList1_ctl08_Add']")
    WebElement commitWebLink;

    //@FindBy(xpath = "//div [@id='ctl00_MainContent_ctl10_RadTreeList1_ctl08_RLB_Answers']")
    @FindBy(xpath = "//tr [@id='ctl00_MainContent_ctl10_RadTreeList1_ctl08__6']")
    WebElement lastGroup;
    /*  @FindBy(id = "ctl00_MainContent_ctl10_RadTreeList1_ctl03_ExpandCollapseButton")
      private WebElement expandCollapseButton;*/
    @FindBy(xpath = "//input [@id='ctl00_MainContent_ctl10_RadTreeList1_ctl03_ExpandCollapseButton']")
    private WebElement expandCollapseButton;

//*[@id='ctl00_MainContent_ctl10_RadTreeList1_ctl08_RLB_Answers_i0']//span[@class='rlbText']



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

    public boolean isTextInsertedOk(String testText) {
        Log.info("isTextInsertedOk Start");
        List<WebElement> webElements = lastGroup.findElements(By.xpath(".//span[@style='display:inline-block;width:100%;']"));
        Log.info("Found elements : " + webElements.size());
        //System.out.println("Found elements : " + webElements.size());
        int i = 0;
        for (WebElement webElement : webElements) {
            i = i + 1;
            if (webElement.isDisplayed()) {

                String temp = webElement.getText();
                Log.info("i=" + i + ":" + temp);
                //System.out.println(temp);
                if (testText.equals(webElement.getText()))
                    return true;
            }
        }
        //Log.info("isTextInsertedOk finished");
        return false;
    }

    public boolean isDrugRemoved(String testText) {
        Log.info("isDrugRemoved Start");
        List<WebElement> webElements = lastGroup.findElements(By.xpath(".//span[@style='display:inline-block;width:100%;']"));
        if (webElements.size() < 1)
            return false;
        for (WebElement webElement : webElements) {
            String temp = webElement.getText();
            Log.info("text:" + temp);
            //System.out.println(temp);
            if (temp.equals(testText))
                return false;
        }
        return true;
    }


    public DrugRecomendationPage waitUntilTestPageIsLoaded() {
        try {
            Thread.sleep(10000);
            driver.switchTo().frame(0);
            waitUntilElementIsLoaded(expandCollapseButton);
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

    public String unCheckCheckBoxDeletedDrug() {

        WebElement webElement = driver.findElement(By.xpath("//li[@id='ctl00_MainContent_ctl10_RadTreeList1_ctl08_RLB_Answers_i0']//input[@checked='checked']"));
        WebElement webElementSpan = driver.findElement(By.xpath("//li[@id='ctl00_MainContent_ctl10_RadTreeList1_ctl08_RLB_Answers_i0']//input[@checked='checked']/../span"));
        if (webElement.isDisplayed())
            Log.info("checked webElement  Founded !!!");
        else
            Log.info("checked webElement NOT  Founded !!!");
        /*if (webElementSpan.isDisplayed())
            System.out.println("webElementSpan Founded !!!");
        else
            System.out.println("webElementSpan NOT  Founded !!!");*/
        String temp = webElementSpan.getText();
        Log.info("webElementSpan.getText()=" + temp);
        Log.info("webElement.click()");
        webElement.click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //WebElement elementSpan=webElement.findElement(By.xpath("/*/../../span"));

        return temp;

        //return null


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
