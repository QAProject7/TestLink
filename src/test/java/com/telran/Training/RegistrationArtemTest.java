package com.telran.Training;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

//import static org.hamcrest.CoreMatchers.*;

public class RegistrationArtemTest {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @BeforeTest
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "http://dhclinicappv2stg.item-soft.co.il/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testNewTextDocument() throws Exception {    driver.get("http://dhclinicappv2stg.item-soft.co.il/Login.aspx");
        for (int second = 0;; second++) {
            if (second >= 60) fail("timeout");
            try { if (isElementPresent(By.id("MainContent_LoginUser_RegisterHyperLink"))) break; } catch (Exception e) {}
            Thread.sleep(1000);
        }

        driver.findElement(By.id("MainContent_LoginUser_RegisterHyperLink")).click();
        for (int second = 0;; second++) {
            if (second >= 60) fail("timeout");
            try { if (isElementPresent(By.id("MainContent_RegisterUser_CreateUserStepContainer_UserNameLabel"))) break; } catch (Exception e) {}
            Thread.sleep(1000);
        }

        // ERROR: Caught exception [ERROR: Unsupported command [getEval |  | ]]
        // ERROR: Caught exception [ERROR: Unsupported command [getEval |  | ]]
        // ERROR: Caught exception [ERROR: Unsupported command [getEval |  | ]]
        String password = "Passw0rd!";
        String teudat = "448638445";
        CharSequence userName = "name";
        CharSequence secondName = "namoff";
        String fullName = userName + " " + secondName;
        System.out.println(fullName);
        driver.findElement(By.id("MainContent_RegisterUser_CreateUserStepContainer_UserName")).clear();
        CharSequence loginName = "testlogin";
        driver.findElement(By.id("MainContent_RegisterUser_CreateUserStepContainer_UserName")).sendKeys(loginName);
        driver.findElement(By.id("MainContent_RegisterUser_CreateUserStepContainer_firstNameTxt")).clear();
        driver.findElement(By.id("MainContent_RegisterUser_CreateUserStepContainer_firstNameTxt")).sendKeys(userName);
        driver.findElement(By.id("MainContent_RegisterUser_CreateUserStepContainer_lastNameTxt")).clear();
        driver.findElement(By.id("MainContent_RegisterUser_CreateUserStepContainer_lastNameTxt")).sendKeys(secondName);
        driver.findElement(By.id("MainContent_RegisterUser_CreateUserStepContainer_Email")).clear();
        driver.findElement(By.id("MainContent_RegisterUser_CreateUserStepContainer_Email")).sendKeys(loginName + "@gmail.com");
        driver.findElement(By.id("MainContent_RegisterUser_CreateUserStepContainer_Password")).clear();
        driver.findElement(By.id("MainContent_RegisterUser_CreateUserStepContainer_Password")).sendKeys(password);
        driver.findElement(By.id("MainContent_RegisterUser_CreateUserStepContainer_ConfirmPassword")).clear();
        driver.findElement(By.id("MainContent_RegisterUser_CreateUserStepContainer_ConfirmPassword")).sendKeys(password);
        driver.findElement(By.id("MainContent_RegisterUser_CreateUserStepContainer_PersonalIdTxt")).clear();
        driver.findElement(By.id("MainContent_RegisterUser_CreateUserStepContainer_PersonalIdTxt")).sendKeys(teudat);
        new Select(driver.findElement(By.id("MainContent_RegisterUser_CreateUserStepContainer_rolesDDl"))).selectByVisibleText("Health Care Provider");
        driver.findElement(By.id("MainContent_RegisterUser_CreateUserStepContainer_clinicNameTxt")).clear();
        driver.findElement(By.id("MainContent_RegisterUser_CreateUserStepContainer_clinicNameTxt")).sendKeys("MyClinika1");
        new Select(driver.findElement(By.id("MainContent_RegisterUser_CreateUserStepContainer_OrganizationDDL"))).selectByVisibleText("?????? ??????");
        driver.findElement(By.id("ctl00_MainContent_RegisterUser_CreateUserStepContainer_birthdayTxt_CalendarPopupButton")).click();
        driver.findElement(By.id("ctl00_MainContent_RegisterUser_CreateUserStepContainer_birthdayTxt_dateInput")).clear();
        driver.findElement(By.id("ctl00_MainContent_RegisterUser_CreateUserStepContainer_birthdayTxt_dateInput")).sendKeys("");
        driver.findElement(By.id("ctl00_MainContent_RegisterUser_CreateUserStepContainer_birthdayTxt")).clear();
        driver.findElement(By.id("ctl00_MainContent_RegisterUser_CreateUserStepContainer_birthdayTxt")).sendKeys("2015-10-29");
        driver.findElement(By.id("ctl00_MainContent_RegisterUser_CreateUserStepContainer_birthdayTxt_dateInput")).clear();
        driver.findElement(By.id("ctl00_MainContent_RegisterUser_CreateUserStepContainer_birthdayTxt_dateInput")).sendKeys("01/01/1980");
        driver.findElement(By.id("ctl00_MainContent_RegisterUser_CreateUserStepContainer_ContactCellTxt")).clear();
        driver.findElement(By.id("ctl00_MainContent_RegisterUser_CreateUserStepContainer_ContactCellTxt")).sendKeys("0547869999");
        driver.findElement(By.id("ctl00_MainContent_RegisterUser_CreateUserStepContainer_ContactPhoneTxt")).clear();
        driver.findElement(By.id("ctl00_MainContent_RegisterUser_CreateUserStepContainer_ContactPhoneTxt")).sendKeys("0547860000");
        driver.findElement(By.id("MainContent_RegisterUser_CreateUserStepContainer_AddressTxt")).clear();
        driver.findElement(By.id("MainContent_RegisterUser_CreateUserStepContainer_AddressTxt")).sendKeys("Y'elim");
        driver.findElement(By.id("MainContent_RegisterUser_CreateUserStepContainer_HouseNumberTxt")).clear();
        driver.findElement(By.id("MainContent_RegisterUser_CreateUserStepContainer_HouseNumberTxt")).sendKeys("3");
        driver.findElement(By.id("MainContent_RegisterUser_CreateUserStepContainer_CityTxt")).clear();
        driver.findElement(By.id("MainContent_RegisterUser_CreateUserStepContainer_CityTxt")).sendKeys("Beersheba");
        driver.findElement(By.id("MainContent_RegisterUser_CreateUserStepContainer_CountryTxt")).clear();
        driver.findElement(By.id("MainContent_RegisterUser_CreateUserStepContainer_CountryTxt")).sendKeys("Israel");
        driver.findElement(By.id("MainContent_RegisterUser_CreateUserStepContainer_ZipCodeTxt")).clear();
        driver.findElement(By.id("MainContent_RegisterUser_CreateUserStepContainer_ZipCodeTxt")).sendKeys("99999");
        driver.findElement(By.id("MainContent_AddNewUser")).click();
        try {
            assertEquals(fullName, driver.findElement(By.id("Top1_HeadLoginView_DisplayName")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
    }

    @AfterTest
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }
}