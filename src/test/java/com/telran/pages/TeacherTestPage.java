package com.telran.pages;

import com.telran.LogLog4j;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Iakov Volf
 */
public class TeacherTestPage extends Page {

    private static Logger Log = Logger.getLogger(LogLog4j.class.getName());
    //fields
    @FindBy(xpath = "//*[@id='MainContent_contentHtml']/table/tbody//input[@name='q1'][@value='3']")
    WebElement question1Button1;
    @FindBy(xpath = "//*[@id='MainContent_contentHtml']/table/tbody//input[@name='q1'][@value='2']")
    WebElement question1Button2;
    @FindBy(xpath = "//*[@id='MainContent_contentHtml']/table/tbody//input[@name='q1'][@value='1']")
    WebElement question1Button3;
    @FindBy(xpath = "//*[@id='MainContent_contentHtml']/table/tbody//input[@name='q1'][@value='0']")
    WebElement question1Button4;

    @FindBy(xpath = "//*[@id='MainContent_contentHtml']/table/tbody//input[@name='q2'][@value='3']")
    WebElement question2Button1;
    @FindBy(xpath = "//*[@id='MainContent_contentHtml']/table/tbody//input[@name='q2'][@value='2']")
    WebElement question2Button2;
    @FindBy(xpath = "//*[@id='MainContent_contentHtml']/table/tbody//input[@name='q2'][@value='1']")
    WebElement question2Button3;
    @FindBy(xpath = "//*[@id='MainContent_contentHtml']/table/tbody//input[@name='q2'][@value='0']")
    WebElement question2Button4;

    @FindBy(xpath = "//*[@id='MainContent_contentHtml']/table/tbody//input[@name='q3'][@value='3']")
    WebElement question3Button1;
    @FindBy(xpath = "//*[@id='MainContent_contentHtml']/table/tbody//input[@name='q3'][@value='2']")
    WebElement question3Button2;
    @FindBy(xpath = "//*[@id='MainContent_contentHtml']/table/tbody//input[@name='q3'][@value='1']")
    WebElement question3Button3;
    @FindBy(xpath = "//*[@id='MainContent_contentHtml']/table/tbody//input[@name='q3'][@value='0']")
    WebElement question3Button4;

    @FindBy(xpath = "//*[@id='MainContent_contentHtml']/table/tbody//input[@name='q4'][@value='3']")
    WebElement question4Button1;
    @FindBy(xpath = "//*[@id='MainContent_contentHtml']/table/tbody//input[@name='q4'][@value='2']")
    WebElement question4Button2;
    @FindBy(xpath = "//*[@id='MainContent_contentHtml']/table/tbody//input[@name='q4'][@value='1']")
    WebElement question4Button3;
    @FindBy(xpath = "//*[@id='MainContent_contentHtml']/table/tbody//input[@name='q4'][@value='0']")
    WebElement question4Button4;

    @FindBy(xpath = "//*[@id='MainContent_contentHtml']/table/tbody//input[@name='q5'][@value='3']")
    WebElement question5Button1;
    @FindBy(xpath = "//*[@id='MainContent_contentHtml']/table/tbody//input[@name='q5'][@value='2']")
    WebElement question5Button2;
    @FindBy(xpath = "//*[@id='MainContent_contentHtml']/table/tbody//input[@name='q5'][@value='1']")
    WebElement question5Button3;
    @FindBy(xpath = "//*[@id='MainContent_contentHtml']/table/tbody//input[@name='q5'][@value='0']")
    WebElement question5Button4;

    @FindBy(xpath = "//*[@id='MainContent_contentHtml']/table/tbody//input[@name='q6'][@value='3']")
    WebElement question6Button1;
    @FindBy(xpath = "//*[@id='MainContent_contentHtml']/table/tbody//input[@name='q6'][@value='2']")
    WebElement question6Button2;
    @FindBy(xpath = "//*[@id='MainContent_contentHtml']/table/tbody//input[@name='q6'][@value='1']")
    WebElement question6Button3;
    @FindBy(xpath = "//*[@id='MainContent_contentHtml']/table/tbody//input[@name='q6'][@value='0']")
    WebElement question6Button4;

    @FindBy(xpath = "//*[@id='MainContent_contentHtml']/table/tbody//input[@name='q7'][@value='3']")
    WebElement question7Button1;
    @FindBy(xpath = "//*[@id='MainContent_contentHtml']/table/tbody//input[@name='q7'][@value='2']")
    WebElement question7Button2;
    @FindBy(xpath = "//*[@id='MainContent_contentHtml']/table/tbody//input[@name='q7'][@value='1']")
    WebElement question7Button3;
    @FindBy(xpath = "//*[@id='MainContent_contentHtml']/table/tbody//input[@name='q7'][@value='0']")
    WebElement question7Button4;

    //new button
    @FindBy(xpath = "//*[@id='MainContent_RptNotification_NowBtn1_0']")
    WebElement buttonTestVanderbild;
    //*[@id='MainContent_RptNotification_NowBtn1_0']

    @FindBy(xpath = "//*[@id='ctl00_MainContent_RadGrid1_ctl00_ctl04_Accept']")
    WebElement buttonAccept;
    //*[@id='ctl00_MainContent_RadGrid1_ctl00_ctl04_Accept']

    //old button
    @FindBy(xpath = "//*[@id='MainContent_contentHtml']/table/tbody/tr")
    WebElement tablelist;

    @FindBy(id = "MainContent_LoginUser_UserName")
    WebElement usernameField;

    @FindBy(id = "MainContent_LoginUser_Password")
    WebElement passwordField;

    @FindBy(id = "MainContent_LoginUser_LoginButton")
    WebElement loginBtn;



    @FindBy(id = "submit")
    WebElement send;

    @FindBy(xpath = "//*[@id='MainContent_RptNotification_NowBtn1_0']")
    WebElement buttonStartTest;

    /*@FindBy(id = "MainContent_LoginUser_UserName")
    WebElement usernameField;

    @FindBy(id = "MainContent_LoginUser_Password")
    WebElement passwordField;

    @FindBy(id = "MainContent_LoginUser_RegisterHyperLink")
    WebElement goToRegLink;

    @FindBy(id = "MainContent_LoginUser_LoginButton")
    WebElement loginButton;

    @FindBy(xpath = "//a[@class='forgot']")
    WebElement forgotPassLink;

    //Alerts
    @FindBy(xpath = "/*//*[@id='MainContent_LoginUser_LoginUserValidationSummary']/ul/li[contains(text(),('שם משתמש חובה'))]")
    WebElement wrongUserNameAlert;


*/

    public TeacherTestPage(WebDriver driver) {
        super(driver);
        this.PAGE_URL = "http://dhclinicappv2stg.item-soft.co.il/SecurityInfrastructure/Notifications.aspx";
        PageFactory.initElements(driver, this);
    }

    public TeacherTestPage openLoginPage(WebDriver driver) {
        Log.info("Openning Login Page");
        driver.get(PAGE_URL);
        return this;
    }

    //Fill the fileds
    public TeacherTestPage fillUsernameField(String username) {
        Log.info("Filling User name");
        setElementText(usernameField, username);
        // Log.info("entering username: " + username + " ");
        return this;
    }

    public TeacherTestPage fillPasswordField(String password) {
        Log.info("Filling password");
        setElementText(passwordField, password);
        // Log.info("entering password: " + password + " ");
        return this;
    }


    //public ProfilePage profilePage;

    public void clickOnAnyStar() {
        Log.info("Click any radio button ");
        List<WebElement> guestList = tablelist.findElements(By.tagName("tr"));
        Iterator<WebElement> iterator = guestList.iterator();
        while (iterator.hasNext()) {
            WebElement genArea = iterator.next();
            List<WebElement> buttons = genArea.findElements(By.tagName("input"));
            String randomValue = String.valueOf(Math.random() * 3);
            for (WebElement button : buttons) {
                if (button.getAttribute("value").equals(randomValue))
                    button.click();
            }

        }
    }

    public TeacherTestPage openTeacherTestPage(WebDriver driver) {
        Log.info("Openning Teacher Test Page");
        driver.get(PAGE_URL);
        return this;
    }

    public TeacherTestPage waitUntilPageIsLoaded() {
        Log.info("Waiting page is loaded");
        try {
            waitUntilElementIsLoaded(send);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }

    public void clickOnSendButton() {
        Log.info("Click Send button");
        clickElement(send);
    }

    public void clickOnButtonStartTest() {
        Log.info("Click button Start Test2");
        clickElement(buttonStartTest);
    }

    public void clickOnButtonTestVanderbild() {
        Log.info("Click button Start Test1");
        clickElement(buttonTestVanderbild);
    }

    public void clickOnButtonAccept() {
        Log.info("Click button accept");
        clickElement(buttonAccept);
    }

    public void clickOnLoginButton() {
        Log.info("Click Login button");
        clickElement(loginBtn);
    }

    public boolean isPageOpened() {
        Log.info("Check the opening page");
        return exists(loginBtn);
    }

    public boolean getButtonStartTest() {
        Log.info("Check availability button start test");
        return exists(buttonStartTest);
    }

    public boolean getButtonTestVanderbild() {
        Log.info("Check availability button start test");
        return exists(buttonTestVanderbild);
    }


}
//Fill the fileds

  /*  public TeacherTestPage fillUsernameField(String username) {
        setElementText(usernameField, username);
        return this;
    }


    public TeacherTestPage fillPasswordField(String password) {
        setElementText(passwordField, password);
        // Log.info("entering password from the list: " + password + " ");
        return this;
    }




    public void clickOnLoginButton() {
        clickElement(loginButton);

    }

    public void openRegistrationPage() {
        clickElement(goToRegLink);

    }


    public void openForgotPassPage() {
        clickElement(forgotPassLink);

    }

    public boolean isOnLoginPage() {
        return exists(loginButton);
    }


    //check alert presence

    public boolean alertMessageNotValidUserName() {
        return exists(wrongUserNameAlert);
    }

  //  public boolean alertMessageNotValidFirsrName() {
      //  return exists(wrongPasswordAlert);
    }

*/
