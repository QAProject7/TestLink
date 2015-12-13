package com.telran.pages;

import com.telran.LogLog4j;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.*;
import java.util.*;

/**
 * Created by Naryck on 2015.11.09.
 */
public class ChronicQuestionnaire1VladimirPage extends Page {
    public static String FILE_PATH;
    public static String teudat;
    private static Logger Log = Logger.getLogger(LogLog4j.class.getName());

    Map<String, Integer> buttons = new HashMap<String, Integer>();
    ObjectOutputStream oos;
    ObjectInputStream ois;

    @FindBy(id = "MainContent_contentHtml")
    WebElement mainDiv;

    @FindBy(id = "Top1_HeadLoginStatus")
    WebElement logOutButton;

    @FindBy(id = "form1")
    WebElement mainForm;

    @FindBy(xpath = "//div/*[contains(text(),'שאלון מחלות כרוניות, ניתוחים וסקירת מערכות - דוח ממתין למילוי')]/../..//a[@class='LinkBtnPatients BlueBtn']")
    WebElement questionnaireChronicIllness;

    @FindBy(xpath = "//*[@id='popup']")
    WebElement questionnairePopUp;

    //comments
    @FindBy(xpath = "//textarea[@name='q35']")
    WebElement commentsTextArea;

    @FindBy(id = "submit")
    WebElement submitButton;

    @FindBy(id = "RadWindowWrapper_ctl00_MainContent_rwFillReport")
    WebElement testForm;

    @FindBy(xpath = "//iframe[@name='rwFillReport']")
    WebElement iFrame;

    public ChronicQuestionnaire1VladimirPage(WebDriver driver) {
        super(driver);
        this.PAGE_URL = "http://dhclinicappv2stg.item-soft.co.il/SitePages/createUser.aspx";
        PageFactory.initElements(driver, this);
    }

    public void fillElements(String zeut) {
        FILE_PATH = "D:\\" + zeut + ".tst";
        teudat = zeut;
        try {
            oos = new ObjectOutputStream((new FileOutputStream(FILE_PATH)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        driver.switchTo().frame(driver.findElement(By.tagName("iframe")));

        List<WebElement> tables = mainDiv.findElements(By.tagName("table"));

        List<WebElement> rows, radioButtons, tds;

        for (WebElement currentTable : tables) {
            Log.info("Filling the tables' radiobuttons");
            rows = currentTable.findElements(By.tagName("tr"));
            for (WebElement currentRow : rows) {
                radioButtons = currentRow.findElements(By.tagName("input"));
                String rndValue = String.valueOf((int) (Math.random() * 3) /*0*/);
                for (WebElement currentRadioButton : radioButtons) {
                    if (currentRadioButton.getAttribute("value").equalsIgnoreCase(rndValue)) {
                        String name = currentRadioButton.getAttribute("name");
                        String question = "";
                        tds = currentRow.findElements(By.tagName("td"));
                        for (WebElement td: tds) {
                            if ("quest".equals(td.getAttribute("class"))) {
                                question = td.getText();
                            }
                        }
                        Log.info("Filling radioButtons with index " + rndValue + " with name " + name +
                                " and question = " + question);
                        buttons.put(question, Integer.parseInt(currentRadioButton.getAttribute("value")));
                        currentRadioButton.click();
                    }
                }
            }
        }
        fillTextAreas(loadSectionsTexts());

        try {
            oos.writeObject(buttons);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //checkAnswers();
        Log.info("Click on 'Submit' button");
        clickElement(submitButton);
        Log.info("Accepting alert window");
        driver.switchTo().alert().accept();
        Log.info("Switching to default content");
        driver.switchTo().defaultContent();
        Log.info("Clicking the 'Log Out' button");
        clickElement(logOutButton);
    }

    private Map<String, String> loadSectionsTexts() {
        // TODO: add logic
        return null;
    }

    private void fillTextAreas(Map<String, String> sectionsTexts) {
        Set<String> sectionsNames = sectionsTexts.keySet();
        for (String sectionName: sectionsNames) {
            WebElement textArea = driver.findElement(
                    By.xpath("//h2[text()='" + sectionName + 
                            "']/following-sibling::table[2]//textarea"));
            // TODO: in case textArea is not found add there logic to display it
            textArea.clear();
            textArea.sendKeys(sectionsTexts.get(sectionName));
        }
    }
    
    public void checkAnswers() {
        // TODO: logic should be moved into proper place
        Log.info("Check Answers");
        try {
            ois = new ObjectInputStream(new FileInputStream(FILE_PATH));
            List<WebElement> radioBtns = mainDiv.findElements(By.xpath("//input[@type='radio']"));
            Map<String, Integer> selectedRadioBtns = new HashMap<String, Integer>();
            for (WebElement rbtn: radioBtns) {
                Log.info("name: " + rbtn.getAttribute("name") + " value " + rbtn.getAttribute("value")
                    + " selected " + rbtn.getAttribute("selected"));
                if ("true".equals(rbtn.getAttribute("selected"))) {
                    selectedRadioBtns.put(rbtn.getAttribute("name"),
                            Integer.valueOf(rbtn.getAttribute("value")));
                }
            }
            Map<String, Integer> buttonsFromFile = (Map<String, Integer>) ois.readObject();
            Log.info("Maps are equal: " + buttonsFromFile.equals(selectedRadioBtns));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean isChronicIllnessAvailable() {
        Log.info("Check if button 'Chronic Illness' available");
        return verifyElementIsPresent(questionnaireChronicIllness);
    }

    public boolean isPopUpPresent() {
        Log.info("Check if popup window disappeared");
        return verifyElementIsPresent(questionnairePopUp);
    }

    public ChronicQuestionnaire1VladimirPage waitUntilTestPageIsLoaded() {
        try {
            Log.info("Waiting for the test page to load");
            waitUntilElementIsLoaded(questionnaireChronicIllness);
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

    public void clickTestButton() {
        Log.info("Clocking the 'Test' button");
        clickElement(questionnaireChronicIllness);
    }

}