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

    @FindBy(xpath = "//*[contains(text(), 'שאלון מחלות כרוניות, ניתוחים וסקירת מערכות - דוח ממתין למילוי')]/../..//*[contains(text(), 'כעת')]")
    WebElement clickTableButtom;

    @FindBy(xpath = "//*[@id='MainContent_contentHtml']")
    WebElement onFrame;

    @FindBy(xpath = "//*[@id='form1']")
    WebElement form1;

    @FindBy(xpath = "//*[@name='q34']")
    WebElement textIntroduce;

    @FindBy(xpath = "//*[@id='submit']")
    WebElement submitButtom;


    public QuestionnaireChronicDiseasesPatientPetruninPage(WebDriver driver) {
        super(driver);
        //Данный сласс не используется, т.к. используем аналогичный loginIrinaPage
    }

    public QuestionnaireChronicDiseasesPatientPetruninPage clickAddAcceptField() {
        clickElement(addAcceptField);
        Log.info("Accept Field was added");
        return this;
    }

    public QuestionnaireChronicDiseasesPatientPetruninPage clickTableButtom() {
        clickElement(clickTableButtom);
        Log.info("TableButtom was pushed");
        return this;
    }

    public boolean isOnframe() {
        return exists(onFrame);
    }

    public QuestionnaireChronicDiseasesPatientPetruninPage fillElements() {
        List<WebElement> sections = form1.findElements(By.tagName("tr"));

        Log.info("Find all table elements " + sections.size());
        List<WebElement> spanWithInput, radioButtons;
        for (WebElement sec : sections) {
            spanWithInput = sec.findElements(By.tagName("td"));
            int rndValue = (int) (Math.random() * 3);
            if (spanWithInput.size() == 5) {
                WebElement currentSpan = spanWithInput.get(rndValue);
                radioButtons = currentSpan.findElements(By.tagName("input"));
                for (WebElement but : radioButtons) {
                    if(Integer.parseInt(but.getAttribute("value"))==rndValue){
                        but.click();
                    }
                }
            } else {
                //Дописать метод поиска пустых строк, внесения их в HashMap и заполнения их
            }
        }
        fillField("test");
        Log.info("Text was write into the last TextField");
        return this;
    }

    public QuestionnaireChronicDiseasesPatientPetruninPage fillField(String text) {
        setElementText(textIntroduce, text);
        return this;
    }

    public QuestionnaireChronicDiseasesPatientPetruninPage clickSubmitButtom() {
        clickElement(submitButtom);
        Log.info("SubmitButtom was pushed");
        return this;
    }
}
