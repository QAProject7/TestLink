package telran.com;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.*;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static org.testng.Assert.*;
//import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class RegIvanTest {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @BeforeTest
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "http://change-this-to-the-site-you-are-testing/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testFainbergClinicsRegister() throws Exception {    String index = "1";
        // ERROR: Caught exception [unknown command [label]]
        driver.get("http://dhclinicappv2stg.item-soft.co.il/SitePages/createUser.aspx?ReturnUrl=HomePage");
        // ERROR: Caught exception [ERROR: Unsupported command [getEval |  | ]]
        String username = "";
        String email = username + "@yopmail.com";
        driver.findElement(By.id("MainContent_RegisterUser_CreateUserStepContainer_UserName")).clear();
        driver.findElement(By.id("MainContent_RegisterUser_CreateUserStepContainer_UserName")).sendKeys(username);
        driver.findElement(By.id("MainContent_RegisterUser_CreateUserStepContainer_firstNameTxt")).clear();
        driver.findElement(By.id("MainContent_RegisterUser_CreateUserStepContainer_firstNameTxt")).sendKeys("qwert");
        driver.findElement(By.id("MainContent_RegisterUser_CreateUserStepContainer_lastNameTxt")).clear();
        driver.findElement(By.id("MainContent_RegisterUser_CreateUserStepContainer_lastNameTxt")).sendKeys("qwert");
        driver.findElement(By.id("MainContent_RegisterUser_CreateUserStepContainer_Email")).clear();
        driver.findElement(By.id("MainContent_RegisterUser_CreateUserStepContainer_Email")).sendKeys(email);
        driver.findElement(By.id("MainContent_RegisterUser_CreateUserStepContainer_Password")).clear();
        driver.findElement(By.id("MainContent_RegisterUser_CreateUserStepContainer_Password")).sendKeys("Asdfgh0!");
        driver.findElement(By.id("MainContent_RegisterUser_CreateUserStepContainer_ConfirmPassword")).clear();
        driver.findElement(By.id("MainContent_RegisterUser_CreateUserStepContainer_ConfirmPassword")).sendKeys("Asdfgh0!");
        driver.findElement(By.id("MainContent_RegisterUser_CreateUserStepContainer_PersonalIdTxt")).clear();
        driver.findElement(By.id("MainContent_RegisterUser_CreateUserStepContainer_PersonalIdTxt")).sendKeys("532315678");
        driver.findElement(By.id("ctl00_MainContent_RegisterUser_CreateUserStepContainer_birthdayTxt_dateInput")).clear();
        driver.findElement(By.id("ctl00_MainContent_RegisterUser_CreateUserStepContainer_birthdayTxt_dateInput")).sendKeys("04/09/1970");
        driver.findElement(By.id("ctl00_MainContent_RegisterUser_CreateUserStepContainer_birthdayTxt")).clear();
        driver.findElement(By.id("ctl00_MainContent_RegisterUser_CreateUserStepContainer_birthdayTxt")).sendKeys("1970-09-04");
        driver.findElement(By.id("ctl00_MainContent_RegisterUser_CreateUserStepContainer_ContactCellTxt")).clear();
        driver.findElement(By.id("ctl00_MainContent_RegisterUser_CreateUserStepContainer_ContactCellTxt")).sendKeys("054-4444444");
        driver.findElement(By.id("ctl00_MainContent_RegisterUser_CreateUserStepContainer_ContactPhoneTxt")).clear();
        driver.findElement(By.id("ctl00_MainContent_RegisterUser_CreateUserStepContainer_ContactPhoneTxt")).sendKeys("(077)-1234567");
        driver.findElement(By.id("MainContent_RegisterUser_CreateUserStepContainer_AddressTxt")).clear();
        driver.findElement(By.id("MainContent_RegisterUser_CreateUserStepContainer_AddressTxt")).sendKeys("Hertzl");
        driver.findElement(By.id("MainContent_RegisterUser_CreateUserStepContainer_HouseNumberTxt")).clear();
        driver.findElement(By.id("MainContent_RegisterUser_CreateUserStepContainer_HouseNumberTxt")).sendKeys("2");
        driver.findElement(By.id("MainContent_RegisterUser_CreateUserStepContainer_CityTxt")).clear();
        driver.findElement(By.id("MainContent_RegisterUser_CreateUserStepContainer_CityTxt")).sendKeys("Beer Sheva");
        driver.findElement(By.id("MainContent_RegisterUser_CreateUserStepContainer_ZipCodeTxt")).clear();
        driver.findElement(By.id("MainContent_RegisterUser_CreateUserStepContainer_ZipCodeTxt")).sendKeys("318001");
        driver.findElement(By.id("MainContent_RegisterUser_CreateUserStepContainer_IsClinicAdmin")).click();
        driver.findElement(By.id("MainContent_AddNewUser")).click();
        try {
            assertTrue(isElementPresent(By.id("Top1_HeadLoginView_DisplayName")));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            assertEquals("qwert qwert", driver.findElement(By.id("Top1_HeadLoginView_DisplayName")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        // ERROR: Caught exception [ERROR: Unsupported command [getEval | ${index}+1 | ]]
        System.out.println("inddex is " + index);
        // ERROR: Caught exception [unknown command [gotoIf]]
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