package com.telran.MobileWebPages;

        import com.telran.pages.Page;
        import org.openqa.selenium.By;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.support.FindBy;
        import org.openqa.selenium.support.PageFactory;

        import java.io.IOException;
        import java.util.List;

public class MobileForTeachersQuestionnairePageVadym extends Page {

    public MobileForTeachersQuestionnairePageVadym(WebDriver driver) {
        super(driver);
        this.PAGE_URL = "http://dhclinicamobileppstg.item-soft.co.il/index.htm";
        PageFactory.initElements(driver, this);
    }


    public MobileForTeachersQuestionnairePageVadym openLoginPage(WebDriver driver) {
        driver.get(PAGE_URL);
        return this;
    }
    @FindBy(xpath = "//*[@id='MainPage']//*[@class='nowBtn BaseBtn GreenBtn']")
    WebElement submitButton;

    //button on page after main menu
    @FindBy(xpath = "//*[@id='listWaitingReports']//*[@class='NextButton']")
    WebElement continueButton;

    //elements on questionnaire page
    @FindBy(id = "form1")
    WebElement questions;

    //button "send" on page form
    @FindBy(xpath = "//*[@id='LeftBtnHeader'][@class='BtnDisplayBehaver BaseBtn GreenBtn Send']")
    WebElement sendButton;

    //button "send" on page form
    @FindBy(xpath = "//*[@class='answerArea']//*[@type='text']")
    WebElement textIntroduce;


    //fill
    public MobileForTeachersQuestionnairePageVadym fillQuestionnaire(){
        List<WebElement> tables = questions.findElements(By.className("sectionq "));
        List<WebElement> spanWithInput, radioButtons;

        for (WebElement currentTable : tables) {
            spanWithInput = currentTable.findElements(By.className("answerInput"));
            if (spanWithInput.size()!=0) {
                int rndValue = (int) (Math.random() * (spanWithInput.size()-1));
                WebElement currentSpan = spanWithInput.get(rndValue);
                WebElement radioButton = currentSpan.findElement(By.tagName("input"));
                radioButton.click();
            }
            else {
                fillField("test");
            }

        }
        return this;
    }
    // wait
    public MobileForTeachersQuestionnairePageVadym waitUntilMenuPageIsLoaded() {
        try {
            waitUntilElementIsLoaded(submitButton);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }

    public MobileForTeachersQuestionnairePageVadym waitUntilStartTestButtonIsLoaded() {
        try {
            waitUntilElementIsLoaded(continueButton);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }

    public MobileForTeachersQuestionnairePageVadym waitUntilQuestionsIsLoaded() {
        try {
            waitUntilElementIsLoaded(questions);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }

    // clicks
    public MobileForTeachersQuestionnairePageVadym clickOnContinueButton() {
        clickElement(continueButton);
        return this;
    }

    public MobileForTeachersQuestionnairePageVadym clickOnStartTestButton() {
        clickElement(submitButton);
        return this;
    }

   public MobileForTeachersQuestionnairePageVadym clickOnSendbutton() {
        clickElement(sendButton);
        return this;
    }

    //assert

    public boolean isCancelButtonExist(){
        return exists(continueButton);
    }

/*    public boolean isHelpButtonExist(){
        return exists(helpButton);
    }*/
public MobileForTeachersQuestionnairePageVadym fillField(String text) {
    setElementText(textIntroduce, text);
    return this;
}
    public boolean isOnLoginPage() {
        return exists(submitButton);
    }
}
