package com.telran.MobileWebPages;

import com.telran.pages.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.telran.LogLog4j;
import org.apache.log4j.Logger;
import java.util.List;

import static org.testng.Assert.assertTrue;

/**
 * Created by Iakov Volf
 */
public class QuestionVanderbiltForParentsPetruninPage extends Page {

    private static Logger Log = Logger.getLogger(LogLog4j.class.getName());
        //fields

    @FindBy(xpath = "//*[@class='TitleManageNot'][contains(text(), 'שאלון וונדרבילט להורה - דוח ממתין למילוי')]/../..//*[@class='nowBtn BaseBtn GreenBtn']")
    WebElement submitButton;

    @FindBy(xpath = "//*[@id='listWaitingReports']//div[@class='NextImgButton']")
    WebElement nextImgButton;

    @FindBy(xpath = "//*[@id='form1']")
    WebElement form1;

   /* @FindBy(xpath = "/*//*[@id='form1']*//*[@class='sectionq']")
    WebElement point;*/

    @FindBy(xpath = "//*[@class='answerArea']//*[@type='text']")
    WebElement textIntroduce;

    @FindBy(id = "LeftBtnHeader")
    WebElement leftBtnHeader;


    //public ProfilePage profilePage;

    public QuestionVanderbiltForParentsPetruninPage(WebDriver driver) {
        super(driver);
        this.PAGE_URL = "http://dhclinicamobileppstg.item-soft.co.il/index.htm";
        PageFactory.initElements(driver, this);
    }


    public QuestionVanderbiltForParentsPetruninPage openLoginPage(WebDriver driver) {
        driver.get(PAGE_URL);
        return this;
    }


    public QuestionVanderbiltForParentsPetruninPage clickSubmitButton() {
        clickElement(submitButton);
        return this;
    }

    public void checkNextImgButton() {
        clickElement(nextImgButton);

    }

    public QuestionVanderbiltForParentsPetruninPage fillElements() {
        List<WebElement> sectionqs = form1.findElements(By.className("sectionq "));

        Log.info("Find all table elements");
        List<WebElement> spanWithInput, radioButtons;

        for (WebElement sec : sectionqs) {
            spanWithInput = sec.findElements(By.className("answerInput"));
            if (spanWithInput.size() != 0) {
                int rndValue = (int) (Math.random() * (spanWithInput.size() - 1));
                WebElement currentSpan = spanWithInput.get(rndValue);
                WebElement radioButton = currentSpan.findElement(By.tagName("input"));
                radioButton.click();
            } else {
                fillField("test");
            }
        }
    return this;
}
    public QuestionVanderbiltForParentsPetruninPage fillField(String text) {
        setElementText(textIntroduce, text);
        return this;
    }



    public QuestionVanderbiltForParentsPetruninPage checkLeftBtnHeader() {
        clickElement(leftBtnHeader);
        return this;
    }

}




