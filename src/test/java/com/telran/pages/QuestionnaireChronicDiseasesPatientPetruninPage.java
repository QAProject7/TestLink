package com.telran.pages;

import com.telran.LogLog4j;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Created by Petrunin on 30.11.2015.
 */
public class QuestionnaireChronicDiseasesPatientPetruninPage extends Page {
    private static Logger Log = Logger.getLogger(LogLog4j.class.getName());
    @FindBy(xpath = "//*[@id='MainContent_LoginUser_CBAgreeToTerms']")
    WebElement addAcceptField;

    @FindBy(xpath = "//*[contains(text(), 'שאלון מחלות כרוניות, ניתוחים וסקירת מערכות - דוח ממתין למילוי')]/../../*[@class='notificationBtns']/a[@id='MainContent_RptNotification_NowBtn1_0']")
    WebElement clickTableButtom;

    @FindBy(xpath = "//*[@id='MainContent_contentHtml']")
    WebElement onFrame;

    @FindBy(xpath = "//*[@id='form1']")
    WebElement form1;

    @FindBy(xpath = "//*[@name='q34']")
    WebElement textIntroduce;

    @FindBy(xpath ="//*[@type='radio']")
    WebElement pointField;

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

    public QuestionnaireChronicDiseasesPatientPetruninPage fillElements() {
        List<WebElement> sectionqs = form1.findElements(By.tagName("tr"));

        Log.info("Find all table elements");
        List<WebElement> spanWithInput, radioButtons;

        for (WebElement sec : sectionqs) {
            spanWithInput = sec.findElements(By.tagName("td"));
            if (spanWithInput.size() != 0) {
                int rndValue = (int) (Math.random() * (spanWithInput.size() - 1));
                WebElement currentSpan = spanWithInput.get(rndValue);
                WebElement radioButton = currentSpan.findElement(By.xpath("//*[@type='radio']"));
                radioButton.click();
            } else {
                fillField("test");
            }
        }
        return this;
    }
    public QuestionnaireChronicDiseasesPatientPetruninPage fillField(String text) {
        setElementText(textIntroduce, text);
        return this;
    }
}
