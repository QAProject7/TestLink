package com.telran.pages;

import com.telran.LogLog4j;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
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
public class ChronicQuestionnaire1VladimirPage extends Page {
    private static Logger Log = Logger.getLogger(LogLog4j.class.getName());

    Map<String, Integer> buttons = new HashMap<String, Integer>();
    ObjectOutputStream oos;

    @FindBy(id = "MainContent_contentHtml")
    WebElement mainDiv;

    @FindBy(id = "Top1_HeadLoginStatus")
    WebElement logOutButton;

    @FindBy(xpath = "//a[@class='rwCloseButton']")
    WebElement closeTableButton;

    @FindBy(id = "form1")
    WebElement mainForm;

    @FindBy(xpath = "//div/*[contains(text(),'שאלון מחלות כרוניות, ניתוחים וסקירת מערכות - דוח ממתין למילוי')]/../..//a[@class='LinkBtnPatients BlueBtn']")
    WebElement questionnaireChronicIllness;

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

    public void fillElements() {
        try {
            oos = new ObjectOutputStream((new FileOutputStream("c:\\temp\\buttons1.tst")));
        } catch (Exception e) {
            e.printStackTrace();
        }
        driver.switchTo().frame(driver.findElement(By.tagName("iframe")));

        List<WebElement> tables = mainDiv.findElements(By.tagName("table"));

        List<WebElement> rows, radioButtons;

        for (WebElement currentTable : tables) {
            Log.info("Filling the tables' radiobuttons");
            rows = currentTable.findElements(By.tagName("tr"));
            for (WebElement currentRow : rows) {
                radioButtons = currentRow.findElements(By.tagName("input"));
                String rndValue = String.valueOf(/*(int) (Math.random() * 3)*/ 1);
                for (WebElement currentRadioButton : radioButtons) {
                    if (currentRadioButton.getAttribute("value").equalsIgnoreCase(rndValue)) {
                        String name = currentRadioButton.getAttribute("name");
                        Log.info("Filling radioButtons with index " + rndValue + " with name " + name);
                        buttons.put(name, Integer.parseInt(currentRadioButton.getAttribute("value")));
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
        Log.info("Click on 'Submit' button");
        clickElement(submitButton);
        Log.info("Accepting alert window");
        driver.switchTo().alert().accept();
        Log.info("Switching to default content");
        driver.switchTo().defaultContent();
        Log.info("Clicking the 'Log Out' button");
        clickElement(logOutButton);
    }

    public boolean isChronicIllnessAvailable() {
        Log.info("Check if button 'Chronic Illness' available");
        return verifyElementIsPresent(questionnaireChronicIllness);
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