package com.telran;

import com.telran.pages.DoctorsPage;
import com.telran.pages.DrugRecomendationPage;
import com.telran.pages.LoginIrinaPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by Alex on 12.11.2015.
 */
public class DrugRecommendationFainbergObjTest {
    public static String username = "6012Doctor";
    public static String password = "LinkCare!!11";
    public static String testText1 = "Test Text 123456";
    public static String testText2 = "Test Text 123";
    private static Logger Log = Logger.getLogger(LogLog4j.class.getName()); //Необходимо для написания логов
    public WebDriver driver;

    public DrugRecomendationPage patientPage;
    public DoctorsPage mainPage;
    public LoginIrinaPage loginPage;

    @BeforeClass(alwaysRun = true)
    public void setUp() {
        driver = new FirefoxDriver();
        //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        loginPage = PageFactory.initElements(driver, LoginIrinaPage.class);
        mainPage = PageFactory.initElements(driver, DoctorsPage.class);
        patientPage = PageFactory.initElements(driver, DrugRecomendationPage.class);
    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethodSetUp() {
        try {
            loginPage
                    .openLoginPage(driver)
                    .waitUntilLoginPageIsLoaded()
                    .fillUsernameField(username)
                    .fillPasswordField(password)
                    .clickOnLoginButton();
            mainPage.waitUntilMainPageIsLoaded()
                    .clickOnGoToPatientButton();

            patientPage.waitUntilTestPageIsLoaded();


            //loginPage.waitUntilTestPageIsLoaded();
        } catch (Exception e) {
            e.printStackTrace();
        }
        driver.manage().window().maximize();
    }

    @Test(groups = {"smoke", "positive"})
    public void AddElement() {

        Log.info("Add drug to last group test start");
        try {
            //mainPage.fillElements();
            Log.info("pressExpandElement");
            patientPage.pressExpandElement();
            patientPage.waitUntilElementIsLoaded(patientPage.groupLastAddLink);
            Thread.sleep(5000);
            Log.info("pressAddLink");
            patientPage.pressAddLink();
            Log.info("fillTextField");
            patientPage.fillTextField(testText1);
            Log.info("pressCommitAddLink");
            patientPage.pressCommitAddLink();
            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Log.info("Asserting starting");
        Assert.assertTrue(patientPage.isTextInsertedOk(testText1), "DrugAddedTest Failed!");
    }


    @Test(groups = {"smoke", "positive"})
    public void DeleteElement() {
        Log.info("Adding element before deleting");
        AddElement();
        Log.info("Delete drug from last group test");
        String deletedDrug = null;
        try {
            deletedDrug = null;
            Log.info("pressExpandElement");
            patientPage.pressExpandElement();
            Log.info("waitUntilElementIsLoaded(patientPage.groupLastAddLink)");
            patientPage.waitUntilElementIsLoaded(patientPage.groupLastAddLink);
            Thread.sleep(5000);
            Log.info("pressAddLink");
            patientPage.pressAddLink();
            Thread.sleep(5000);
            Log.info("unCheckCheckBoxDeletedDrug");
            deletedDrug = patientPage.unCheckCheckBoxDeletedDrug();
            Thread.sleep(5000);
            Log.info("pressCommitAddLink");
            patientPage.pressCommitAddLink();
            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Assert.assertTrue(patientPage.isDrugRemoved(deletedDrug), "DrugRemove Test Failed!");
    }


    @AfterTest(alwaysRun = true)
    public void tearDown() {
        this.driver.quit();
    }

}
