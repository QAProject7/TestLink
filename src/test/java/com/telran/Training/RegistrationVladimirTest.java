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

public class RegistrationVladimirTest {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();
    private String lFamily = "testfam";
    private String lName = "testname";
    private String loginName = "loginname03";

    @BeforeTest
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "http://dhclinicappv2stg.item-soft.co.il/Login.aspx";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testClinicRegisterV02TestNGWDVladimir() throws Exception {
        // ERROR: Caught exception [ERROR: Unsupported command [getEval |  | ]]
        // ERROR: Caught exception [ERROR: Unsupported command [getEval |  | ]]
        // ERROR: Caught exception [ERROR: Unsupported command [getEval |  | ]]
        driver.get("http://dhclinicappv2stg.item-soft.co.il/Login.aspx");
        driver.findElement(By.id("MainContent_LoginUser_RegisterHyperLink")).click();
        for (int second = 0; ; second++) {
            if (second >= 60) fail("timeout");
            try {
                if (isElementPresent(By.xpath("//input[@id='MainContent_RegisterUser_CreateUserStepContainer_UserName']")))
                    break;
            } catch (Exception e) {
            }
            Thread.sleep(1000);
        }

        driver.findElement(By.id("MainContent_RegisterUser_CreateUserStepContainer_UserName")).clear();
        driver.findElement(By.id("MainContent_RegisterUser_CreateUserStepContainer_UserName")).sendKeys(loginName);
        try {
            assertEquals(loginName, driver.findElement(By.xpath("//input[@id='MainContent_RegisterUser_CreateUserStepContainer_UserName']")).getAttribute("value"));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        driver.findElement(By.id("MainContent_RegisterUser_CreateUserStepContainer_firstNameTxt")).clear();

        driver.findElement(By.id("MainContent_RegisterUser_CreateUserStepContainer_firstNameTxt")).sendKeys(lName);
        driver.findElement(By.id("MainContent_RegisterUser_CreateUserStepContainer_lastNameTxt")).clear();
        driver.findElement(By.id("MainContent_RegisterUser_CreateUserStepContainer_lastNameTxt")).sendKeys(lFamily);
        driver.findElement(By.id("MainContent_RegisterUser_CreateUserStepContainer_Email")).clear();
        driver.findElement(By.id("MainContent_RegisterUser_CreateUserStepContainer_Email")).sendKeys(loginName + "@yopmail.com");
        // ERROR: Caught exception [ERROR: Unsupported command [getEval | storedVars['loginName']+"@yopmail.com" | ]]
        String mailVar = loginName + "@yopmail.com";
        System.out.println("mail is: " + mailVar);
        try {
            assertEquals(mailVar, driver.findElement(By.xpath("//*[@id='MainContent_RegisterUser_CreateUserStepContainer_Email']")).getAttribute("value"));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        driver.findElement(By.id("MainContent_RegisterUser_CreateUserStepContainer_Password")).clear();
        driver.findElement(By.id("MainContent_RegisterUser_CreateUserStepContainer_Password")).sendKeys("Qazxsw2!");
        driver.findElement(By.id("MainContent_RegisterUser_CreateUserStepContainer_ConfirmPassword")).clear();
        driver.findElement(By.id("MainContent_RegisterUser_CreateUserStepContainer_ConfirmPassword")).sendKeys("Qazxsw2!");
        driver.findElement(By.id("MainContent_RegisterUser_CreateUserStepContainer_PersonalIdTxt")).clear();
        driver.findElement(By.id("MainContent_RegisterUser_CreateUserStepContainer_PersonalIdTxt")).sendKeys("70357264");
        driver.findElement(By.id("MainContent_RegisterUser_CreateUserStepContainer_clinicNameTxt")).clear();
        driver.findElement(By.id("MainContent_RegisterUser_CreateUserStepContainer_clinicNameTxt")).sendKeys("Clinic");
        new Select(driver.findElement(By.id("MainContent_RegisterUser_CreateUserStepContainer_OrganizationDDL"))).selectByVisibleText("רופאים פרטיים");
        driver.findElement(By.id("ctl00_MainContent_RegisterUser_CreateUserStepContainer_birthdayTxt_dateInput")).click();
        driver.findElement(By.id("ctl00_MainContent_RegisterUser_CreateUserStepContainer_birthdayTxt_dateInput")).clear();
        driver.findElement(By.id("ctl00_MainContent_RegisterUser_CreateUserStepContainer_birthdayTxt_dateInput")).sendKeys("07/11/1981");
        /*driver.findElement(By.id("ctl00_MainContent_RegisterUser_CreateUserStepContainer_birthdayTxt")).clear();
        driver.findElement(By.id("ctl00_MainContent_RegisterUser_CreateUserStepContainer_birthdayTxt")).sendKeys("1981-11-07");
        driver.findElement(By.id("ctl00_MainContent_RegisterUser_CreateUserStepContainer_birthdayTxt")).clear();
        driver.findElement(By.id("ctl00_MainContent_RegisterUser_CreateUserStepContainer_birthdayTxt")).sendKeys("1981-11-07");*/
        driver.findElement(By.id("ctl00_MainContent_RegisterUser_CreateUserStepContainer_ContactCellTxt")).clear();
        driver.findElement(By.id("ctl00_MainContent_RegisterUser_CreateUserStepContainer_ContactCellTxt")).sendKeys("053-1234567");
        driver.findElement(By.id("ctl00_MainContent_RegisterUser_CreateUserStepContainer_ContactPhoneTxt")).clear();
        driver.findElement(By.id("ctl00_MainContent_RegisterUser_CreateUserStepContainer_ContactPhoneTxt")).sendKeys("(053)-1234568");
        driver.findElement(By.id("MainContent_RegisterUser_CreateUserStepContainer_AddressTxt")).clear();
        driver.findElement(By.id("MainContent_RegisterUser_CreateUserStepContainer_AddressTxt")).sendKeys("Ye'elim");
        driver.findElement(By.id("MainContent_RegisterUser_CreateUserStepContainer_HouseNumberTxt")).clear();
        driver.findElement(By.id("MainContent_RegisterUser_CreateUserStepContainer_HouseNumberTxt")).sendKeys("3");
        driver.findElement(By.id("MainContent_RegisterUser_CreateUserStepContainer_CityTxt")).clear();
        driver.findElement(By.id("MainContent_RegisterUser_CreateUserStepContainer_CityTxt")).sendKeys("Jerusalem");
        driver.findElement(By.id("MainContent_RegisterUser_CreateUserStepContainer_ZipCodeTxt")).clear();
        driver.findElement(By.id("MainContent_RegisterUser_CreateUserStepContainer_ZipCodeTxt")).sendKeys("1234567");
        driver.findElement(By.id("MainContent_AddNewUser")).click();
        //driver.findElement(By.id("MainContent_RegisterUser_CreateUserStepContainer_CreateUserButton")).click();
        try {
            assertEquals("http://dhclinicappv2stg.item-soft.co.il/SecurityInfrastructure/Accounts.aspx", driver.getCurrentUrl());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            assertEquals(lName + " " + lFamily, driver.findElement(By.xpath("//*[@id='Top1_HeadLoginView_DisplayName']")).getText());
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