package com.telran.MobileWebPages;

import com.telran.pages.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static org.testng.Assert.assertTrue;

/**
 * Created by Iakov Volf
 */
public class QuestionVanderbiltForParentsPetrunin extends Page {

    QuestionVanderbiltForParentsPetrunin questionVanderbiltForParentsPetrunin;
    //private static Logger Log = Logger.getLogger(LogLog4j.class.getName());
    //fields
    @FindBy(xpath = "//div[@id='MainPage']//label[contains(text(), 'שאלון וונדרבילט להורה- אבחון מעקב - דוח ממתין למילוי')]/../..//div[contains(text(), 'כעת')]")
    WebElement submitButton;

    @FindBy(xpath = "//*[@id='listWaitingReports']//div[@class='NextImgButton']")
    WebElement nextImgButton;

    @FindBy(xpath = "//*[@id='form1']")
    WebElement form1;

   /* @FindBy(xpath = "/*//*[@id='form1']*//*[@class='sectionq']")
    WebElement point;*/


    @FindBy(id = "LeftBtnHeader")
    WebElement leftBtnHeader;


    //public ProfilePage profilePage;

    public QuestionVanderbiltForParentsPetrunin(WebDriver driver) {
        super(driver);
        this.PAGE_URL = "http://dhclinicamobileppstg.item-soft.co.il/index.htm";
        PageFactory.initElements(driver, this);
    }


    public QuestionVanderbiltForParentsPetrunin openLoginPage(WebDriver driver) {
        driver.get(PAGE_URL);
        return this;
    }


    public QuestionVanderbiltForParentsPetrunin clickSubmitButton() {
        clickElement(submitButton);
        return this;
    }

    public void checkNextImgButton() {
        clickElement(nextImgButton);

    }

    public void fillElements() {
        List<WebElement> sectionqs = form1.findElements(By.className("sectionq "));
        List<WebElement> spanWithInput, radioButtons;
        int divAnswered = 0;
        int divNotAnswered = sectionqs.size();

        for (WebElement sec: sectionqs) {
            questionVanderbiltForParentsPetrunin.checkLeftBtnHeader();
            int divCounter = 1;
            for(WebElement question: sectionqs) {
                if(divCounter > divAnswered) {
                    assertTrue(question.getAttribute("class").equals("sectionq  Required"));
                }
                divCounter++;
            }
            spanWithInput = sec.findElements(By.className("answerInput"));
            int rndValue = (int) (Math.random() * 3);
            WebElement currentSpan = spanWithInput.get(rndValue);
            WebElement radioButton = currentSpan.findElement(By.tagName("input"));
            radioButton.click();
            divAnswered++;
        }
    }

    public QuestionVanderbiltForParentsPetrunin checkLeftBtnHeader() {
        clickElement(leftBtnHeader);
        return this;
    }

}




