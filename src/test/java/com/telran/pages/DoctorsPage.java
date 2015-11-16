package com.telran.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

/**
 * Created by Iakov Volf,Oleg
 */
public class DoctorsPage extends Page {

    @FindBy(id = "MainContent_LoginUser_Password")
    WebElement passwordField;
    @FindBy(id = "MainContent_LoginUser_RegisterHyperLink")
    WebElement goToRegLink;
    @FindBy(id = "MainContent_LoginUser_LoginButton")
    WebElement loginButton;
    @FindBy(xpath = "//span[@id='Top1_HeadLoginView_DisplayName']")
    private WebElement namesField;
    //buttons
    @FindBy(xpath = "//a[@class='forgot']")
    private WebElement forgotPassLink;
    //alerts
    @FindBy(xpath = "//div[@id='MainContent_LoginUser_LoginUserValidationSummary']/ul/li[contains(text(),'שם משתמש חובה')]")
    private WebElement wrongUsernameAlert;

    @FindBy(xpath = "//div[@id='MainContent_LoginUser_LoginUserValidationSummary']/ul/li[contains(text(),'סיסמא חובה.')]")
    private WebElement wrongPasswordAlert;


    @FindBy(xpath = "//a[@class='LinkBtnPatients GreenBtn']")
    private WebElement goToPatientButton;

    @FindBy(id = "MainContent_ItemLinkButton3")
    private WebElement addPatientButton;
//*[@id='MainContent_ItemLinkButton3']

    public DoctorsPage(WebDriver driver) {
        super(driver);
        this.PAGE_URL = "http://dhclinicappv2stg.item-soft.co.il/SecurityInfrastructure/Accounts.aspx";
        PageFactory.initElements(driver, this);
    }

    public DoctorsPage openMainPage(WebDriver driver) {
        driver.get(PAGE_URL);
        return this;
    }

//Fill the fileds
    public void openPatientPage(String teudat){
        String locator="//td[contains(text(),'"+ teudat + "')]/../*//*[@class='LinkBtnPatients GreenBtn']";
        WebElement greenButton= driver.findElement(By.xpath(locator));
        greenButton.click();
    }

    public DoctorsPage waitUntilMainPageIsLoaded() {
        try {
            waitUntilElementIsLoaded(namesField);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }

    public void clickOnGoToPatientButton() {
        clickElement(goToPatientButton);

    }

    public void openRegistrationPage() {
        clickElement(goToRegLink);

    }

    public void openForgotPassPage() {
        clickElement(forgotPassLink);

    }



    public boolean isOnMainPage() {
        return exists(namesField);
    }

    //check alert presence

    public boolean alertMessageNotValidUsername() {

        return exists(wrongUsernameAlert);
    }
    //div[@id='MainContent_LoginUser_LoginUserValidationSummary']/ul/li[1]

    public boolean alertMessageNotValidPassword() {
        return exists(wrongPasswordAlert);
    }

}
