package com.telran.pages;

import com.telran.LogLog4j;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;

/**
 * Created by leoni on 02.12.2015.
 */
public class DoctorQuestionnaireChronicDiseasesPage extends Page {
    private static final int PATIENT_TZ = 779294107;  // Возможна замена ТедатЗеута
    private static Logger Log = Logger.getLogger(LogLog4j.class.getName());

    @FindBy(xpath = ("//*[contains(text(), '"+PATIENT_TZ+"')]/..//*[@class='LinkBtnPatients GreenBtn']"))
    WebElement choosePatient;

    @FindBy(xpath = "//*[contains(text(),'שאלון מחלות כרוניות, ניתוחים וסקירת מערכות')]/div/img")
    WebElement tableFrame;


    public DoctorQuestionnaireChronicDiseasesPage(WebDriver driver) {
        super(driver);
        //Данный сласс не используется, т.к. используем аналогичный loginIrinaPage
    }

    public DoctorQuestionnaireChronicDiseasesPage clickChoosePatient() {
        clickElement(choosePatient);
        Log.info("The patient was choosed");
        return this;
    }

    public boolean inTableFrame() throws IOException, InterruptedException {
        waitUntilElementIsLoaded(tableFrame);
        return exists(tableFrame);
    }

    public DoctorQuestionnaireChronicDiseasesPage clickTableFrame() {
        clickElement(tableFrame);
        Log.info("TableFrame was opend");
        return this;
    }


}
