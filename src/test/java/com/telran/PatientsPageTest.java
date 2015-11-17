package com.telran;

import com.telran.pages.DoctorMainPage;
import com.telran.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;

/**
 * Created by Christina on 10/16/15.
 */
public class PatientsPageTest {

    private static String DATE_OF_MEETING = "23/11/2015";
    public WebDriver driver;
    public DoctorMainPage mainPage;
    public LoginPage loginPage;


    @BeforeClass(alwaysRun = true)
    public void setup() {
        driver = new FirefoxDriver();
        loginPage = PageFactory.initElements(driver, LoginPage.class);
        mainPage = PageFactory.initElements(driver, DoctorMainPage.class);

    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethodSetUp() {
        try {
            loginPage.openLoginPage(driver)
                    .waitUntilLoginPageIsLoaded()
                    .login("493Baranoski", "Mzj$6Vbb3I");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test(groups = {"smoke", "positive"})
    public void test1() {

        mainPage
                .clickToSelectPatientsActive()
                .waitUntilLabelListOfPatientsForPatientsActiveIsLoaded();
        Assert.assertTrue(mainPage.visibleLabelListOfPatientsPatientActive(), "The Patient Active Page doesn't open");
        mainPage.clickToSelectPatientsToday()
                .waitUntilLabelListOfPatientsForPatientsTodayIsLoaded();
        Assert.assertTrue(mainPage.visibleLabelListOfPatientsPatientToday(), "The Patient Today Page doesn't open");
        mainPage.clickToSelectSearchPatients()
                .waitUntilLabelListOfPatientsForSearchPatientsIsLoaded();
        Assert.assertTrue(mainPage.visibleLabelListOfPatientsSearchPatient(), "The Search Patient Page doesn't open");
       /* mainPage.clickToSelectPatientsToday()
                    .waitUntilLabelListOfPatientsForPatientsTodayIsLoaded()

                    .clickToSelectPatientsActive()
                    .waitUntilLabelListOfPatientsForPatientsActiveIsLoaded();*/

        //
        //

    }

    @Test(groups = {"smoke", "positive"})
    public void test2() {
        try {
            mainPage
                    .clickToCalendarButton()
                    .waitUntilCalendarIsLoaded()
                    .clickToCalendarButton();
            //           assertTrue("The Patient Active Page doesn't open",mainPage.visibleCalendarAppears());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test(groups = {"smoke", "positive"})
    public void test3() {
        try {
            mainPage
                    .fillToCalendarField(DATE_OF_MEETING);

            /*  assertTrue("The Patient Active Page doesn't open",;
            assertTrue("The Patient Today Page doesn't open",;
            assertTrue("The Search Patient Page doesn't open",;*/
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(groups = {"smoke", "positive"})
    public void test4() {
        try {
            mainPage
                    .fillToCalendarField(DATE_OF_MEETING)
                    .clickToRemoveFilter();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(groups = {"smoke", "negative"})
    public void test5() {
        try {
            mainPage
                    .fillToCalendarField("a")
                    .clearCalendarFieldByBackspase()
                    .fillToCalendarField("0000000000")
                    .clickToRemoveFilter()
                    .fillToCalendarField("/")
                    .clearCalendarFieldByBackspase();
            sleep(3000);
            /*  assertTrue("The Patient Active Page doesn't open",;
            assertTrue("The Patient Today Page doesn't open",;
            assertTrue("The Search Patient Page doesn't open",;*/
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test(groups = {"smoke", "negative"})
    public void test6() {
        try {
            mainPage
                    .fillToCalendarField("");
            sleep(3000);
            /*  assertTrue("The Patient Active Page doesn't open",;
            assertTrue("The Patient Today Page doesn't open",;
            assertTrue("The Search Patient Page doesn't open",;*/
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @AfterClass(alwaysRun = true)
    public void teardown() {
        this.driver.quit();
    }
}


