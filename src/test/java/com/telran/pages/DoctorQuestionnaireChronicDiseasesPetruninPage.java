package com.telran.pages;

import com.telran.LogLog4j;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Created by leoni on 02.12.2015.
 */
public class DoctorQuestionnaireChronicDiseasesPetruninPage extends Page {
    private static final int PATIENT_TZ = 779294107;  // Возможна замена ТедатЗеута
    private static Logger Log = Logger.getLogger(LogLog4j.class.getName());

    @FindBy(xpath = ("//*[contains(text(), '"+PATIENT_TZ+"')]/..//*[@class='LinkBtnPatients GreenBtn']"))
    WebElement choosePatient;

    @FindBy(xpath = "//div[contains(text(), 'שאלון מחלות כרוניות, ניתוחים וסקירת מערכות')]/div/img")
    WebElement tableFrame;



    public DoctorQuestionnaireChronicDiseasesPetruninPage(WebDriver driver) {
        super(driver);
        //Данный сласс не используется, т.к. используем аналогичный loginIrinaPage
    }

    public DoctorQuestionnaireChronicDiseasesPetruninPage clickChoosePatient() {
        clickElement(choosePatient);
        Log.info("The patient was choosed");
        return this;
    }

    public boolean inTableFrame() {
        return exists(tableFrame);
    }

    public DoctorQuestionnaireChronicDiseasesPetruninPage clickTableFrame() {
        clickElement(tableFrame);
        Log.info("TableFrame was opend");
        return this;
    }


}
   /* public QuestionnaireChronicDiseasesPatientPetruninPage clickTableButtom() {
        clickElement(clickTableButtom);
        Log.info("TableButtom was pushed");
        return this;
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
}*/