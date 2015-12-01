package com.telran.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Petrunin on 30.11.2015.
 */
public class QuestionnaireChronicDiseasesPatientPetruninPage extends Page{

    @FindBy(xpath = "//*[@id='MainContent_LoginUser_CBAgreeToTerms']")
    WebElement addAcceptField;

    @FindBy(xpath = "//*[contains(text(), 'שאלון מחלות כרוניות, ניתוחים וסקירת מערכות - דוח ממתין למילוי')]/../../*[@class='notificationBtns']/a[@id='MainContent_RptNotification_NowBtn1_0']")
    WebElement clickTableButtom;

    @FindBy(xpath = "//*[@id='MainContent_contentHtml']")
    WebElement onFrame;


    public QuestionnaireChronicDiseasesPatientPetruninPage(WebDriver driver) {
        super(driver);
        //Данный сласс не используется, т.к. используем аналогичный loginIrinaPage
    }

    public QuestionnaireChronicDiseasesPatientPetruninPage clickAddAcceptField() {
        clickElement(addAcceptField);
        return this;
    }

    public QuestionnaireChronicDiseasesPatientPetruninPage clickTableButtom() {
        clickElement(clickTableButtom);
        return this;
    }

    public boolean isOnframe() {


        return exists(onFrame);
    }
}
