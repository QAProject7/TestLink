package com.telran.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.List;

/**
 * Created by Iakov Volf
 */
public class MobileQuestionnareForTeacher8qLeonid extends Page {

    @FindBy(xpath = "//div[@id='MainPage']//label[contains(text(), 'שאלון וונדרבילט למורה - דוח ממתין למילוי')]/../..//div[contains(text(), 'כעת')]")
    WebElement submitButton;

    @FindBy(xpath = ".//*[@id='listWaitingReports']/li")
    WebElement startButon;

    @FindBy(id = "form1")
    WebElement questionsForm;

    @FindBy(id = "LeftBtnHeader")
    WebElement sendResultButton;

    public MobileQuestionnareForTeacher8qLeonid(WebDriver driver) {
        super(driver);
        this.PAGE_URL = "http://dhclinicamobileppstg.item-soft.co.il/index.htm";
        PageFactory.initElements(driver, this);
    }


    public MobileQuestionnareForTeacher8qLeonid openLoginPage(WebDriver driver) {
        driver.get(PAGE_URL);
        return this;
    }
//fill
    public MobileQuestionnareForTeacher8qLeonid fillQuestionnaire(){
        List<WebElement> tables = questionsForm.findElements(By.className("sectionq "));
        for (WebElement element : tables) {
            System.out.println(element);
        }
        List<WebElement> spanWithInput, radioButtons;

        for (WebElement currentTable : tables) {
            spanWithInput = currentTable.findElements(By.className("answerInput"));
            int rndValue = (int) (Math.random() * 3);
            WebElement currentSpan = spanWithInput.get(rndValue);
            WebElement radioButton = currentSpan.findElement(By.tagName("input"));
            radioButton.click();
        }
        return this;
    }

// wait
    public MobileQuestionnareForTeacher8qLeonid waitUntilMenuPageIsLoaded() {
        try {
            waitUntilElementIsLoaded(submitButton);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }

    public MobileQuestionnareForTeacher8qLeonid waitUntilStartTestButtonIsLoaded() {
        try {
            waitUntilElementIsLoaded(startButon);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }

    public MobileQuestionnareForTeacher8qLeonid waitUntilQuestionsIsLoaded() {
        try {
            waitUntilElementIsLoaded(questionsForm);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }

// clicks
    public MobileQuestionnareForTeacher8qLeonid clickOnSubmitButton() {
        clickElement(submitButton);
        return this;
    }

    public MobileQuestionnareForTeacher8qLeonid clickOnStartTestButton() {
        clickElement(startButon);
        return this;
    }

    public MobileQuestionnareForTeacher8qLeonid clickOnSendResultbutton() {
        clickElement(sendResultButton);
        return this;
    }

    public boolean isOnLoginPage() {
        return exists(submitButton);
    }
}
