package com.telran.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Iterator;
import java.util.List;

/**
 * Created by Maksim Superfin on 09.11.2015.
 */
public class ChronicQuestionaryMaksimPage extends Page {

    @FindBy(xpath = "//input[@name='q2'][@value='2']")
    WebElement anyChronicIllnessNotRelevantRadioBtn;

    @FindBy(xpath = "//input[@name='q2'][@value='1']")
    WebElement anyChronicIllnessNoRadioBtn;

    @FindBy(xpath = "//input[@name='q2'][@value='0']")
    WebElement anyChronicIllnessYesRadioBtn;

    @FindBy(xpath = "//textarea[@name='q3']")
    WebElement anyChronicIllnessTextArea;

    @FindBy(xpath = "//input[@name='q4'][@value='2']")
    WebElement anyAnalizeNotRelevantRadioBtn;

    @FindBy(xpath = "//input[@name='q4'][@value='1']")
    WebElement anyAnalizeNoRadioBtn;

    @FindBy(xpath = "//input[@name='q4'][@value='0']")
    WebElement anyAnalizeYesRadioBtn;

    @FindBy(xpath = "//textarea[@name='q5']")
    WebElement anyAnalizeTextArea;



    @FindBy(xpath = "//input[@name='q6'][@value='2']")
    WebElement seizuresNotRelevantRadioBtn;

    @FindBy(xpath = "//input[@name='q6'][@value='1']")
    WebElement seizuresNoRadioBtn;

    @FindBy(xpath = "//input[@name='q6'][@value='0']")
    WebElement seizuresYesRadioBtn;

    @FindBy(xpath = "//input[@name='q7'][@value='2']")
    WebElement iroimNotRelevantRadioBtn;

    @FindBy(xpath = "//input[@name='q7'][@value='1']")
    WebElement iroimNoRadioBtn;

    @FindBy(xpath = "//input[@name='q7'][@value='0']")
    WebElement iroimYesRadioBtn;

    @FindBy(xpath = "//input[@name='q8'][@value='2']")
    WebElement ticsNotRelevantRadioBtn;

    @FindBy(xpath = "//input[@name='q8'][@value='1']")
    WebElement ticsNoRadioBtn;

    @FindBy(xpath = "//input[@name='q8'][@value='0']")
    WebElement ticsYesRadioBtn;

    @FindBy(xpath = "//input[@name='q9'][@value='2']")
    WebElement visionProblemsNotRelevantRadioBtn;

    @FindBy(xpath = "//input[@name='q9'][@value='1']")
    WebElement visionProblemsNoRadioBtn;

    @FindBy(xpath = "//input[@name='q9'][@value='0']")
    WebElement visionProblemsYesRadioBtn;

    @FindBy(xpath = "//input[@name='q10'][@value='2']")
    WebElement hearingProblemsNotRelevantRadioBtn;

    @FindBy(xpath = "//input[@name='q10'][@value='1']")
    WebElement hearingProblemsNoRadioBtn;

    @FindBy(xpath = "//input[@name='q10'][@value='0']")
    WebElement hearingProblemsYesRadioBtn;

    @FindBy(xpath = "//input[@name='q11'][@value='2']")
    WebElement speakingProblemNotRelevantRadioBtn;

    @FindBy(xpath = "//input[@name='q11'][@value='1']")
    WebElement speakingProblemNoRadioBtn;

    @FindBy(xpath = "//input[@name='q11'][@value='0']")
    WebElement speakingProblemYesRadioBtn;

    @FindBy(xpath = "//input[@name='q12'][@value='2']")
    WebElement swallowingProblemNotRelevantRadioBtn;

    @FindBy(xpath = "//input[@name='q12'][@value='1']")
    WebElement swallowingProblemNoRadioBtn;

    @FindBy(xpath = "//input[@name='q12'][@value='0']")
    WebElement swallowingProblemYesRadioBtn;

    @FindBy(xpath = "//input[@name='q13'][@value='2']")
    WebElement movingArmsProblemNotRelevantRadioBtn;

    @FindBy(xpath = "//input[@name='q13'][@value='1']")
    WebElement movingArmsProblemNoRadioBtn;

    @FindBy(xpath = "//input[@name='q13'][@value='0']")
    WebElement movingArmsProblemYesRadioBtn;

    @FindBy(xpath = "//input[@name='q14'][@value='2']")
    WebElement repeatFallsProblemNotRelevantRadioBtn;

    @FindBy(xpath = "//input[@name='q14'][@value='1']")
    WebElement repeatFallsProblemNoRadioBtn;

    @FindBy(xpath = "//input[@name='q14'][@value='0']")
    WebElement repeatFallsProblemYesRadioBtn;

    @FindBy(xpath = "//textarea[@name='q15']")
    WebElement neurologicTextArea;

    @FindBy(xpath = "//input[@name='q16'][@value='2']")
    WebElement heartProblemsNotRelevantRadioBtn;

    @FindBy(xpath = "//input[@name='q16'][@value='1']")
    WebElement heartProblemsNoRadioBtn;

    @FindBy(xpath = "//input[@name='q16'][@value='0']")
    WebElement heartProblemsYesRadioBtn;

    @FindBy(xpath = "//input[@name='q17'][@value='2']")
    WebElement lossOfConsciousnessNotRelevantRadioBtn;

    @FindBy(xpath = "//input[@name='q17'][@value='1']")
    WebElement lossOfConsciousnessNoRadioBtn;

    @FindBy(xpath = "//input[@name='q17'][@value='0']")
    WebElement lossOfConsciousnessYesRadioBtn;

    @FindBy(xpath = "//input[@name='q18'][@value='2']")
    WebElement astmaNotRelevantRadioBtn;

    @FindBy(xpath = "//input[@name='q18'][@value='1']")
    WebElement astmaNoRadioBtn;

    @FindBy(xpath = "//input[@name='q18'][@value='0']")
    WebElement astmaYesRadioBtn;

    @FindBy(xpath = "//input[@name='q19'][@value='2']")
    WebElement coughtAtNightNotRelevantRadioBtn;

    @FindBy(xpath = "//input[@name='q19'][@value='1']")
    WebElement coughtAtNightNoRadioBtn;

    @FindBy(xpath = "//input[@name='q19'][@value='0']")
    WebElement coughtAtNightYesRadioBtn;

    @FindBy(xpath = "//input[@name='q20'][@value='2']")
    WebElement lungInfectionsNotRelevantRadioBtn;

    @FindBy(xpath = "//input[@name='q20'][@value='1']")
    WebElement lungInfectionsNoRadioBtn;

    @FindBy(xpath = "//input[@name='q20'][@value='0']")
    WebElement lungInfectionsYesRadioBtn;

    @FindBy(xpath = "//input[@name='q21'][@value='2']")
    WebElement inhalationTherapyNotRelevantRadioBtn;

    @FindBy(xpath = "//input[@name='q21'][@value='1']")
    WebElement inhalationTherapyNoRadioBtn;

    @FindBy(xpath = "//input[@name='q21'][@value='0']")
    WebElement inhalationTherapyYesRadioBtn;

    @FindBy(xpath = "//input[@name='q22'][@value='2']")
    WebElement snoringNotRelevantRadioBtn;

    @FindBy(xpath = "//input[@name='q22'][@value='1']")
    WebElement snoringNoRadioBtn;

    @FindBy(xpath = "//input[@name='q22'][@value='0']")
    WebElement snoringYesRadioBtn;

    @FindBy(xpath = "//input[@name='q23'][@value='2']")
    WebElement rhinitsrhinitsNotRelevantRadioBtn;

    @FindBy(xpath = "//input[@name='q23'][@value='1']")
    WebElement rhinitsNoRadioBtn;

    @FindBy(xpath = "//input[@name='q23'][@value='0']")
    WebElement rhinitsYesRadioBtn;

    @FindBy(xpath = "//input[@name='q24'][@value='2']")
    WebElement throatInfectionsNotRelevantRadioBtn;

    @FindBy(xpath = "//input[@name='q24'][@value='1']")
    WebElement throatInfectionsNoRadioBtn;

    @FindBy(xpath = "//input[@name='q24'][@value='0']")
    WebElement throatInfectionsYesRadioBtn;

    @FindBy(xpath = "//textarea[@name='q25']")
    WebElement heartTextArea;

    //BELLY
    //constipation
    @FindBy(xpath = "//input[@name='q26'][@value='2']")
    WebElement constipationProblemsNotRelevantRadioBtn;

    @FindBy(xpath = "//input[@name='q26'][@value='1']")
    WebElement constipationProblemsNoRadioBtn;

    @FindBy(xpath = "//input[@name='q26'][@value='0']")
    WebElement constipationProblemsYesRadioBtn;

    //diarrhea
    @FindBy(xpath = "//input[@name='q27'][@value='2']")
    WebElement diarrheaProblemsNotRelevantRadioBtn;

    @FindBy(xpath = "//input[@name='q27'][@value='1']")
    WebElement diarrheaProblemsNoRadioBtn;

    @FindBy(xpath = "//input[@name='q27'][@value='0']")
    WebElement diarrheaProblemsYesRadioBtn;

    //urinary problems
    @FindBy(xpath = "//input[@name='q28'][@value='2']")
    WebElement urinaryProblemsNotRelevantRadioBtn;

    @FindBy(xpath = "//input[@name='q28'][@value='1']")
    WebElement urinaryProblemsNoRadioBtn;

    @FindBy(xpath = "//input[@name='q28'][@value='0']")
    WebElement urinaryProblemsYesRadioBtn;

    //urinary infections
    @FindBy(xpath = "//input[@name='q29'][@value='2']")
    WebElement urinaryInfectionsProblemsNotRelevantRadioBtn;

    @FindBy(xpath = "//input[@name='q29'][@value='1']")
    WebElement urinaryInfectionsProblemsNoRadioBtn;

    @FindBy(xpath = "//input[@name='q29'][@value='0']")
    WebElement urinaryInfectionsProblemsYesRadioBtn;

    @FindBy(xpath = "//textarea[@name='q30']")
    WebElement bellyTextArea;
    
    @FindBy(xpath = "//input[@name='q31'][@value='2']")
    WebElement rashNotRelevantRadioBtn;

    @FindBy(xpath = "//input[@name='q31'][@value='1']")
    WebElement rashNoRadioBtn;

    @FindBy(xpath = "//input[@name='q31'][@value='0']")
    WebElement rashYesRadioBtn;

    @FindBy(xpath = "//input[@name='q32'][@value='2']")
    WebElement painInJointsNotRelevantRadioBtn;

    @FindBy(xpath = "//input[@name='q32'][@value='1']")
    WebElement painInJointsNoRadioBtn;

    @FindBy(xpath = "//input[@name='q32'][@value='0']")
    WebElement painInJointsYesRadioBtn;

    @FindBy(xpath = "//input[@name='q33'][@value='2']")
    WebElement musclePainNotRelevantRadioBtn;

    @FindBy(xpath = "//input[@name='q33'][@value='1']")
    WebElement musclePainNoRadioBtn;

    @FindBy(xpath = "//input[@name='q33'][@value='0']")
    WebElement musclePainYesRadioBtn;

    @FindBy(xpath = "//textarea[@name='q34']")
    WebElement muscleTextArea;

    @FindBy(xpath = "//textarea[@name='q35']")
    WebElement commentsTextArea;

    @FindBy(id = "submit")
    WebElement submitButton;

    @FindBy(id = "MainContent_contentHtml")
    WebElement mainDiv;

    public ChronicQuestionaryMaksimPage(WebDriver driver) {
        super(driver);
        // TODO:
    }

    public void fillElements() {
        List<WebElement> tables = mainDiv.findElements(By.tagName("table"));
        List<WebElement> rows, radioButtons;
        for (WebElement curTable: tables) {
            rows = curTable.findElements(By.tagName("tr"));
            for (WebElement curRow: rows) {
                radioButtons = curRow.findElements(By.tagName("input"));
                String randomValue = String.valueOf((int)(Math.random()*3));
                for (WebElement curRadioButton: radioButtons) {
                    if (curRadioButton.getAttribute("value").equals(randomValue)) {
                        curRadioButton.click();
                    }
                }
            }
        }
    }
}
