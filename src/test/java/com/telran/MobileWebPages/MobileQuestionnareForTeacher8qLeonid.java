package com.telran.MobileWebPages;

import com.telran.pages.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.List;

/**
 * Created by Leonid Gengrinovich
 */
public class MobileQuestionnareForTeacher8qLeonid extends Page {

    //main menu elements
    @FindBy(xpath = "//div[@id='MainPage']//label[contains(text(), 'שאלון וונדרבילט למורה - דוח ממתין למילוי')]/../..//div[contains(text(), 'כעת')]")
    WebElement submitButton;

    //button on page after main menu
    @FindBy(xpath = ".//*[@id='listWaitingReports']/li")
    WebElement startButon;

    //elements on questionnaire page
    @FindBy(id = "form1")
    WebElement questionsForm;

    @FindBy(id = "LeftBtnHeader")
    WebElement sendResultButton;

    @FindBy(id = "RightBtnHeader")
    WebElement cancelButton;

    @FindBy(xpath = "//div[@class='BtnDisplayBehaver Help'")
    WebElement helpButton;

    public MobileQuestionnareForTeacher8qLeonid(WebDriver driver) {
        super(driver);
        this.PAGE_URL = "http://dhclinicamobileppstg.item-soft.co.il/index.htm";
        PageFactory.initElements(driver, this);
    }


    public MobileQuestionnareForTeacher8qLeonid openLoginPage(WebDriver driver) {
        driver.get(PAGE_URL);
        return this;
    }
//find element
    public List<WebElement> getAllQuestions(){
        return questionsForm.findElements(By.className("sectionq "));
    }

//fill
    public MobileQuestionnareForTeacher8qLeonid fillQuestionnaire() throws InterruptedException {
        List<WebElement> divs = questionsForm.findElements(By.className("sectionq "));

        List<WebElement> spanWithInput, radioButtons;
        int divAnswered = 0;
        int divNotAnswered = divs.size();

        for (WebElement div: divs) {
            clickOnSendResultbutton();
            int divCounter = 1;
            for(WebElement question: divs) {
                if(divCounter > divAnswered) {
                    question.getAttribute("class").equals("sectionq  Required");
                    System.out.println("divAnswered = " + divAnswered + ". divCounter = " + divCounter);
                    //todo assert na razmer ostavwihsya qs
                }
                divCounter++;
            }
            spanWithInput = div.findElements(By.className("answerInput"));
            int rndValue = (int) (Math.random() * 3);
            WebElement currentSpan = spanWithInput.get(rndValue);
            WebElement radioButton = currentSpan.findElement(By.tagName("input"));
            radioButton.click();
            divAnswered++;
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
//assert

    public boolean isCancelButtonExist(){
        return exists(cancelButton);
    }

    public boolean isHelpButtonExist(){
        return exists(helpButton);
    }

    public boolean isOnLoginPage() {
        return exists(submitButton);
    }
}
