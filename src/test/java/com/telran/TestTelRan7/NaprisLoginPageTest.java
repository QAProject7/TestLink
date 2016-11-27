package com.telran.TestTelRan7;

import com.telran.pages.TelRan7.NaprisLoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by Napris on 27.11.2016.
 */
public class NaprisLoginPageTest {
    public static final String DEFAULT_USERNAME = "Doctor1";
    public static final String DEFAULT_PASSWORD = "LinkCare!!11";
    public WebDriver driver;
    public NaprisLoginPage naprisloginPage;

    @BeforeClass(alwaysRun = true)
    public void setup() {
        System.setProperty("webdriver.gecko.driver", "C:\\Program Files\\geckodriver.exe");
        driver = new FirefoxDriver();
        naprisloginPage = PageFactory.initElements(driver, NaprisLoginPage.class);
    }

    @BeforeMethod
    public void goToLoginPage() {
        driver.get("http://dhclinicappv2stg.item-soft.co.il/Login.aspx");
    }

    @Test(groups = {"positive"})
    public void loginTest() {
        naprisloginPage.login(DEFAULT_USERNAME, DEFAULT_PASSWORD);
    }

    @Test(groups = {"negative"})
    public void loginWithoutUsernameTest() {
        naprisloginPage.login("", DEFAULT_PASSWORD);
    }

    @Test(groups = {"negative"})
    public void loginWithoutPasswordTest() {
        naprisloginPage.login(DEFAULT_USERNAME, "");
    }

    @Test(groups = {"negative"})
    public void loginWithoutUsernameAndPasswordTest() {
        naprisloginPage.login("", "");
    }

    @AfterClass
    public void tearDown() {
        this.driver.quit();
    }
}
