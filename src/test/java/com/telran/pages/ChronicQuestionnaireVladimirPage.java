package com.telran.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.List;

/**
 * Created by Naryck on 2015.11.09.
 */
public class ChronicQuestionnaireVladimirPage extends Page {
    @FindBy(id = "MainContent_contentHtml")
    WebElement mainDiv;

    @FindBy(id = "form1")
    WebElement mainForm;

    //Chronic Illness
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q2'][@value='2']")
    WebElement anyChronicIllnessNotRelevantRadioBtn;
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q2'][@value='1']")
    WebElement anyChronicIllnessNoRadioBtn;
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q2'][@value='0']")
    WebElement anyChronicIllnessYesRadioBtn;
    @FindBy(xpath = "//textarea[@name='q3']")
    WebElement anyChronicIllnessTextArea;
    //Analysis
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q4'][@value='2']")
    WebElement anyAnalysisNotRelevantRadioBtn;
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q4'][@value='1']")
    WebElement anyAnalysisNoRadioBtn;
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q4'][@value='0']")
    WebElement anyAnalysisYesRadioBtn;
    @FindBy(xpath = "//textarea[@name='q5']")
    WebElement anyAnalysisTextArea;

    //NEUROLOGY
    //seizures
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q6'][@value='2']")
    WebElement seizuresNotRelevantRadioBtn;
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q6'][@value='1']")
    WebElement seizuresNoRadioBtn;
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q6'][@value='0']")
    WebElement seizuresYesRadioBtn;
    //???
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q7'][@value='2']")
    WebElement yiruimNotRelevantRadioBtn;
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q7'][@value='1']")
    WebElement yiruimNoRadioBtn;
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q7'][@value='0']")
    WebElement yiruimYesRadioBtn;
    //ticks and involuntary movements
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q8'][@value='2']")
    WebElement ticsNotRelevantRadioBtn;
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q8'][@value='1']")
    WebElement ticsNoRadioBtn;
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q8'][@value='0']")
    WebElement ticsYesRadioBtn;
    //vision problems
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q9'][@value='2']")
    WebElement visionProblemsNotRelevantRadioBtn;
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q9'][@value='1']")
    WebElement visionProblemsNoRadioBtn;
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q9'][@value='0']")
    WebElement visionProblemsYesRadioBtn;
    //hearing problems
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q10'][@value='2']")
    WebElement hearingProblemsNotRelevantRadioBtn;
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q10'][@value='1']")
    WebElement hearingProblemsNoRadioBtn;
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q10'][@value='0']")
    WebElement hearingProblemsYesRadioBtn;
    //speaking problems
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q11'][@value='2']")
    WebElement speakingProblemsNotRelevantRadioBtn;
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q11'][@value='1']")
    WebElement speakingProblemsNoRadioBtn;
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q11'][@value='0']")
    WebElement speakingProblemsYesRadioBtn;
    //swallow problems
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q12'][@value='2']")
    WebElement swallowProblemsNotRelevantRadioBtn;
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q12'][@value='1']")
    WebElement swallowProblemsNoRadioBtn;
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q12'][@value='0']")
    WebElement swallowProblemsYesRadioBtn;
    //moving arms/legs problems
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q13'][@value='2']")
    WebElement movingArmsProblemsNotRelevantRadioBtn;
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q13'][@value='1']")
    WebElement movingArmsProblemsNoRadioBtn;
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q13'][@value='0']")
    WebElement movingArmsProblemsYesRadioBtn;
    //falling problems
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q14'][@value='2']")
    WebElement fallingProblemsNotRelevantRadioBtn;
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q14'][@value='1']")
    WebElement fallingProblemsNoRadioBtn;
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q14'][@value='0']")
    WebElement fallingProblemsYesRadioBtn;
    @FindBy(xpath = "//textarea[@name='q15']")
    WebElement neurologicTextArea;

    //HEART AND LUNGS
    //heart problems
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q16'][@value='2']")
    WebElement heartProblemsNotRelevantRadioBtn;
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q16'][@value='1']")
    WebElement heartProblemsNoRadioBtn;
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q16'][@value='0']")
    WebElement heartProblemsYesRadioBtn;
    //conciousness problems
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q17'][@value='2']")
    WebElement conciousnessProblemsNotRelevantRadioBtn;
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q17'][@value='1']")
    WebElement conciousnessProblemsNoRadioBtn;
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q17'][@value='0']")
    WebElement conciousnessProblemsYesRadioBtn;
    //asthma problems
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q18'][@value='2']")
    WebElement asthmaProblemsNotRelevantRadioBtn;
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q18'][@value='1']")
    WebElement asthmaProblemsNoRadioBtn;
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q18'][@value='0']")
    WebElement asthmaProblemsYesRadioBtn;
    //night cough problems
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q19'][@value='2']")
    WebElement nightCoughProblemsNotRelevantRadioBtn;
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q19'][@value='1']")
    WebElement nightCoughProblemsNoRadioBtn;
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q19'][@value='0']")
    WebElement nightCoughProblemsYesRadioBtn;
    //lung infections
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q20'][@value='2']")
    WebElement lungInfectionsProblemsNotRelevantRadioBtn;
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q20'][@value='1']")
    WebElement lungInfectionsProblemsNoRadioBtn;
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q20'][@value='0']")
    WebElement lungInfectionsProblemsYesRadioBtn;
    //inhalation therapy
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q21'][@value='2']")
    WebElement inhalationProblemsNotRelevantRadioBtn;
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q21'][@value='1']")
    WebElement inhalationProblemsNoRadioBtn;
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q21'][@value='0']")
    WebElement inhalationProblemsYesRadioBtn;
    //snoring
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q22'][@value='2']")
    WebElement snoringProblemsNotRelevantRadioBtn;
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q22'][@value='1']")
    WebElement snoringProblemsNoRadioBtn;
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q22'][@value='0']")
    WebElement snoringProblemsYesRadioBtn;
    //rhinits
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q23'][@value='2']")
    WebElement rhinitsProblemsNotRelevantRadioBtn;
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q23'][@value='1']")
    WebElement rhinitsProblemsNoRadioBtn;
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q23'][@value='0']")
    WebElement rhinitsProblemsYesRadioBtn;
    //throat infections
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q24'][@value='2']")
    WebElement throatInfectionsProblemsNotRelevantRadioBtn;
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q24'][@value='1']")
    WebElement throatInfectionsProblemsNoRadioBtn;
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q24'][@value='0']")
    WebElement throatInfectionsProblemsYesRadioBtn;

    @FindBy(xpath = "//textarea[@name='q25']")
    WebElement heartTextArea;

    //BELLY
    //constipation
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q26'][@value='2']")
    WebElement constipationProblemsNotRelevantRadioBtn;
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q26'][@value='1']")
    WebElement constipationProblemsNoRadioBtn;
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q26'][@value='0']")
    WebElement constipationProblemsYesRadioBtn;
    //diarrhea
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q27'][@value='2']")
    WebElement diarrheaProblemsNotRelevantRadioBtn;
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q27'][@value='1']")
    WebElement diarrheaProblemsNoRadioBtn;
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q27'][@value='0']")
    WebElement diarrheaProblemsYesRadioBtn;
    //urinary problems
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q28'][@value='2']")
    WebElement urinaryProblemsNotRelevantRadioBtn;
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q28'][@value='1']")
    WebElement urinaryProblemsNoRadioBtn;
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q28'][@value='0']")
    WebElement urinaryProblemsYesRadioBtn;
    //urinary infections
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q29'][@value='2']")
    WebElement urinaryInfectionsProblemsNotRelevantRadioBtn;
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q29'][@value='1']")
    WebElement urinaryInfectionsProblemsNoRadioBtn;
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q29'][@value='0']")
    WebElement urinaryInfectionsProblemsYesRadioBtn;

    @FindBy(xpath = "//textarea[@name='q30']")
    WebElement bellyTextArea;

    //SKELETON, MUSCLE, SKIN
    //rash
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q31'][@value='2']")
    WebElement rashNotRelevantRadioBtn;
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q31'][@value='1']")
    WebElement rashNoRadioBtn;
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q31'][@value='0']")
    WebElement rashYesRadioBtn;
    //pain in joints
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q32'][@value='2']")
    WebElement painInJointsNotRelevantRadioBtn;
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q32'][@value='1']")
    WebElement painInJointsNoRadioBtn;
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q32'][@value='0']")
    WebElement painInJointsYesRadioBtn;
    //muscle pain
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q33'][@value='2']")
    WebElement musclePainNotRelevantRadioBtn;
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q33'][@value='1']")
    WebElement musclePainNoRadioBtn;
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q33'][@value='0']")
    WebElement musclePainYesRadioBtn;

    @FindBy(xpath = "//textarea[@name='q34']")
    WebElement muscleTextArea;

    //comments
    @FindBy(xpath = "//textarea[@name='q35']")
    WebElement commentsTextArea;

    @FindBy(id = "submit")
    WebElement submitButton;

    @FindBy(id = "RadWindowWrapper_ctl00_MainContent_rwFillReport")
    WebElement testForm;

    public ChronicQuestionnaireVladimirPage(WebDriver driver) {
        super(driver);
        this.PAGE_URL = "http://dhclinicappv2stg.item-soft.co.il/SitePages/createUser.aspx";
        PageFactory.initElements(driver, this);
    }

    public void fillElements() {
        //List<WebElement> divs = mainForm.findElements(By.tagName("div"));
        List<WebElement> tables = mainDiv.findElements(By.tagName("table"));
        for (WebElement element : tables) {
            System.out.println(element);
        }
        List<WebElement> rows, radioButtons;

        for (WebElement currentTable : tables) {
            rows = currentTable.findElements(By.tagName("tr"));
            for (WebElement currentRow : rows) {
                radioButtons = currentRow.findElements(By.tagName("input"));
                String rndValue = String.valueOf((int) (Math.random() * 3));
                for (WebElement currentRadioButton : radioButtons) {
                    if (currentRadioButton.getAttribute("value").equalsIgnoreCase(rndValue)) {
                        currentRadioButton.click();
                    }
                }
            }
        }
    }

    public ChronicQuestionnaireVladimirPage waitUntilTestPageIsLoaded() {
        try {
            waitUntilElementIsLoaded(testForm);
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
}