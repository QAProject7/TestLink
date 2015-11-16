package com.telran.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Naryck on 2015.11.09.
 */
public class ChronicQuestionnaire3VladimirPage extends Page {
    Map<String, Integer> buttons = new HashMap<String, Integer>();
    ObjectOutputStream oos;

    @FindBy(id = "MainContent_contentHtml")
    WebElement mainDiv;

    /*@FindBy(id = "form1")
    WebElement mainForm;

    //VANDERBILT CHRONIC QUESTIONNAIRE
    //Attention to Details
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q1'][@value='3']")
    WebElement chronicAttentionOftenRadioBtn;
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q1'][@value='2']")
    WebElement chronicAttentionOnceRadioBtn;
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q1'][@value='1']")
    WebElement chronicAttentionSeldomRadioBtn;
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q1'][@value='0']")
    WebElement chronicAttentionNeverRadioBtn;
    //Not Staying on Task and Stops Playing
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q2'][@value='3']")
    WebElement taskOftenRadioBtn;
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q2'][@value='2']")
    WebElement taskOnceRadioBtn;
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q2'][@value='1']")
    WebElement taskSeldomRadioBtn;
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q2'][@value='0']")
    WebElement taskNeverRadioBtn;
    //Not Listening
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q3'][@value='3']")
    WebElement notListenOftenRadioBtn;
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q3'][@value='2']")
    WebElement notListenOnceRadioBtn;
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q3'][@value='1']")
    WebElement notListenSeldomRadioBtn;
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q3'][@value='0']")
    WebElement notListenNeverRadioBtn;
    //Can Not Finish Required Work
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q4'][@value='3']")
    WebElement notFinishOftenRadioBtn;
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q4'][@value='2']")
    WebElement notFinishOnceRadioBtn;
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q4'][@value='1']")
    WebElement notFinishSeldomRadioBtn;
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q4'][@value='0']")
    WebElement notFinishNeverRadioBtn;
    //Difficulty Organizing Tasks
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q5'][@value='3']")
    WebElement notOrganizedOftenRadioBtn;
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q5'][@value='2']")
    WebElement notOrganizedOnceRadioBtn;
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q5'][@value='1']")
    WebElement notOrganizedSeldomRadioBtn;
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q5'][@value='0']")
    WebElement notOrganizedNeverRadioBtn;
    //Deterred from Performing Tasks
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q6'][@value='3']")
    WebElement deterredOftenRadioBtn;
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q6'][@value='2']")
    WebElement deterredOnceRadioBtn;
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q6'][@value='1']")
    WebElement deterredSeldomRadioBtn;
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q6'][@value='0']")
    WebElement deterredNeverRadioBtn;
    //Lose Things
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q7'][@value='3']")
    WebElement losingOftenRadioBtn;
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q7'][@value='2']")
    WebElement losingOnceRadioBtn;
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q7'][@value='1']")
    WebElement losingSeldomRadioBtn;
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q7'][@value='0']")
    WebElement losingNeverRadioBtn;
    //Distracted Easily
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q8'][@value='3']")
    WebElement distractedOftenRadioBtn;
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q8'][@value='2']")
    WebElement distractedOnceRadioBtn;
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q8'][@value='1']")
    WebElement distractedSeldomRadioBtn;
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q8'][@value='0']")
    WebElement distractedNeverRadioBtn;
    //Forgets things
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q9'][@value='3']")
    WebElement forgetsOftenRadioBtn;
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q9'][@value='2']")
    WebElement forgetsOnceRadioBtn;
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q9'][@value='1']")
    WebElement forgetsSeldomRadioBtn;
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q9'][@value='0']")
    WebElement forgetsNeverRadioBtn;
    //Moves Restlessly
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q10'][@value='3']")
    WebElement restlessOftenRadioBtn;
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q10'][@value='2']")
    WebElement restlessOnceRadioBtn;
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q10'][@value='1']")
    WebElement restlessSeldomRadioBtn;
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q10'][@value='0']")
    WebElement restlessNeverRadioBtn;
    //Leaves Places
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q11'][@value='3']")
    WebElement leavesOftenRadioBtn;
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q11'][@value='2']")
    WebElement leavesOnceRadioBtn;
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q11'][@value='1']")
    WebElement leavesSeldomRadioBtn;
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q11'][@value='0']")
    WebElement leavesNeverRadioBtn;
    //Running or Climbing in not Suitable Situations
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q12'][@value='3']")
    WebElement climbingOftenRadioBtn;
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q12'][@value='2']")
    WebElement climbingOnceRadioBtn;
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q12'][@value='1']")
    WebElement climbingSeldomRadioBtn;
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q12'][@value='0']")
    WebElement climbingNeverRadioBtn;
    //Not Playing
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q13'][@value='3']")
    WebElement notPlayingOftenRadioBtn;
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q13'][@value='2']")
    WebElement notPlayingOnceRadioBtn;
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q13'][@value='1']")
    WebElement notPlayingSeldomRadioBtn;
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q13'][@value='0']")
    WebElement notPlayingNeverRadioBtn;
    //Restless as Driven by Motor
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q14'][@value='3']")
    WebElement motorDrivenOftenRadioBtn;
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q14'][@value='2']")
    WebElement motorDrivenOnceRadioBtn;
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q14'][@value='1']")
    WebElement motorDrivenSeldomRadioBtn;
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q14'][@value='0']")
    WebElement motorDrivenNeverRadioBtn;
    //Talks Too Much
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q15'][@value='3']")
    WebElement talksMuchOftenRadioBtn;
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q15'][@value='2']")
    WebElement talksMuchOnceRadioBtn;
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q15'][@value='1']")
    WebElement talksMuchSeldomRadioBtn;
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q15'][@value='0']")
    WebElement talksMuchNeverRadioBtn;
    //Explosive Answers
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q16'][@value='3']")
    WebElement explosiveOftenRadioBtn;
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q16'][@value='2']")
    WebElement explosiveOnceRadioBtn;
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q16'][@value='1']")
    WebElement explosiveSeldomRadioBtn;
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q16'][@value='0']")
    WebElement explosiveNeverRadioBtn;
    //Difficulties with Waiting
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q17'][@value='3']")
    WebElement noWaitOftenRadioBtn;
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q17'][@value='2']")
    WebElement noWaitOnceRadioBtn;
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q17'][@value='1']")
    WebElement noWaitSeldomRadioBtn;
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q17'][@value='0']")
    WebElement noWaitNeverRadioBtn;
    //Interferes Conversations
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q18'][@value='3']")
    WebElement interfereOftenRadioBtn;
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q18'][@value='2']")
    WebElement interfereOnceRadioBtn;
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q18'][@value='1']")
    WebElement interfereSeldomRadioBtn;
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q18'][@value='0']")
    WebElement interfereNeverRadioBtn;

    //SYMPTOMS
    //Argues With Adults
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q19'][@value='3']")
    WebElement arguesOftenRadioBtn;
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q19'][@value='2']")
    WebElement arguesOnceRadioBtn;
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q19'][@value='1']")
    WebElement arguesSeldomRadioBtn;
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q19'][@value='0']")
    WebElement arguesNeverRadioBtn;
    //Impatient
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q20'][@value='3']")
    WebElement impatientOftenRadioBtn;
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q20'][@value='2']")
    WebElement impatientOnceRadioBtn;
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q20'][@value='1']")
    WebElement impatientSeldomRadioBtn;
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q20'][@value='0']")
    WebElement impatientNeverRadioBtn;
    //Refuses to Abide Requests
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q21'][@value='3']")
    WebElement noAbidanceOftenRadioBtn;
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q21'][@value='2']")
    WebElement noAbidanceOnceRadioBtn;
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q21'][@value='1']")
    WebElement noAbidanceSeldomRadioBtn;
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q21'][@value='0']")
    WebElement noAbidanceNeverRadioBtn;
    //Annoying Others
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q22'][@value='3']")
    WebElement annoyingOftenRadioBtn;
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q22'][@value='2']")
    WebElement annoyingOnceRadioBtn;
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q22'][@value='1']")
    WebElement annoyingSeldomRadioBtn;
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q22'][@value='0']")
    WebElement annoyingNeverRadioBtn;
    //Blames Others
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q23'][@value='3']")
    WebElement blameOftenRadioBtn;
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q23'][@value='2']")
    WebElement blameOnceRadioBtn;
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q23'][@value='1']")
    WebElement blameSeldomRadioBtn;
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q23'][@value='0']")
    WebElement blameNeverRadioBtn;
    //Too Sensitive
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q24'][@value='3']")
    WebElement sensitiveOftenRadioBtn;
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q24'][@value='2']")
    WebElement sensitiveOnceRadioBtn;
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q24'][@value='1']")
    WebElement sensitiveSeldomRadioBtn;
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q24'][@value='0']")
    WebElement sensitiveNeverRadioBtn;
    //Angry or Bitter
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q25'][@value='3']")
    WebElement angryOftenRadioBtn;
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q25'][@value='2']")
    WebElement angryOnceRadioBtn;
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q25'][@value='1']")
    WebElement angrySeldomRadioBtn;
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q25'][@value='0']")
    WebElement angryNeverRadioBtn;
    //Vindictive
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q26'][@value='3']")
    WebElement vindictiveOftenRadioBtn;
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q26'][@value='2']")
    WebElement vindictiveOnceRadioBtn;
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q26'][@value='1']")
    WebElement vindictiveSeldomRadioBtn;
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q26'][@value='0']")
    WebElement vindictiveNeverRadioBtn;

    //ACHIEVEMENTS
    //Reading
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q27'][@value='4']")
    WebElement problematicReadingRadioBtn;
    //Writing
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q28'][@value='4']")
    WebElement problematicWritingRadioBtn;
    //Count
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q29'][@value='4']")
    WebElement problematicCountRadioBtn;
    //Relations with Parents
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q30'][@value='4']")
    WebElement problematicParentsWritingRadioBtn;
    //Relations with Parents
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q31'][@value='4']")
    WebElement problematicSiblingsRadioBtn;
    //Relations with Friends
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q32'][@value='4']")
    WebElement problematicFriendsRadioBtn;
    //Group Activities
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q33'][@value='4']")
    WebElement problematicActivitiesRadioBtn;

    //SIDE EFFECTS
    //Head Aches
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q34'][@value='3']")
    WebElement headAchesToughRadioBtn;
    //Abdominal Pain
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q35'][@value='3']")
    WebElement abdominalPainToughRadioBtn;
    //Appetite
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q36'][@value='3']")
    WebElement appetiteChangesToughRadioBtn;
    //Difficult Sleep
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q37'][@value='3']")
    WebElement difficultSleepingToughRadioBtn;
    //Unrest
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q38'][@value='3']")
    WebElement unrestToughRadioBtn;
    //Social Drop
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q39'][@value='3']")
    WebElement socialDropToughRadioBtn;
    //Extremely Sad
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q40'][@value='3']")
    WebElement sadToughRadioBtn;
    //Indifferent, Bored, Tired
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q41'][@value='3']")
    WebElement boredToughRadioBtn;
    //Sense of Tremor
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q42'][@value='3']")
    WebElement tremorToughRadioBtn;
    //Facial Deformities
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q43'][@value='3']")
    WebElement ticToughRadioBtn;
    //Nail Biting
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q44'][@value='3']")
    WebElement nailBitingToughRadioBtn;
    //Hallucinating
    @FindBy(xpath = "//div[@id='MainContent_contentHtml']//input[@name='q45'][@value='3']")
    WebElement hallucinatingToughRadioBtn;*/

    @FindBy(id = "submit")
    WebElement submitButton;
    /*@FindBy(id = "ExportFrame")
    WebElement iFrame;*/

    public ChronicQuestionnaire3VladimirPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void fillElements() {
        try {
            oos = new ObjectOutputStream((new FileOutputStream("d:\\buttons3.tst")));
        } catch (Exception e) {
            e.printStackTrace();
        }
        driver.switchTo().frame(driver.findElement(By.tagName("iFrame")));
        //driver.switchTo().defaultContent();
//>>>>>>> Stashed changes
        List<WebElement> tables = mainDiv.findElements(By.tagName("table"));
        for (WebElement element : tables) {
            System.out.println(element);
        }
        List<WebElement> rows, radioButtons;

        for (WebElement currentTable : tables) {
            rows = currentTable.findElements(By.tagName("tr"));
            for (WebElement currentRow : rows) {
                radioButtons = currentRow.findElements(By.tagName("input"));
                String rndValue = String.valueOf(1);
                for (WebElement currentRadioButton : radioButtons) {
                    if (currentRadioButton.getAttribute("value").equalsIgnoreCase(rndValue)) {
                        buttons.put(currentRadioButton.getAttribute("name"), Integer.parseInt(currentRadioButton.getAttribute("value")));
                        currentRadioButton.click();
                    }
                }
            }
            try {
                oos.writeObject(buttons);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        clickElement(submitButton);
        try {
            wait(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.switchTo().activeElement().sendKeys(Keys.RETURN);
    }

    public ChronicQuestionnaire3VladimirPage waitUntilTestPageIsLoaded() {
        try {
            waitUntilElementIsLoaded(submitButton);
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