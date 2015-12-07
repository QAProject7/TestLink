package com.telran;

import com.telran.MobileWebPages.LoginMobilePage;
import com.telran.MobileWebPages.QuestionVanderbiltForParentsPetruninPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by PetruninLeonid
 */
public class QuestionVanderbiltForParentsPetruninTest extends TestNgTestBase{ //ТЕСТ ГОТОВ! Вписан клеент с незаполненой таблицей!
    private static Logger Log = Logger.getLogger(LogLog4j.class.getName());
    public static String registered_username = "hore4832@yopmail.com"; //Данные входа клеента
    public static String registered_password = "LinkCare!!11";//Данные входа доктора
    public QuestionVanderbiltForParentsPetruninPage questionVanderbiltForParentsPetrunin; //Ссылка на вход на страницу (берет из класса LoginMaksimPage)
    public LoginMobilePage loginMobilePage;
   // private WebDriver driver;


    @BeforeClass(alwaysRun = true)
    public void setup() {
        //driver = new FirefoxDriver(); //Запускаем Firefox
        loginMobilePage = PageFactory.initElements(driver, LoginMobilePage.class); //Обращаемся к классу LoginMobilePage и берем оттуда ссылку на страницу
        questionVanderbiltForParentsPetrunin = PageFactory.initElements(driver, QuestionVanderbiltForParentsPetruninPage.class);

    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethodSetUp() { //Входим на страницу и ждем пока она загрузится
        //loginMobilePage.openLoginPage(driver); //Логи к данному методу добавлены на странице LoginMobilePage
        driver.get("http://dhclinicamobileppstg.item-soft.co.il/index.htm");
        loginMobilePage.waitUntilLoginPageIsLoaded();
        loginMobilePage
                .fillUsernameField(registered_username)
                .fillPasswordField(registered_password)
                .checkAgreeChebox();

        loginMobilePage.clickOnLoginButton();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
        }
        questionVanderbiltForParentsPetrunin.clickSubmitButton();
    }

    @Test(groups = {"positive", "smoke"})
    public void testOpenPatientPage() throws InterruptedException {
            Thread.sleep(3000);
        questionVanderbiltForParentsPetrunin.checkNextImgButton();
            Thread.sleep(5000);
        questionVanderbiltForParentsPetrunin.fillElements();
        Thread.sleep(3000);
        Log.info("All input elements is clicked");
            Thread.sleep(3000);
       questionVanderbiltForParentsPetrunin.checkLeftBtnHeader();
        Log.info("Access buttom was pushed. Test is finished!");
    }


    @AfterClass(alwaysRun = true)
    public void tearDown() {
        this.driver.quit();
    }
}


