package com.telran.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.List;

/**
 * Created by
 */
public class DrugRecomendationPage extends Page {

    //private static Logger Log = Logger.getLogger(LogLog4j.class.getName());
    //fields

    //input [@id="ctl00_MainContent_ctl10_RadTreeList1_ctl03_ExpandCollapseButton" ]

    @FindBy(xpath = "//tr[@id='ctl00_MainContent_ctl10_RadTreeList1_ctl08__6']//*[contains(text(),('ערוך'))]")
    WebElement groupLastAddLink;
    @FindBy(id = "ctl00_MainContent_ctl10_RadTreeList1_ctl08_TxtPlan")
    WebElement groupLastTextInput;
    @FindBy(id = "ctl00_MainContent_ctl10_RadTreeList1_ctl08_Add")
    WebElement commitWebLink;
    @FindBy(xpath = "//*[@id = 'ctl00_MainContent_ctl10_RadTreeList1_ctl08_TxtPlan']/../../../..")
    WebElement lastGroup;
    /*  @FindBy(id = "ctl00_MainContent_ctl10_RadTreeList1_ctl03_ExpandCollapseButton")
      private WebElement expandCollapseButton;*/
    @FindBy(id = "ctl00_MainContent_ctl10_RadTreeList1_ctl03_ExpandCollapseButton")
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
        List<WebElement> webElements = lastGroup.findElements(By.xpath("//tr[@class='planAnswers'][not(contains(@onclick,'javascript:'))]"));
        System.out.println("Found elements : " + webElements.size());
        for (WebElement webElement : webElements) {
            String temp = webElement.getText();
            System.out.println(temp);
            if (testText.equals(webElement.getText()))
                return true;
        }
        return false;
    }

    public boolean isDrugRemoved(String testText) {
        List<WebElement> webElements = lastGroup.findElements(By.xpath("//tr[@class='planAnswers'][not(contains(@onclick,'javascript:'))] "));
        for (WebElement webElement : webElements) {
            String temp = webElement.getText();
            System.out.println(temp);
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
/*        List<WebElement> webElementList=driver.findElements(By.xpath("//div[@id='ctl00_MainContent_ctl10_RadTreeList1_ctl08_RLB_Answers']//ul[@class='rlbList']/*//*[@checked='checked']"));///../span"));
        for (WebElement webElement:webElementList ){
            webElement.click();
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            WebElement elementSpan=webElement.findElement(By.xpath("/../span"));
            String temp=elementSpan.getText();
            System.out.println("elementSpan.getText()="+temp);
            return temp;
        }
        return null;*/
        WebElement webElement = driver.findElement(By.xpath("//*[@id='ctl00_MainContent_ctl10_RadTreeList1_ctl08_RLB_Answers']//*[@class='rlbList']  /*//*[@checked='checked']"));///../span"));
        WebElement webElementSpan = driver.findElement(By.xpath("//*[@id='ctl00_MainContent_ctl10_RadTreeList1_ctl08_RLB_Answers']//*[@class='rlbList']  /*//*[@checked='checked']/../span"));
        if (webElement.isDisplayed())
            System.out.println("webElement Founded !!!");
        else
            System.out.println("webElement NOT  Founded !!!");
        if (webElementSpan.isDisplayed())
            System.out.println("webElementSpan Founded !!!");
        else
            System.out.println("webElementSpan NOT  Founded !!!");
        String temp = webElementSpan.getText();
        webElement.click();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //WebElement elementSpan=webElement.findElement(By.xpath("/*/../../span"));

        System.out.println("webElementSpan.getText()=" + temp);
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
