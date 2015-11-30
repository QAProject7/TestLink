package com.telran.util;

import java.util.concurrent.TimeUnit;

import com.telran.pages.LoginMaksimPage;
import com.telran.pages.Page;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TemporaryCreateNewPatientAndFillProfile {



    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();
    LoginMaksimPage loginPage;
    //private String registered_doctor_name = "5998Doctor";
    private String registered_doctor_name = "493Doctor";
    private String registered_doctor_pass = "LinkCare!!11";

    private String email = "metupelet15@yopmail.com";
    private static final String TZ1 = "208463992";
    private static final String TZ2 = "385949870";

    @BeforeClass
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "http://dhclinicappv2stg.item-soft.co.il/";
        loginPage = PageFactory.initElements(driver, LoginMaksimPage.class);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void testUntitled2() throws Exception {
        loginPage.openLoginPage(driver)
            .fillUsernameField(registered_doctor_name)
            .fillPasswordField(registered_doctor_pass)
            .clickOnLoginButton();
        driver.findElement(By.xpath("//div[@id='ctl00_DisplayImportantLinks1_myMenu']/ul/li[2]/a/img")).click();
        driver.findElement(By.id("MainContent_AddNewItem")).click();
        driver.switchTo().frame(driver.findElement(By.tagName("iframe")));
        driver.findElement(By.id("MainContent_AddEditAccount1_firstNameTxt")).clear();
        driver.findElement(By.id("MainContent_AddEditAccount1_firstNameTxt")).sendKeys("IvanOne");
        driver.findElement(By.id("MainContent_AddEditAccount1_lastNameTxt")).clear();
        driver.findElement(By.id("MainContent_AddEditAccount1_lastNameTxt")).sendKeys("IvanovOne");
        driver.findElement(By.id("MainContent_AddEditAccount1_PersonalPatientTxt")).clear();
        driver.findElement(By.id("MainContent_AddEditAccount1_PersonalPatientTxt")).sendKeys(TZ1);
        driver.findElement(By.id("ctl00_MainContent_AddEditAccount1_rdp_birthDate_dateInput")).clear();
        driver.findElement(By.id("ctl00_MainContent_AddEditAccount1_rdp_birthDate_dateInput")).sendKeys("01/01/2005");
/*
        driver.findElement(By.id("ctl00_MainContent_AddEditAccount1_rdp_birthDate")).clear();
        driver.findElement(By.id("ctl00_MainContent_AddEditAccount1_rdp_birthDate")).sendKeys("2005-01-01");
*/
        driver.findElement(By.id("MainContent_AddEditAccount1_rtb_Weight")).clear();
        driver.findElement(By.id("MainContent_AddEditAccount1_rtb_Weight")).sendKeys("35");
        driver.findElement(By.id("ctl00_MainContent_AddEditAccount1_TxtsearchMail")).clear();
        driver.findElement(By.id("ctl00_MainContent_AddEditAccount1_TxtsearchMail")).sendKeys(email);
        driver.findElement(By.id("ctl00_MainContent_AddEditAccount1_BtnSearch_input")).click();
        loginPage.waitUntilIsLoaded(driver.findElement(By.id("ctl00_MainContent_AddEditAccount1_RadGrid2_ctl00")));

        loginPage.waitUntilElementIsLoaded(driver.findElement(By.id("ctl00_MainContent_AddEditAccount1_RDTmeetingdate_dateInput")));
        driver.findElement(By.id("ctl00_MainContent_AddEditAccount1_RDTmeetingdate_dateInput")).clear();
        driver.findElement(By.id("ctl00_MainContent_AddEditAccount1_RDTmeetingdate_dateInput")).sendKeys("01/12/2015 10:00");

/*
        driver.findElement(By.id("ctl00_MainContent_AddEditAccount1_RDTmeetingdate")).clear();
        driver.findElement(By.id("ctl00_MainContent_AddEditAccount1_RDTmeetingdate")).sendKeys("2015-12-01-00-00-00");
*/
        driver.findElement(By.id("MainContent_AddEditAccount1_SaveAccount")).click();
        //driver.switchTo().defaultContent();

        driver.findElement(By.id("Top1_HeadLoginStatus")).click();
        driver.findElement(By.id("MainContent_LoginUser_UserName")).clear();
        driver.findElement(By.id("MainContent_LoginUser_UserName")).sendKeys(email);
        driver.findElement(By.id("MainContent_LoginUser_Password")).clear();
        driver.findElement(By.id("MainContent_LoginUser_Password")).sendKeys("LinkCare!1");
        driver.findElement(By.id("MainContent_LoginUser_LoginButton")).click();
        driver.findElement(By.id("MainContent_ChangeUserPassword_ChangePasswordContainerID_CancelPushButton")).click();
        driver.findElement(By.id("MainContent_firstNameTxt")).clear();
        driver.findElement(By.id("MainContent_firstNameTxt")).sendKeys("IvanOneP");
        driver.findElement(By.id("MainContent_lastNameTxt")).clear();
        driver.findElement(By.id("MainContent_lastNameTxt")).sendKeys("IvanovOne");
        driver.findElement(By.id("ctl00_MainContent_birthdayTxt_dateInput")).clear();
        driver.findElement(By.id("ctl00_MainContent_birthdayTxt_dateInput")).sendKeys("01/01/1975");
/*
        driver.findElement(By.id("ctl00_MainContent_birthdayTxt")).clear();
        driver.findElement(By.id("ctl00_MainContent_birthdayTxt")).sendKeys("1975-01-01");
*/
        driver.findElement(By.id("ctl00_MainContent_ContactCellTxt")).click();
        driver.findElement(By.id("ctl00_MainContent_ContactCellTxt")).clear();
        driver.findElement(By.id("ctl00_MainContent_ContactCellTxt")).sendKeys("050-1234567");
        driver.findElement(By.id("ctl00_MainContent_ContactPhoneTxt")).click();
        driver.findElement(By.id("ctl00_MainContent_ContactPhoneTxt")).clear();
        driver.findElement(By.id("ctl00_MainContent_ContactPhoneTxt")).sendKeys("(050)-1234567");
        driver.findElement(By.id("MainContent_AddressTxt")).clear();
        driver.findElement(By.id("MainContent_AddressTxt")).sendKeys("Ahat");
        driver.findElement(By.id("MainContent_HouseNumberTxt")).clear();
        driver.findElement(By.id("MainContent_HouseNumberTxt")).sendKeys("1");
        driver.findElement(By.id("MainContent_CityTxt")).clear();
        driver.findElement(By.id("MainContent_CityTxt")).sendKeys("Ashdod");
        driver.findElement(By.id("MainContent_CreateUserButton")).click();
        driver.findElement(By.id("MainContent_PersonalIdTxt")).clear();
        driver.findElement(By.id("MainContent_PersonalIdTxt")).sendKeys(TZ2);
        driver.findElement(By.id("MainContent_CreateUserButton")).click();
    }

    @AfterClass
    public void tearDown() throws Exception {
        //driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
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